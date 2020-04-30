
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

public class registrarvehiculo implements IRemote{
	public static registrarvehiculo mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public registrarvehiculo() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("registrarvehiculo"), "b4a.HelmetAPPV3.registrarvehiculo");
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
		pcBA = new PCBA(this, registrarvehiculo.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _rp = RemoteObject.declareNull("anywheresoftware.b4a.objects.RuntimePermissions");
public static RemoteObject _usuarios = RemoteObject.declareNull("b4a.HelmetAPPV3.usuarios");
public static RemoteObject _lblstatus = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _btnconnect = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _lblmessage = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _progressbar1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ProgressBarWrapper");
public static RemoteObject _btndisconnect = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btnagregarcascoprincipal = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btnagregarcascosecundario = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _pnlprincipal = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _lblfondo = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _bluetoothon = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
public static RemoteObject _bluetoothoff = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
public static RemoteObject _lbltres = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _tglbtnconexion = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");
public static RemoteObject _btnleer = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btnlimpiar = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static b4a.HelmetAPPV3.main _main = null;
public static b4a.HelmetAPPV3.ingresarcascoid _ingresarcascoid = null;
public static b4a.HelmetAPPV3.pantallaprincipal _pantallaprincipal = null;
public static b4a.HelmetAPPV3.starter _starter = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",registrarvehiculo.mostCurrent._activity,"bluetoothOff",registrarvehiculo.mostCurrent._bluetoothoff,"bluetoothOn",registrarvehiculo.mostCurrent._bluetoothon,"btnAgregarCascoPrincipal",registrarvehiculo.mostCurrent._btnagregarcascoprincipal,"btnAgregarCascoSecundario",registrarvehiculo.mostCurrent._btnagregarcascosecundario,"btnConnect",registrarvehiculo.mostCurrent._btnconnect,"btnDisconnect",registrarvehiculo.mostCurrent._btndisconnect,"btnLeer",registrarvehiculo.mostCurrent._btnleer,"btnLimpiar",registrarvehiculo.mostCurrent._btnlimpiar,"IngresarCascoID",Debug.moduleToString(b4a.HelmetAPPV3.ingresarcascoid.class),"lblFondo",registrarvehiculo.mostCurrent._lblfondo,"lblMessage",registrarvehiculo.mostCurrent._lblmessage,"lblStatus",registrarvehiculo.mostCurrent._lblstatus,"lblTres",registrarvehiculo.mostCurrent._lbltres,"Main",Debug.moduleToString(b4a.HelmetAPPV3.main.class),"pantallaPrincipal",Debug.moduleToString(b4a.HelmetAPPV3.pantallaprincipal.class),"pnlPrincipal",registrarvehiculo.mostCurrent._pnlprincipal,"ProgressBar1",registrarvehiculo.mostCurrent._progressbar1,"rp",registrarvehiculo._rp,"Starter",Debug.moduleToString(b4a.HelmetAPPV3.starter.class),"tglbtnConexion",registrarvehiculo.mostCurrent._tglbtnconexion,"usuarios",Debug.moduleToString(b4a.HelmetAPPV3.usuarios.class)};
}
}