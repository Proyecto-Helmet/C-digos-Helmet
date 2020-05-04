package b4a.HelmetAPPV3;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class ingresarcascoid_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (ingresarcascoid) ","ingresarcascoid",1,ingresarcascoid.mostCurrent.activityBA,ingresarcascoid.mostCurrent,42);
if (RapidSub.canDelegate("activity_create")) { return b4a.HelmetAPPV3.ingresarcascoid.remoteMe.runUserSub(false, "ingresarcascoid","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 42;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(512);
 BA.debugLineNum = 44;BA.debugLine="Activity.LoadLayout(\"IngresarCascoID\")";
Debug.ShouldStop(2048);
ingresarcascoid.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("IngresarCascoID")),ingresarcascoid.mostCurrent.activityBA);
 BA.debugLineNum = 45;BA.debugLine="Activity.Title=\"Helmet APP - Registrar Casco\"";
Debug.ShouldStop(4096);
ingresarcascoid.mostCurrent._activity.runMethod(false,"setTitle",BA.ObjectToCharSequence("Helmet APP - Registrar Casco"));
 BA.debugLineNum = 46;BA.debugLine="qrcrv.Visible = False";
Debug.ShouldStop(8192);
ingresarcascoid.mostCurrent._qrcrv.runMethod(true,"setVisible",ingresarcascoid.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 47;BA.debugLine="pnlContinuar.Visible=False";
Debug.ShouldStop(16384);
ingresarcascoid.mostCurrent._pnlcontinuar.runMethod(true,"setVisible",ingresarcascoid.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 48;BA.debugLine="pnlNegro.Visible=True";
Debug.ShouldStop(32768);
ingresarcascoid.mostCurrent._pnlnegro.runMethod(true,"setVisible",ingresarcascoid.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 49;BA.debugLine="flag=False";
Debug.ShouldStop(65536);
ingresarcascoid._flag = ingresarcascoid.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 50;BA.debugLine="usuarios.Initialize";
Debug.ShouldStop(131072);
ingresarcascoid.mostCurrent._usuarios.runClassMethod (b4a.HelmetAPPV3.usuarios.class, "_initialize",ingresarcascoid.processBA);
 BA.debugLineNum = 52;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (ingresarcascoid) ","ingresarcascoid",1,ingresarcascoid.mostCurrent.activityBA,ingresarcascoid.mostCurrent,58);
if (RapidSub.canDelegate("activity_pause")) { return b4a.HelmetAPPV3.ingresarcascoid.remoteMe.runUserSub(false, "ingresarcascoid","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 58;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 60;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (ingresarcascoid) ","ingresarcascoid",1,ingresarcascoid.mostCurrent.activityBA,ingresarcascoid.mostCurrent,54);
if (RapidSub.canDelegate("activity_resume")) { return b4a.HelmetAPPV3.ingresarcascoid.remoteMe.runUserSub(false, "ingresarcascoid","activity_resume");}
 BA.debugLineNum = 54;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 56;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _b1_click() throws Exception{
try {
		Debug.PushSubsStack("b1_Click (ingresarcascoid) ","ingresarcascoid",1,ingresarcascoid.mostCurrent.activityBA,ingresarcascoid.mostCurrent,63);
if (RapidSub.canDelegate("b1_click")) { return b4a.HelmetAPPV3.ingresarcascoid.remoteMe.runUserSub(false, "ingresarcascoid","b1_click");}
 BA.debugLineNum = 63;BA.debugLine="Sub b1_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 66;BA.debugLine="qrcrv.Visible = True";
Debug.ShouldStop(2);
ingresarcascoid.mostCurrent._qrcrv.runMethod(true,"setVisible",ingresarcascoid.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 67;BA.debugLine="pnlNegro.Visible=False";
Debug.ShouldStop(4);
ingresarcascoid.mostCurrent._pnlnegro.runMethod(true,"setVisible",ingresarcascoid.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 68;BA.debugLine="DoEvents";
Debug.ShouldStop(8);
ingresarcascoid.mostCurrent.__c.runVoidMethodAndSync ("DoEvents");
 BA.debugLineNum = 69;BA.debugLine="qrcrv.startScan";
Debug.ShouldStop(16);
ingresarcascoid.mostCurrent._qrcrv.runVoidMethod ("startScan");
 BA.debugLineNum = 71;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _b2_click() throws Exception{
try {
		Debug.PushSubsStack("b2_Click (ingresarcascoid) ","ingresarcascoid",1,ingresarcascoid.mostCurrent.activityBA,ingresarcascoid.mostCurrent,72);
if (RapidSub.canDelegate("b2_click")) { return b4a.HelmetAPPV3.ingresarcascoid.remoteMe.runUserSub(false, "ingresarcascoid","b2_click");}
 BA.debugLineNum = 72;BA.debugLine="Sub b2_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 74;BA.debugLine="qrcrv.stopScan";
Debug.ShouldStop(512);
ingresarcascoid.mostCurrent._qrcrv.runVoidMethod ("stopScan");
 BA.debugLineNum = 75;BA.debugLine="DoEvents";
Debug.ShouldStop(1024);
ingresarcascoid.mostCurrent.__c.runVoidMethodAndSync ("DoEvents");
 BA.debugLineNum = 76;BA.debugLine="pnlNegro.Visible=True";
Debug.ShouldStop(2048);
ingresarcascoid.mostCurrent._pnlnegro.runMethod(true,"setVisible",ingresarcascoid.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 77;BA.debugLine="qrcrv.Visible = False";
Debug.ShouldStop(4096);
ingresarcascoid.mostCurrent._qrcrv.runMethod(true,"setVisible",ingresarcascoid.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 79;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btncontinuar_click() throws Exception{
try {
		Debug.PushSubsStack("btnContinuar_Click (ingresarcascoid) ","ingresarcascoid",1,ingresarcascoid.mostCurrent.activityBA,ingresarcascoid.mostCurrent,96);
if (RapidSub.canDelegate("btncontinuar_click")) { return b4a.HelmetAPPV3.ingresarcascoid.remoteMe.runUserSub(false, "ingresarcascoid","btncontinuar_click");}
 BA.debugLineNum = 96;BA.debugLine="Sub btnContinuar_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 98;BA.debugLine="Log (\"valor de dni: \"&Main.dni)";
Debug.ShouldStop(2);
ingresarcascoid.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("valor de dni: "),ingresarcascoid.mostCurrent._main._dni)));
 BA.debugLineNum = 99;BA.debugLine="usuarios.insertarHelmetID(IDcasco,Main.dni)";
Debug.ShouldStop(4);
ingresarcascoid.mostCurrent._usuarios.runClassMethod (b4a.HelmetAPPV3.usuarios.class, "_insertarhelmetid",(Object)(ingresarcascoid._idcasco),(Object)(ingresarcascoid.mostCurrent._main._dni));
 BA.debugLineNum = 101;BA.debugLine="StartActivity(\"RegistrarVehiculo\")";
Debug.ShouldStop(16);
ingresarcascoid.mostCurrent.__c.runVoidMethod ("StartActivity",ingresarcascoid.processBA,(Object)((RemoteObject.createImmutable("RegistrarVehiculo"))));
 BA.debugLineNum = 102;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnreescanear_click() throws Exception{
try {
		Debug.PushSubsStack("btnReescanear_Click (ingresarcascoid) ","ingresarcascoid",1,ingresarcascoid.mostCurrent.activityBA,ingresarcascoid.mostCurrent,91);
if (RapidSub.canDelegate("btnreescanear_click")) { return b4a.HelmetAPPV3.ingresarcascoid.remoteMe.runUserSub(false, "ingresarcascoid","btnreescanear_click");}
 BA.debugLineNum = 91;BA.debugLine="Sub btnReescanear_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 92;BA.debugLine="flag=False";
Debug.ShouldStop(134217728);
ingresarcascoid._flag = ingresarcascoid.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 93;BA.debugLine="pnlContinuar.Visible=False";
Debug.ShouldStop(268435456);
ingresarcascoid.mostCurrent._pnlcontinuar.runMethod(true,"setVisible",ingresarcascoid.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 94;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 19;BA.debugLine="Private qrcrv As QRCodeReaderView";
ingresarcascoid.mostCurrent._qrcrv = RemoteObject.createNew ("qrcodereaderviewwrapper.qrCodeReaderViewWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private b1 As Button";
ingresarcascoid.mostCurrent._b1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private b2 As Button";
ingresarcascoid.mostCurrent._b2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private lblFondo As Label";
ingresarcascoid.mostCurrent._lblfondo = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private pnlContinuar As Panel";
ingresarcascoid.mostCurrent._pnlcontinuar = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private lblEscaneoExitoso As Label";
ingresarcascoid.mostCurrent._lblescaneoexitoso = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private Label2 As Label";
ingresarcascoid.mostCurrent._label2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private lblSeguro As Label";
ingresarcascoid.mostCurrent._lblseguro = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private btnReescanear As Button";
ingresarcascoid.mostCurrent._btnreescanear = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private btnContinuar As Button";
ingresarcascoid.mostCurrent._btncontinuar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private pnlBorde As Panel";
ingresarcascoid.mostCurrent._pnlborde = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private pnlNegro As Panel";
ingresarcascoid.mostCurrent._pnlnegro = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private lblDos As Label";
ingresarcascoid.mostCurrent._lbldos = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Dim flag As Boolean";
ingresarcascoid._flag = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 38;BA.debugLine="Dim usuarios As Usuarios";
ingresarcascoid.mostCurrent._usuarios = RemoteObject.createNew ("b4a.HelmetAPPV3.usuarios");
 //BA.debugLineNum = 40;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 9;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 12;BA.debugLine="Dim IDcasco As String";
ingresarcascoid._idcasco = RemoteObject.createImmutable("");
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _qrcrv_result_found(RemoteObject _retval) throws Exception{
try {
		Debug.PushSubsStack("qrcrv_result_found (ingresarcascoid) ","ingresarcascoid",1,ingresarcascoid.mostCurrent.activityBA,ingresarcascoid.mostCurrent,81);
if (RapidSub.canDelegate("qrcrv_result_found")) { return b4a.HelmetAPPV3.ingresarcascoid.remoteMe.runUserSub(false, "ingresarcascoid","qrcrv_result_found", _retval);}
Debug.locals.put("retval", _retval);
 BA.debugLineNum = 81;BA.debugLine="Sub qrcrv_result_found(retval As String)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 82;BA.debugLine="If retval<>\"\" And flag=False Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("!",_retval,BA.ObjectToString("")) && RemoteObject.solveBoolean("=",ingresarcascoid._flag,ingresarcascoid.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 83;BA.debugLine="flag=True";
Debug.ShouldStop(262144);
ingresarcascoid._flag = ingresarcascoid.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 84;BA.debugLine="IDcasco=retval";
Debug.ShouldStop(524288);
ingresarcascoid._idcasco = _retval;
 BA.debugLineNum = 85;BA.debugLine="Log(\"Código escaneado: \" & IDcasco)";
Debug.ShouldStop(1048576);
ingresarcascoid.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Código escaneado: "),ingresarcascoid._idcasco)));
 BA.debugLineNum = 86;BA.debugLine="pnlContinuar.Visible=True";
Debug.ShouldStop(2097152);
ingresarcascoid.mostCurrent._pnlcontinuar.runMethod(true,"setVisible",ingresarcascoid.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 89;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}