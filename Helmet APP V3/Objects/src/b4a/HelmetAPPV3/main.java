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

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.HelmetAPPV3", "b4a.HelmetAPPV3.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
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
		activityBA = new BA(this, layout, processBA, "b4a.HelmetAPPV3", "b4a.HelmetAPPV3.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.HelmetAPPV3.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
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
		return main.class;
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
        BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
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
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (ingresarcascoid.mostCurrent != null);
vis = vis | (registrarvehiculo.mostCurrent != null);
vis = vis | (pantallaprincipal.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (ingresarcascoid.previousOne != null) {
				__a = ingresarcascoid.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(ingresarcascoid.mostCurrent == null ? null : ingresarcascoid.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (registrarvehiculo.previousOne != null) {
				__a = registrarvehiculo.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(registrarvehiculo.mostCurrent == null ? null : registrarvehiculo.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (pantallaprincipal.previousOne != null) {
				__a = pantallaprincipal.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(pantallaprincipal.mostCurrent == null ? null : pantallaprincipal.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static String _dni = "";
public static String _clave = "";
public anywheresoftware.b4a.objects.ButtonWrapper _btncontinuarregistro = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtxtclave = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtxtdni = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblclave = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbldni = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlregistrousuario = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbluno = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblerroneo = null;
public anywheresoftware.b4a.objects.ProgressBarWrapper _progressbar1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btningresar = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnlimpiar = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblcandado = null;
public b4a.HelmetAPPV3.usuarios _usuarios = null;
public b4a.HelmetAPPV3.ingresarcascoid _ingresarcascoid = null;
public b4a.HelmetAPPV3.registrarvehiculo _registrarvehiculo = null;
public b4a.HelmetAPPV3.pantallaprincipal _pantallaprincipal = null;
public b4a.HelmetAPPV3.starter _starter = null;
public static String  _actividad(String _dniingresado) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "actividad"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "actividad", new Object[] {_dniingresado}));}
boolean _existehelmetid = false;
boolean _existemotoid = false;
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub actividad (DniIngresado As String)";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="Dim existeHelmetID As Boolean";
_existehelmetid = false;
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="Dim existeMotoID As Boolean";
_existemotoid = false;
RDebugUtils.currentLine=1048579;
 //BA.debugLineNum = 1048579;BA.debugLine="dni=edtxtDNI.Text";
_dni = mostCurrent._edtxtdni.getText();
RDebugUtils.currentLine=1048580;
 //BA.debugLineNum = 1048580;BA.debugLine="existeHelmetID=usuarios.chequearHelmetId(DniIngre";
_existehelmetid = mostCurrent._usuarios._chequearhelmetid(null,_dniingresado);
RDebugUtils.currentLine=1048583;
 //BA.debugLineNum = 1048583;BA.debugLine="If existeHelmetID=True Then";
if (_existehelmetid==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=1048584;
 //BA.debugLineNum = 1048584;BA.debugLine="StartActivity(\"RegistrarVehiculo\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("RegistrarVehiculo"));
 }else {
RDebugUtils.currentLine=1048586;
 //BA.debugLineNum = 1048586;BA.debugLine="StartActivity(\"IngresarCascoID\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("IngresarCascoID"));
 };
RDebugUtils.currentLine=1048588;
 //BA.debugLineNum = 1048588;BA.debugLine="End Sub";
return "";
}
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="Activity.LoadLayout(\"RegistroUsuario\")";
mostCurrent._activity.LoadLayout("RegistroUsuario",mostCurrent.activityBA);
RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="Activity.Title=\"Helmet APP - Registrar Usuario\"";
mostCurrent._activity.setTitle(BA.ObjectToCharSequence("Helmet APP - Registrar Usuario"));
RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="btnContinuarRegistro.Visible=True 'si no se ingre";
mostCurrent._btncontinuarregistro.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="btnIngresar.Visible=True";
mostCurrent._btningresar.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="btnContinuarRegistro.Enabled=False";
mostCurrent._btncontinuarregistro.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131080;
 //BA.debugLineNum = 131080;BA.debugLine="btnIngresar.Enabled=False";
mostCurrent._btningresar.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131082;
 //BA.debugLineNum = 131082;BA.debugLine="lblErroneo.Visible=False";
mostCurrent._lblerroneo.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131083;
 //BA.debugLineNum = 131083;BA.debugLine="usuarios.Initialize";
mostCurrent._usuarios._initialize(null,processBA);
RDebugUtils.currentLine=131094;
 //BA.debugLineNum = 131094;BA.debugLine="usuarios.leerUSUARIOS";
mostCurrent._usuarios._leerusuarios(null);
RDebugUtils.currentLine=131097;
 //BA.debugLineNum = 131097;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="End Sub";
return "";
}
public static String  _btncontinuarregistro_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btncontinuarregistro_click"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btncontinuarregistro_click", null));}
boolean _dniusado = false;
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub btnContinuarRegistro_Click";
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="Dim DNIusado As Boolean";
_dniusado = false;
RDebugUtils.currentLine=720900;
 //BA.debugLineNum = 720900;BA.debugLine="If edtxtDNI.Text.Length = 8 Then";
if (mostCurrent._edtxtdni.getText().length()==8) { 
RDebugUtils.currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="If edtxtClave.Text.Length = 4 Then";
if (mostCurrent._edtxtclave.getText().length()==4) { 
RDebugUtils.currentLine=720903;
 //BA.debugLineNum = 720903;BA.debugLine="DNIusado=usuarios.chequearDNI(edtxtDNI.Text)  '";
_dniusado = mostCurrent._usuarios._chequeardni(null,mostCurrent._edtxtdni.getText());
RDebugUtils.currentLine=720904;
 //BA.debugLineNum = 720904;BA.debugLine="If DNIusado=True Then  'ya hay un usuario con e";
if (_dniusado==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=720905;
 //BA.debugLineNum = 720905;BA.debugLine="lblErroneo.Visible=True";
mostCurrent._lblerroneo.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=720906;
 //BA.debugLineNum = 720906;BA.debugLine="lblErroneo.Text=\"el DNI ingresado pertenece a";
mostCurrent._lblerroneo.setText(BA.ObjectToCharSequence("el DNI ingresado pertenece a un usuario ya registrado"));
RDebugUtils.currentLine=720907;
 //BA.debugLineNum = 720907;BA.debugLine="Log(\"ya hay un dni registrado\")";
anywheresoftware.b4a.keywords.Common.Log("ya hay un dni registrado");
 }else {
RDebugUtils.currentLine=720909;
 //BA.debugLineNum = 720909;BA.debugLine="Log(\"-----------------------------------------";
anywheresoftware.b4a.keywords.Common.Log("--------------------------------------------");
RDebugUtils.currentLine=720910;
 //BA.debugLineNum = 720910;BA.debugLine="Log(\"dni ingresado válido\")";
anywheresoftware.b4a.keywords.Common.Log("dni ingresado válido");
RDebugUtils.currentLine=720911;
 //BA.debugLineNum = 720911;BA.debugLine="lblErroneo.Visible=False";
mostCurrent._lblerroneo.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=720912;
 //BA.debugLineNum = 720912;BA.debugLine="dni=edtxtDNI.Text";
_dni = mostCurrent._edtxtdni.getText();
RDebugUtils.currentLine=720913;
 //BA.debugLineNum = 720913;BA.debugLine="clave=edtxtClave.Text";
_clave = mostCurrent._edtxtclave.getText();
RDebugUtils.currentLine=720914;
 //BA.debugLineNum = 720914;BA.debugLine="usuarios.insertarDNICLAVE(dni,clave)";
mostCurrent._usuarios._insertardniclave(null,(int)(Double.parseDouble(_dni)),(int)(Double.parseDouble(_clave)));
RDebugUtils.currentLine=720915;
 //BA.debugLineNum = 720915;BA.debugLine="ProgressBar1.Enabled=True";
mostCurrent._progressbar1.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=720916;
 //BA.debugLineNum = 720916;BA.debugLine="Log(\"DNI y Clave ingresados en la base de dato";
anywheresoftware.b4a.keywords.Common.Log("DNI y Clave ingresados en la base de datos");
RDebugUtils.currentLine=720917;
 //BA.debugLineNum = 720917;BA.debugLine="Log(\"DNI: \"&dni)";
anywheresoftware.b4a.keywords.Common.Log("DNI: "+_dni);
RDebugUtils.currentLine=720918;
 //BA.debugLineNum = 720918;BA.debugLine="Log(\"CLAVE: \"&clave)";
anywheresoftware.b4a.keywords.Common.Log("CLAVE: "+_clave);
RDebugUtils.currentLine=720919;
 //BA.debugLineNum = 720919;BA.debugLine="StartActivity(\"IngresarCascoID\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("IngresarCascoID"));
 };
 }else {
RDebugUtils.currentLine=720924;
 //BA.debugLineNum = 720924;BA.debugLine="lblErroneo.Text=\"clave errónea\"";
mostCurrent._lblerroneo.setText(BA.ObjectToCharSequence("clave errónea"));
RDebugUtils.currentLine=720925;
 //BA.debugLineNum = 720925;BA.debugLine="lblErroneo.Visible=True";
mostCurrent._lblerroneo.setVisible(anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
RDebugUtils.currentLine=720928;
 //BA.debugLineNum = 720928;BA.debugLine="lblErroneo.Text= \"DNI erróneo\"";
mostCurrent._lblerroneo.setText(BA.ObjectToCharSequence("DNI erróneo"));
RDebugUtils.currentLine=720929;
 //BA.debugLineNum = 720929;BA.debugLine="lblErroneo.Visible=True";
mostCurrent._lblerroneo.setVisible(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=720932;
 //BA.debugLineNum = 720932;BA.debugLine="End Sub";
return "";
}
public static String  _btningresar_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btningresar_click"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btningresar_click", null));}
boolean _dniexistente = false;
boolean _clavecorrecta = false;
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub btnIngresar_Click";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="Dim DniExistente As Boolean";
_dniexistente = false;
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="Dim ClaveCorrecta As Boolean";
_clavecorrecta = false;
RDebugUtils.currentLine=917507;
 //BA.debugLineNum = 917507;BA.debugLine="DniExistente=False";
_dniexistente = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=917508;
 //BA.debugLineNum = 917508;BA.debugLine="ProgressBar1.Visible=True";
mostCurrent._progressbar1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=917511;
 //BA.debugLineNum = 917511;BA.debugLine="If edtxtDNI.Text.Length = 8 Then";
if (mostCurrent._edtxtdni.getText().length()==8) { 
RDebugUtils.currentLine=917512;
 //BA.debugLineNum = 917512;BA.debugLine="If edtxtClave.Text.Length = 4 Then";
if (mostCurrent._edtxtclave.getText().length()==4) { 
RDebugUtils.currentLine=917513;
 //BA.debugLineNum = 917513;BA.debugLine="DniExistente= usuarios.chequearDNI(edtxtDNI.Tex";
_dniexistente = mostCurrent._usuarios._chequeardni(null,mostCurrent._edtxtdni.getText());
RDebugUtils.currentLine=917514;
 //BA.debugLineNum = 917514;BA.debugLine="If DniExistente=True Then    'si existe chequea";
if (_dniexistente==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=917515;
 //BA.debugLineNum = 917515;BA.debugLine="ClaveCorrecta=usuarios.chequearCLAVE(edtxtDNI.";
_clavecorrecta = mostCurrent._usuarios._chequearclave(null,mostCurrent._edtxtdni.getText(),mostCurrent._edtxtclave.getText());
RDebugUtils.currentLine=917516;
 //BA.debugLineNum = 917516;BA.debugLine="If ClaveCorrecta=True Then";
if (_clavecorrecta==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=917517;
 //BA.debugLineNum = 917517;BA.debugLine="ProgressBar1.Visible=False";
mostCurrent._progressbar1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=917518;
 //BA.debugLineNum = 917518;BA.debugLine="actividad(edtxtDNI.Text) 'decide hacia que ac";
_actividad(mostCurrent._edtxtdni.getText());
 };
RDebugUtils.currentLine=917521;
 //BA.debugLineNum = 917521;BA.debugLine="If ClaveCorrecta=False Then";
if (_clavecorrecta==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=917522;
 //BA.debugLineNum = 917522;BA.debugLine="lblErroneo.Text=\"La clave no coincide con el";
mostCurrent._lblerroneo.setText(BA.ObjectToCharSequence("La clave no coincide con el DNI ingresado"));
RDebugUtils.currentLine=917523;
 //BA.debugLineNum = 917523;BA.debugLine="lblErroneo.Visible=True";
mostCurrent._lblerroneo.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=917524;
 //BA.debugLineNum = 917524;BA.debugLine="ProgressBar1.Visible=False";
mostCurrent._progressbar1.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
RDebugUtils.currentLine=917527;
 //BA.debugLineNum = 917527;BA.debugLine="If DniExistente=False Then   'si no existe en l";
if (_dniexistente==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=917528;
 //BA.debugLineNum = 917528;BA.debugLine="lblErroneo.Text=\"Usuario Inexistente, por favo";
mostCurrent._lblerroneo.setText(BA.ObjectToCharSequence("Usuario Inexistente, por favor registre su DNI y su Clave"));
RDebugUtils.currentLine=917529;
 //BA.debugLineNum = 917529;BA.debugLine="lblErroneo.Visible=True";
mostCurrent._lblerroneo.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=917530;
 //BA.debugLineNum = 917530;BA.debugLine="ProgressBar1.Visible=False";
mostCurrent._progressbar1.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 }else {
RDebugUtils.currentLine=917533;
 //BA.debugLineNum = 917533;BA.debugLine="lblErroneo.Text=\"clave errónea\"";
mostCurrent._lblerroneo.setText(BA.ObjectToCharSequence("clave errónea"));
RDebugUtils.currentLine=917534;
 //BA.debugLineNum = 917534;BA.debugLine="ProgressBar1.Visible=False";
mostCurrent._progressbar1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=917535;
 //BA.debugLineNum = 917535;BA.debugLine="lblErroneo.Visible=True";
mostCurrent._lblerroneo.setVisible(anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
RDebugUtils.currentLine=917538;
 //BA.debugLineNum = 917538;BA.debugLine="lblErroneo.Text= \"DNI erróneo\"";
mostCurrent._lblerroneo.setText(BA.ObjectToCharSequence("DNI erróneo"));
RDebugUtils.currentLine=917539;
 //BA.debugLineNum = 917539;BA.debugLine="ProgressBar1.Visible=False";
mostCurrent._progressbar1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=917540;
 //BA.debugLineNum = 917540;BA.debugLine="lblErroneo.Visible=True";
mostCurrent._lblerroneo.setVisible(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=917544;
 //BA.debugLineNum = 917544;BA.debugLine="End Sub";
return "";
}
public static String  _btnlimpiar_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnlimpiar_click"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnlimpiar_click", null));}
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub btnLimpiar_Click";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="usuarios.borrarTODO";
mostCurrent._usuarios._borrartodo(null);
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="usuarios.leerUSUARIOS";
mostCurrent._usuarios._leerusuarios(null);
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="End Sub";
return "";
}
public static String  _edtxtclave_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "edtxtclave_textchanged"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "edtxtclave_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub edtxtClave_TextChanged (Old As String, New As";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="If edtxtClave.Text <> \"\"  Then";
if ((mostCurrent._edtxtclave.getText()).equals("") == false) { 
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="If edtxtDNI.Text<>\"\" Then";
if ((mostCurrent._edtxtdni.getText()).equals("") == false) { 
RDebugUtils.currentLine=786435;
 //BA.debugLineNum = 786435;BA.debugLine="btnContinuarRegistro.Enabled=True";
mostCurrent._btncontinuarregistro.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=786436;
 //BA.debugLineNum = 786436;BA.debugLine="btnIngresar.Enabled=True";
mostCurrent._btningresar.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=786438;
 //BA.debugLineNum = 786438;BA.debugLine="btnContinuarRegistro.Enabled=False";
mostCurrent._btncontinuarregistro.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=786439;
 //BA.debugLineNum = 786439;BA.debugLine="btnIngresar.Enabled=False";
mostCurrent._btningresar.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 };
 }else {
RDebugUtils.currentLine=786442;
 //BA.debugLineNum = 786442;BA.debugLine="btnContinuarRegistro.Enabled=False";
mostCurrent._btncontinuarregistro.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=786443;
 //BA.debugLineNum = 786443;BA.debugLine="btnIngresar.Enabled=False";
mostCurrent._btningresar.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=786445;
 //BA.debugLineNum = 786445;BA.debugLine="End Sub";
return "";
}
public static String  _edtxtdni_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "edtxtdni_textchanged"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "edtxtdni_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Sub edtxtDNI_TextChanged (Old As String, New As St";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="If edtxtClave.Text <> \"\"  Then";
if ((mostCurrent._edtxtclave.getText()).equals("") == false) { 
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="If edtxtDNI.Text<>\"\" Then";
if ((mostCurrent._edtxtdni.getText()).equals("") == false) { 
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="btnContinuarRegistro.Enabled=True";
mostCurrent._btncontinuarregistro.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=851972;
 //BA.debugLineNum = 851972;BA.debugLine="btnIngresar.Enabled=True";
mostCurrent._btningresar.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
RDebugUtils.currentLine=851976;
 //BA.debugLineNum = 851976;BA.debugLine="btnContinuarRegistro.Enabled=False";
mostCurrent._btncontinuarregistro.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=851977;
 //BA.debugLineNum = 851977;BA.debugLine="btnIngresar.Enabled=False";
mostCurrent._btningresar.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=851979;
 //BA.debugLineNum = 851979;BA.debugLine="End Sub";
return "";
}
}