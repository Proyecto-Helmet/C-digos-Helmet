package b4a.HelmetAPPV3;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class starter extends  android.app.Service{
	public static class starter_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
            BA.LogInfo("** Receiver (starter) OnReceive **");
			android.content.Intent in = new android.content.Intent(context, starter.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
            ServiceHelper.StarterHelper.startServiceFromReceiver (context, in, true, anywheresoftware.b4a.ShellBA.class);
		}

	}
    static starter mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return starter.class;
	}
	@Override
	public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new anywheresoftware.b4a.ShellBA(this, null, null, "b4a.HelmetAPPV3", "b4a.HelmetAPPV3.starter");
            if (BA.isShellModeRuntimeCheck(processBA)) {
                processBA.raiseEvent2(null, true, "SHELL", false);
		    }
            try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            processBA.loadHtSubs(this.getClass());
            ServiceHelper.init();
        }
        _service = new ServiceHelper(this);
        processBA.service = this;
        
        if (BA.isShellModeRuntimeCheck(processBA)) {
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.HelmetAPPV3.starter", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!true && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (starter) Create ***");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (true) {
			ServiceHelper.StarterHelper.runWaitForLayouts();
		}
    }
		@Override
	public void onStart(android.content.Intent intent, int startId) {
		onStartCommand(intent, 0, 0);
    }
    @Override
    public int onStartCommand(final android.content.Intent intent, int flags, int startId) {
    	if (ServiceHelper.StarterHelper.onStartCommand(processBA, new Runnable() {
            public void run() {
                handleStart(intent);
            }}))
			;
		else {
			ServiceHelper.StarterHelper.addWaitForLayout (new Runnable() {
				public void run() {
                    processBA.setActivityPaused(false);
                    BA.LogInfo("** Service (starter) Create **");
                    processBA.raiseEvent(null, "service_create");
					handleStart(intent);
                    ServiceHelper.StarterHelper.removeWaitForLayout();
				}
			});
		}
        processBA.runHook("onstartcommand", this, new Object[] {intent, flags, startId});
		return android.app.Service.START_NOT_STICKY;
    }
    public void onTaskRemoved(android.content.Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        if (true)
            processBA.raiseEvent(null, "service_taskremoved");
            
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (starter) Start **");
    	java.lang.reflect.Method startEvent = processBA.htSubs.get("service_start");
    	if (startEvent != null) {
    		if (startEvent.getParameterTypes().length > 0) {
    			anywheresoftware.b4a.objects.IntentWrapper iw = ServiceHelper.StarterHelper.handleStartIntent(intent, _service, processBA);
    			processBA.raiseEvent(null, "service_start", iw);
    		}
    		else {
    			processBA.raiseEvent(null, "service_start");
    		}
    	}
    }
	
	@Override
	public void onDestroy() {
        super.onDestroy();
        if (true) {
            BA.LogInfo("** Service (starter) Destroy (ignored)**");
        }
        else {
            BA.LogInfo("** Service (starter) Destroy **");
		    processBA.raiseEvent(null, "service_destroy");
            processBA.service = null;
		    mostCurrent = null;
		    processBA.setActivityPaused(true);
            processBA.runHook("ondestroy", this, null);
        }
	}

@Override
	public android.os.IBinder onBind(android.content.Intent intent) {
		return null;
	}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.Serial _serial = null;
public static anywheresoftware.b4a.objects.Serial.BluetoothAdmin _admin = null;
public static b4a.HelmetAPPV3.asyncstreamstext _ast = null;
public static boolean _connected = false;
public static boolean _connecting = false;
public b4a.HelmetAPPV3.main _main = null;
public b4a.HelmetAPPV3.ingresarcascoid _ingresarcascoid = null;
public b4a.HelmetAPPV3.registrarvehiculo _registrarvehiculo = null;
public b4a.HelmetAPPV3.pantallaprincipal _pantallaprincipal = null;
public static String  _enviarleer() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "enviarleer"))
	 {return ((String) Debug.delegate(processBA, "enviarleer", null));}
RDebugUtils.currentLine=4849664;
 //BA.debugLineNum = 4849664;BA.debugLine="Public Sub enviarLeer()";
RDebugUtils.currentLine=4849665;
 //BA.debugLineNum = 4849665;BA.debugLine="Log(\"Leer datos en la EEPROM de HelmetRX\")";
anywheresoftware.b4a.keywords.Common.Log("Leer datos en la EEPROM de HelmetRX");
RDebugUtils.currentLine=4849666;
 //BA.debugLineNum = 4849666;BA.debugLine="ast.Write(\"L\"&Chr(10))";
_ast._write(null,"L"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (10))));
RDebugUtils.currentLine=4849667;
 //BA.debugLineNum = 4849667;BA.debugLine="Log(\"Enviando L\")";
anywheresoftware.b4a.keywords.Common.Log("Enviando L");
RDebugUtils.currentLine=4849668;
 //BA.debugLineNum = 4849668;BA.debugLine="End Sub";
return "";
}
public static String  _enviarlimpiar() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "enviarlimpiar"))
	 {return ((String) Debug.delegate(processBA, "enviarlimpiar", null));}
RDebugUtils.currentLine=4915200;
 //BA.debugLineNum = 4915200;BA.debugLine="Public Sub enviarLimpiar()";
RDebugUtils.currentLine=4915201;
 //BA.debugLineNum = 4915201;BA.debugLine="Log(\"Limpiar datos en la EEPROM de HelmetRX\")";
anywheresoftware.b4a.keywords.Common.Log("Limpiar datos en la EEPROM de HelmetRX");
RDebugUtils.currentLine=4915202;
 //BA.debugLineNum = 4915202;BA.debugLine="ast.Write(\"C\"&Chr(10))";
_ast._write(null,"C"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (10))));
RDebugUtils.currentLine=4915203;
 //BA.debugLineNum = 4915203;BA.debugLine="Log(\"Enviando C\")";
anywheresoftware.b4a.keywords.Common.Log("Enviando C");
RDebugUtils.currentLine=4915205;
 //BA.debugLineNum = 4915205;BA.debugLine="End Sub";
return "";
}
public static String  _enviarnack() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "enviarnack"))
	 {return ((String) Debug.delegate(processBA, "enviarnack", null));}
RDebugUtils.currentLine=7733248;
 //BA.debugLineNum = 7733248;BA.debugLine="Public Sub enviarNACK()";
RDebugUtils.currentLine=7733249;
 //BA.debugLineNum = 7733249;BA.debugLine="Log(\"Enviando NACK\")";
anywheresoftware.b4a.keywords.Common.Log("Enviando NACK");
RDebugUtils.currentLine=7733250;
 //BA.debugLineNum = 7733250;BA.debugLine="ast.Write(\"NACK\"&Chr(10))";
_ast._write(null,"NACK"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (10))));
RDebugUtils.currentLine=7733251;
 //BA.debugLineNum = 7733251;BA.debugLine="End Sub";
return "";
}
public static String  _enviarack() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "enviarack"))
	 {return ((String) Debug.delegate(processBA, "enviarack", null));}
RDebugUtils.currentLine=7667712;
 //BA.debugLineNum = 7667712;BA.debugLine="Public Sub enviarACK()";
RDebugUtils.currentLine=7667713;
 //BA.debugLineNum = 7667713;BA.debugLine="Log(\"Enviando ACK\")";
anywheresoftware.b4a.keywords.Common.Log("Enviando ACK");
RDebugUtils.currentLine=7667714;
 //BA.debugLineNum = 7667714;BA.debugLine="ast.Write(\"ACK\"&Chr(10))";
_ast._write(null,"ACK"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (10))));
RDebugUtils.currentLine=7667715;
 //BA.debugLineNum = 7667715;BA.debugLine="End Sub";
return "";
}
public static String  _enviardniycasco() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "enviardniycasco"))
	 {return ((String) Debug.delegate(processBA, "enviardniycasco", null));}
RDebugUtils.currentLine=8323072;
 //BA.debugLineNum = 8323072;BA.debugLine="Public Sub enviarDNIyCASCO()";
RDebugUtils.currentLine=8323073;
 //BA.debugLineNum = 8323073;BA.debugLine="ast.Write(\"A\" & Main.dni & \"P\" &  IngresarCascoID";
_ast._write(null,"A"+mostCurrent._main._dni+"P"+mostCurrent._ingresarcascoid._idcasco+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (10))));
RDebugUtils.currentLine=8323074;
 //BA.debugLineNum = 8323074;BA.debugLine="Log(\"enviar DNI: \" & Main.dni )";
anywheresoftware.b4a.keywords.Common.Log("enviar DNI: "+mostCurrent._main._dni);
RDebugUtils.currentLine=8323075;
 //BA.debugLineNum = 8323075;BA.debugLine="Log(\"enviar ID casco: \" & IngresarCascoID.IDcasco";
anywheresoftware.b4a.keywords.Common.Log("enviar ID casco: "+mostCurrent._ingresarcascoid._idcasco);
RDebugUtils.currentLine=8323076;
 //BA.debugLineNum = 8323076;BA.debugLine="Log(\"A\"&Main.dni&\"P\"&IngresarCascoID.IDcasco&Chr(";
anywheresoftware.b4a.keywords.Common.Log("A"+mostCurrent._main._dni+"P"+mostCurrent._ingresarcascoid._idcasco+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (10))));
RDebugUtils.currentLine=8323078;
 //BA.debugLineNum = 8323078;BA.debugLine="End Sub";
return "";
}
public static String  _connect() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "connect"))
	 {return ((String) Debug.delegate(processBA, "connect", null));}
RDebugUtils.currentLine=4390912;
 //BA.debugLineNum = 4390912;BA.debugLine="Public Sub Connect";
RDebugUtils.currentLine=4390913;
 //BA.debugLineNum = 4390913;BA.debugLine="admin.StartDiscovery";
_admin.StartDiscovery();
RDebugUtils.currentLine=4390914;
 //BA.debugLineNum = 4390914;BA.debugLine="connecting = True";
_connecting = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=4390915;
 //BA.debugLineNum = 4390915;BA.debugLine="CallSub(RegistrarVehiculo, \"SetState\")";
anywheresoftware.b4a.keywords.Common.CallSubDebug(processBA,(Object)(mostCurrent._registrarvehiculo.getObject()),"SetState");
RDebugUtils.currentLine=4390916;
 //BA.debugLineNum = 4390916;BA.debugLine="End Sub";
return "";
}
public static String  _admin_devicefound(String _name,String _macaddress) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "admin_devicefound"))
	 {return ((String) Debug.delegate(processBA, "admin_devicefound", new Object[] {_name,_macaddress}));}
RDebugUtils.currentLine=4456448;
 //BA.debugLineNum = 4456448;BA.debugLine="Private Sub admin_DeviceFound (Name As String, Mac";
RDebugUtils.currentLine=4456458;
 //BA.debugLineNum = 4456458;BA.debugLine="Log($\"Device found: ${Name}\"$)";
anywheresoftware.b4a.keywords.Common.Log(("Device found: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_name))+""));
RDebugUtils.currentLine=4456459;
 //BA.debugLineNum = 4456459;BA.debugLine="If Name = \"SLAVE\" Then";
if ((_name).equals("SLAVE")) { 
RDebugUtils.currentLine=4456460;
 //BA.debugLineNum = 4456460;BA.debugLine="Log(\"Trying to connect...\")";
anywheresoftware.b4a.keywords.Common.Log("Trying to connect...");
RDebugUtils.currentLine=4456461;
 //BA.debugLineNum = 4456461;BA.debugLine="admin.CancelDiscovery";
_admin.CancelDiscovery();
RDebugUtils.currentLine=4456462;
 //BA.debugLineNum = 4456462;BA.debugLine="serial.Connect(MacAddress)";
_serial.Connect(processBA,_macaddress);
 };
RDebugUtils.currentLine=4456464;
 //BA.debugLineNum = 4456464;BA.debugLine="End Sub";
return "";
}
public static String  _admin_discoveryfinished() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "admin_discoveryfinished"))
	 {return ((String) Debug.delegate(processBA, "admin_discoveryfinished", null));}
RDebugUtils.currentLine=4521984;
 //BA.debugLineNum = 4521984;BA.debugLine="Private Sub admin_DiscoveryFinished";
RDebugUtils.currentLine=4522004;
 //BA.debugLineNum = 4522004;BA.debugLine="connecting = False";
_connecting = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=4522006;
 //BA.debugLineNum = 4522006;BA.debugLine="End Sub";
return "";
}
public static boolean  _application_error(anywheresoftware.b4a.objects.B4AException _error,String _stacktrace) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "application_error"))
	 {return ((Boolean) Debug.delegate(processBA, "application_error", new Object[] {_error,_stacktrace}));}
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="End Sub";
return false;
}
public static String  _ast_newtext(String _text) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "ast_newtext"))
	 {return ((String) Debug.delegate(processBA, "ast_newtext", new Object[] {_text}));}
RDebugUtils.currentLine=4718592;
 //BA.debugLineNum = 4718592;BA.debugLine="Private Sub ast_NewText (Text As String)";
RDebugUtils.currentLine=4718593;
 //BA.debugLineNum = 4718593;BA.debugLine="CallSub2(RegistrarVehiculo, \"MessageFromDevice\",";
anywheresoftware.b4a.keywords.Common.CallSubDebug2(processBA,(Object)(mostCurrent._registrarvehiculo.getObject()),"MessageFromDevice",(Object)(_text));
RDebugUtils.currentLine=4718594;
 //BA.debugLineNum = 4718594;BA.debugLine="End Sub";
return "";
}
public static String  _ast_terminated() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "ast_terminated"))
	 {return ((String) Debug.delegate(processBA, "ast_terminated", null));}
RDebugUtils.currentLine=4784128;
 //BA.debugLineNum = 4784128;BA.debugLine="Private Sub ast_Terminated";
RDebugUtils.currentLine=4784129;
 //BA.debugLineNum = 4784129;BA.debugLine="connected = False";
_connected = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=4784130;
 //BA.debugLineNum = 4784130;BA.debugLine="CallSub(RegistrarVehiculo, \"SetState\")";
anywheresoftware.b4a.keywords.Common.CallSubDebug(processBA,(Object)(mostCurrent._registrarvehiculo.getObject()),"SetState");
RDebugUtils.currentLine=4784131;
 //BA.debugLineNum = 4784131;BA.debugLine="End Sub";
return "";
}
public static String  _serial_connected(boolean _success) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "serial_connected"))
	 {return ((String) Debug.delegate(processBA, "serial_connected", new Object[] {_success}));}
RDebugUtils.currentLine=4587520;
 //BA.debugLineNum = 4587520;BA.debugLine="Private Sub Serial_Connected (Success As Boolean)";
RDebugUtils.currentLine=4587521;
 //BA.debugLineNum = 4587521;BA.debugLine="If Success Then";
if (_success) { 
RDebugUtils.currentLine=4587522;
 //BA.debugLineNum = 4587522;BA.debugLine="If ast.IsInitialized Then ast.Close";
if (_ast.IsInitialized()) { 
_ast._close(null);};
RDebugUtils.currentLine=4587523;
 //BA.debugLineNum = 4587523;BA.debugLine="ast.Initialize(Me, \"Ast\", serial.InputStream, se";
_ast._initialize(null,processBA,starter.getObject(),"Ast",(anywheresoftware.b4a.objects.streams.File.InputStreamWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper(), (java.io.InputStream)(_serial.getInputStream())),(anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper(), (java.io.OutputStream)(_serial.getOutputStream())));
RDebugUtils.currentLine=4587524;
 //BA.debugLineNum = 4587524;BA.debugLine="Log(\"Connected\")";
anywheresoftware.b4a.keywords.Common.Log("Connected");
RDebugUtils.currentLine=4587525;
 //BA.debugLineNum = 4587525;BA.debugLine="connected = True";
_connected = anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=4587528;
 //BA.debugLineNum = 4587528;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(processBA)));
 };
RDebugUtils.currentLine=4587530;
 //BA.debugLineNum = 4587530;BA.debugLine="connecting = False";
_connecting = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=4587531;
 //BA.debugLineNum = 4587531;BA.debugLine="CallSub(RegistrarVehiculo, \"SetState\")";
anywheresoftware.b4a.keywords.Common.CallSubDebug(processBA,(Object)(mostCurrent._registrarvehiculo.getObject()),"SetState");
RDebugUtils.currentLine=4587532;
 //BA.debugLineNum = 4587532;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "service_create"))
	 {return ((String) Debug.delegate(processBA, "service_create", null));}
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub Service_Create";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="serial.Initialize(\"serial\")";
_serial.Initialize("serial");
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="admin.Initialize(\"admin\")";
_admin.Initialize(processBA,"admin");
RDebugUtils.currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "service_destroy"))
	 {return ((String) Debug.delegate(processBA, "service_destroy", null));}
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub Service_Destroy";
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "service_start"))
	 {return ((String) Debug.delegate(processBA, "service_start", new Object[] {_startingintent}));}
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="End Sub";
return "";
}
}