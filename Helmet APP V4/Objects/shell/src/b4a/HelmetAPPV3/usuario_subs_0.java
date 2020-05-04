package b4a.HelmetAPPV3;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class usuario_subs_0 {


public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Public dni As Int";
usuario._dni = RemoteObject.createImmutable(0);__ref.setField("_dni",usuario._dni);
 //BA.debugLineNum = 3;BA.debugLine="Public clave As Int";
usuario._clave = RemoteObject.createImmutable(0);__ref.setField("_clave",usuario._clave);
 //BA.debugLineNum = 4;BA.debugLine="Public helmetID As Long  'int en B4A son 32 bits";
usuario._helmetid = RemoteObject.createImmutable(0L);__ref.setField("_helmetid",usuario._helmetid);
 //BA.debugLineNum = 5;BA.debugLine="Public motoID As Int";
usuario._motoid = RemoteObject.createImmutable(0);__ref.setField("_motoid",usuario._motoid);
 //BA.debugLineNum = 6;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("Initialize (usuario) ","usuario",5,__ref.getField(false, "ba"),__ref,9);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "usuario","initialize", __ref, _ba);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
 BA.debugLineNum = 9;BA.debugLine="Public Sub Initialize";
Debug.ShouldStop(256);
 BA.debugLineNum = 11;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}