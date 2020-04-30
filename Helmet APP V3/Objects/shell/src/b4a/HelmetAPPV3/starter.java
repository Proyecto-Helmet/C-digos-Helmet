
package b4a.HelmetAPPV3;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class starter implements IRemote{
	public static starter mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public starter() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("starter"), "b4a.HelmetAPPV3.starter");
	}
     public static RemoteObject getObject() {
		return myClass;
	 }
	public RemoteObject _service;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
        _service = (RemoteObject) args[2];
        remoteMe = RemoteObject.declareNull("b4a.HelmetAPPV3.starter");
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[3];
		pcBA = new PCBA(this, starter.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _serial = RemoteObject.declareNull("anywheresoftware.b4a.objects.Serial");
public static RemoteObject _admin = RemoteObject.declareNull("anywheresoftware.b4a.objects.Serial.BluetoothAdmin");
public static RemoteObject _ast = RemoteObject.declareNull("b4a.HelmetAPPV3.asyncstreamstext");
public static RemoteObject _connected = RemoteObject.createImmutable(false);
public static RemoteObject _connecting = RemoteObject.createImmutable(false);
public static b4a.HelmetAPPV3.main _main = null;
public static b4a.HelmetAPPV3.ingresarcascoid _ingresarcascoid = null;
public static b4a.HelmetAPPV3.registrarvehiculo _registrarvehiculo = null;
public static b4a.HelmetAPPV3.pantallaprincipal _pantallaprincipal = null;
  public Object[] GetGlobals() {
		return new Object[] {"admin",starter._admin,"ast",starter._ast,"connected",starter._connected,"connecting",starter._connecting,"IngresarCascoID",Debug.moduleToString(b4a.HelmetAPPV3.ingresarcascoid.class),"Main",Debug.moduleToString(b4a.HelmetAPPV3.main.class),"pantallaPrincipal",Debug.moduleToString(b4a.HelmetAPPV3.pantallaprincipal.class),"RegistrarVehiculo",Debug.moduleToString(b4a.HelmetAPPV3.registrarvehiculo.class),"serial",starter._serial,"Service",starter.mostCurrent._service};
}
}