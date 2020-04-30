//En esta última version se agregó la funcionalidad de la memoria EEPROM//

#include <EEPROM.h>
#include <SPI.h>
#include <nRF24L01.h>
#include <RF24.h>
#include <RF24_config.h>
#include <avr/sleep.h>
#include <avr/interrupt.h>
#include <avr/power.h>
#include <avr/wdt.h>
#include <ArduinoUniqueID.h>
#include <SoftwareSerial.h>

/*-----( DECLARACION CONSTANTES Y PINES )-----*/
#define CE_PIN   9
#define CSN_PIN 10
const uint64_t pipe = 0xE8E8F0F0E1LL; // define el canal de transmisión
const String RXID;

/*-----( DECLARACION DE OBJETOS )-----*/
SoftwareSerial S2(7, 8);
RF24 radio(CE_PIN, CSN_PIN);

/*--DECLARACION VARIABLES--*/
int Dir = 0;
long AppID = 0;
long ID[254];
int TX[7];
volatile int x = 0;       //para las diferentes intermitencias de los pitidos del buzzer, antes de entrar a MODO DESHABILITADO
volatile int y = 1;      //para sonarizar solo una vez al buzzer antes de entrar a MODO HABILITADO
volatile int z = 1;     //para evitar valores erroneos enviados por el sensor de presión (optativo)
volatile boolean h = 0;    //para entrar solo 1 vez a program() cuando recien se enciende el micro, antes de entrar a MODO POWER SAVING
volatile int g = 0;   //para mostrar el estado de la bateria solo una vez en el serial;
volatile int j = 0;  //para mostrar NO SE DETECTA NUEVA INFORMACION solo una vez
volatile boolean m = 0; // indica si el sistema se encuentra en modo habilitado h=1, o dasebilitado h=0;
volatile int f_wdt = 1;
int i = 0;  //contador para el FOR de sensado
int n = 0;
String TXID = "";

ISR(WDT_vect) //Juan: Subrutina del Watchdog
{
  if (f_wdt == 0)
  {
    f_wdt = 1;
  }
  else
  {
    Serial.println("Enviar peticion a TX");
    radio.write("Coso", 1);//Envio de datos cualquiera al TX
    n = 0; //Resetea la variable n
    do { //En esta seccion va el codigo de alerta si no se detecta TX
      n++;
      delayMicroseconds(20000);
      Serial.println(n);
      Serial.flush();
    } while (!radio.available() && n <= 200);
  }
}

void setup() {
  for (size_t i = 0; i < UniqueIDsize; i++) {
    RXID = RXID + String(UniqueID[i], DEC);
  }
  EEPROM.get(0, Dir);
  EEPROM.get(2, AppID);
  Serial.begin(115200);
  S2.begin(115200);
  MLoad();

  radio.begin();
  radio.setDataRate(RF24_2MBPS);
  radio.setAutoAck(true);     //DESACTIVA EL ACKNOWLEDGE
  radio.openReadingPipe(1, pipe);
  radio.startListening();

  set_sleep_mode(SLEEP_MODE_PWR_DOWN); //CONFIGURA MODO DE POWER SAVING(es el más extremo)

  pinMode(2, OUTPUT);      //Salida de control al relay
  pinMode(5, OUTPUT);     //led rojo--encendido indica ingreso al MODO DESHABILITADO
  pinMode(6, OUTPUT);    //led verde--encendido indica ingreso al MODO HABILITADO
  pinMode(7, OUTPUT);   //led amarillo--encendido indica que el microcontrolador se encuentra activo (no se encuentra en MODO POWER SAVING)
  pinMode(A5, OUTPUT); //Buzzer

  pinMode(A1, OUTPUT);  // A1 a A3 salidas de indicacion de la bateria
  pinMode(A2, OUTPUT);
  pinMode(A3, OUTPUT);

  digitalWrite(2, LOW);
  digitalWrite(5, HIGH);
  digitalWrite(6, LOW);
  digitalWrite(7, HIGH);

  digitalWrite(A0, LOW);
  digitalWrite(A1, LOW);
  digitalWrite(A2, LOW);
  digitalWrite(A3, LOW);
  digitalWrite(A4, LOW);

  //Juan
  /*** Setup the WDT ***/
  /* Clear the reset flag. */
  MCUSR &= ~(1 << WDRF);
  /* In order to change WDE or the prescaler, we need to
     set WDCE (This will allow updates for 4 clock cycles).
  */
  WDTCSR |= (1 << WDCE) | (1 << WDE);
  /* set new watchdog timeout prescaler value */
  WDTCSR = 1 << WDP0 | 1 << WDP3; /* 8.0 seconds */
  /* Enable the WD interrupt (note no reset). */
  WDTCSR |= _BV(WDIE);
  Serial.println("Initialisation complete.");
  Serial.println(RXID);
  Serial.flush();
}

void loop() {
  Chk();
  if (h == 0) {
    program();  //ingresa 1 vez a program() y luego ingresa a POWER SAVING
  }
  goToSleep();
}

void goToSleep() {
  //***********ingreso al modo sleep****************
  h = 1;
  g = 0;
  digitalWrite(7, LOW);                                      //led de interrupción
  sleep_enable();                                           //habilita el modo sleep, pero todavia no ingresa
  attachInterrupt(digitalPinToInterrupt(3), wakeUp, LOW);  //habilita la interrupción del pin 3//la interrupción la provocará el NRF24L01 cuando reciba un dato
  delay(20);
  sei();                                                 //habilita todas las interrupciones en general
  Serial.println("***********MODO SLEEP ON***********");
  Serial.flush();
  delay(500);
  wdt_enable(WDTO_8S);
  sleep_cpu();                                               //ingresa a MODO POWER SAVING
  //************luego del metodo wakeUp continúa en esta línea***
}

void wakeUp() { //INGRESA A ESTE MÉTODO LUEGO DE DESPERTAR
  sleep_disable();  //deshabilita el MODO SLEEP
  wdt_disable();
  delay(20);
  digitalWrite(7, HIGH);  //led de interrupción
  detachInterrupt(digitalPinToInterrupt(3));          //deshabilita la interrupción del pin 3
  Serial.println("--una interrupción ha ocurrido--");
  Serial.println("***********MODO SLEEP OFF***********");
  Serial.flush();
  program();
}

void program() {  //AQUI SE REALIZA LA RECEPCIÓN DE DATOS Y LA TOMA DE DECISIONES EN EL RECEPTOR, UNA VEZ FINALIZADO INGRESA NUEVAMENTE AL MODO POWER SAVING
  sei();         //activa todas la interrupciones en general
label0:
  for (i = 0; i < 30; i++) {  //realiza veinte veces el sensado de información que envía el TX, para obtener mayor precisión en los datos
label1:
    /*if (radio.available()) {          //si registra que el TX se encuentra activo, realiza lo siguiente
      int j = 0;
        radio.read(&j, 1);
        Serial.println(j);
        }*/
    if (radio.available()) {          //si registra que el TX se encuentra activo, realiza lo siguiente
      radio.read(TX, sizeof(TX));         //lee el vector de datos enviados por el TX
      TXID = String(TX[0]) + String(TX[1]) + String(TX[2]) + String(TX[3]) + String(TX[4]);
      Serial.println(String(TX[0]) + String(TX[1]) + String(TX[2]) + String(TX[3]) + String(TX[4]) + " - " + String(TX[5]) + " - " + String(TX[6]));
      Serial.flush();
      if (g == 0) {                 //TX[1] posee información sobre el ESTADO DE BATERIA del TX, esta mapeado entre 0 y 255
        estadoBateria();            //ingresa al método estadoBateria()
        g = 1;                     //ingresa al modo ESTADO DE BATERIA solo 1 vez en el FOR, cada vez que se interrumpe, para eso se usa la variable g
      }
      //Serial.println("valor sensor de fuerza: " + String(TX[5]));
      if (TX[5] >= 200) {       //TX[5] posee información sobre el sensor de fuerza, lo compara con un umbral para detectar si el sistema se encuentar en MODO HABILITADO/DESHABILITADO
        digitalWrite(6, HIGH);   //VERDE --INGRESO A MODO HABILITADO
        digitalWrite(5, LOW);   //ROJO
        digitalWrite(2, HIGH); // LA SALIDA AL RELAY SE PONE EN ALTO
        Serial.println("MODO HABILITADO");
        Serial.flush();
        x = 1;
        z = 0;
        j = 0;
        h = 1; // se levanta el flag de MODO HABILITADO
        if (y == 1) {
          tone(A5, 1000);
          delay(50);
          noTone(A5);
          delay(50);
          tone(A5, 1000);
          delay(50);
          noTone(A5);
          delay(50);
          y = 0;
        }
      }
    }
    else
    {
      if (j == 0) {
        Serial.println("NO SE DETECTA NUEVA INFORMACIÓN");  //indica cuando el RX se encuentra DESPIERTO, es decir fuera del MODO POWER SAVING
        j = 1;
      }
      if (z == 0) {
        TX[5] = 500;
      }
      else if (z == 1) {
        TX[5] = 0;
      }
    }
    //*******************************************************
    if (TX[5] < 200 && x  <= 60 && x != 0) {    //se compara el dato del sensor de fuerza con un umbral para decidir si se encuentra en el MODO DESHABILITADO
      x++;                                     //la variable x comienza a incrementarse luego de que se detectó un nivel bajo en el sensor de fuerza y vuelve a cero cuando se detecta un nivel alto nuevamente(MODO HABILITADO) o si se ingresa a MODO DESAHABILITADO                                   // Si detecta un nivel bajo del sensor de fuerza, espera un tiempo antes de enviar una alarma
      z = 1;
      if (x % 2 == 0) {     // si x es par
        digitalWrite(6, LOW);   //VERDE Apagado
      }
      else {
        digitalWrite(6, HIGH);   //VERDE Encedido
      }
      delay(200);
      Serial.println("en espera... " + String(x));
      Serial.flush();
      goto label1;
    }
    else if (TX[5] < 50 && x > 60 && x <= 70 ) {  //primera alarma de nivel bajo del sensor de fuerza, comienza a sonar el BUZZER
      tone(A5, 2000);
      if (x % 2 == 0) {     // si x es par
        digitalWrite(6, LOW);   //VERDE Apagado
      }
      else {
        digitalWrite(6, HIGH);   //VERDE Encedido
      }
      delay(75);
      noTone(A5);
      delay(75);
      x++;
      Serial.println("en espera... " + String(x));
      Serial.flush();
      goto label1;
    }
    //*****************************************************
    else if (TX[5] < 50 && x > 70 && x <= 90) { //segunda alarma de nivel bajo del sensor de fuerza, el BUZZER suena más rápido
      tone(A5, 2000);
      if (x % 2 == 0) {     // si x es par
        digitalWrite(6, LOW);   //VERDE Apagado
      }
      else {
        digitalWrite(6, HIGH);   //VERDE Encedido
      }
      delay(50);
      noTone(A5);
      delay(50);
      x++;
      Serial.println("en espera... " + String(x));
      Serial.flush();
      goto label1;
    }
    //*****************************************************
    else if (TX[5] < 50 && x > 90 && x < 92) { // Finalmente se ingresa al MODO DESHABILITADO, tras varios avisos
      /*
        tone(A5, 2000);
        delay(50);
        noTone(A5);
        delay(50);
      */
      digitalWrite(6, LOW);    //led verde
      digitalWrite(5, HIGH);  //led rojo
      digitalWrite(2, LOW);  //LA SALIDA AL RELAY SE PONE EN BAJO
      x = 0;                //la variable x se reinicia para un nuevo ciclo
      y = 1;               // la variable Y vuelve a 1 para permitir el reingreso al MODO HABILITADO
      j = 0;
      h = 0;    // Se levanta el flag de MODO DESHABILITADO
      Serial.println("MODO DESHABILITADO");
      Serial.flush();
    }
    //*******************************************************
  }
  if (TX[5] < 500 && h == 1 ) { //si esta MODO DESHABILITADO, no ingresa. Si esta en MODO HABILITADO y el sensor de fuerza es menor a 500, sigue pidiendo información
    i = 0;                  //metodo para evitar que el sistema continue en modo habilitado cuando el sensor indica un modo deshabilitado
    goto label0;
  }
}

void estadoBateria() {
  //radio.read(TX, 3);  //lee el vector de datos enviados por el TX
  //Serial.println("Calculando estado de la batería..." + String(TX[1]));
  if (TX[1] >= 0 && TX[1] < 85) {
    digitalWrite(A1, HIGH);
    digitalWrite(A2, LOW);
    digitalWrite(A3, LOW);
    //Serial.println("----Led Rojo(BAJA)----");
  }
  else if (TX[1] >= 85 && TX[1] < 169) {
    digitalWrite(A1, LOW);
    digitalWrite(A2, HIGH);
    digitalWrite(A3, LOW);
    //Serial.println("----Led Amarillo(MEDIA)----");
  }
  else if (TX[1] >= 169 && TX[1] < 255) {
    digitalWrite(A1, LOW);
    digitalWrite(A2, LOW);
    digitalWrite(A3, HIGH);
    //Serial.println("----Led Verde(MAX)----");
  }
}

void Chk() {
  if (S2.available()) {
    String In = S2.readStringUntil('\n');
    Serial.println("Recibido: " + In);
    switch (In.charAt(0)) {
      case 'C':
        MClear();
        break;
      case 'A':
        MAdd(In.substring(1));
        break;
      case 'L':
        MList();
        break;
      default:
        break;
    }
  }
}

void MClear() {
  for (int i = 0 ; i < Dir ; i++) {
    EEPROM.write(i, 0);
    ID[i] = 0;
    AppID = 0;
  }
  Dir = 0;
  Serial.println("Memoria limpiada");
}

void MLoad() {
  if (Dir > 0) {
    for (int i = 0; i < Dir; i++) {
      EEPROM.get(4 * i + 6, ID[i]);
    }
  }
}

void MAdd(String Inp) {
  if ((Inp.substring(0, Inp.indexOf("P"))) != ID[0] && !MComp(Inp.substring(Inp.indexOf("P") + 1)) && Dir == 0) {
    EEPROM.put(2, Inp.substring(0, Inp.indexOf("P")).toInt());
    Serial.println(Inp.substring(0, Inp.indexOf("P")).toInt());
    Serial.flush();
    EEPROM.put(6, Inp.substring(Inp.indexOf("P") + 1).toInt());
    Serial.println(Inp.substring(Inp.indexOf("P") + 1).toInt());
    Serial.flush();
    Dir = 2;
    EEPROM.put(0, Dir);
    Serial.println("AppID y HelmetID agregados");
    Serial.flush();
  }
  else if ((Inp.substring(0, Inp.indexOf("P"))) == ID[0] && !MComp(Inp.substring(Inp.indexOf("P") + 1)) && Dir != 0) {
    EEPROM.put(4 * Dir + 6, Inp.substring(Inp.indexOf("P") + 1).toInt());
    Serial.println("HelmetID agregado");
    Serial.flush();
    Dir++;
    EEPROM.put(0, Dir);
  }
  else {
    Serial.println("Minga!!");
    Serial.flush();
  }
}

bool MComp(String In) {
  bool Coin = false;
  int i = 0;
  long l = In.toInt();
  do {
    Coin = (l == ID[i]);
    i++;
  } while (!Coin && i != Dir);
  return Coin;
}

void MList() {
  MLoad();
  for (int i = 0; i < Dir; i++) {
    Serial.println(ID[i]);
    Serial.flush();
  }
  Serial.println("F");
  Serial.flush();
}
