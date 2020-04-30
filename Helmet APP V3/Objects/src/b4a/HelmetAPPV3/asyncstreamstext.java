package b4a.HelmetAPPV3;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class asyncstreamstext extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "b4a.HelmetAPPV3.asyncstreamstext");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.HelmetAPPV3.asyncstreamstext.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public anywheresoftware.b4a.keywords.Common __c = null;
public Object _mtarget = null;
public String _meventname = "";
public anywheresoftware.b4a.randomaccessfile.AsyncStreams _astreams = null;
public String _charset = "";
public anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
public b4a.HelmetAPPV3.main _main = null;
public b4a.HelmetAPPV3.ingresarcascoid _ingresarcascoid = null;
public b4a.HelmetAPPV3.registrarvehiculo _registrarvehiculo = null;
public b4a.HelmetAPPV3.pantallaprincipal _pantallaprincipal = null;
public b4a.HelmetAPPV3.starter _starter = null;
public String  _astreams_error(b4a.HelmetAPPV3.asyncstreamstext __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="asyncstreamstext";
if (Debug.shouldDelegate(ba, "astreams_error"))
	 {return ((String) Debug.delegate(ba, "astreams_error", null));}
RDebugUtils.currentLine=3145728;
 //BA.debugLineNum = 3145728;BA.debugLine="Private Sub astreams_Error";
RDebugUtils.currentLine=3145729;
 //BA.debugLineNum = 3145729;BA.debugLine="Log(\"error: \" & LastException)";
__c.Log("error: "+BA.ObjectToString(__c.LastException(getActivityBA())));
RDebugUtils.currentLine=3145730;
 //BA.debugLineNum = 3145730;BA.debugLine="astreams.Close";
__ref._astreams.Close();
RDebugUtils.currentLine=3145731;
 //BA.debugLineNum = 3145731;BA.debugLine="CallSubDelayed(mTarget, mEventName & \"_Terminated";
__c.CallSubDelayed(ba,__ref._mtarget,__ref._meventname+"_Terminated");
RDebugUtils.currentLine=3145732;
 //BA.debugLineNum = 3145732;BA.debugLine="End Sub";
return "";
}
public String  _astreams_newdata(b4a.HelmetAPPV3.asyncstreamstext __ref,byte[] _buffer) throws Exception{
__ref = this;
RDebugUtils.currentModule="asyncstreamstext";
if (Debug.shouldDelegate(ba, "astreams_newdata"))
	 {return ((String) Debug.delegate(ba, "astreams_newdata", new Object[] {_buffer}));}
int _newdatastart = 0;
String _s = "";
int _start = 0;
int _i = 0;
char _c = '\0';
RDebugUtils.currentLine=3014656;
 //BA.debugLineNum = 3014656;BA.debugLine="Private Sub astreams_NewData (Buffer() As Byte)";
RDebugUtils.currentLine=3014657;
 //BA.debugLineNum = 3014657;BA.debugLine="Dim newDataStart As Int = sb.Length";
_newdatastart = __ref._sb.getLength();
RDebugUtils.currentLine=3014658;
 //BA.debugLineNum = 3014658;BA.debugLine="sb.Append(BytesToString(Buffer, 0, Buffer.Length,";
__ref._sb.Append(__c.BytesToString(_buffer,(int) (0),_buffer.length,__ref._charset));
RDebugUtils.currentLine=3014659;
 //BA.debugLineNum = 3014659;BA.debugLine="Dim s As String = sb.ToString";
_s = __ref._sb.ToString();
RDebugUtils.currentLine=3014660;
 //BA.debugLineNum = 3014660;BA.debugLine="Dim start As Int = 0";
_start = (int) (0);
RDebugUtils.currentLine=3014661;
 //BA.debugLineNum = 3014661;BA.debugLine="For i = newDataStart To s.Length - 1";
{
final int step5 = 1;
final int limit5 = (int) (_s.length()-1);
_i = _newdatastart ;
for (;_i <= limit5 ;_i = _i + step5 ) {
RDebugUtils.currentLine=3014662;
 //BA.debugLineNum = 3014662;BA.debugLine="Dim c As Char = s.CharAt(i)";
_c = _s.charAt(_i);
RDebugUtils.currentLine=3014663;
 //BA.debugLineNum = 3014663;BA.debugLine="If i = 0 And c = Chr(10) Then '\\n...";
if (_i==0 && _c==__c.Chr((int) (10))) { 
RDebugUtils.currentLine=3014664;
 //BA.debugLineNum = 3014664;BA.debugLine="start = 1 'might be a broken end of line charac";
_start = (int) (1);
RDebugUtils.currentLine=3014665;
 //BA.debugLineNum = 3014665;BA.debugLine="Continue";
if (true) continue;
 };
RDebugUtils.currentLine=3014667;
 //BA.debugLineNum = 3014667;BA.debugLine="If c = Chr(10) Then '\\n";
if (_c==__c.Chr((int) (10))) { 
RDebugUtils.currentLine=3014668;
 //BA.debugLineNum = 3014668;BA.debugLine="CallSubDelayed2(mTarget, mEventName & \"_NewText";
__c.CallSubDelayed2(ba,__ref._mtarget,__ref._meventname+"_NewText",(Object)(_s.substring(_start,_i)));
RDebugUtils.currentLine=3014669;
 //BA.debugLineNum = 3014669;BA.debugLine="start = i + 1";
_start = (int) (_i+1);
 }else 
{RDebugUtils.currentLine=3014670;
 //BA.debugLineNum = 3014670;BA.debugLine="Else If c = Chr(13) Then '\\r";
if (_c==__c.Chr((int) (13))) { 
RDebugUtils.currentLine=3014671;
 //BA.debugLineNum = 3014671;BA.debugLine="CallSubDelayed2(mTarget, mEventName & \"_NewText";
__c.CallSubDelayed2(ba,__ref._mtarget,__ref._meventname+"_NewText",(Object)(_s.substring(_start,_i)));
RDebugUtils.currentLine=3014672;
 //BA.debugLineNum = 3014672;BA.debugLine="If i < s.Length - 1 And s.CharAt(i + 1) = Chr(1";
if (_i<_s.length()-1 && _s.charAt((int) (_i+1))==__c.Chr((int) (10))) { 
RDebugUtils.currentLine=3014673;
 //BA.debugLineNum = 3014673;BA.debugLine="i = i + 1";
_i = (int) (_i+1);
 };
RDebugUtils.currentLine=3014675;
 //BA.debugLineNum = 3014675;BA.debugLine="start = i + 1";
_start = (int) (_i+1);
 }}
;
 }
};
RDebugUtils.currentLine=3014678;
 //BA.debugLineNum = 3014678;BA.debugLine="If start > 0 Then sb.Remove(0, start)";
if (_start>0) { 
__ref._sb.Remove((int) (0),_start);};
RDebugUtils.currentLine=3014679;
 //BA.debugLineNum = 3014679;BA.debugLine="End Sub";
return "";
}
public String  _astreams_terminated(b4a.HelmetAPPV3.asyncstreamstext __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="asyncstreamstext";
if (Debug.shouldDelegate(ba, "astreams_terminated"))
	 {return ((String) Debug.delegate(ba, "astreams_terminated", null));}
RDebugUtils.currentLine=3080192;
 //BA.debugLineNum = 3080192;BA.debugLine="Private Sub astreams_Terminated";
RDebugUtils.currentLine=3080193;
 //BA.debugLineNum = 3080193;BA.debugLine="CallSubDelayed(mTarget, mEventName & \"_Terminated";
__c.CallSubDelayed(ba,__ref._mtarget,__ref._meventname+"_Terminated");
RDebugUtils.currentLine=3080194;
 //BA.debugLineNum = 3080194;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(b4a.HelmetAPPV3.asyncstreamstext __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="asyncstreamstext";
RDebugUtils.currentLine=2818048;
 //BA.debugLineNum = 2818048;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=2818049;
 //BA.debugLineNum = 2818049;BA.debugLine="Private mTarget As Object";
_mtarget = new Object();
RDebugUtils.currentLine=2818050;
 //BA.debugLineNum = 2818050;BA.debugLine="Private mEventName As String";
_meventname = "";
RDebugUtils.currentLine=2818051;
 //BA.debugLineNum = 2818051;BA.debugLine="Public astreams As AsyncStreams";
_astreams = new anywheresoftware.b4a.randomaccessfile.AsyncStreams();
RDebugUtils.currentLine=2818052;
 //BA.debugLineNum = 2818052;BA.debugLine="Public charset As String = \"UTF8\"";
_charset = "UTF8";
RDebugUtils.currentLine=2818053;
 //BA.debugLineNum = 2818053;BA.debugLine="Private sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=2818054;
 //BA.debugLineNum = 2818054;BA.debugLine="End Sub";
return "";
}
public String  _close(b4a.HelmetAPPV3.asyncstreamstext __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="asyncstreamstext";
if (Debug.shouldDelegate(ba, "close"))
	 {return ((String) Debug.delegate(ba, "close", null));}
RDebugUtils.currentLine=3211264;
 //BA.debugLineNum = 3211264;BA.debugLine="Public Sub Close";
RDebugUtils.currentLine=3211265;
 //BA.debugLineNum = 3211265;BA.debugLine="astreams.Close";
__ref._astreams.Close();
RDebugUtils.currentLine=3211266;
 //BA.debugLineNum = 3211266;BA.debugLine="End Sub";
return "";
}
public String  _initialize(b4a.HelmetAPPV3.asyncstreamstext __ref,anywheresoftware.b4a.BA _ba,Object _targetmodule,String _eventname,anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _in,anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="asyncstreamstext";
if (Debug.shouldDelegate(ba, "initialize"))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_targetmodule,_eventname,_in,_out}));}
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Public Sub Initialize (TargetModule As Object, Eve";
RDebugUtils.currentLine=2883585;
 //BA.debugLineNum = 2883585;BA.debugLine="mTarget = TargetModule";
__ref._mtarget = _targetmodule;
RDebugUtils.currentLine=2883586;
 //BA.debugLineNum = 2883586;BA.debugLine="mEventName = EventName";
__ref._meventname = _eventname;
RDebugUtils.currentLine=2883587;
 //BA.debugLineNum = 2883587;BA.debugLine="astreams.Initialize(In, out, \"astreams\")";
__ref._astreams.Initialize(ba,(java.io.InputStream)(_in.getObject()),(java.io.OutputStream)(_out.getObject()),"astreams");
RDebugUtils.currentLine=2883588;
 //BA.debugLineNum = 2883588;BA.debugLine="sb.Initialize";
__ref._sb.Initialize();
RDebugUtils.currentLine=2883589;
 //BA.debugLineNum = 2883589;BA.debugLine="End Sub";
return "";
}
public String  _write(b4a.HelmetAPPV3.asyncstreamstext __ref,String _text) throws Exception{
__ref = this;
RDebugUtils.currentModule="asyncstreamstext";
if (Debug.shouldDelegate(ba, "write"))
	 {return ((String) Debug.delegate(ba, "write", new Object[] {_text}));}
RDebugUtils.currentLine=2949120;
 //BA.debugLineNum = 2949120;BA.debugLine="Public Sub Write(Text As String)";
RDebugUtils.currentLine=2949121;
 //BA.debugLineNum = 2949121;BA.debugLine="astreams.Write(Text.GetBytes(charset))";
__ref._astreams.Write(_text.getBytes(__ref._charset));
RDebugUtils.currentLine=2949122;
 //BA.debugLineNum = 2949122;BA.debugLine="End Sub";
return "";
}
}