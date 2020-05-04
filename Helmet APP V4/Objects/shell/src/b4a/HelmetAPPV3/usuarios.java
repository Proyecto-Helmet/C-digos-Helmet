
package b4a.HelmetAPPV3;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class usuarios {
    public static RemoteObject myClass;
	public usuarios() {
	}
    public static PCBA staticBA = new PCBA(null, usuarios.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _sql = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL");
public static b4a.HelmetAPPV3.main _main = null;
public static b4a.HelmetAPPV3.ingresarcascoid _ingresarcascoid = null;
public static b4a.HelmetAPPV3.registrarvehiculo _registrarvehiculo = null;
public static b4a.HelmetAPPV3.pantallaprincipal _pantallaprincipal = null;
public static b4a.HelmetAPPV3.starter _starter = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"Sql",_ref.getField(false, "_sql")};
}
}