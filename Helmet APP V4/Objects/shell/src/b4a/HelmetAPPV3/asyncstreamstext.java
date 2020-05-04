
package b4a.HelmetAPPV3;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class asyncstreamstext {
    public static RemoteObject myClass;
	public asyncstreamstext() {
	}
    public static PCBA staticBA = new PCBA(null, asyncstreamstext.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _mtarget = RemoteObject.declareNull("Object");
public static RemoteObject _meventname = RemoteObject.createImmutable("");
public static RemoteObject _astreams = RemoteObject.declareNull("anywheresoftware.b4a.randomaccessfile.AsyncStreams");
public static RemoteObject _charset = RemoteObject.createImmutable("");
public static RemoteObject _sb = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
public static b4a.HelmetAPPV3.main _main = null;
public static b4a.HelmetAPPV3.ingresarcascoid _ingresarcascoid = null;
public static b4a.HelmetAPPV3.registrarvehiculo _registrarvehiculo = null;
public static b4a.HelmetAPPV3.pantallaprincipal _pantallaprincipal = null;
public static b4a.HelmetAPPV3.starter _starter = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"astreams",_ref.getField(false, "_astreams"),"charset",_ref.getField(false, "_charset"),"mEventName",_ref.getField(false, "_meventname"),"mTarget",_ref.getField(false, "_mtarget"),"sb",_ref.getField(false, "_sb")};
}
}