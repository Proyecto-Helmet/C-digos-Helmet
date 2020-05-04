package b4a.HelmetAPPV3;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class registrarvehiculo extends Activity implements B4AActivity{
	public static registrarvehiculo mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.HelmetAPPV3", "b4a.HelmetAPPV3.registrarvehiculo");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (registrarvehiculo).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.HelmetAPPV3", "b4a.HelmetAPPV3.registrarvehiculo");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.HelmetAPPV3.registrarvehiculo", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (registrarvehiculo) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (registrarvehiculo) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return registrarvehiculo.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (registrarvehiculo) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            registrarvehiculo mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (registrarvehiculo) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.RuntimePermissions _rp = null;
public static String _idmoto = "";
public b4a.HelmetAPPV3.usuarios _usuarios = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblstatus = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnconnect = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblmessage = null;
public anywheresoftware.b4a.objects.ProgressBarWrapper _progressbar1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btndisconnect = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnagregarcascoprincipal = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnagregarcascosecundario = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlprincipal = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblfondo = null;
public anywheresoftware.b4a.objects.drawable.BitmapDrawable _bluetoothon = null;
public anywheresoftware.b4a.objects.drawable.BitmapDrawable _bluetoothoff = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbltres = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper _tglbtnconexion = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnleer = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnlimpiar = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblaviso = null;
public b4a.HelmetAPPV3.main _main = null;
public b4a.HelmetAPPV3.ingresarcascoid _ingresarcascoid = null;
public b4a.HelmetAPPV3.pantallaprincipal _pantallaprincipal = null;
public b4a.HelmetAPPV3.starter _starter = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="registrarvehiculo";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=1900544;
 //BA.debugLineNum = 1900544;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=1900545;
 //BA.debugLineNum = 1900545;BA.debugLine="usuarios.Initialize";
mostCurrent._usuarios._initialize(null,processBA);
RDebugUtils.currentLine=1900546;
 //BA.debugLineNum = 1900546;BA.debugLine="Activity.LoadLayout(\"RegistrarVehiculo\")";
mostCurrent._activity.LoadLayout("RegistrarVehiculo",mostCurrent.activityBA);
RDebugUtils.currentLine=1900547;
 //BA.debugLineNum = 1900547;BA.debugLine="Activity.Title=\"Helmet APP - Registrar Vehículo\"";
mostCurrent._activity.setTitle(BA.ObjectToCharSequence("Helmet APP - Registrar Vehículo"));
RDebugUtils.currentLine=1900548;
 //BA.debugLineNum = 1900548;BA.debugLine="btnConnect.Visible=True";
mostCurrent._btnconnect.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1900549;
 //BA.debugLineNum = 1900549;BA.debugLine="btnDisconnect.Visible=False";
mostCurrent._btndisconnect.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1900550;
 //BA.debugLineNum = 1900550;BA.debugLine="lblAviso.Visible=False";
mostCurrent._lblaviso.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1900553;
 //BA.debugLineNum = 1900553;BA.debugLine="bluetoothOff.Initialize(LoadBitmap(File.DirAssets";
mostCurrent._bluetoothoff.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"bluetoothoff (1).png").getObject()));
RDebugUtils.currentLine=1900554;
 //BA.debugLineNum = 1900554;BA.debugLine="bluetoothOff.Gravity= Gravity.FILL";
mostCurrent._bluetoothoff.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=1900555;
 //BA.debugLineNum = 1900555;BA.debugLine="btnConnect.Background= bluetoothOff";
mostCurrent._btnconnect.setBackground((android.graphics.drawable.Drawable)(mostCurrent._bluetoothoff.getObject()));
RDebugUtils.currentLine=1900557;
 //BA.debugLineNum = 1900557;BA.debugLine="bluetoothOn.Initialize(LoadBitmap(File.DirAssets,";
mostCurrent._bluetoothon.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"bluetoothon (1).png").getObject()));
RDebugUtils.currentLine=1900558;
 //BA.debugLineNum = 1900558;BA.debugLine="bluetoothOn.Gravity=Gravity.FILL";
mostCurrent._bluetoothon.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=1900559;
 //BA.debugLineNum = 1900559;BA.debugLine="btnDisconnect.Background=bluetoothOn";
mostCurrent._btndisconnect.setBackground((android.graphics.drawable.Drawable)(mostCurrent._bluetoothon.getObject()));
RDebugUtils.currentLine=1900561;
 //BA.debugLineNum = 1900561;BA.debugLine="IngresarCascoID.IDcasco=usuarios.leerHelmetID(Mai";
mostCurrent._ingresarcascoid._idcasco = mostCurrent._usuarios._leerhelmetid(null,mostCurrent._main._dni);
RDebugUtils.currentLine=1900564;
 //BA.debugLineNum = 1900564;BA.debugLine="Log(\"El formato que se enviará al HelmetRX es: A\"";
anywheresoftware.b4a.keywords.Common.Log("El formato que se enviará al HelmetRX es: A"+mostCurrent._main._dni+"P"+mostCurrent._ingresarcascoid._idcasco+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (10))));
RDebugUtils.currentLine=1900568;
 //BA.debugLineNum = 1900568;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="registrarvehiculo";
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="registrarvehiculo";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=1966081;
 //BA.debugLineNum = 1966081;BA.debugLine="SetState";
_setstate();
RDebugUtils.currentLine=1966082;
 //BA.debugLineNum = 1966082;BA.debugLine="End Sub";
return "";
}
public static String  _setstate() throws Exception{
RDebugUtils.currentModule="registrarvehiculo";
if (Debug.shouldDelegate(mostCurrent.activityBA, "setstate"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "setstate", null));}
String _status = "";
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Public Sub SetState";
RDebugUtils.currentLine=2031618;
 //BA.debugLineNum = 2031618;BA.debugLine="btnConnect.Enabled = Not(Starter.connected)";
mostCurrent._btnconnect.setEnabled(anywheresoftware.b4a.keywords.Common.Not(mostCurrent._starter._connected));
RDebugUtils.currentLine=2031619;
 //BA.debugLineNum = 2031619;BA.debugLine="ProgressBar1.Visible = Starter.connecting";
mostCurrent._progressbar1.setVisible(mostCurrent._starter._connecting);
RDebugUtils.currentLine=2031620;
 //BA.debugLineNum = 2031620;BA.debugLine="Dim status As String";
_status = "";
RDebugUtils.currentLine=2031621;
 //BA.debugLineNum = 2031621;BA.debugLine="If Starter.connected Then";
if (mostCurrent._starter._connected) { 
RDebugUtils.currentLine=2031622;
 //BA.debugLineNum = 2031622;BA.debugLine="status = \"Conectado\"";
_status = "Conectado";
RDebugUtils.currentLine=2031623;
 //BA.debugLineNum = 2031623;BA.debugLine="CallSub(Starter,\"enviar\")";
anywheresoftware.b4a.keywords.Common.CallSubDebug(processBA,(Object)(mostCurrent._starter.getObject()),"enviar");
 }else 
{RDebugUtils.currentLine=2031624;
 //BA.debugLineNum = 2031624;BA.debugLine="else if Starter.connecting Then";
if (mostCurrent._starter._connecting) { 
RDebugUtils.currentLine=2031625;
 //BA.debugLineNum = 2031625;BA.debugLine="status = \"Procesando...\"";
_status = "Procesando...";
 }else {
RDebugUtils.currentLine=2031627;
 //BA.debugLineNum = 2031627;BA.debugLine="status = \"Desconectado\"";
_status = "Desconectado";
 }}
;
RDebugUtils.currentLine=2031629;
 //BA.debugLineNum = 2031629;BA.debugLine="lblStatus.Text = $\"Status: ${status}\"$";
mostCurrent._lblstatus.setText(BA.ObjectToCharSequence(("Status: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_status))+"")));
RDebugUtils.currentLine=2031630;
 //BA.debugLineNum = 2031630;BA.debugLine="End Sub";
return "";
}
public static String  _btnagregarcascoprincipal_click() throws Exception{
RDebugUtils.currentModule="registrarvehiculo";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnagregarcascoprincipal_click"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnagregarcascoprincipal_click", null));}
RDebugUtils.currentLine=2490368;
 //BA.debugLineNum = 2490368;BA.debugLine="Sub btnAgregarCascoPrincipal_Click";
RDebugUtils.currentLine=2490370;
 //BA.debugLineNum = 2490370;BA.debugLine="End Sub";
return "";
}
public static String  _btnagregarcascosecundario_click() throws Exception{
RDebugUtils.currentModule="registrarvehiculo";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnagregarcascosecundario_click"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnagregarcascosecundario_click", null));}
RDebugUtils.currentLine=2555904;
 //BA.debugLineNum = 2555904;BA.debugLine="Sub btnAgregarCascoSecundario_Click";
RDebugUtils.currentLine=2555906;
 //BA.debugLineNum = 2555906;BA.debugLine="End Sub";
return "";
}
public static String  _btnconnect_click() throws Exception{
RDebugUtils.currentModule="registrarvehiculo";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnconnect_click"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnconnect_click", null));}
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Sub btnConnect_Click";
RDebugUtils.currentLine=2293770;
 //BA.debugLineNum = 2293770;BA.debugLine="End Sub";
return "";
}
public static String  _btndisconnect_click() throws Exception{
RDebugUtils.currentModule="registrarvehiculo";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btndisconnect_click"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btndisconnect_click", null));}
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Sub btnDisconnect_Click";
RDebugUtils.currentLine=2424833;
 //BA.debugLineNum = 2424833;BA.debugLine="btnDisconnect.Visible=False";
mostCurrent._btndisconnect.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2424834;
 //BA.debugLineNum = 2424834;BA.debugLine="btnConnect.Visible=True";
mostCurrent._btnconnect.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2424835;
 //BA.debugLineNum = 2424835;BA.debugLine="End Sub";
return "";
}
public static String  _btnleer_click() throws Exception{
RDebugUtils.currentModule="registrarvehiculo";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnleer_click"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnleer_click", null));}
RDebugUtils.currentLine=2686976;
 //BA.debugLineNum = 2686976;BA.debugLine="Sub btnLeer_Click";
RDebugUtils.currentLine=2686977;
 //BA.debugLineNum = 2686977;BA.debugLine="CallSub(Starter,\"enviarLeer\")";
anywheresoftware.b4a.keywords.Common.CallSubDebug(processBA,(Object)(mostCurrent._starter.getObject()),"enviarLeer");
RDebugUtils.currentLine=2686978;
 //BA.debugLineNum = 2686978;BA.debugLine="End Sub";
return "";
}
public static String  _btnlimpiar_click() throws Exception{
RDebugUtils.currentModule="registrarvehiculo";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnlimpiar_click"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnlimpiar_click", null));}
RDebugUtils.currentLine=2752512;
 //BA.debugLineNum = 2752512;BA.debugLine="Sub btnLimpiar_Click";
RDebugUtils.currentLine=2752513;
 //BA.debugLineNum = 2752513;BA.debugLine="CallSub(Starter,\"enviarLimpiar\")";
anywheresoftware.b4a.keywords.Common.CallSubDebug(processBA,(Object)(mostCurrent._starter.getObject()),"enviarLimpiar");
RDebugUtils.currentLine=2752514;
 //BA.debugLineNum = 2752514;BA.debugLine="End Sub";
return "";
}
public static String  _lblstatus_click() throws Exception{
RDebugUtils.currentModule="registrarvehiculo";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lblstatus_click"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lblstatus_click", null));}
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Sub lblStatus_Click";
RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="End Sub";
return "";
}
public static String  _messagefromdevice(String _msg) throws Exception{
RDebugUtils.currentModule="registrarvehiculo";
if (Debug.shouldDelegate(mostCurrent.activityBA, "messagefromdevice"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "messagefromdevice", new Object[] {_msg}));}
boolean _flag = false;
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Public Sub MessageFromDevice(msg As String)";
RDebugUtils.currentLine=2097153;
 //BA.debugLineNum = 2097153;BA.debugLine="Dim flag As Boolean  'para saber si ya hay un mot";
_flag = false;
RDebugUtils.currentLine=2097154;
 //BA.debugLineNum = 2097154;BA.debugLine="flag=False";
_flag = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=2097157;
 //BA.debugLineNum = 2097157;BA.debugLine="Log(\"El mensaje enviado por HelmetRX es: \"& msg)";
anywheresoftware.b4a.keywords.Common.Log("El mensaje enviado por HelmetRX es: "+_msg);
RDebugUtils.currentLine=2097159;
 //BA.debugLineNum = 2097159;BA.debugLine="If msg=\"DNINACK\" Then   'si ya hay un usuario reg";
if ((_msg).equals("DNINACK")) { 
RDebugUtils.currentLine=2097160;
 //BA.debugLineNum = 2097160;BA.debugLine="lblAviso.Text=\"Ya existe un usuario registrado e";
mostCurrent._lblaviso.setText(BA.ObjectToCharSequence("Ya existe un usuario registrado en este vehículo! "));
 }else {
RDebugUtils.currentLine=2097162;
 //BA.debugLineNum = 2097162;BA.debugLine="IDmoto=msg  'Si el mensaje no es \"DNINACK\" enton";
_idmoto = _msg;
RDebugUtils.currentLine=2097163;
 //BA.debugLineNum = 2097163;BA.debugLine="Log(\"El dato recibido es: \" & IDmoto & \" y repre";
anywheresoftware.b4a.keywords.Common.Log("El dato recibido es: "+_idmoto+" y representa el motoID");
RDebugUtils.currentLine=2097165;
 //BA.debugLineNum = 2097165;BA.debugLine="flag=usuarios.chequearMotoID(IDmoto)  'llama al";
_flag = mostCurrent._usuarios._chequearmotoid(null,_idmoto);
RDebugUtils.currentLine=2097167;
 //BA.debugLineNum = 2097167;BA.debugLine="If flag=True Then  'el método devuelve TRUE si y";
if (_flag==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=2097168;
 //BA.debugLineNum = 2097168;BA.debugLine="lblAviso.Text=\"Este vehículo ya esta registrado";
mostCurrent._lblaviso.setText(BA.ObjectToCharSequence("Este vehículo ya esta registrado en el sistema y solo puede tener 1 casco principal!"));
RDebugUtils.currentLine=2097169;
 //BA.debugLineNum = 2097169;BA.debugLine="lblAviso.Visible=True";
mostCurrent._lblaviso.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2097170;
 //BA.debugLineNum = 2097170;BA.debugLine="CallSub(Starter,\"enviarNACK\")";
anywheresoftware.b4a.keywords.Common.CallSubDebug(processBA,(Object)(mostCurrent._starter.getObject()),"enviarNACK");
 }else {
RDebugUtils.currentLine=2097172;
 //BA.debugLineNum = 2097172;BA.debugLine="Log(\"No existe ningun usuario registrado en est";
anywheresoftware.b4a.keywords.Common.Log("No existe ningun usuario registrado en este vehículo, se procederá a guardar");
RDebugUtils.currentLine=2097173;
 //BA.debugLineNum = 2097173;BA.debugLine="usuarios.insertarMotoID(IDmoto,Main.dni)";
mostCurrent._usuarios._insertarmotoid(null,_idmoto,mostCurrent._main._dni);
RDebugUtils.currentLine=2097174;
 //BA.debugLineNum = 2097174;BA.debugLine="CallSub(Starter,\"enviarACK\")";
anywheresoftware.b4a.keywords.Common.CallSubDebug(processBA,(Object)(mostCurrent._starter.getObject()),"enviarACK");
 };
 };
RDebugUtils.currentLine=2097178;
 //BA.debugLineNum = 2097178;BA.debugLine="End Sub";
return "";
}
public static String  _switch1_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="registrarvehiculo";
if (Debug.shouldDelegate(mostCurrent.activityBA, "switch1_checkedchange"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "switch1_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Sub Switch1_CheckedChange(Checked As Boolean)";
RDebugUtils.currentLine=2228226;
 //BA.debugLineNum = 2228226;BA.debugLine="If Checked Then";
if (_checked) { 
RDebugUtils.currentLine=2228227;
 //BA.debugLineNum = 2228227;BA.debugLine="CallSub(Starter, \"enviarDNIyCASCO\")";
anywheresoftware.b4a.keywords.Common.CallSubDebug(processBA,(Object)(mostCurrent._starter.getObject()),"enviarDNIyCASCO");
 };
RDebugUtils.currentLine=2228229;
 //BA.debugLineNum = 2228229;BA.debugLine="End Sub";
return "";
}
public static void  _tglbtnconexion_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="registrarvehiculo";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tglbtnconexion_checkedchange"))
	 {Debug.delegate(mostCurrent.activityBA, "tglbtnconexion_checkedchange", new Object[] {_checked}); return;}
ResumableSub_tglbtnConexion_CheckedChange rsub = new ResumableSub_tglbtnConexion_CheckedChange(null,_checked);
rsub.resume(processBA, null);
}
public static class ResumableSub_tglbtnConexion_CheckedChange extends BA.ResumableSub {
public ResumableSub_tglbtnConexion_CheckedChange(b4a.HelmetAPPV3.registrarvehiculo parent,boolean _checked) {
this.parent = parent;
this._checked = _checked;
}
b4a.HelmetAPPV3.registrarvehiculo parent;
boolean _checked;
String _permission = "";
boolean _result = false;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="registrarvehiculo";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=2621441;
 //BA.debugLineNum = 2621441;BA.debugLine="If Checked Then";
if (true) break;

case 1:
//if
this.state = 10;
if (_checked) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=2621442;
 //BA.debugLineNum = 2621442;BA.debugLine="btnConnect.Visible=False";
parent.mostCurrent._btnconnect.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2621443;
 //BA.debugLineNum = 2621443;BA.debugLine="btnDisconnect.Visible=True";
parent.mostCurrent._btndisconnect.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2621444;
 //BA.debugLineNum = 2621444;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_ACCESS_COARSE_L";
parent._rp.CheckAndRequest(processBA,parent._rp.PERMISSION_ACCESS_COARSE_LOCATION);
RDebugUtils.currentLine=2621445;
 //BA.debugLineNum = 2621445;BA.debugLine="Wait For Activity_PermissionResult (Permission A";
anywheresoftware.b4a.keywords.Common.WaitFor("activity_permissionresult", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "registrarvehiculo", "tglbtnconexion_checkedchange"), null);
this.state = 11;
return;
case 11:
//C
this.state = 4;
_permission = (String) result[0];
_result = (Boolean) result[1];
;
RDebugUtils.currentLine=2621446;
 //BA.debugLineNum = 2621446;BA.debugLine="If Result Then";
if (true) break;

case 4:
//if
this.state = 9;
if (_result) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 9;
RDebugUtils.currentLine=2621447;
 //BA.debugLineNum = 2621447;BA.debugLine="CallSub(Starter, \"Connect\")";
anywheresoftware.b4a.keywords.Common.CallSubDebug(processBA,(Object)(parent.mostCurrent._starter.getObject()),"Connect");
 if (true) break;

case 8:
//C
this.state = 9;
RDebugUtils.currentLine=2621449;
 //BA.debugLineNum = 2621449;BA.debugLine="ToastMessageShow(\"No permission\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No permission"),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 9:
//C
this.state = 10;
;
 if (true) break;

case 10:
//C
this.state = -1;
;
RDebugUtils.currentLine=2621453;
 //BA.debugLineNum = 2621453;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
}