
package b4a.HelmetAPPV3;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class usuario {
    public static RemoteObject myClass;
	public usuario() {
	}
    public static PCBA staticBA = new PCBA(null, usuario.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _dni = RemoteObject.createImmutable(0);
public static RemoteObject _clave = RemoteObject.createImmutable(0);
public static RemoteObject _helmetid = RemoteObject.createImmutable(0L);
public static RemoteObject _motoid = RemoteObject.createImmutable(0);
public static b4a.HelmetAPPV3.main _main = null;
public static b4a.HelmetAPPV3.ingresarcascoid _ingresarcascoid = null;
public static b4a.HelmetAPPV3.registrarvehiculo _registrarvehiculo = null;
public static b4a.HelmetAPPV3.pantallaprincipal _pantallaprincipal = null;
public static b4a.HelmetAPPV3.starter _starter = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"clave",_ref.getField(false, "_clave"),"dni",_ref.getField(false, "_dni"),"helmetID",_ref.getField(false, "_helmetid"),"motoID",_ref.getField(false, "_motoid")};
}
}