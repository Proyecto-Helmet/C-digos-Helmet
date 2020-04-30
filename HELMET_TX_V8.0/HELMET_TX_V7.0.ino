
//En esta versión se agrego un watchdog timer para solucionar el problema de que si se desconectaba el TX el RX no lo detectaba. Ahora se realiza una interrupción periódica cada 8 segundos apróx.

//CONSUMOS:

//CON BATERIA DE LITIO DE 1 CELDA: MÁXIMO VOLTAJE 4.21V(ALIMENTACIÓN DIRECTA A ATMEGA328P), A TRAVÉS DE 2 DIODOS(0.67V CAIDA) EL VOLTAJE ES 3.53V(ALIMENTACIÓN A NRF24L01)
//PARÁMETROS DE ALIMENTACIÓN DE NRF (MAX 3.6V,MIN 1.9V)----PARAMETROS DE BATERIA CON DIODOS (MAX 3.53), LA BATERIA NO DEBE BAJAR DE 2.6V=(0.67V+1.9V)
//PARAMETROS DE ALIMENTACIÓN ARDUINO (MAX 5.5V, MIN 2.9v) , 3v+0.25v=3.25v la bateria no deberia bajar de 3.35v, ya que el arduino pasa a través de 1 diodo
// EN SLEEP: 0.25mA  EN MODO NORMAL: 15mA

//CADA VEZ QUE SE ENVIA INFO SE UTILIZA APROX 1 SEGUNDO EL MODO NORMAL, SI DURANTE 1 DIA SE USA LA MOTO 5 VECES, SON DOS VECES DE MODO
//NORMAL POR VEZ, POR LO TANTO SON 10 SEG POR DIA EN MODO NORMAL, Y EL RESTO EN MODO SLEEP, DA UN USO TOTAL DE CORRIENTE POR DIA DE:
//15mA*10SEG+0.25mA*(24H*3600SEG-10SEG) =21747.5ma*seg=6.04mA*H---unidad de carga(carga que se gasta en 1 día)
//La bateria a utilizar tiene una carga de 600maH---600maH/6.04maH = 99.3 días de duración de la batería

#include <SPI.h>
#include <nRF24L01.h>
#include <RF24.h>
#include <RF24_config.h>
#include <avr/sleep.h>
#include <avr/interrupt.h>
#include <ArduinoUniqueID.h>

#define CE_PIN 9
#define CSN_PIN 10

const uint64_t pipe = 0xE8E8F0F0E1LL;
const String TXID = "";
RF24 radio(CE_PIN, CSN_PIN);
int battCalibrated;
int battVolts;
int lectura;
int TX[7];

void setup() {
  for (size_t i = 0; i < UniqueIDsize; i++) {
    TXID = TXID + String(UniqueID[i], DEC);
  }
  TX[0] = TXID.substring(0, 4).toInt();
  TX[1] = TXID.substring(4, 8).toInt();
  TX[2] = TXID.substring(8, 12).toInt();
  TX[3] = TXID.substring(12, 16).toInt();
  TX[4] = TXID.substring(16, TXID.length()).toInt();

  Serial.begin(115200);
  Serial.println(TXID);
  Serial.flush();

  radio.begin();
  radio.setDataRate(RF24_2MBPS);
  radio.setAutoAck(true);//ACTIVA EL ACKNOWLEDGE
  radio.openWritingPipe(pipe);

  pinMode(2,INPUT);
  pinMode(3, INPUT); 
  
  pinMode(4, OUTPUT); //led de bateria
  digitalWrite(4, LOW);
  delayMicroseconds(500000);
  set_sleep_mode(SLEEP_MODE_PWR_DOWN);
  medirBateria();
}

void loop() {
  sensarYenviar();
  cli();
  
  Serial.println("***********MODO SLEEP ON************");
  Serial.flush();
  goToSleep();
}

void goToSleep() {
  //***********ingreso al modo sleep****************
  radio.powerDown();
  sleep_enable();
  attachInterrupt(digitalPinToInterrupt(2), wakeUp, CHANGE);
  attachInterrupt(digitalPinToInterrupt(3), wakeUp, CHANGE);
  delayMicroseconds(1000000);
  sei();
  sleep_cpu();
  //************luego del metodo wakeUp continúa en esta línea***
}

void wakeUp() {

  sleep_disable();
  radio.powerUp();
  delayMicroseconds(20000);
  cli();
  detachInterrupt(digitalPinToInterrupt(2));
  detachInterrupt(digitalPinToInterrupt(3));
  Serial.println("--una interrupción ha ocurrido--");
  Serial.println("***********MODO SLEEP OFF***********");
  Serial.flush();
  delayMicroseconds(100000);
  sensarYenviar();
}

void sensarYenviar() {
  
  medirBateria();
label0:
  for ( int i = 0; i < 50; i++) {
    TX[5] = analogRead(0);
    delayMicroseconds(10000);
  }
  bool ok = false;
  do {
    ok = radio.write(TX, sizeof(TX));
    delayMicroseconds(150);
  } while (!ok);
  Serial.println("Oka");
  Serial.flush();
  Serial.println(String(TX[0]) + String(TX[1]) + String(TX[2]) + String(TX[3]) + String(TX[4]) + String(TX[5]) + String(TX[6]));
  Serial.flush();
  Serial.println("enviando informacion del sensor");
  Serial.println("sensor de fuerza: " + String(TX[5]));
  Serial.flush();
  delayMicroseconds(100000);

  if (TX[5] > 200 && TX[5] < 450) { // loop que continúa sensando en el rango conflictivo de valores (200 a 450) para evitar que el sistema siga en MODO HABILITADO cuando no debería estarlo
    goto label0;                 // ya que si hay una interrupcion (aprox en 600) y el sistema entra a modo sleep antes de entrar al rango de MODO DESHABILITADO
  }                              // entonces habrá un error en el sistema
}

void medirBateria(void)
{
  for (int i = 0; i <= 3; i++) battVolts = getBandgap(); //4 readings required for best stable value?
  Serial.print("VOLTAJE DE BATERÍA =  ");
  battCalibrated = battVolts + 10;
  Serial.println(battCalibrated);
  TX[6] = map(battCalibrated, 320, 510, 0, 255 );
  Serial.println(String(TX[6]));
  Serial.flush();
  delayMicroseconds(100000);
}

int getBandgap(void) {
#if defined(__AVR_ATmega1280__) || defined(__AVR_ATmega2560__)
  // For mega boards
  const long InternalReferenceVoltage = 1115L;  // Adust this value to your boards specific internal BG voltage x1000
  // REFS1 REFS0          --> 0 1, AVcc internal ref.
  // MUX4 MUX3 MUX2 MUX1 MUX0  --> 11110 1.1V (VBG)
  ADMUX = (0 << REFS1) | (1 << REFS0) | (0 << ADLAR) | (1 << MUX4) | (1 << MUX3) | (1 << MUX2) | (1 << MUX1) | (0 << MUX0);
#else
  // For 168/328 boards
  const long InternalReferenceVoltage = 1050L;  // Adust this value to your boards specific internal BG voltage x1000
  // REFS1 REFS0          --> 0 1, AVcc internal ref.
  // MUX3 MUX2 MUX1 MUX0  --> 1110 1.1V (VBG)
  ADMUX = (0 << REFS1) | (1 << REFS0) | (0 << ADLAR) | (1 << MUX3) | (1 << MUX2) | (1 << MUX1) | (0 << MUX0);
#endif
  // Start a conversion
  ADCSRA |= _BV( ADSC );
  // Wait for it to complete
  while ( ( (ADCSRA & (1 << ADSC)) != 0 ) );
  // Scale the value
  int results = (((InternalReferenceVoltage * 1024L) / ADC) + 5L) / 10L;
  return results;
}
