package b4a.HelmetAPPV3;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class usuarios extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "b4a.HelmetAPPV3.usuarios");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.HelmetAPPV3.usuarios.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.sql.SQL _sql = null;
public b4a.HelmetAPPV3.main _main = null;
public b4a.HelmetAPPV3.ingresarcascoid _ingresarcascoid = null;
public b4a.HelmetAPPV3.registrarvehiculo _registrarvehiculo = null;
public b4a.HelmetAPPV3.pantallaprincipal _pantallaprincipal = null;
public b4a.HelmetAPPV3.starter _starter = null;
public boolean  _chequearhelmetid(b4a.HelmetAPPV3.usuarios __ref,String _dni) throws Exception{
__ref = this;
RDebugUtils.currentModule="usuarios";
if (Debug.shouldDelegate(ba, "chequearhelmetid"))
	 {return ((Boolean) Debug.delegate(ba, "chequearhelmetid", new Object[] {_dni}));}
int _dniint = 0;
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
boolean _flag = false;
int _i = 0;
b4a.HelmetAPPV3.usuario _datos = null;
RDebugUtils.currentLine=4194304;
 //BA.debugLineNum = 4194304;BA.debugLine="Public Sub chequearHelmetId (Dni As String) As Boo";
RDebugUtils.currentLine=4194305;
 //BA.debugLineNum = 4194305;BA.debugLine="Log(\"--------------------------------------------";
__c.Log("--------------------------------------------");
RDebugUtils.currentLine=4194306;
 //BA.debugLineNum = 4194306;BA.debugLine="Log (\"Chequeando si el DNI ingresado ya contiene";
__c.Log("Chequeando si el DNI ingresado ya contiene un HelmetID");
RDebugUtils.currentLine=4194307;
 //BA.debugLineNum = 4194307;BA.debugLine="Dim DniINT As Int";
_dniint = 0;
RDebugUtils.currentLine=4194308;
 //BA.debugLineNum = 4194308;BA.debugLine="DniINT=Dni'PASO A INTEGER";
_dniint = (int)(Double.parseDouble(_dni));
RDebugUtils.currentLine=4194309;
 //BA.debugLineNum = 4194309;BA.debugLine="Dim cursor As Cursor";
_cursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=4194310;
 //BA.debugLineNum = 4194310;BA.debugLine="Dim flag As Boolean";
_flag = false;
RDebugUtils.currentLine=4194311;
 //BA.debugLineNum = 4194311;BA.debugLine="flag=False";
_flag = __c.False;
RDebugUtils.currentLine=4194314;
 //BA.debugLineNum = 4194314;BA.debugLine="cursor=Sql.ExecQuery(\"SELECT * FROM usuarios\")";
_cursor.setObject((android.database.Cursor)(__ref._sql.ExecQuery("SELECT * FROM usuarios")));
RDebugUtils.currentLine=4194315;
 //BA.debugLineNum = 4194315;BA.debugLine="For i=0 To cursor.RowCount-1";
{
final int step9 = 1;
final int limit9 = (int) (_cursor.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit9 ;_i = _i + step9 ) {
RDebugUtils.currentLine=4194316;
 //BA.debugLineNum = 4194316;BA.debugLine="cursor.Position=i";
_cursor.setPosition(_i);
RDebugUtils.currentLine=4194318;
 //BA.debugLineNum = 4194318;BA.debugLine="Dim datos As Usuario";
_datos = new b4a.HelmetAPPV3.usuario();
RDebugUtils.currentLine=4194319;
 //BA.debugLineNum = 4194319;BA.debugLine="datos.Initialize";
_datos._initialize(null,ba);
RDebugUtils.currentLine=4194321;
 //BA.debugLineNum = 4194321;BA.debugLine="datos.dni=cursor.GetInt(\"dni\")";
_datos._dni = _cursor.GetInt("dni");
RDebugUtils.currentLine=4194322;
 //BA.debugLineNum = 4194322;BA.debugLine="If datos.dni=DniINT Then";
if (_datos._dni==_dniint) { 
RDebugUtils.currentLine=4194323;
 //BA.debugLineNum = 4194323;BA.debugLine="Log(\"dni detectado\")";
__c.Log("dni detectado");
RDebugUtils.currentLine=4194324;
 //BA.debugLineNum = 4194324;BA.debugLine="datos.helmetID=cursor.GetInt(\"helmetid\")";
_datos._helmetid = (long) (_cursor.GetInt("helmetid"));
RDebugUtils.currentLine=4194326;
 //BA.debugLineNum = 4194326;BA.debugLine="If datos.helmetID=0 Then";
if (_datos._helmetid==0) { 
RDebugUtils.currentLine=4194327;
 //BA.debugLineNum = 4194327;BA.debugLine="Log(\"Ningún HelmetID registrado con el usuario";
__c.Log("Ningún HelmetID registrado con el usuario ingresado");
RDebugUtils.currentLine=4194328;
 //BA.debugLineNum = 4194328;BA.debugLine="flag=False";
_flag = __c.False;
 }else {
RDebugUtils.currentLine=4194330;
 //BA.debugLineNum = 4194330;BA.debugLine="flag=True";
_flag = __c.True;
RDebugUtils.currentLine=4194331;
 //BA.debugLineNum = 4194331;BA.debugLine="Log(\"Ya hay un HelmetID registrado con este u";
__c.Log("Ya hay un HelmetID registrado con este usuario");
RDebugUtils.currentLine=4194332;
 //BA.debugLineNum = 4194332;BA.debugLine="Log(\"El HelmetID es: \"& datos.helmetID)";
__c.Log("El HelmetID es: "+BA.NumberToString(_datos._helmetid));
 };
 };
 }
};
RDebugUtils.currentLine=4194337;
 //BA.debugLineNum = 4194337;BA.debugLine="Return flag";
if (true) return _flag;
RDebugUtils.currentLine=4194339;
 //BA.debugLineNum = 4194339;BA.debugLine="End Sub";
return false;
}
public String  _initialize(b4a.HelmetAPPV3.usuarios __ref,anywheresoftware.b4a.BA _ba) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="usuarios";
if (Debug.shouldDelegate(ba, "initialize"))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba}));}
RDebugUtils.currentLine=3801088;
 //BA.debugLineNum = 3801088;BA.debugLine="Public Sub Initialize";
RDebugUtils.currentLine=3801089;
 //BA.debugLineNum = 3801089;BA.debugLine="Sql.Initialize(File.DirInternalCache,\"usuarios.db";
__ref._sql.Initialize(__c.File.getDirInternalCache(),"usuarios.db",__c.True);
RDebugUtils.currentLine=3801090;
 //BA.debugLineNum = 3801090;BA.debugLine="Sql.ExecNonQuery(\"CREATE TABLE IF NOT EXISTS usua";
__ref._sql.ExecNonQuery("CREATE TABLE IF NOT EXISTS usuarios (dni integer PRIMARY KEY,clave integer, helmetid long,motoid integer)");
RDebugUtils.currentLine=3801091;
 //BA.debugLineNum = 3801091;BA.debugLine="End Sub";
return "";
}
public String  _leerusuarios(b4a.HelmetAPPV3.usuarios __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="usuarios";
if (Debug.shouldDelegate(ba, "leerusuarios"))
	 {return ((String) Debug.delegate(ba, "leerusuarios", null));}
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
int _i = 0;
b4a.HelmetAPPV3.usuario _datos = null;
RDebugUtils.currentLine=3997696;
 //BA.debugLineNum = 3997696;BA.debugLine="Public Sub leerUSUARIOS";
RDebugUtils.currentLine=3997697;
 //BA.debugLineNum = 3997697;BA.debugLine="Log(\"--------------------------------------------";
__c.Log("--------------------------------------------");
RDebugUtils.currentLine=3997698;
 //BA.debugLineNum = 3997698;BA.debugLine="Log (\"leyendo base de datos\")";
__c.Log("leyendo base de datos");
RDebugUtils.currentLine=3997699;
 //BA.debugLineNum = 3997699;BA.debugLine="Dim cursor As Cursor";
_cursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=3997702;
 //BA.debugLineNum = 3997702;BA.debugLine="cursor=Sql.ExecQuery(\"SELECT * FROM usuarios\")";
_cursor.setObject((android.database.Cursor)(__ref._sql.ExecQuery("SELECT * FROM usuarios")));
RDebugUtils.currentLine=3997703;
 //BA.debugLineNum = 3997703;BA.debugLine="For i=0 To cursor.RowCount-1";
{
final int step5 = 1;
final int limit5 = (int) (_cursor.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
RDebugUtils.currentLine=3997704;
 //BA.debugLineNum = 3997704;BA.debugLine="cursor.Position=i";
_cursor.setPosition(_i);
RDebugUtils.currentLine=3997705;
 //BA.debugLineNum = 3997705;BA.debugLine="Dim datos As Usuario";
_datos = new b4a.HelmetAPPV3.usuario();
RDebugUtils.currentLine=3997706;
 //BA.debugLineNum = 3997706;BA.debugLine="datos.Initialize";
_datos._initialize(null,ba);
RDebugUtils.currentLine=3997707;
 //BA.debugLineNum = 3997707;BA.debugLine="datos.dni=cursor.GetInt(\"dni\")";
_datos._dni = _cursor.GetInt("dni");
RDebugUtils.currentLine=3997708;
 //BA.debugLineNum = 3997708;BA.debugLine="datos.clave=cursor.GetInt(\"clave\")";
_datos._clave = _cursor.GetInt("clave");
RDebugUtils.currentLine=3997709;
 //BA.debugLineNum = 3997709;BA.debugLine="datos.helmetID=cursor.GetInt(\"helmetid\")";
_datos._helmetid = (long) (_cursor.GetInt("helmetid"));
RDebugUtils.currentLine=3997710;
 //BA.debugLineNum = 3997710;BA.debugLine="datos.motoID=cursor.GetInt(\"motoid\")";
_datos._motoid = _cursor.GetInt("motoid");
RDebugUtils.currentLine=3997711;
 //BA.debugLineNum = 3997711;BA.debugLine="Log(\"Usuario Nº \"&i)";
__c.Log("Usuario Nº "+BA.NumberToString(_i));
RDebugUtils.currentLine=3997712;
 //BA.debugLineNum = 3997712;BA.debugLine="Log(\"DNI: \"&datos.dni)";
__c.Log("DNI: "+BA.NumberToString(_datos._dni));
RDebugUtils.currentLine=3997713;
 //BA.debugLineNum = 3997713;BA.debugLine="Log (\"Clave: \"&datos.clave)";
__c.Log("Clave: "+BA.NumberToString(_datos._clave));
RDebugUtils.currentLine=3997714;
 //BA.debugLineNum = 3997714;BA.debugLine="Log(\"Helmet ID: \"&datos.helmetID)";
__c.Log("Helmet ID: "+BA.NumberToString(_datos._helmetid));
RDebugUtils.currentLine=3997715;
 //BA.debugLineNum = 3997715;BA.debugLine="Log(\"Moto ID: \"&datos.motoID)";
__c.Log("Moto ID: "+BA.NumberToString(_datos._motoid));
 }
};
RDebugUtils.currentLine=3997718;
 //BA.debugLineNum = 3997718;BA.debugLine="End Sub";
return "";
}
public boolean  _chequeardni(b4a.HelmetAPPV3.usuarios __ref,String _dni) throws Exception{
__ref = this;
RDebugUtils.currentModule="usuarios";
if (Debug.shouldDelegate(ba, "chequeardni"))
	 {return ((Boolean) Debug.delegate(ba, "chequeardni", new Object[] {_dni}));}
int _dniint = 0;
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
boolean _flag = false;
int _i = 0;
b4a.HelmetAPPV3.usuario _datos = null;
RDebugUtils.currentLine=3932160;
 //BA.debugLineNum = 3932160;BA.debugLine="Public Sub chequearDNI(Dni As String) As Boolean";
RDebugUtils.currentLine=3932162;
 //BA.debugLineNum = 3932162;BA.debugLine="Log(\"--------------------------------------------";
__c.Log("--------------------------------------------");
RDebugUtils.currentLine=3932163;
 //BA.debugLineNum = 3932163;BA.debugLine="Log (\"chequeando DNI\")";
__c.Log("chequeando DNI");
RDebugUtils.currentLine=3932164;
 //BA.debugLineNum = 3932164;BA.debugLine="Dim DniINT As Int";
_dniint = 0;
RDebugUtils.currentLine=3932165;
 //BA.debugLineNum = 3932165;BA.debugLine="DniINT=Dni'PASO A INTEGER";
_dniint = (int)(Double.parseDouble(_dni));
RDebugUtils.currentLine=3932166;
 //BA.debugLineNum = 3932166;BA.debugLine="Dim cursor As Cursor";
_cursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=3932167;
 //BA.debugLineNum = 3932167;BA.debugLine="Dim flag As Boolean";
_flag = false;
RDebugUtils.currentLine=3932168;
 //BA.debugLineNum = 3932168;BA.debugLine="flag=False";
_flag = __c.False;
RDebugUtils.currentLine=3932170;
 //BA.debugLineNum = 3932170;BA.debugLine="cursor=Sql.ExecQuery(\"SELECT * FROM usuarios\")";
_cursor.setObject((android.database.Cursor)(__ref._sql.ExecQuery("SELECT * FROM usuarios")));
RDebugUtils.currentLine=3932171;
 //BA.debugLineNum = 3932171;BA.debugLine="For i=0 To cursor.RowCount-1";
{
final int step9 = 1;
final int limit9 = (int) (_cursor.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit9 ;_i = _i + step9 ) {
RDebugUtils.currentLine=3932172;
 //BA.debugLineNum = 3932172;BA.debugLine="cursor.Position=i";
_cursor.setPosition(_i);
RDebugUtils.currentLine=3932174;
 //BA.debugLineNum = 3932174;BA.debugLine="Dim datos As Usuario";
_datos = new b4a.HelmetAPPV3.usuario();
RDebugUtils.currentLine=3932175;
 //BA.debugLineNum = 3932175;BA.debugLine="datos.Initialize";
_datos._initialize(null,ba);
RDebugUtils.currentLine=3932176;
 //BA.debugLineNum = 3932176;BA.debugLine="datos.dni=cursor.GetInt(\"dni\")";
_datos._dni = _cursor.GetInt("dni");
RDebugUtils.currentLine=3932177;
 //BA.debugLineNum = 3932177;BA.debugLine="If datos.dni=DniINT Then";
if (_datos._dni==_dniint) { 
RDebugUtils.currentLine=3932178;
 //BA.debugLineNum = 3932178;BA.debugLine="flag=True";
_flag = __c.True;
 };
 }
};
RDebugUtils.currentLine=3932182;
 //BA.debugLineNum = 3932182;BA.debugLine="Return flag";
if (true) return _flag;
RDebugUtils.currentLine=3932183;
 //BA.debugLineNum = 3932183;BA.debugLine="End Sub";
return false;
}
public String  _insertardniclave(b4a.HelmetAPPV3.usuarios __ref,int _dni,int _clave) throws Exception{
__ref = this;
RDebugUtils.currentModule="usuarios";
if (Debug.shouldDelegate(ba, "insertardniclave"))
	 {return ((String) Debug.delegate(ba, "insertardniclave", new Object[] {_dni,_clave}));}
RDebugUtils.currentLine=3866624;
 //BA.debugLineNum = 3866624;BA.debugLine="Public Sub insertarDNICLAVE(Dni As Int, Clave As I";
RDebugUtils.currentLine=3866625;
 //BA.debugLineNum = 3866625;BA.debugLine="Log(\"--------------------------------------------";
__c.Log("--------------------------------------------");
RDebugUtils.currentLine=3866626;
 //BA.debugLineNum = 3866626;BA.debugLine="Log(\"ingresando datos en la base de datos\")";
__c.Log("ingresando datos en la base de datos");
RDebugUtils.currentLine=3866627;
 //BA.debugLineNum = 3866627;BA.debugLine="Sql.ExecNonQuery2(\"INSERT INTO usuarios (dni,clav";
__ref._sql.ExecNonQuery2("INSERT INTO usuarios (dni,clave) VALUES(?,?) ",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_dni),(Object)(_clave)}));
RDebugUtils.currentLine=3866628;
 //BA.debugLineNum = 3866628;BA.debugLine="End Sub";
return "";
}
public boolean  _chequearclave(b4a.HelmetAPPV3.usuarios __ref,String _dni,String _claveingresada) throws Exception{
__ref = this;
RDebugUtils.currentModule="usuarios";
if (Debug.shouldDelegate(ba, "chequearclave"))
	 {return ((Boolean) Debug.delegate(ba, "chequearclave", new Object[] {_dni,_claveingresada}));}
int _dniint = 0;
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
boolean _flag = false;
int _claveingresadaint = 0;
int _i = 0;
b4a.HelmetAPPV3.usuario _datos = null;
RDebugUtils.currentLine=4128768;
 //BA.debugLineNum = 4128768;BA.debugLine="Public Sub chequearCLAVE (Dni As String,ClaveIngre";
RDebugUtils.currentLine=4128770;
 //BA.debugLineNum = 4128770;BA.debugLine="Log(\"--------------------------------------------";
__c.Log("--------------------------------------------");
RDebugUtils.currentLine=4128771;
 //BA.debugLineNum = 4128771;BA.debugLine="Log (\"Chequeando que la Clave coincida con el DNI";
__c.Log("Chequeando que la Clave coincida con el DNI ingresado");
RDebugUtils.currentLine=4128772;
 //BA.debugLineNum = 4128772;BA.debugLine="Dim DniINT As Int";
_dniint = 0;
RDebugUtils.currentLine=4128773;
 //BA.debugLineNum = 4128773;BA.debugLine="DniINT=Dni'PASO A INTEGER";
_dniint = (int)(Double.parseDouble(_dni));
RDebugUtils.currentLine=4128774;
 //BA.debugLineNum = 4128774;BA.debugLine="Dim cursor As Cursor";
_cursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=4128775;
 //BA.debugLineNum = 4128775;BA.debugLine="Dim flag As Boolean";
_flag = false;
RDebugUtils.currentLine=4128776;
 //BA.debugLineNum = 4128776;BA.debugLine="Dim claveIngresadaINT As Int";
_claveingresadaint = 0;
RDebugUtils.currentLine=4128779;
 //BA.debugLineNum = 4128779;BA.debugLine="flag=False";
_flag = __c.False;
RDebugUtils.currentLine=4128780;
 //BA.debugLineNum = 4128780;BA.debugLine="claveIngresadaINT= ClaveIngresada'convierto a int";
_claveingresadaint = (int)(Double.parseDouble(_claveingresada));
RDebugUtils.currentLine=4128781;
 //BA.debugLineNum = 4128781;BA.debugLine="Log (\"la clave ingresada es: \"&claveIngresadaINT)";
__c.Log("la clave ingresada es: "+BA.NumberToString(_claveingresadaint));
RDebugUtils.currentLine=4128783;
 //BA.debugLineNum = 4128783;BA.debugLine="cursor=Sql.ExecQuery(\"SELECT * FROM usuarios\")";
_cursor.setObject((android.database.Cursor)(__ref._sql.ExecQuery("SELECT * FROM usuarios")));
RDebugUtils.currentLine=4128784;
 //BA.debugLineNum = 4128784;BA.debugLine="For i=0 To cursor.RowCount-1";
{
final int step12 = 1;
final int limit12 = (int) (_cursor.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit12 ;_i = _i + step12 ) {
RDebugUtils.currentLine=4128785;
 //BA.debugLineNum = 4128785;BA.debugLine="cursor.Position=i";
_cursor.setPosition(_i);
RDebugUtils.currentLine=4128787;
 //BA.debugLineNum = 4128787;BA.debugLine="Dim datos As Usuario";
_datos = new b4a.HelmetAPPV3.usuario();
RDebugUtils.currentLine=4128788;
 //BA.debugLineNum = 4128788;BA.debugLine="datos.Initialize";
_datos._initialize(null,ba);
RDebugUtils.currentLine=4128790;
 //BA.debugLineNum = 4128790;BA.debugLine="datos.dni=cursor.GetInt(\"dni\")";
_datos._dni = _cursor.GetInt("dni");
RDebugUtils.currentLine=4128791;
 //BA.debugLineNum = 4128791;BA.debugLine="If datos.dni=DniINT Then";
if (_datos._dni==_dniint) { 
RDebugUtils.currentLine=4128792;
 //BA.debugLineNum = 4128792;BA.debugLine="Log(\"dni detectado\")";
__c.Log("dni detectado");
RDebugUtils.currentLine=4128793;
 //BA.debugLineNum = 4128793;BA.debugLine="datos.clave=cursor.GetInt(\"clave\")";
_datos._clave = _cursor.GetInt("clave");
RDebugUtils.currentLine=4128794;
 //BA.debugLineNum = 4128794;BA.debugLine="Log(\"la clave de ese dni es: \"&datos.clave)";
__c.Log("la clave de ese dni es: "+BA.NumberToString(_datos._clave));
RDebugUtils.currentLine=4128795;
 //BA.debugLineNum = 4128795;BA.debugLine="If datos.clave=claveIngresadaINT Then";
if (_datos._clave==_claveingresadaint) { 
RDebugUtils.currentLine=4128796;
 //BA.debugLineNum = 4128796;BA.debugLine="Log(\"Usuario identificado exitósamente\")";
__c.Log("Usuario identificado exitósamente");
RDebugUtils.currentLine=4128797;
 //BA.debugLineNum = 4128797;BA.debugLine="flag=True";
_flag = __c.True;
 };
 };
 }
};
RDebugUtils.currentLine=4128803;
 //BA.debugLineNum = 4128803;BA.debugLine="Return flag";
if (true) return _flag;
RDebugUtils.currentLine=4128805;
 //BA.debugLineNum = 4128805;BA.debugLine="End Sub";
return false;
}
public String  _borrartodo(b4a.HelmetAPPV3.usuarios __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="usuarios";
if (Debug.shouldDelegate(ba, "borrartodo"))
	 {return ((String) Debug.delegate(ba, "borrartodo", null));}
RDebugUtils.currentLine=4063232;
 //BA.debugLineNum = 4063232;BA.debugLine="Public Sub borrarTODO";
RDebugUtils.currentLine=4063233;
 //BA.debugLineNum = 4063233;BA.debugLine="Sql.ExecNonQuery(\"DELETE FROM usuarios\")";
__ref._sql.ExecNonQuery("DELETE FROM usuarios");
RDebugUtils.currentLine=4063234;
 //BA.debugLineNum = 4063234;BA.debugLine="Log(\"base de datos limpia...\")";
__c.Log("base de datos limpia...");
RDebugUtils.currentLine=4063235;
 //BA.debugLineNum = 4063235;BA.debugLine="End Sub";
return "";
}
public String  _insertarhelmetid(b4a.HelmetAPPV3.usuarios __ref,String _helmetidingresado,String _dniingresado) throws Exception{
__ref = this;
RDebugUtils.currentModule="usuarios";
if (Debug.shouldDelegate(ba, "insertarhelmetid"))
	 {return ((String) Debug.delegate(ba, "insertarhelmetid", new Object[] {_helmetidingresado,_dniingresado}));}
long _helmetidingresadolong = 0L;
int _dniingresadoint = 0;
RDebugUtils.currentLine=4259840;
 //BA.debugLineNum = 4259840;BA.debugLine="Public Sub insertarHelmetID (HelmetIDIngresado As";
RDebugUtils.currentLine=4259841;
 //BA.debugLineNum = 4259841;BA.debugLine="Dim HelmetIDIngresadoLONG As Long";
_helmetidingresadolong = 0L;
RDebugUtils.currentLine=4259842;
 //BA.debugLineNum = 4259842;BA.debugLine="Dim DniIngresadoINT As Int";
_dniingresadoint = 0;
RDebugUtils.currentLine=4259844;
 //BA.debugLineNum = 4259844;BA.debugLine="HelmetIDIngresadoLONG=HelmetIDIngresado'paso de s";
_helmetidingresadolong = (long)(Double.parseDouble(_helmetidingresado));
RDebugUtils.currentLine=4259845;
 //BA.debugLineNum = 4259845;BA.debugLine="DniIngresadoINT=DniIngresado'paso de string a int";
_dniingresadoint = (int)(Double.parseDouble(_dniingresado));
RDebugUtils.currentLine=4259847;
 //BA.debugLineNum = 4259847;BA.debugLine="Log(\"--------------------------------------------";
__c.Log("--------------------------------------------");
RDebugUtils.currentLine=4259848;
 //BA.debugLineNum = 4259848;BA.debugLine="Log(\"ingresando HelmetID en la base de datos, baj";
__c.Log("ingresando HelmetID en la base de datos, bajo el DNI: "+_dniingresado);
RDebugUtils.currentLine=4259849;
 //BA.debugLineNum = 4259849;BA.debugLine="Log (\"el helmet ID es: \"& HelmetIDIngresadoLONG)";
__c.Log("el helmet ID es: "+BA.NumberToString(_helmetidingresadolong));
RDebugUtils.currentLine=4259850;
 //BA.debugLineNum = 4259850;BA.debugLine="Sql.ExecNonQuery2(\"UPDATE usuarios SET helmetid=?";
__ref._sql.ExecNonQuery2("UPDATE usuarios SET helmetid=? WHERE dni=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_helmetidingresadolong),(Object)(_dniingresado)}));
RDebugUtils.currentLine=4259851;
 //BA.debugLineNum = 4259851;BA.debugLine="Log (\"helmet ID ingresado\")";
__c.Log("helmet ID ingresado");
RDebugUtils.currentLine=4259853;
 //BA.debugLineNum = 4259853;BA.debugLine="End Sub";
return "";
}
public String  _leerhelmetid(b4a.HelmetAPPV3.usuarios __ref,String _dni) throws Exception{
__ref = this;
RDebugUtils.currentModule="usuarios";
if (Debug.shouldDelegate(ba, "leerhelmetid"))
	 {return ((String) Debug.delegate(ba, "leerhelmetid", new Object[] {_dni}));}
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
int _i = 0;
b4a.HelmetAPPV3.usuario _datos = null;
RDebugUtils.currentLine=4325376;
 //BA.debugLineNum = 4325376;BA.debugLine="Public Sub leerHelmetID (dni As String) As String";
RDebugUtils.currentLine=4325379;
 //BA.debugLineNum = 4325379;BA.debugLine="Log(\"--------------------------------------------";
__c.Log("--------------------------------------------");
RDebugUtils.currentLine=4325380;
 //BA.debugLineNum = 4325380;BA.debugLine="Log (\"leyendo HelmetID\")";
__c.Log("leyendo HelmetID");
RDebugUtils.currentLine=4325381;
 //BA.debugLineNum = 4325381;BA.debugLine="Dim cursor As Cursor";
_cursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=4325383;
 //BA.debugLineNum = 4325383;BA.debugLine="cursor=Sql.ExecQuery(\"SELECT * FROM usuarios\")";
_cursor.setObject((android.database.Cursor)(__ref._sql.ExecQuery("SELECT * FROM usuarios")));
RDebugUtils.currentLine=4325384;
 //BA.debugLineNum = 4325384;BA.debugLine="For i=0 To cursor.RowCount-1";
{
final int step5 = 1;
final int limit5 = (int) (_cursor.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
RDebugUtils.currentLine=4325385;
 //BA.debugLineNum = 4325385;BA.debugLine="cursor.Position=i";
_cursor.setPosition(_i);
RDebugUtils.currentLine=4325386;
 //BA.debugLineNum = 4325386;BA.debugLine="Dim datos As Usuario";
_datos = new b4a.HelmetAPPV3.usuario();
RDebugUtils.currentLine=4325387;
 //BA.debugLineNum = 4325387;BA.debugLine="datos.Initialize";
_datos._initialize(null,ba);
RDebugUtils.currentLine=4325388;
 //BA.debugLineNum = 4325388;BA.debugLine="datos.dni=cursor.GetInt(\"dni\")";
_datos._dni = _cursor.GetInt("dni");
RDebugUtils.currentLine=4325389;
 //BA.debugLineNum = 4325389;BA.debugLine="datos.clave=cursor.GetInt(\"clave\")";
_datos._clave = _cursor.GetInt("clave");
RDebugUtils.currentLine=4325390;
 //BA.debugLineNum = 4325390;BA.debugLine="datos.helmetID=cursor.GetInt(\"helmetid\")";
_datos._helmetid = (long) (_cursor.GetInt("helmetid"));
RDebugUtils.currentLine=4325391;
 //BA.debugLineNum = 4325391;BA.debugLine="datos.motoID=cursor.GetInt(\"motoid\")";
_datos._motoid = _cursor.GetInt("motoid");
RDebugUtils.currentLine=4325392;
 //BA.debugLineNum = 4325392;BA.debugLine="If datos.dni=dni Then";
if (_datos._dni==(double)(Double.parseDouble(_dni))) { 
RDebugUtils.currentLine=4325393;
 //BA.debugLineNum = 4325393;BA.debugLine="Log(\"El HelmetID correspondiente al dni: \" & da";
__c.Log("El HelmetID correspondiente al dni: "+BA.NumberToString(_datos._dni)+" es: "+BA.NumberToString(_datos._helmetid));
RDebugUtils.currentLine=4325394;
 //BA.debugLineNum = 4325394;BA.debugLine="Return datos.helmetID";
if (true) return BA.NumberToString(_datos._helmetid);
 };
 }
};
RDebugUtils.currentLine=4325398;
 //BA.debugLineNum = 4325398;BA.debugLine="End Sub";
return "";
}
public boolean  _chequearmotoid(b4a.HelmetAPPV3.usuarios __ref,String _motoid) throws Exception{
__ref = this;
RDebugUtils.currentModule="usuarios";
if (Debug.shouldDelegate(ba, "chequearmotoid"))
	 {return ((Boolean) Debug.delegate(ba, "chequearmotoid", new Object[] {_motoid}));}
int _motoidint = 0;
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
boolean _flag = false;
int _i = 0;
b4a.HelmetAPPV3.usuario _datos = null;
RDebugUtils.currentLine=5963776;
 //BA.debugLineNum = 5963776;BA.debugLine="Public Sub chequearMotoID (motoid As String) As Bo";
RDebugUtils.currentLine=5963779;
 //BA.debugLineNum = 5963779;BA.debugLine="Log(\"--------------------------------------------";
__c.Log("--------------------------------------------");
RDebugUtils.currentLine=5963780;
 //BA.debugLineNum = 5963780;BA.debugLine="Log(\"Chequeando en la base de datos si el motoID";
__c.Log("Chequeando en la base de datos si el motoID ya se encuentra registrado a nombre de otro usuario...");
RDebugUtils.currentLine=5963781;
 //BA.debugLineNum = 5963781;BA.debugLine="Dim motoidINT As Int";
_motoidint = 0;
RDebugUtils.currentLine=5963782;
 //BA.debugLineNum = 5963782;BA.debugLine="motoidINT=motoid'PASO A INTEGER";
_motoidint = (int)(Double.parseDouble(_motoid));
RDebugUtils.currentLine=5963783;
 //BA.debugLineNum = 5963783;BA.debugLine="Dim cursor As Cursor";
_cursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=5963784;
 //BA.debugLineNum = 5963784;BA.debugLine="Dim flag As Boolean";
_flag = false;
RDebugUtils.currentLine=5963785;
 //BA.debugLineNum = 5963785;BA.debugLine="flag=False";
_flag = __c.False;
RDebugUtils.currentLine=5963788;
 //BA.debugLineNum = 5963788;BA.debugLine="cursor=Sql.ExecQuery(\"SELECT * FROM usuarios\")";
_cursor.setObject((android.database.Cursor)(__ref._sql.ExecQuery("SELECT * FROM usuarios")));
RDebugUtils.currentLine=5963789;
 //BA.debugLineNum = 5963789;BA.debugLine="For i=0 To cursor.RowCount-1";
{
final int step9 = 1;
final int limit9 = (int) (_cursor.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit9 ;_i = _i + step9 ) {
RDebugUtils.currentLine=5963790;
 //BA.debugLineNum = 5963790;BA.debugLine="cursor.Position=i";
_cursor.setPosition(_i);
RDebugUtils.currentLine=5963792;
 //BA.debugLineNum = 5963792;BA.debugLine="Dim datos As Usuario";
_datos = new b4a.HelmetAPPV3.usuario();
RDebugUtils.currentLine=5963793;
 //BA.debugLineNum = 5963793;BA.debugLine="datos.Initialize";
_datos._initialize(null,ba);
RDebugUtils.currentLine=5963795;
 //BA.debugLineNum = 5963795;BA.debugLine="datos.motoID=cursor.GetInt(\"motoid\")";
_datos._motoid = _cursor.GetInt("motoid");
RDebugUtils.currentLine=5963797;
 //BA.debugLineNum = 5963797;BA.debugLine="If datos.motoID=motoidINT Then";
if (_datos._motoid==_motoidint) { 
RDebugUtils.currentLine=5963799;
 //BA.debugLineNum = 5963799;BA.debugLine="Log(\"Ya hay un motoID registrado con este usuar";
__c.Log("Ya hay un motoID registrado con este usuario!");
RDebugUtils.currentLine=5963800;
 //BA.debugLineNum = 5963800;BA.debugLine="Log(\"El DNI es: \"& datos.dni)";
__c.Log("El DNI es: "+BA.NumberToString(_datos._dni));
RDebugUtils.currentLine=5963801;
 //BA.debugLineNum = 5963801;BA.debugLine="flag=True";
_flag = __c.True;
 }else {
RDebugUtils.currentLine=5963804;
 //BA.debugLineNum = 5963804;BA.debugLine="Log(\"Ningún motoID registrado con el usuario in";
__c.Log("Ningún motoID registrado con el usuario ingresado");
RDebugUtils.currentLine=5963805;
 //BA.debugLineNum = 5963805;BA.debugLine="flag=False";
_flag = __c.False;
 };
 }
};
RDebugUtils.currentLine=5963809;
 //BA.debugLineNum = 5963809;BA.debugLine="Return flag";
if (true) return _flag;
RDebugUtils.currentLine=5963810;
 //BA.debugLineNum = 5963810;BA.debugLine="End Sub";
return false;
}
public String  _insertarmotoid(b4a.HelmetAPPV3.usuarios __ref,String _motoidingresado,String _dniingresado) throws Exception{
__ref = this;
RDebugUtils.currentModule="usuarios";
if (Debug.shouldDelegate(ba, "insertarmotoid"))
	 {return ((String) Debug.delegate(ba, "insertarmotoid", new Object[] {_motoidingresado,_dniingresado}));}
long _motoidingresadolong = 0L;
int _dniingresadoint = 0;
RDebugUtils.currentLine=7012352;
 //BA.debugLineNum = 7012352;BA.debugLine="Public Sub insertarMotoID (motoidIngresado As Stri";
RDebugUtils.currentLine=7012354;
 //BA.debugLineNum = 7012354;BA.debugLine="Dim MotoIDIngresadoLONG As Long";
_motoidingresadolong = 0L;
RDebugUtils.currentLine=7012355;
 //BA.debugLineNum = 7012355;BA.debugLine="Dim DniIngresadoINT As Int";
_dniingresadoint = 0;
RDebugUtils.currentLine=7012357;
 //BA.debugLineNum = 7012357;BA.debugLine="MotoIDIngresadoLONG=motoidIngresado'paso de strin";
_motoidingresadolong = (long)(Double.parseDouble(_motoidingresado));
RDebugUtils.currentLine=7012358;
 //BA.debugLineNum = 7012358;BA.debugLine="DniIngresadoINT=dniIngresado'paso de string a int";
_dniingresadoint = (int)(Double.parseDouble(_dniingresado));
RDebugUtils.currentLine=7012360;
 //BA.debugLineNum = 7012360;BA.debugLine="Log(\"--------------------------------------------";
__c.Log("--------------------------------------------");
RDebugUtils.currentLine=7012361;
 //BA.debugLineNum = 7012361;BA.debugLine="Log(\"ingresando MotoID: \"& MotoIDIngresadoLONG&\"";
__c.Log("ingresando MotoID: "+BA.NumberToString(_motoidingresadolong)+" en la base de datos, bajo el DNI: "+_dniingresado);
RDebugUtils.currentLine=7012362;
 //BA.debugLineNum = 7012362;BA.debugLine="Sql.ExecNonQuery2(\"UPDATE usuarios SET motoid=? W";
__ref._sql.ExecNonQuery2("UPDATE usuarios SET motoid=? WHERE dni=?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_motoidingresadolong),(Object)(_dniingresado)}));
RDebugUtils.currentLine=7012363;
 //BA.debugLineNum = 7012363;BA.debugLine="Log (\"Moto ID ingresado\")";
__c.Log("Moto ID ingresado");
RDebugUtils.currentLine=7012364;
 //BA.debugLineNum = 7012364;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(b4a.HelmetAPPV3.usuarios __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="usuarios";
RDebugUtils.currentLine=3735552;
 //BA.debugLineNum = 3735552;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=3735553;
 //BA.debugLineNum = 3735553;BA.debugLine="Private Sql As SQL";
_sql = new anywheresoftware.b4a.sql.SQL();
RDebugUtils.currentLine=3735554;
 //BA.debugLineNum = 3735554;BA.debugLine="End Sub";
return "";
}
}