package b4a.HelmetAPPV3;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class starter_subs_0 {


public static RemoteObject  _admin_devicefound(RemoteObject _name,RemoteObject _macaddress) throws Exception{
try {
		Debug.PushSubsStack("admin_DeviceFound (starter) ","starter",7,starter.processBA,starter.mostCurrent,33);
if (RapidSub.canDelegate("admin_devicefound")) { return b4a.HelmetAPPV3.starter.remoteMe.runUserSub(false, "starter","admin_devicefound", _name, _macaddress);}
Debug.locals.put("Name", _name);
Debug.locals.put("MacAddress", _macaddress);
 BA.debugLineNum = 33;BA.debugLine="Private Sub admin_DeviceFound (Name As String, Mac";
Debug.ShouldStop(1);
 BA.debugLineNum = 43;BA.debugLine="Log($\"Device found: ${Name}\"$)";
Debug.ShouldStop(1024);
starter.mostCurrent.__c.runVoidMethod ("Log",(Object)((RemoteObject.concat(RemoteObject.createImmutable("Device found: "),starter.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_name))),RemoteObject.createImmutable("")))));
 BA.debugLineNum = 44;BA.debugLine="If Name = \"SLAVE\" Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",_name,BA.ObjectToString("SLAVE"))) { 
 BA.debugLineNum = 45;BA.debugLine="Log(\"Trying to connect...\")";
Debug.ShouldStop(4096);
starter.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Trying to connect...")));
 BA.debugLineNum = 46;BA.debugLine="admin.CancelDiscovery";
Debug.ShouldStop(8192);
starter._admin.runVoidMethod ("CancelDiscovery");
 BA.debugLineNum = 47;BA.debugLine="serial.Connect(MacAddress)";
Debug.ShouldStop(16384);
starter._serial.runVoidMethod ("Connect",starter.processBA,(Object)(_macaddress));
 };
 BA.debugLineNum = 49;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _admin_discoveryfinished() throws Exception{
try {
		Debug.PushSubsStack("admin_DiscoveryFinished (starter) ","starter",7,starter.processBA,starter.mostCurrent,51);
if (RapidSub.canDelegate("admin_discoveryfinished")) { return b4a.HelmetAPPV3.starter.remoteMe.runUserSub(false, "starter","admin_discoveryfinished");}
 BA.debugLineNum = 51;BA.debugLine="Private Sub admin_DiscoveryFinished";
Debug.ShouldStop(262144);
 BA.debugLineNum = 71;BA.debugLine="connecting = False";
Debug.ShouldStop(64);
starter._connecting = starter.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 73;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _application_error(RemoteObject _error,RemoteObject _stacktrace) throws Exception{
try {
		Debug.PushSubsStack("Application_Error (starter) ","starter",7,starter.processBA,starter.mostCurrent,114);
if (RapidSub.canDelegate("application_error")) { return b4a.HelmetAPPV3.starter.remoteMe.runUserSub(false, "starter","application_error", _error, _stacktrace);}
Debug.locals.put("Error", _error);
Debug.locals.put("StackTrace", _stacktrace);
 BA.debugLineNum = 114;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
Debug.ShouldStop(131072);
 BA.debugLineNum = 115;BA.debugLine="Return True";
Debug.ShouldStop(262144);
if (true) return starter.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 116;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _ast_newtext(RemoteObject _text) throws Exception{
try {
		Debug.PushSubsStack("ast_NewText (starter) ","starter",7,starter.processBA,starter.mostCurrent,98);
if (RapidSub.canDelegate("ast_newtext")) { return b4a.HelmetAPPV3.starter.remoteMe.runUserSub(false, "starter","ast_newtext", _text);}
Debug.locals.put("Text", _text);
 BA.debugLineNum = 98;BA.debugLine="Private Sub ast_NewText (Text As String)";
Debug.ShouldStop(2);
 BA.debugLineNum = 99;BA.debugLine="CallSub2(RegistrarVehiculo, \"MessageFromDevice\",";
Debug.ShouldStop(4);
starter.mostCurrent.__c.runMethodAndSync(false,"CallSubNew2",starter.processBA,(Object)((starter.mostCurrent._registrarvehiculo.getObject())),(Object)(BA.ObjectToString("MessageFromDevice")),(Object)((_text)));
 BA.debugLineNum = 100;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _ast_terminated() throws Exception{
try {
		Debug.PushSubsStack("ast_Terminated (starter) ","starter",7,starter.processBA,starter.mostCurrent,102);
if (RapidSub.canDelegate("ast_terminated")) { return b4a.HelmetAPPV3.starter.remoteMe.runUserSub(false, "starter","ast_terminated");}
 BA.debugLineNum = 102;BA.debugLine="Private Sub ast_Terminated";
Debug.ShouldStop(32);
 BA.debugLineNum = 103;BA.debugLine="connected = False";
Debug.ShouldStop(64);
starter._connected = starter.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 104;BA.debugLine="CallSub(RegistrarVehiculo, \"SetState\")";
Debug.ShouldStop(128);
starter.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",starter.processBA,(Object)((starter.mostCurrent._registrarvehiculo.getObject())),(Object)(RemoteObject.createImmutable("SetState")));
 BA.debugLineNum = 105;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _connect() throws Exception{
try {
		Debug.PushSubsStack("Connect (starter) ","starter",7,starter.processBA,starter.mostCurrent,27);
if (RapidSub.canDelegate("connect")) { return b4a.HelmetAPPV3.starter.remoteMe.runUserSub(false, "starter","connect");}
 BA.debugLineNum = 27;BA.debugLine="Public Sub Connect";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 28;BA.debugLine="admin.StartDiscovery";
Debug.ShouldStop(134217728);
starter._admin.runVoidMethod ("StartDiscovery");
 BA.debugLineNum = 29;BA.debugLine="connecting = True";
Debug.ShouldStop(268435456);
starter._connecting = starter.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 30;BA.debugLine="CallSub(RegistrarVehiculo, \"SetState\")";
Debug.ShouldStop(536870912);
starter.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",starter.processBA,(Object)((starter.mostCurrent._registrarvehiculo.getObject())),(Object)(RemoteObject.createImmutable("SetState")));
 BA.debugLineNum = 31;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _enviarack() throws Exception{
try {
		Debug.PushSubsStack("enviarACK (starter) ","starter",7,starter.processBA,starter.mostCurrent,135);
if (RapidSub.canDelegate("enviarack")) { return b4a.HelmetAPPV3.starter.remoteMe.runUserSub(false, "starter","enviarack");}
 BA.debugLineNum = 135;BA.debugLine="Public Sub enviarACK()";
Debug.ShouldStop(64);
 BA.debugLineNum = 136;BA.debugLine="Log(\"Enviando ACK\")";
Debug.ShouldStop(128);
starter.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Enviando ACK")));
 BA.debugLineNum = 137;BA.debugLine="ast.Write(\"ACK\"&Chr(10))";
Debug.ShouldStop(256);
starter._ast.runClassMethod (b4a.HelmetAPPV3.asyncstreamstext.class, "_write",(Object)(RemoteObject.concat(RemoteObject.createImmutable("ACK"),starter.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 10))))));
 BA.debugLineNum = 138;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _enviardniycasco() throws Exception{
try {
		Debug.PushSubsStack("enviarDNIyCASCO (starter) ","starter",7,starter.processBA,starter.mostCurrent,89);
if (RapidSub.canDelegate("enviardniycasco")) { return b4a.HelmetAPPV3.starter.remoteMe.runUserSub(false, "starter","enviardniycasco");}
 BA.debugLineNum = 89;BA.debugLine="Public Sub enviarDNIyCASCO()";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 90;BA.debugLine="ast.Write(\"A\" & Main.dni & \"P\" &  IngresarCascoID";
Debug.ShouldStop(33554432);
starter._ast.runClassMethod (b4a.HelmetAPPV3.asyncstreamstext.class, "_write",(Object)(RemoteObject.concat(RemoteObject.createImmutable("A"),starter.mostCurrent._main._dni,RemoteObject.createImmutable("P"),starter.mostCurrent._ingresarcascoid._idcasco,starter.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 10))))));
 BA.debugLineNum = 91;BA.debugLine="Log(\"enviar DNI: \" & Main.dni )";
Debug.ShouldStop(67108864);
starter.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("enviar DNI: "),starter.mostCurrent._main._dni)));
 BA.debugLineNum = 92;BA.debugLine="Log(\"enviar ID casco: \" & IngresarCascoID.IDcasco";
Debug.ShouldStop(134217728);
starter.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("enviar ID casco: "),starter.mostCurrent._ingresarcascoid._idcasco)));
 BA.debugLineNum = 93;BA.debugLine="Log(\"A\"&Main.dni&\"P\"&IngresarCascoID.IDcasco&Chr(";
Debug.ShouldStop(268435456);
starter.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("A"),starter.mostCurrent._main._dni,RemoteObject.createImmutable("P"),starter.mostCurrent._ingresarcascoid._idcasco,starter.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 10))))));
 BA.debugLineNum = 95;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _enviarleer() throws Exception{
try {
		Debug.PushSubsStack("enviarLeer (starter) ","starter",7,starter.processBA,starter.mostCurrent,122);
if (RapidSub.canDelegate("enviarleer")) { return b4a.HelmetAPPV3.starter.remoteMe.runUserSub(false, "starter","enviarleer");}
 BA.debugLineNum = 122;BA.debugLine="Public Sub enviarLeer()";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 123;BA.debugLine="Log(\"Leer datos en la EEPROM de HelmetRX\")";
Debug.ShouldStop(67108864);
starter.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Leer datos en la EEPROM de HelmetRX")));
 BA.debugLineNum = 124;BA.debugLine="ast.Write(\"L\"&Chr(10))";
Debug.ShouldStop(134217728);
starter._ast.runClassMethod (b4a.HelmetAPPV3.asyncstreamstext.class, "_write",(Object)(RemoteObject.concat(RemoteObject.createImmutable("L"),starter.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 10))))));
 BA.debugLineNum = 125;BA.debugLine="Log(\"Enviando L\")";
Debug.ShouldStop(268435456);
starter.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Enviando L")));
 BA.debugLineNum = 126;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _enviarlimpiar() throws Exception{
try {
		Debug.PushSubsStack("enviarLimpiar (starter) ","starter",7,starter.processBA,starter.mostCurrent,128);
if (RapidSub.canDelegate("enviarlimpiar")) { return b4a.HelmetAPPV3.starter.remoteMe.runUserSub(false, "starter","enviarlimpiar");}
 BA.debugLineNum = 128;BA.debugLine="Public Sub enviarLimpiar()";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 129;BA.debugLine="Log(\"Limpiar datos en la EEPROM de HelmetRX\")";
Debug.ShouldStop(1);
starter.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Limpiar datos en la EEPROM de HelmetRX")));
 BA.debugLineNum = 130;BA.debugLine="ast.Write(\"C\"&Chr(10))";
Debug.ShouldStop(2);
starter._ast.runClassMethod (b4a.HelmetAPPV3.asyncstreamstext.class, "_write",(Object)(RemoteObject.concat(RemoteObject.createImmutable("C"),starter.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 10))))));
 BA.debugLineNum = 131;BA.debugLine="Log(\"Enviando C\")";
Debug.ShouldStop(4);
starter.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Enviando C")));
 BA.debugLineNum = 133;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _enviarnack() throws Exception{
try {
		Debug.PushSubsStack("enviarNACK (starter) ","starter",7,starter.processBA,starter.mostCurrent,140);
if (RapidSub.canDelegate("enviarnack")) { return b4a.HelmetAPPV3.starter.remoteMe.runUserSub(false, "starter","enviarnack");}
 BA.debugLineNum = 140;BA.debugLine="Public Sub enviarNACK()";
Debug.ShouldStop(2048);
 BA.debugLineNum = 141;BA.debugLine="Log(\"Enviando NACK\")";
Debug.ShouldStop(4096);
starter.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Enviando NACK")));
 BA.debugLineNum = 142;BA.debugLine="ast.Write(\"NACK\"&Chr(10))";
Debug.ShouldStop(8192);
starter._ast.runClassMethod (b4a.HelmetAPPV3.asyncstreamstext.class, "_write",(Object)(RemoteObject.concat(RemoteObject.createImmutable("NACK"),starter.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 10))))));
 BA.debugLineNum = 143;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 8;BA.debugLine="Private serial As Serial";
starter._serial = RemoteObject.createNew ("anywheresoftware.b4a.objects.Serial");
 //BA.debugLineNum = 9;BA.debugLine="Private admin As BluetoothAdmin";
starter._admin = RemoteObject.createNew ("anywheresoftware.b4a.objects.Serial.BluetoothAdmin");
 //BA.debugLineNum = 10;BA.debugLine="Private ast As AsyncStreamsText";
starter._ast = RemoteObject.createNew ("b4a.HelmetAPPV3.asyncstreamstext");
 //BA.debugLineNum = 11;BA.debugLine="Public connected As Boolean";
starter._connected = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 12;BA.debugLine="Public connecting As Boolean";
starter._connecting = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _serial_connected(RemoteObject _success) throws Exception{
try {
		Debug.PushSubsStack("Serial_Connected (starter) ","starter",7,starter.processBA,starter.mostCurrent,75);
if (RapidSub.canDelegate("serial_connected")) { return b4a.HelmetAPPV3.starter.remoteMe.runUserSub(false, "starter","serial_connected", _success);}
Debug.locals.put("Success", _success);
 BA.debugLineNum = 75;BA.debugLine="Private Sub Serial_Connected (Success As Boolean)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 76;BA.debugLine="If Success Then";
Debug.ShouldStop(2048);
if (_success.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 77;BA.debugLine="If ast.IsInitialized Then ast.Close";
Debug.ShouldStop(4096);
if (starter._ast.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
starter._ast.runClassMethod (b4a.HelmetAPPV3.asyncstreamstext.class, "_close");};
 BA.debugLineNum = 78;BA.debugLine="ast.Initialize(Me, \"Ast\", serial.InputStream, se";
Debug.ShouldStop(8192);
starter._ast.runClassMethod (b4a.HelmetAPPV3.asyncstreamstext.class, "_initialize",starter.processBA,(Object)(starter.getObject()),(Object)(BA.ObjectToString("Ast")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.streams.File.InputStreamWrapper"), starter._serial.runMethod(false,"getInputStream")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper"), starter._serial.runMethod(false,"getOutputStream")));
 BA.debugLineNum = 79;BA.debugLine="Log(\"Connected\")";
Debug.ShouldStop(16384);
starter.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Connected")));
 BA.debugLineNum = 80;BA.debugLine="connected = True";
Debug.ShouldStop(32768);
starter._connected = starter.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 83;BA.debugLine="Log(LastException)";
Debug.ShouldStop(262144);
starter.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(starter.mostCurrent.__c.runMethod(false,"LastException",starter.processBA))));
 };
 BA.debugLineNum = 85;BA.debugLine="connecting = False";
Debug.ShouldStop(1048576);
starter._connecting = starter.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 86;BA.debugLine="CallSub(RegistrarVehiculo, \"SetState\")";
Debug.ShouldStop(2097152);
starter.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",starter.processBA,(Object)((starter.mostCurrent._registrarvehiculo.getObject())),(Object)(RemoteObject.createImmutable("SetState")));
 BA.debugLineNum = 87;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_create() throws Exception{
try {
		Debug.PushSubsStack("Service_Create (starter) ","starter",7,starter.processBA,starter.mostCurrent,22);
if (RapidSub.canDelegate("service_create")) { return b4a.HelmetAPPV3.starter.remoteMe.runUserSub(false, "starter","service_create");}
 BA.debugLineNum = 22;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 23;BA.debugLine="serial.Initialize(\"serial\")";
Debug.ShouldStop(4194304);
starter._serial.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("serial")));
 BA.debugLineNum = 24;BA.debugLine="admin.Initialize(\"admin\")";
Debug.ShouldStop(8388608);
starter._admin.runVoidMethod ("Initialize",starter.processBA,(Object)(RemoteObject.createImmutable("admin")));
 BA.debugLineNum = 25;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_destroy() throws Exception{
try {
		Debug.PushSubsStack("Service_Destroy (starter) ","starter",7,starter.processBA,starter.mostCurrent,118);
if (RapidSub.canDelegate("service_destroy")) { return b4a.HelmetAPPV3.starter.remoteMe.runUserSub(false, "starter","service_destroy");}
 BA.debugLineNum = 118;BA.debugLine="Sub Service_Destroy";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 120;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_start(RemoteObject _startingintent) throws Exception{
try {
		Debug.PushSubsStack("Service_Start (starter) ","starter",7,starter.processBA,starter.mostCurrent,109);
if (RapidSub.canDelegate("service_start")) { return b4a.HelmetAPPV3.starter.remoteMe.runUserSub(false, "starter","service_start", _startingintent);}
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 109;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 111;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}