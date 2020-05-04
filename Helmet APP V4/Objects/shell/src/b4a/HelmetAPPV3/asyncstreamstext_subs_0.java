package b4a.HelmetAPPV3;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class asyncstreamstext_subs_0 {


public static RemoteObject  _astreams_error(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("astreams_Error (asyncstreamstext) ","asyncstreamstext",3,__ref.getField(false, "ba"),__ref,54);
if (RapidSub.canDelegate("astreams_error")) { return __ref.runUserSub(false, "asyncstreamstext","astreams_error", __ref);}
 BA.debugLineNum = 54;BA.debugLine="Private Sub astreams_Error";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 55;BA.debugLine="Log(\"error: \" & LastException)";
Debug.ShouldStop(4194304);
asyncstreamstext.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("error: "),asyncstreamstext.__c.runMethod(false,"LastException",__ref.runMethod(false,"getActivityBA")))));
 BA.debugLineNum = 56;BA.debugLine="astreams.Close";
Debug.ShouldStop(8388608);
__ref.getField(false,"_astreams").runVoidMethod ("Close");
 BA.debugLineNum = 57;BA.debugLine="CallSubDelayed(mTarget, mEventName & \"_Terminated";
Debug.ShouldStop(16777216);
asyncstreamstext.__c.runVoidMethod ("CallSubDelayed",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_mtarget")),(Object)(RemoteObject.concat(__ref.getField(true,"_meventname"),RemoteObject.createImmutable("_Terminated"))));
 BA.debugLineNum = 58;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _astreams_newdata(RemoteObject __ref,RemoteObject _buffer) throws Exception{
try {
		Debug.PushSubsStack("astreams_NewData (asyncstreamstext) ","asyncstreamstext",3,__ref.getField(false, "ba"),__ref,26);
if (RapidSub.canDelegate("astreams_newdata")) { return __ref.runUserSub(false, "asyncstreamstext","astreams_newdata", __ref, _buffer);}
RemoteObject _newdatastart = RemoteObject.createImmutable(0);
RemoteObject _s = RemoteObject.createImmutable("");
RemoteObject _start = RemoteObject.createImmutable(0);
int _i = 0;
RemoteObject _c = RemoteObject.createImmutable('\0');
Debug.locals.put("Buffer", _buffer);
 BA.debugLineNum = 26;BA.debugLine="Private Sub astreams_NewData (Buffer() As Byte)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 27;BA.debugLine="Dim newDataStart As Int = sb.Length";
Debug.ShouldStop(67108864);
_newdatastart = __ref.getField(false,"_sb").runMethod(true,"getLength");Debug.locals.put("newDataStart", _newdatastart);Debug.locals.put("newDataStart", _newdatastart);
 BA.debugLineNum = 28;BA.debugLine="sb.Append(BytesToString(Buffer, 0, Buffer.Length,";
Debug.ShouldStop(134217728);
__ref.getField(false,"_sb").runVoidMethod ("Append",(Object)(asyncstreamstext.__c.runMethod(true,"BytesToString",(Object)(_buffer),(Object)(BA.numberCast(int.class, 0)),(Object)(_buffer.getField(true,"length")),(Object)(__ref.getField(true,"_charset")))));
 BA.debugLineNum = 29;BA.debugLine="Dim s As String = sb.ToString";
Debug.ShouldStop(268435456);
_s = __ref.getField(false,"_sb").runMethod(true,"ToString");Debug.locals.put("s", _s);Debug.locals.put("s", _s);
 BA.debugLineNum = 30;BA.debugLine="Dim start As Int = 0";
Debug.ShouldStop(536870912);
_start = BA.numberCast(int.class, 0);Debug.locals.put("start", _start);Debug.locals.put("start", _start);
 BA.debugLineNum = 31;BA.debugLine="For i = newDataStart To s.Length - 1";
Debug.ShouldStop(1073741824);
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {_s.runMethod(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = _newdatastart.<Integer>get().intValue() ;
for (;(step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5) ;_i = ((int)(0 + _i + step5))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 32;BA.debugLine="Dim c As Char = s.CharAt(i)";
Debug.ShouldStop(-2147483648);
_c = _s.runMethod(true,"charAt",(Object)(BA.numberCast(int.class, _i)));Debug.locals.put("c", _c);Debug.locals.put("c", _c);
 BA.debugLineNum = 33;BA.debugLine="If i = 0 And c = Chr(10) Then '\\n...";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",RemoteObject.createImmutable(_i),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("=",_c,asyncstreamstext.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 10))))) { 
 BA.debugLineNum = 34;BA.debugLine="start = 1 'might be a broken end of line charac";
Debug.ShouldStop(2);
_start = BA.numberCast(int.class, 1);Debug.locals.put("start", _start);
 BA.debugLineNum = 35;BA.debugLine="Continue";
Debug.ShouldStop(4);
if (true) continue;
 };
 BA.debugLineNum = 37;BA.debugLine="If c = Chr(10) Then '\\n";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",_c,asyncstreamstext.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 10))))) { 
 BA.debugLineNum = 38;BA.debugLine="CallSubDelayed2(mTarget, mEventName & \"_NewText";
Debug.ShouldStop(32);
asyncstreamstext.__c.runVoidMethod ("CallSubDelayed2",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_mtarget")),(Object)(RemoteObject.concat(__ref.getField(true,"_meventname"),RemoteObject.createImmutable("_NewText"))),(Object)((_s.runMethod(true,"substring",(Object)(_start),(Object)(BA.numberCast(int.class, _i))))));
 BA.debugLineNum = 39;BA.debugLine="start = i + 1";
Debug.ShouldStop(64);
_start = RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("start", _start);
 }else 
{ BA.debugLineNum = 40;BA.debugLine="Else If c = Chr(13) Then '\\r";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",_c,asyncstreamstext.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 13))))) { 
 BA.debugLineNum = 41;BA.debugLine="CallSubDelayed2(mTarget, mEventName & \"_NewText";
Debug.ShouldStop(256);
asyncstreamstext.__c.runVoidMethod ("CallSubDelayed2",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_mtarget")),(Object)(RemoteObject.concat(__ref.getField(true,"_meventname"),RemoteObject.createImmutable("_NewText"))),(Object)((_s.runMethod(true,"substring",(Object)(_start),(Object)(BA.numberCast(int.class, _i))))));
 BA.debugLineNum = 42;BA.debugLine="If i < s.Length - 1 And s.CharAt(i + 1) = Chr(1";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("<",RemoteObject.createImmutable(_i),BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_s.runMethod(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1))) && RemoteObject.solveBoolean("=",_s.runMethod(true,"charAt",(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "+",1, 1))),asyncstreamstext.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 10))))) { 
 BA.debugLineNum = 43;BA.debugLine="i = i + 1";
Debug.ShouldStop(1024);
_i = RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "+",1, 1).<Integer>get().intValue();Debug.locals.put("i", _i);
 };
 BA.debugLineNum = 45;BA.debugLine="start = i + 1";
Debug.ShouldStop(4096);
_start = RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("start", _start);
 }}
;
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 48;BA.debugLine="If start > 0 Then sb.Remove(0, start)";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean(">",_start,BA.numberCast(double.class, 0))) { 
__ref.getField(false,"_sb").runVoidMethod ("Remove",(Object)(BA.numberCast(int.class, 0)),(Object)(_start));};
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
public static RemoteObject  _astreams_terminated(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("astreams_Terminated (asyncstreamstext) ","asyncstreamstext",3,__ref.getField(false, "ba"),__ref,50);
if (RapidSub.canDelegate("astreams_terminated")) { return __ref.runUserSub(false, "asyncstreamstext","astreams_terminated", __ref);}
 BA.debugLineNum = 50;BA.debugLine="Private Sub astreams_Terminated";
Debug.ShouldStop(131072);
 BA.debugLineNum = 51;BA.debugLine="CallSubDelayed(mTarget, mEventName & \"_Terminated";
Debug.ShouldStop(262144);
asyncstreamstext.__c.runVoidMethod ("CallSubDelayed",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_mtarget")),(Object)(RemoteObject.concat(__ref.getField(true,"_meventname"),RemoteObject.createImmutable("_Terminated"))));
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
public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Private mTarget As Object";
asyncstreamstext._mtarget = RemoteObject.createNew ("Object");__ref.setField("_mtarget",asyncstreamstext._mtarget);
 //BA.debugLineNum = 8;BA.debugLine="Private mEventName As String";
asyncstreamstext._meventname = RemoteObject.createImmutable("");__ref.setField("_meventname",asyncstreamstext._meventname);
 //BA.debugLineNum = 9;BA.debugLine="Public astreams As AsyncStreams";
asyncstreamstext._astreams = RemoteObject.createNew ("anywheresoftware.b4a.randomaccessfile.AsyncStreams");__ref.setField("_astreams",asyncstreamstext._astreams);
 //BA.debugLineNum = 10;BA.debugLine="Public charset As String = \"UTF8\"";
asyncstreamstext._charset = BA.ObjectToString("UTF8");__ref.setField("_charset",asyncstreamstext._charset);
 //BA.debugLineNum = 11;BA.debugLine="Private sb As StringBuilder";
asyncstreamstext._sb = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");__ref.setField("_sb",asyncstreamstext._sb);
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _close(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("Close (asyncstreamstext) ","asyncstreamstext",3,__ref.getField(false, "ba"),__ref,60);
if (RapidSub.canDelegate("close")) { return __ref.runUserSub(false, "asyncstreamstext","close", __ref);}
 BA.debugLineNum = 60;BA.debugLine="Public Sub Close";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 61;BA.debugLine="astreams.Close";
Debug.ShouldStop(268435456);
__ref.getField(false,"_astreams").runVoidMethod ("Close");
 BA.debugLineNum = 62;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba,RemoteObject _targetmodule,RemoteObject _eventname,RemoteObject _in,RemoteObject _out) throws Exception{
try {
		Debug.PushSubsStack("Initialize (asyncstreamstext) ","asyncstreamstext",3,__ref.getField(false, "ba"),__ref,14);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "asyncstreamstext","initialize", __ref, _ba, _targetmodule, _eventname, _in, _out);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
Debug.locals.put("TargetModule", _targetmodule);
Debug.locals.put("EventName", _eventname);
Debug.locals.put("In", _in);
Debug.locals.put("out", _out);
 BA.debugLineNum = 14;BA.debugLine="Public Sub Initialize (TargetModule As Object, Eve";
Debug.ShouldStop(8192);
 BA.debugLineNum = 15;BA.debugLine="mTarget = TargetModule";
Debug.ShouldStop(16384);
__ref.setField ("_mtarget",_targetmodule);
 BA.debugLineNum = 16;BA.debugLine="mEventName = EventName";
Debug.ShouldStop(32768);
__ref.setField ("_meventname",_eventname);
 BA.debugLineNum = 17;BA.debugLine="astreams.Initialize(In, out, \"astreams\")";
Debug.ShouldStop(65536);
__ref.getField(false,"_astreams").runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)((_in.getObject())),(Object)((_out.getObject())),(Object)(RemoteObject.createImmutable("astreams")));
 BA.debugLineNum = 18;BA.debugLine="sb.Initialize";
Debug.ShouldStop(131072);
__ref.getField(false,"_sb").runVoidMethod ("Initialize");
 BA.debugLineNum = 19;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _write(RemoteObject __ref,RemoteObject _text) throws Exception{
try {
		Debug.PushSubsStack("Write (asyncstreamstext) ","asyncstreamstext",3,__ref.getField(false, "ba"),__ref,22);
if (RapidSub.canDelegate("write")) { return __ref.runUserSub(false, "asyncstreamstext","write", __ref, _text);}
Debug.locals.put("Text", _text);
 BA.debugLineNum = 22;BA.debugLine="Public Sub Write(Text As String)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 23;BA.debugLine="astreams.Write(Text.GetBytes(charset))";
Debug.ShouldStop(4194304);
__ref.getField(false,"_astreams").runVoidMethod ("Write",(Object)(_text.runMethod(false,"getBytes",(Object)(__ref.getField(true,"_charset")))));
 BA.debugLineNum = 24;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}