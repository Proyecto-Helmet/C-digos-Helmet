package b4a.HelmetAPPV3;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class pantallaprincipal_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (pantallaprincipal) ","pantallaprincipal",4,pantallaprincipal.mostCurrent.activityBA,pantallaprincipal.mostCurrent,18);
if (RapidSub.canDelegate("activity_create")) { return b4a.HelmetAPPV3.pantallaprincipal.remoteMe.runUserSub(false, "pantallaprincipal","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 18;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 20;BA.debugLine="Activity.LoadLayout(\"pantallaPrincipal\")";
Debug.ShouldStop(524288);
pantallaprincipal.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("pantallaPrincipal")),pantallaprincipal.mostCurrent.activityBA);
 BA.debugLineNum = 21;BA.debugLine="Activity.Title=\"Helmet APP - Menu Principal\"";
Debug.ShouldStop(1048576);
pantallaprincipal.mostCurrent._activity.runMethod(false,"setTitle",BA.ObjectToCharSequence("Helmet APP - Menu Principal"));
 BA.debugLineNum = 23;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("Activity_Pause (pantallaprincipal) ","pantallaprincipal",4,pantallaprincipal.mostCurrent.activityBA,pantallaprincipal.mostCurrent,29);
if (RapidSub.canDelegate("activity_pause")) { return b4a.HelmetAPPV3.pantallaprincipal.remoteMe.runUserSub(false, "pantallaprincipal","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 29;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(268435456);
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (pantallaprincipal) ","pantallaprincipal",4,pantallaprincipal.mostCurrent.activityBA,pantallaprincipal.mostCurrent,25);
if (RapidSub.canDelegate("activity_resume")) { return b4a.HelmetAPPV3.pantallaprincipal.remoteMe.runUserSub(false, "pantallaprincipal","activity_resume");}
 BA.debugLineNum = 25;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 27;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}