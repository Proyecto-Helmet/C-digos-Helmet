package b4a.HelmetAPPV3;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _actividad(RemoteObject _dniingresado) throws Exception{
try {
		Debug.PushSubsStack("actividad (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,198);
if (RapidSub.canDelegate("actividad")) { return b4a.HelmetAPPV3.main.remoteMe.runUserSub(false, "main","actividad", _dniingresado);}
RemoteObject _existehelmetid = RemoteObject.createImmutable(false);
RemoteObject _existemotoid = RemoteObject.createImmutable(false);
Debug.locals.put("DniIngresado", _dniingresado);
 BA.debugLineNum = 198;BA.debugLine="Sub actividad (DniIngresado As String)";
Debug.ShouldStop(32);
 BA.debugLineNum = 199;BA.debugLine="Dim existeHelmetID As Boolean";
Debug.ShouldStop(64);
_existehelmetid = RemoteObject.createImmutable(false);Debug.locals.put("existeHelmetID", _existehelmetid);
 BA.debugLineNum = 200;BA.debugLine="Dim existeMotoID As Boolean";
Debug.ShouldStop(128);
_existemotoid = RemoteObject.createImmutable(false);Debug.locals.put("existeMotoID", _existemotoid);
 BA.debugLineNum = 201;BA.debugLine="dni=edtxtDNI.Text";
Debug.ShouldStop(256);
main._dni = main.mostCurrent._edtxtdni.runMethod(true,"getText");
 BA.debugLineNum = 202;BA.debugLine="existeHelmetID=usuarios.chequearHelmetId(DniIngre";
Debug.ShouldStop(512);
_existehelmetid = main.mostCurrent._usuarios.runClassMethod (b4a.HelmetAPPV3.usuarios.class, "_chequearhelmetid",(Object)(_dniingresado));Debug.locals.put("existeHelmetID", _existehelmetid);
 BA.debugLineNum = 205;BA.debugLine="If existeHelmetID=True Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",_existehelmetid,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 206;BA.debugLine="StartActivity(\"RegistrarVehiculo\")";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((RemoteObject.createImmutable("RegistrarVehiculo"))));
 }else {
 BA.debugLineNum = 208;BA.debugLine="StartActivity(\"IngresarCascoID\")";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((RemoteObject.createImmutable("IngresarCascoID"))));
 };
 BA.debugLineNum = 210;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,43);
if (RapidSub.canDelegate("activity_create")) { return b4a.HelmetAPPV3.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 43;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 45;BA.debugLine="Activity.LoadLayout(\"RegistroUsuario\")";
Debug.ShouldStop(4096);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("RegistroUsuario")),main.mostCurrent.activityBA);
 BA.debugLineNum = 46;BA.debugLine="Activity.Title=\"Helmet APP - Registrar Usuario\"";
Debug.ShouldStop(8192);
main.mostCurrent._activity.runMethod(false,"setTitle",BA.ObjectToCharSequence("Helmet APP - Registrar Usuario"));
 BA.debugLineNum = 48;BA.debugLine="btnContinuarRegistro.Visible=True 'si no se ingre";
Debug.ShouldStop(32768);
main.mostCurrent._btncontinuarregistro.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 49;BA.debugLine="btnIngresar.Visible=True";
Debug.ShouldStop(65536);
main.mostCurrent._btningresar.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 50;BA.debugLine="btnContinuarRegistro.Enabled=False";
Debug.ShouldStop(131072);
main.mostCurrent._btncontinuarregistro.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 51;BA.debugLine="btnIngresar.Enabled=False";
Debug.ShouldStop(262144);
main.mostCurrent._btningresar.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 53;BA.debugLine="lblErroneo.Visible=False";
Debug.ShouldStop(1048576);
main.mostCurrent._lblerroneo.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 54;BA.debugLine="usuarios.Initialize";
Debug.ShouldStop(2097152);
main.mostCurrent._usuarios.runClassMethod (b4a.HelmetAPPV3.usuarios.class, "_initialize",main.processBA);
 BA.debugLineNum = 65;BA.debugLine="usuarios.leerUSUARIOS";
Debug.ShouldStop(1);
main.mostCurrent._usuarios.runClassMethod (b4a.HelmetAPPV3.usuarios.class, "_leerusuarios");
 BA.debugLineNum = 68;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,74);
if (RapidSub.canDelegate("activity_pause")) { return b4a.HelmetAPPV3.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 74;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(512);
 BA.debugLineNum = 76;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,70);
if (RapidSub.canDelegate("activity_resume")) { return b4a.HelmetAPPV3.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 70;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(32);
 BA.debugLineNum = 72;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btncontinuarregistro_click() throws Exception{
try {
		Debug.PushSubsStack("btnContinuarRegistro_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,80);
if (RapidSub.canDelegate("btncontinuarregistro_click")) { return b4a.HelmetAPPV3.main.remoteMe.runUserSub(false, "main","btncontinuarregistro_click");}
RemoteObject _dniusado = RemoteObject.createImmutable(false);
 BA.debugLineNum = 80;BA.debugLine="Sub btnContinuarRegistro_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 82;BA.debugLine="Dim DNIusado As Boolean";
Debug.ShouldStop(131072);
_dniusado = RemoteObject.createImmutable(false);Debug.locals.put("DNIusado", _dniusado);
 BA.debugLineNum = 84;BA.debugLine="If edtxtDNI.Text.Length = 8 Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",main.mostCurrent._edtxtdni.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 8))) { 
 BA.debugLineNum = 85;BA.debugLine="If edtxtClave.Text.Length = 4 Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",main.mostCurrent._edtxtclave.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 4))) { 
 BA.debugLineNum = 87;BA.debugLine="DNIusado=usuarios.chequearDNI(edtxtDNI.Text)  '";
Debug.ShouldStop(4194304);
_dniusado = main.mostCurrent._usuarios.runClassMethod (b4a.HelmetAPPV3.usuarios.class, "_chequeardni",(Object)(main.mostCurrent._edtxtdni.runMethod(true,"getText")));Debug.locals.put("DNIusado", _dniusado);
 BA.debugLineNum = 88;BA.debugLine="If DNIusado=True Then  'ya hay un usuario con e";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",_dniusado,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 89;BA.debugLine="lblErroneo.Visible=True";
Debug.ShouldStop(16777216);
main.mostCurrent._lblerroneo.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 90;BA.debugLine="lblErroneo.Text=\"el DNI ingresado pertenece a";
Debug.ShouldStop(33554432);
main.mostCurrent._lblerroneo.runMethod(true,"setText",BA.ObjectToCharSequence("el DNI ingresado pertenece a un usuario ya registrado"));
 BA.debugLineNum = 91;BA.debugLine="Log(\"ya hay un dni registrado\")";
Debug.ShouldStop(67108864);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("ya hay un dni registrado")));
 }else {
 BA.debugLineNum = 93;BA.debugLine="Log(\"-----------------------------------------";
Debug.ShouldStop(268435456);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("--------------------------------------------")));
 BA.debugLineNum = 94;BA.debugLine="Log(\"dni ingresado válido\")";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("dni ingresado válido")));
 BA.debugLineNum = 95;BA.debugLine="lblErroneo.Visible=False";
Debug.ShouldStop(1073741824);
main.mostCurrent._lblerroneo.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 96;BA.debugLine="dni=edtxtDNI.Text";
Debug.ShouldStop(-2147483648);
main._dni = main.mostCurrent._edtxtdni.runMethod(true,"getText");
 BA.debugLineNum = 97;BA.debugLine="clave=edtxtClave.Text";
Debug.ShouldStop(1);
main._clave = main.mostCurrent._edtxtclave.runMethod(true,"getText");
 BA.debugLineNum = 98;BA.debugLine="usuarios.insertarDNICLAVE(dni,clave)";
Debug.ShouldStop(2);
main.mostCurrent._usuarios.runClassMethod (b4a.HelmetAPPV3.usuarios.class, "_insertardniclave",(Object)(BA.numberCast(int.class, main._dni)),(Object)(BA.numberCast(int.class, main._clave)));
 BA.debugLineNum = 99;BA.debugLine="ProgressBar1.Enabled=True";
Debug.ShouldStop(4);
main.mostCurrent._progressbar1.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 100;BA.debugLine="Log(\"DNI y Clave ingresados en la base de dato";
Debug.ShouldStop(8);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("DNI y Clave ingresados en la base de datos")));
 BA.debugLineNum = 101;BA.debugLine="Log(\"DNI: \"&dni)";
Debug.ShouldStop(16);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("DNI: "),main._dni)));
 BA.debugLineNum = 102;BA.debugLine="Log(\"CLAVE: \"&clave)";
Debug.ShouldStop(32);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("CLAVE: "),main._clave)));
 BA.debugLineNum = 103;BA.debugLine="StartActivity(\"IngresarCascoID\")";
Debug.ShouldStop(64);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((RemoteObject.createImmutable("IngresarCascoID"))));
 };
 }else {
 BA.debugLineNum = 108;BA.debugLine="lblErroneo.Text=\"clave errónea\"";
Debug.ShouldStop(2048);
main.mostCurrent._lblerroneo.runMethod(true,"setText",BA.ObjectToCharSequence("clave errónea"));
 BA.debugLineNum = 109;BA.debugLine="lblErroneo.Visible=True";
Debug.ShouldStop(4096);
main.mostCurrent._lblerroneo.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 };
 }else {
 BA.debugLineNum = 112;BA.debugLine="lblErroneo.Text= \"DNI erróneo\"";
Debug.ShouldStop(32768);
main.mostCurrent._lblerroneo.runMethod(true,"setText",BA.ObjectToCharSequence("DNI erróneo"));
 BA.debugLineNum = 113;BA.debugLine="lblErroneo.Visible=True";
Debug.ShouldStop(65536);
main.mostCurrent._lblerroneo.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 116;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btningresar_click() throws Exception{
try {
		Debug.PushSubsStack("btnIngresar_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,147);
if (RapidSub.canDelegate("btningresar_click")) { return b4a.HelmetAPPV3.main.remoteMe.runUserSub(false, "main","btningresar_click");}
RemoteObject _dniexistente = RemoteObject.createImmutable(false);
RemoteObject _clavecorrecta = RemoteObject.createImmutable(false);
 BA.debugLineNum = 147;BA.debugLine="Sub btnIngresar_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 148;BA.debugLine="Dim DniExistente As Boolean";
Debug.ShouldStop(524288);
_dniexistente = RemoteObject.createImmutable(false);Debug.locals.put("DniExistente", _dniexistente);
 BA.debugLineNum = 149;BA.debugLine="Dim ClaveCorrecta As Boolean";
Debug.ShouldStop(1048576);
_clavecorrecta = RemoteObject.createImmutable(false);Debug.locals.put("ClaveCorrecta", _clavecorrecta);
 BA.debugLineNum = 150;BA.debugLine="DniExistente=False";
Debug.ShouldStop(2097152);
_dniexistente = main.mostCurrent.__c.getField(true,"False");Debug.locals.put("DniExistente", _dniexistente);
 BA.debugLineNum = 151;BA.debugLine="ProgressBar1.Visible=True";
Debug.ShouldStop(4194304);
main.mostCurrent._progressbar1.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 154;BA.debugLine="If edtxtDNI.Text.Length = 8 Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",main.mostCurrent._edtxtdni.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 8))) { 
 BA.debugLineNum = 155;BA.debugLine="If edtxtClave.Text.Length = 4 Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",main.mostCurrent._edtxtclave.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 4))) { 
 BA.debugLineNum = 156;BA.debugLine="DniExistente= usuarios.chequearDNI(edtxtDNI.Tex";
Debug.ShouldStop(134217728);
_dniexistente = main.mostCurrent._usuarios.runClassMethod (b4a.HelmetAPPV3.usuarios.class, "_chequeardni",(Object)(main.mostCurrent._edtxtdni.runMethod(true,"getText")));Debug.locals.put("DniExistente", _dniexistente);
 BA.debugLineNum = 157;BA.debugLine="If DniExistente=True Then    'si existe chequea";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",_dniexistente,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 158;BA.debugLine="ClaveCorrecta=usuarios.chequearCLAVE(edtxtDNI.";
Debug.ShouldStop(536870912);
_clavecorrecta = main.mostCurrent._usuarios.runClassMethod (b4a.HelmetAPPV3.usuarios.class, "_chequearclave",(Object)(main.mostCurrent._edtxtdni.runMethod(true,"getText")),(Object)(main.mostCurrent._edtxtclave.runMethod(true,"getText")));Debug.locals.put("ClaveCorrecta", _clavecorrecta);
 BA.debugLineNum = 159;BA.debugLine="If ClaveCorrecta=True Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",_clavecorrecta,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 160;BA.debugLine="ProgressBar1.Visible=False";
Debug.ShouldStop(-2147483648);
main.mostCurrent._progressbar1.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 161;BA.debugLine="actividad(edtxtDNI.Text) 'decide hacia que ac";
Debug.ShouldStop(1);
_actividad(main.mostCurrent._edtxtdni.runMethod(true,"getText"));
 };
 BA.debugLineNum = 164;BA.debugLine="If ClaveCorrecta=False Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",_clavecorrecta,main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 165;BA.debugLine="lblErroneo.Text=\"La clave no coincide con el";
Debug.ShouldStop(16);
main.mostCurrent._lblerroneo.runMethod(true,"setText",BA.ObjectToCharSequence("La clave no coincide con el DNI ingresado"));
 BA.debugLineNum = 166;BA.debugLine="lblErroneo.Visible=True";
Debug.ShouldStop(32);
main.mostCurrent._lblerroneo.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 167;BA.debugLine="ProgressBar1.Visible=False";
Debug.ShouldStop(64);
main.mostCurrent._progressbar1.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 };
 };
 BA.debugLineNum = 170;BA.debugLine="If DniExistente=False Then   'si no existe en l";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",_dniexistente,main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 171;BA.debugLine="lblErroneo.Text=\"Usuario Inexistente, por favo";
Debug.ShouldStop(1024);
main.mostCurrent._lblerroneo.runMethod(true,"setText",BA.ObjectToCharSequence("Usuario Inexistente, por favor registre su DNI y su Clave"));
 BA.debugLineNum = 172;BA.debugLine="lblErroneo.Visible=True";
Debug.ShouldStop(2048);
main.mostCurrent._lblerroneo.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 173;BA.debugLine="ProgressBar1.Visible=False";
Debug.ShouldStop(4096);
main.mostCurrent._progressbar1.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 };
 }else {
 BA.debugLineNum = 176;BA.debugLine="lblErroneo.Text=\"clave errónea\"";
Debug.ShouldStop(32768);
main.mostCurrent._lblerroneo.runMethod(true,"setText",BA.ObjectToCharSequence("clave errónea"));
 BA.debugLineNum = 177;BA.debugLine="ProgressBar1.Visible=False";
Debug.ShouldStop(65536);
main.mostCurrent._progressbar1.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 178;BA.debugLine="lblErroneo.Visible=True";
Debug.ShouldStop(131072);
main.mostCurrent._lblerroneo.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 };
 }else {
 BA.debugLineNum = 181;BA.debugLine="lblErroneo.Text= \"DNI erróneo\"";
Debug.ShouldStop(1048576);
main.mostCurrent._lblerroneo.runMethod(true,"setText",BA.ObjectToCharSequence("DNI erróneo"));
 BA.debugLineNum = 182;BA.debugLine="ProgressBar1.Visible=False";
Debug.ShouldStop(2097152);
main.mostCurrent._progressbar1.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 183;BA.debugLine="lblErroneo.Visible=True";
Debug.ShouldStop(4194304);
main.mostCurrent._lblerroneo.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 187;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("btnLimpiar_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,193);
if (RapidSub.canDelegate("btnlimpiar_click")) { return b4a.HelmetAPPV3.main.remoteMe.runUserSub(false, "main","btnlimpiar_click");}
 BA.debugLineNum = 193;BA.debugLine="Sub btnLimpiar_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 194;BA.debugLine="usuarios.borrarTODO";
Debug.ShouldStop(2);
main.mostCurrent._usuarios.runClassMethod (b4a.HelmetAPPV3.usuarios.class, "_borrartodo");
 BA.debugLineNum = 195;BA.debugLine="usuarios.leerUSUARIOS";
Debug.ShouldStop(4);
main.mostCurrent._usuarios.runClassMethod (b4a.HelmetAPPV3.usuarios.class, "_leerusuarios");
 BA.debugLineNum = 196;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _edtxtclave_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("edtxtClave_TextChanged (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,118);
if (RapidSub.canDelegate("edtxtclave_textchanged")) { return b4a.HelmetAPPV3.main.remoteMe.runUserSub(false, "main","edtxtclave_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 118;BA.debugLine="Sub edtxtClave_TextChanged (Old As String, New As";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 119;BA.debugLine="If edtxtClave.Text <> \"\"  Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("!",main.mostCurrent._edtxtclave.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 120;BA.debugLine="If edtxtDNI.Text<>\"\" Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("!",main.mostCurrent._edtxtdni.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 121;BA.debugLine="btnContinuarRegistro.Enabled=True";
Debug.ShouldStop(16777216);
main.mostCurrent._btncontinuarregistro.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 122;BA.debugLine="btnIngresar.Enabled=True";
Debug.ShouldStop(33554432);
main.mostCurrent._btningresar.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 124;BA.debugLine="btnContinuarRegistro.Enabled=False";
Debug.ShouldStop(134217728);
main.mostCurrent._btncontinuarregistro.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 125;BA.debugLine="btnIngresar.Enabled=False";
Debug.ShouldStop(268435456);
main.mostCurrent._btningresar.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 };
 }else {
 BA.debugLineNum = 128;BA.debugLine="btnContinuarRegistro.Enabled=False";
Debug.ShouldStop(-2147483648);
main.mostCurrent._btncontinuarregistro.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 129;BA.debugLine="btnIngresar.Enabled=False";
Debug.ShouldStop(1);
main.mostCurrent._btningresar.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 131;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _edtxtdni_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("edtxtDNI_TextChanged (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,133);
if (RapidSub.canDelegate("edtxtdni_textchanged")) { return b4a.HelmetAPPV3.main.remoteMe.runUserSub(false, "main","edtxtdni_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 133;BA.debugLine="Sub edtxtDNI_TextChanged (Old As String, New As St";
Debug.ShouldStop(16);
 BA.debugLineNum = 134;BA.debugLine="If edtxtClave.Text <> \"\"  Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("!",main.mostCurrent._edtxtclave.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 135;BA.debugLine="If edtxtDNI.Text<>\"\" Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("!",main.mostCurrent._edtxtdni.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 136;BA.debugLine="btnContinuarRegistro.Enabled=True";
Debug.ShouldStop(128);
main.mostCurrent._btncontinuarregistro.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 137;BA.debugLine="btnIngresar.Enabled=True";
Debug.ShouldStop(256);
main.mostCurrent._btningresar.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 };
 }else {
 BA.debugLineNum = 141;BA.debugLine="btnContinuarRegistro.Enabled=False";
Debug.ShouldStop(4096);
main.mostCurrent._btncontinuarregistro.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 142;BA.debugLine="btnIngresar.Enabled=False";
Debug.ShouldStop(8192);
main.mostCurrent._btningresar.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 144;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 23;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 26;BA.debugLine="Private btnContinuarRegistro As Button";
main.mostCurrent._btncontinuarregistro = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private edtxtClave As EditText";
main.mostCurrent._edtxtclave = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private edtxtDNI As EditText";
main.mostCurrent._edtxtdni = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private lblClave As Label";
main.mostCurrent._lblclave = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private lblDNI As Label";
main.mostCurrent._lbldni = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private pnlRegistroUsuario As Panel";
main.mostCurrent._pnlregistrousuario = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private lblUno As Label";
main.mostCurrent._lbluno = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private lblErroneo As Label";
main.mostCurrent._lblerroneo = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private ProgressBar1 As ProgressBar";
main.mostCurrent._progressbar1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ProgressBarWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private btnIngresar As Button";
main.mostCurrent._btningresar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private btnLimpiar As Button";
main.mostCurrent._btnlimpiar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private lblCandado As Label";
main.mostCurrent._lblcandado = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Dim usuarios As Usuarios";
main.mostCurrent._usuarios = RemoteObject.createNew ("b4a.HelmetAPPV3.usuarios");
 //BA.debugLineNum = 41;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
ingresarcascoid_subs_0._process_globals();
registrarvehiculo_subs_0._process_globals();
pantallaprincipal_subs_0._process_globals();
starter_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.HelmetAPPV3.main");
ingresarcascoid.myClass = BA.getDeviceClass ("b4a.HelmetAPPV3.ingresarcascoid");
registrarvehiculo.myClass = BA.getDeviceClass ("b4a.HelmetAPPV3.registrarvehiculo");
asyncstreamstext.myClass = BA.getDeviceClass ("b4a.HelmetAPPV3.asyncstreamstext");
pantallaprincipal.myClass = BA.getDeviceClass ("b4a.HelmetAPPV3.pantallaprincipal");
usuario.myClass = BA.getDeviceClass ("b4a.HelmetAPPV3.usuario");
usuarios.myClass = BA.getDeviceClass ("b4a.HelmetAPPV3.usuarios");
starter.myClass = BA.getDeviceClass ("b4a.HelmetAPPV3.starter");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 16;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 19;BA.debugLine="Dim dni As String";
main._dni = RemoteObject.createImmutable("");
 //BA.debugLineNum = 20;BA.debugLine="Dim clave As String";
main._clave = RemoteObject.createImmutable("");
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}