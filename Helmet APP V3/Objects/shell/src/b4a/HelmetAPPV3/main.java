
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

public class main implements IRemote{
	public static main mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public main() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("main"), "b4a.HelmetAPPV3.main");
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
		pcBA = new PCBA(this, main.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _dni = RemoteObject.createImmutable("");
public static RemoteObject _clave = RemoteObject.createImmutable("");
public static RemoteObject _btncontinuarregistro = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _edtxtclave = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _edtxtdni = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _lblclave = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbldni = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pnlregistrousuario = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _lbluno = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblerroneo = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _progressbar1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ProgressBarWrapper");
public static RemoteObject _btningresar = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btnlimpiar = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _lblcandado = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _usuarios = RemoteObject.declareNull("b4a.HelmetAPPV3.usuarios");
public static b4a.HelmetAPPV3.ingresarcascoid _ingresarcascoid = null;
public static b4a.HelmetAPPV3.registrarvehiculo _registrarvehiculo = null;
public static b4a.HelmetAPPV3.pantallaprincipal _pantallaprincipal = null;
public static b4a.HelmetAPPV3.starter _starter = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",main.mostCurrent._activity,"btnContinuarRegistro",main.mostCurrent._btncontinuarregistro,"btnIngresar",main.mostCurrent._btningresar,"btnLimpiar",main.mostCurrent._btnlimpiar,"clave",main._clave,"dni",main._dni,"edtxtClave",main.mostCurrent._edtxtclave,"edtxtDNI",main.mostCurrent._edtxtdni,"IngresarCascoID",Debug.moduleToString(b4a.HelmetAPPV3.ingresarcascoid.class),"lblCandado",main.mostCurrent._lblcandado,"lblClave",main.mostCurrent._lblclave,"lblDNI",main.mostCurrent._lbldni,"lblErroneo",main.mostCurrent._lblerroneo,"lblUno",main.mostCurrent._lbluno,"pantallaPrincipal",Debug.moduleToString(b4a.HelmetAPPV3.pantallaprincipal.class),"pnlRegistroUsuario",main.mostCurrent._pnlregistrousuario,"ProgressBar1",main.mostCurrent._progressbar1,"RegistrarVehiculo",Debug.moduleToString(b4a.HelmetAPPV3.registrarvehiculo.class),"Starter",Debug.moduleToString(b4a.HelmetAPPV3.starter.class),"usuarios",Debug.moduleToString(b4a.HelmetAPPV3.usuarios.class)};
}
}