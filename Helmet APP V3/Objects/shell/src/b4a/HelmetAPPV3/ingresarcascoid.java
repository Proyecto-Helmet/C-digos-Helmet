
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

public class ingresarcascoid implements IRemote{
	public static ingresarcascoid mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public ingresarcascoid() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("ingresarcascoid"), "b4a.HelmetAPPV3.ingresarcascoid");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, ingresarcascoid.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _idcasco = RemoteObject.createImmutable("");
public static RemoteObject _qrcrv = RemoteObject.declareNull("qrcodereaderviewwrapper.qrCodeReaderViewWrapper");
public static RemoteObject _b1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _b2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _lblfondo = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pnlcontinuar = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _lblescaneoexitoso = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblseguro = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _btnreescanear = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btncontinuar = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _pnlborde = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlnegro = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _lbldos = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _flag = RemoteObject.createImmutable(false);
public static RemoteObject _usuarios = RemoteObject.declareNull("b4a.HelmetAPPV3.usuarios");
public static b4a.HelmetAPPV3.main _main = null;
public static b4a.HelmetAPPV3.registrarvehiculo _registrarvehiculo = null;
public static b4a.HelmetAPPV3.pantallaprincipal _pantallaprincipal = null;
public static b4a.HelmetAPPV3.starter _starter = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",ingresarcascoid.mostCurrent._activity,"b1",ingresarcascoid.mostCurrent._b1,"b2",ingresarcascoid.mostCurrent._b2,"btnContinuar",ingresarcascoid.mostCurrent._btncontinuar,"btnReescanear",ingresarcascoid.mostCurrent._btnreescanear,"flag",ingresarcascoid._flag,"IDcasco",ingresarcascoid._idcasco,"Label2",ingresarcascoid.mostCurrent._label2,"lblDos",ingresarcascoid.mostCurrent._lbldos,"lblEscaneoExitoso",ingresarcascoid.mostCurrent._lblescaneoexitoso,"lblFondo",ingresarcascoid.mostCurrent._lblfondo,"lblSeguro",ingresarcascoid.mostCurrent._lblseguro,"Main",Debug.moduleToString(b4a.HelmetAPPV3.main.class),"pantallaPrincipal",Debug.moduleToString(b4a.HelmetAPPV3.pantallaprincipal.class),"pnlBorde",ingresarcascoid.mostCurrent._pnlborde,"pnlContinuar",ingresarcascoid.mostCurrent._pnlcontinuar,"pnlNegro",ingresarcascoid.mostCurrent._pnlnegro,"qrcrv",ingresarcascoid.mostCurrent._qrcrv,"RegistrarVehiculo",Debug.moduleToString(b4a.HelmetAPPV3.registrarvehiculo.class),"Starter",Debug.moduleToString(b4a.HelmetAPPV3.starter.class),"usuarios",Debug.moduleToString(b4a.HelmetAPPV3.usuarios.class)};
}
}