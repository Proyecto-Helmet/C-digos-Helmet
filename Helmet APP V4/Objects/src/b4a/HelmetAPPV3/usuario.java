package b4a.HelmetAPPV3;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class usuario extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "b4a.HelmetAPPV3.usuario");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.HelmetAPPV3.usuario.class).invoke(this, new Object[] {null});
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
public int _dni = 0;
public int _clave = 0;
public long _helmetid = 0L;
public int _motoid = 0;
public b4a.HelmetAPPV3.main _main = null;
public b4a.HelmetAPPV3.ingresarcascoid _ingresarcascoid = null;
public b4a.HelmetAPPV3.registrarvehiculo _registrarvehiculo = null;
public b4a.HelmetAPPV3.pantallaprincipal _pantallaprincipal = null;
public b4a.HelmetAPPV3.starter _starter = null;
public String  _class_globals(b4a.HelmetAPPV3.usuario __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="usuario";
RDebugUtils.currentLine=3604480;
 //BA.debugLineNum = 3604480;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=3604481;
 //BA.debugLineNum = 3604481;BA.debugLine="Public dni As Int";
_dni = 0;
RDebugUtils.currentLine=3604482;
 //BA.debugLineNum = 3604482;BA.debugLine="Public clave As Int";
_clave = 0;
RDebugUtils.currentLine=3604483;
 //BA.debugLineNum = 3604483;BA.debugLine="Public helmetID As Long  'int en B4A son 32 bits";
_helmetid = 0L;
RDebugUtils.currentLine=3604484;
 //BA.debugLineNum = 3604484;BA.debugLine="Public motoID As Int";
_motoid = 0;
RDebugUtils.currentLine=3604485;
 //BA.debugLineNum = 3604485;BA.debugLine="End Sub";
return "";
}
public String  _initialize(b4a.HelmetAPPV3.usuario __ref,anywheresoftware.b4a.BA _ba) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="usuario";
if (Debug.shouldDelegate(ba, "initialize"))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba}));}
RDebugUtils.currentLine=3670016;
 //BA.debugLineNum = 3670016;BA.debugLine="Public Sub Initialize";
RDebugUtils.currentLine=3670018;
 //BA.debugLineNum = 3670018;BA.debugLine="End Sub";
return "";
}
}