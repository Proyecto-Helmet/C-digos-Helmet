package b4a.HelmetAPPV3;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class registrarvehiculo_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (registrarvehiculo) ","registrarvehiculo",2,registrarvehiculo.mostCurrent.activityBA,registrarvehiculo.mostCurrent,38);
if (RapidSub.canDelegate("activity_create")) { return b4a.HelmetAPPV3.registrarvehiculo.remoteMe.runUserSub(false, "registrarvehiculo","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 38;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(32);
 BA.debugLineNum = 39;BA.debugLine="usuarios.Initialize";
Debug.ShouldStop(64);
registrarvehiculo.mostCurrent._usuarios.runClassMethod (b4a.HelmetAPPV3.usuarios.class, "_initialize",registrarvehiculo.processBA);
 BA.debugLineNum = 40;BA.debugLine="Activity.LoadLayout(\"RegistrarVehiculo\")";
Debug.ShouldStop(128);
registrarvehiculo.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("RegistrarVehiculo")),registrarvehiculo.mostCurrent.activityBA);
 BA.debugLineNum = 41;BA.debugLine="Activity.Title=\"Helmet APP - Registrar Vehículo\"";
Debug.ShouldStop(256);
registrarvehiculo.mostCurrent._activity.runMethod(false,"setTitle",BA.ObjectToCharSequence("Helmet APP - Registrar Vehículo"));
 BA.debugLineNum = 42;BA.debugLine="btnConnect.Visible=True";
Debug.ShouldStop(512);
registrarvehiculo.mostCurrent._btnconnect.runMethod(true,"setVisible",registrarvehiculo.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 43;BA.debugLine="btnDisconnect.Visible=False";
Debug.ShouldStop(1024);
registrarvehiculo.mostCurrent._btndisconnect.runMethod(true,"setVisible",registrarvehiculo.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 46;BA.debugLine="bluetoothOff.Initialize(LoadBitmap(File.DirAssets";
Debug.ShouldStop(8192);
registrarvehiculo.mostCurrent._bluetoothoff.runVoidMethod ("Initialize",(Object)((registrarvehiculo.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(registrarvehiculo.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("bluetoothoff (1).png"))).getObject())));
 BA.debugLineNum = 47;BA.debugLine="bluetoothOff.Gravity= Gravity.FILL";
Debug.ShouldStop(16384);
registrarvehiculo.mostCurrent._bluetoothoff.runMethod(true,"setGravity",registrarvehiculo.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 48;BA.debugLine="btnConnect.Background= bluetoothOff";
Debug.ShouldStop(32768);
registrarvehiculo.mostCurrent._btnconnect.runMethod(false,"setBackground",(registrarvehiculo.mostCurrent._bluetoothoff.getObject()));
 BA.debugLineNum = 50;BA.debugLine="bluetoothOn.Initialize(LoadBitmap(File.DirAssets,";
Debug.ShouldStop(131072);
registrarvehiculo.mostCurrent._bluetoothon.runVoidMethod ("Initialize",(Object)((registrarvehiculo.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(registrarvehiculo.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("bluetoothon (1).png"))).getObject())));
 BA.debugLineNum = 51;BA.debugLine="bluetoothOn.Gravity=Gravity.FILL";
Debug.ShouldStop(262144);
registrarvehiculo.mostCurrent._bluetoothon.runMethod(true,"setGravity",registrarvehiculo.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 52;BA.debugLine="btnDisconnect.Background=bluetoothOn";
Debug.ShouldStop(524288);
registrarvehiculo.mostCurrent._btndisconnect.runMethod(false,"setBackground",(registrarvehiculo.mostCurrent._bluetoothon.getObject()));
 BA.debugLineNum = 54;BA.debugLine="IngresarCascoID.IDcasco=usuarios.leerHelmetID(Mai";
Debug.ShouldStop(2097152);
registrarvehiculo.mostCurrent._ingresarcascoid._idcasco = registrarvehiculo.mostCurrent._usuarios.runClassMethod (b4a.HelmetAPPV3.usuarios.class, "_leerhelmetid",(Object)(registrarvehiculo.mostCurrent._main._dni));
 BA.debugLineNum = 57;BA.debugLine="Log(\"El formato que se enviará al HelmetRX es: A\"";
Debug.ShouldStop(16777216);
registrarvehiculo.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("El formato que se enviará al HelmetRX es: A"),registrarvehiculo.mostCurrent._main._dni,RemoteObject.createImmutable("P"),registrarvehiculo.mostCurrent._ingresarcascoid._idcasco,registrarvehiculo.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 10))))));
 BA.debugLineNum = 61;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("Activity_Pause (registrarvehiculo) ","registrarvehiculo",2,registrarvehiculo.mostCurrent.activityBA,registrarvehiculo.mostCurrent,87);
if (RapidSub.canDelegate("activity_pause")) { return b4a.HelmetAPPV3.registrarvehiculo.remoteMe.runUserSub(false, "registrarvehiculo","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 87;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(4194304);
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (registrarvehiculo) ","registrarvehiculo",2,registrarvehiculo.mostCurrent.activityBA,registrarvehiculo.mostCurrent,63);
if (RapidSub.canDelegate("activity_resume")) { return b4a.HelmetAPPV3.registrarvehiculo.remoteMe.runUserSub(false, "registrarvehiculo","activity_resume");}
 BA.debugLineNum = 63;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 64;BA.debugLine="SetState";
Debug.ShouldStop(-2147483648);
_setstate();
 BA.debugLineNum = 65;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnagregarcascoprincipal_click() throws Exception{
try {
		Debug.PushSubsStack("btnAgregarCascoPrincipal_Click (registrarvehiculo) ","registrarvehiculo",2,registrarvehiculo.mostCurrent.activityBA,registrarvehiculo.mostCurrent,120);
if (RapidSub.canDelegate("btnagregarcascoprincipal_click")) { return b4a.HelmetAPPV3.registrarvehiculo.remoteMe.runUserSub(false, "registrarvehiculo","btnagregarcascoprincipal_click");}
 BA.debugLineNum = 120;BA.debugLine="Sub btnAgregarCascoPrincipal_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 122;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnagregarcascosecundario_click() throws Exception{
try {
		Debug.PushSubsStack("btnAgregarCascoSecundario_Click (registrarvehiculo) ","registrarvehiculo",2,registrarvehiculo.mostCurrent.activityBA,registrarvehiculo.mostCurrent,124);
if (RapidSub.canDelegate("btnagregarcascosecundario_click")) { return b4a.HelmetAPPV3.registrarvehiculo.remoteMe.runUserSub(false, "registrarvehiculo","btnagregarcascosecundario_click");}
 BA.debugLineNum = 124;BA.debugLine="Sub btnAgregarCascoSecundario_Click";
Debug.ShouldStop(134217728);
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
public static RemoteObject  _btnconnect_click() throws Exception{
try {
		Debug.PushSubsStack("btnConnect_Click (registrarvehiculo) ","registrarvehiculo",2,registrarvehiculo.mostCurrent.activityBA,registrarvehiculo.mostCurrent,99);
if (RapidSub.canDelegate("btnconnect_click")) { return b4a.HelmetAPPV3.registrarvehiculo.remoteMe.runUserSub(false, "registrarvehiculo","btnconnect_click");}
 BA.debugLineNum = 99;BA.debugLine="Sub btnConnect_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 109;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btndisconnect_click() throws Exception{
try {
		Debug.PushSubsStack("btnDisconnect_Click (registrarvehiculo) ","registrarvehiculo",2,registrarvehiculo.mostCurrent.activityBA,registrarvehiculo.mostCurrent,115);
if (RapidSub.canDelegate("btndisconnect_click")) { return b4a.HelmetAPPV3.registrarvehiculo.remoteMe.runUserSub(false, "registrarvehiculo","btndisconnect_click");}
 BA.debugLineNum = 115;BA.debugLine="Sub btnDisconnect_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 116;BA.debugLine="btnDisconnect.Visible=False";
Debug.ShouldStop(524288);
registrarvehiculo.mostCurrent._btndisconnect.runMethod(true,"setVisible",registrarvehiculo.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 117;BA.debugLine="btnConnect.Visible=True";
Debug.ShouldStop(1048576);
registrarvehiculo.mostCurrent._btnconnect.runMethod(true,"setVisible",registrarvehiculo.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 118;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnleer_click() throws Exception{
try {
		Debug.PushSubsStack("btnLeer_Click (registrarvehiculo) ","registrarvehiculo",2,registrarvehiculo.mostCurrent.activityBA,registrarvehiculo.mostCurrent,144);
if (RapidSub.canDelegate("btnleer_click")) { return b4a.HelmetAPPV3.registrarvehiculo.remoteMe.runUserSub(false, "registrarvehiculo","btnleer_click");}
 BA.debugLineNum = 144;BA.debugLine="Sub btnLeer_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 145;BA.debugLine="CallSub(Starter,\"enviarLeer\")";
Debug.ShouldStop(65536);
registrarvehiculo.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",registrarvehiculo.processBA,(Object)((registrarvehiculo.mostCurrent._starter.getObject())),(Object)(RemoteObject.createImmutable("enviarLeer")));
 BA.debugLineNum = 146;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnlimpiar_click() throws Exception{
try {
		Debug.PushSubsStack("btnLimpiar_Click (registrarvehiculo) ","registrarvehiculo",2,registrarvehiculo.mostCurrent.activityBA,registrarvehiculo.mostCurrent,148);
if (RapidSub.canDelegate("btnlimpiar_click")) { return b4a.HelmetAPPV3.registrarvehiculo.remoteMe.runUserSub(false, "registrarvehiculo","btnlimpiar_click");}
 BA.debugLineNum = 148;BA.debugLine="Sub btnLimpiar_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 149;BA.debugLine="CallSub(Starter,\"enviarLimpiar\")";
Debug.ShouldStop(1048576);
registrarvehiculo.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",registrarvehiculo.processBA,(Object)((registrarvehiculo.mostCurrent._starter.getObject())),(Object)(RemoteObject.createImmutable("enviarLimpiar")));
 BA.debugLineNum = 150;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Dim usuarios As Usuarios";
registrarvehiculo.mostCurrent._usuarios = RemoteObject.createNew ("b4a.HelmetAPPV3.usuarios");
 //BA.debugLineNum = 17;BA.debugLine="Private lblStatus As Label";
registrarvehiculo.mostCurrent._lblstatus = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private btnConnect As Button";
registrarvehiculo.mostCurrent._btnconnect = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private lblMessage As Label";
registrarvehiculo.mostCurrent._lblmessage = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private ProgressBar1 As ProgressBar";
registrarvehiculo.mostCurrent._progressbar1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ProgressBarWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private btnDisconnect As Button";
registrarvehiculo.mostCurrent._btndisconnect = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private btnAgregarCascoPrincipal As Button";
registrarvehiculo.mostCurrent._btnagregarcascoprincipal = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private btnAgregarCascoSecundario As Button";
registrarvehiculo.mostCurrent._btnagregarcascosecundario = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private pnlPrincipal As Panel";
registrarvehiculo.mostCurrent._pnlprincipal = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private lblFondo As Label";
registrarvehiculo.mostCurrent._lblfondo = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Dim bluetoothOn As BitmapDrawable";
registrarvehiculo.mostCurrent._bluetoothon = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
 //BA.debugLineNum = 28;BA.debugLine="Dim bluetoothOff As BitmapDrawable";
registrarvehiculo.mostCurrent._bluetoothoff = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
 //BA.debugLineNum = 31;BA.debugLine="Private lblTres As Label";
registrarvehiculo.mostCurrent._lbltres = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private tglbtnConexion As ToggleButton";
registrarvehiculo.mostCurrent._tglbtnconexion = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private btnLeer As Button";
registrarvehiculo.mostCurrent._btnleer = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private btnLimpiar As Button";
registrarvehiculo.mostCurrent._btnlimpiar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lblstatus_click() throws Exception{
try {
		Debug.PushSubsStack("lblStatus_Click (registrarvehiculo) ","registrarvehiculo",2,registrarvehiculo.mostCurrent.activityBA,registrarvehiculo.mostCurrent,111);
if (RapidSub.canDelegate("lblstatus_click")) { return b4a.HelmetAPPV3.registrarvehiculo.remoteMe.runUserSub(false, "registrarvehiculo","lblstatus_click");}
 BA.debugLineNum = 111;BA.debugLine="Sub lblStatus_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 113;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _messagefromdevice(RemoteObject _msg) throws Exception{
try {
		Debug.PushSubsStack("MessageFromDevice (registrarvehiculo) ","registrarvehiculo",2,registrarvehiculo.mostCurrent.activityBA,registrarvehiculo.mostCurrent,83);
if (RapidSub.canDelegate("messagefromdevice")) { return b4a.HelmetAPPV3.registrarvehiculo.remoteMe.runUserSub(false, "registrarvehiculo","messagefromdevice", _msg);}
Debug.locals.put("msg", _msg);
 BA.debugLineNum = 83;BA.debugLine="Public Sub MessageFromDevice(msg As String)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 84;BA.debugLine="lblMessage.Text = msg";
Debug.ShouldStop(524288);
registrarvehiculo.mostCurrent._lblmessage.runMethod(true,"setText",BA.ObjectToCharSequence(_msg));
 BA.debugLineNum = 85;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 8;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 11;BA.debugLine="Private rp As RuntimePermissions";
registrarvehiculo._rp = RemoteObject.createNew ("anywheresoftware.b4a.objects.RuntimePermissions");
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _setstate() throws Exception{
try {
		Debug.PushSubsStack("SetState (registrarvehiculo) ","registrarvehiculo",2,registrarvehiculo.mostCurrent.activityBA,registrarvehiculo.mostCurrent,67);
if (RapidSub.canDelegate("setstate")) { return b4a.HelmetAPPV3.registrarvehiculo.remoteMe.runUserSub(false, "registrarvehiculo","setstate");}
RemoteObject _status = RemoteObject.createImmutable("");
 BA.debugLineNum = 67;BA.debugLine="Public Sub SetState";
Debug.ShouldStop(4);
 BA.debugLineNum = 69;BA.debugLine="btnConnect.Enabled = Not(Starter.connected)";
Debug.ShouldStop(16);
registrarvehiculo.mostCurrent._btnconnect.runMethod(true,"setEnabled",registrarvehiculo.mostCurrent.__c.runMethod(true,"Not",(Object)(registrarvehiculo.mostCurrent._starter._connected)));
 BA.debugLineNum = 70;BA.debugLine="ProgressBar1.Visible = Starter.connecting";
Debug.ShouldStop(32);
registrarvehiculo.mostCurrent._progressbar1.runMethod(true,"setVisible",registrarvehiculo.mostCurrent._starter._connecting);
 BA.debugLineNum = 71;BA.debugLine="Dim status As String";
Debug.ShouldStop(64);
_status = RemoteObject.createImmutable("");Debug.locals.put("status", _status);
 BA.debugLineNum = 72;BA.debugLine="If Starter.connected Then";
Debug.ShouldStop(128);
if (registrarvehiculo.mostCurrent._starter._connected.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 73;BA.debugLine="status = \"Conectado\"";
Debug.ShouldStop(256);
_status = BA.ObjectToString("Conectado");Debug.locals.put("status", _status);
 BA.debugLineNum = 74;BA.debugLine="CallSub(Starter,\"enviar\")";
Debug.ShouldStop(512);
registrarvehiculo.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",registrarvehiculo.processBA,(Object)((registrarvehiculo.mostCurrent._starter.getObject())),(Object)(RemoteObject.createImmutable("enviar")));
 }else 
{ BA.debugLineNum = 75;BA.debugLine="else if Starter.connecting Then";
Debug.ShouldStop(1024);
if (registrarvehiculo.mostCurrent._starter._connecting.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 76;BA.debugLine="status = \"Procesando...\"";
Debug.ShouldStop(2048);
_status = BA.ObjectToString("Procesando...");Debug.locals.put("status", _status);
 }else {
 BA.debugLineNum = 78;BA.debugLine="status = \"Desconectado\"";
Debug.ShouldStop(8192);
_status = BA.ObjectToString("Desconectado");Debug.locals.put("status", _status);
 }}
;
 BA.debugLineNum = 80;BA.debugLine="lblStatus.Text = $\"Status: ${status}\"$";
Debug.ShouldStop(32768);
registrarvehiculo.mostCurrent._lblstatus.runMethod(true,"setText",BA.ObjectToCharSequence((RemoteObject.concat(RemoteObject.createImmutable("Status: "),registrarvehiculo.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_status))),RemoteObject.createImmutable("")))));
 BA.debugLineNum = 81;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _switch1_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("Switch1_CheckedChange (registrarvehiculo) ","registrarvehiculo",2,registrarvehiculo.mostCurrent.activityBA,registrarvehiculo.mostCurrent,92);
if (RapidSub.canDelegate("switch1_checkedchange")) { return b4a.HelmetAPPV3.registrarvehiculo.remoteMe.runUserSub(false, "registrarvehiculo","switch1_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 92;BA.debugLine="Sub Switch1_CheckedChange(Checked As Boolean)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 94;BA.debugLine="If Checked Then";
Debug.ShouldStop(536870912);
if (_checked.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 95;BA.debugLine="CallSub(Starter, \"enviar\")";
Debug.ShouldStop(1073741824);
registrarvehiculo.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",registrarvehiculo.processBA,(Object)((registrarvehiculo.mostCurrent._starter.getObject())),(Object)(RemoteObject.createImmutable("enviar")));
 };
 BA.debugLineNum = 97;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _tglbtnconexion_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("tglbtnConexion_CheckedChange (registrarvehiculo) ","registrarvehiculo",2,registrarvehiculo.mostCurrent.activityBA,registrarvehiculo.mostCurrent,129);
if (RapidSub.canDelegate("tglbtnconexion_checkedchange")) { b4a.HelmetAPPV3.registrarvehiculo.remoteMe.runUserSub(false, "registrarvehiculo","tglbtnconexion_checkedchange", _checked); return;}
ResumableSub_tglbtnConexion_CheckedChange rsub = new ResumableSub_tglbtnConexion_CheckedChange(null,_checked);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_tglbtnConexion_CheckedChange extends BA.ResumableSub {
public ResumableSub_tglbtnConexion_CheckedChange(b4a.HelmetAPPV3.registrarvehiculo parent,RemoteObject _checked) {
this.parent = parent;
this._checked = _checked;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.HelmetAPPV3.registrarvehiculo parent;
RemoteObject _checked;
RemoteObject _permission = RemoteObject.createImmutable("");
RemoteObject _result = RemoteObject.createImmutable(false);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("tglbtnConexion_CheckedChange (registrarvehiculo) ","registrarvehiculo",2,registrarvehiculo.mostCurrent.activityBA,registrarvehiculo.mostCurrent,129);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 130;BA.debugLine="If Checked Then";
Debug.ShouldStop(2);
if (true) break;

case 1:
//if
this.state = 10;
if (_checked.<Boolean>get().booleanValue()) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 131;BA.debugLine="btnConnect.Visible=False";
Debug.ShouldStop(4);
parent.mostCurrent._btnconnect.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 132;BA.debugLine="btnDisconnect.Visible=True";
Debug.ShouldStop(8);
parent.mostCurrent._btndisconnect.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 133;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_ACCESS_COARSE_L";
Debug.ShouldStop(16);
parent._rp.runVoidMethod ("CheckAndRequest",registrarvehiculo.processBA,(Object)(parent._rp.getField(true,"PERMISSION_ACCESS_COARSE_LOCATION")));
 BA.debugLineNum = 134;BA.debugLine="Wait For Activity_PermissionResult (Permission A";
Debug.ShouldStop(32);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","activity_permissionresult", registrarvehiculo.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this), null);
this.state = 11;
return;
case 11:
//C
this.state = 4;
_permission = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Permission", _permission);
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(1));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 135;BA.debugLine="If Result Then";
Debug.ShouldStop(64);
if (true) break;

case 4:
//if
this.state = 9;
if (_result.<Boolean>get().booleanValue()) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 9;
 BA.debugLineNum = 136;BA.debugLine="CallSub(Starter, \"Connect\")";
Debug.ShouldStop(128);
parent.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",registrarvehiculo.processBA,(Object)((parent.mostCurrent._starter.getObject())),(Object)(RemoteObject.createImmutable("Connect")));
 if (true) break;

case 8:
//C
this.state = 9;
 BA.debugLineNum = 138;BA.debugLine="ToastMessageShow(\"No permission\", True)";
Debug.ShouldStop(512);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No permission")),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 if (true) break;

case 9:
//C
this.state = 10;
;
 if (true) break;

case 10:
//C
this.state = -1;
;
 BA.debugLineNum = 142;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static void  _activity_permissionresult(RemoteObject _permission,RemoteObject _result) throws Exception{
}
}