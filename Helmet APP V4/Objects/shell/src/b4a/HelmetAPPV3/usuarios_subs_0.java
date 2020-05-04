package b4a.HelmetAPPV3;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class usuarios_subs_0 {


public static RemoteObject  _borrartodo(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("borrarTODO (usuarios) ","usuarios",6,__ref.getField(false, "ba"),__ref,66);
if (RapidSub.canDelegate("borrartodo")) { return __ref.runUserSub(false, "usuarios","borrartodo", __ref);}
 BA.debugLineNum = 66;BA.debugLine="Public Sub borrarTODO";
Debug.ShouldStop(2);
 BA.debugLineNum = 67;BA.debugLine="Sql.ExecNonQuery(\"DELETE FROM usuarios\")";
Debug.ShouldStop(4);
__ref.getField(false,"_sql").runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("DELETE FROM usuarios")));
 BA.debugLineNum = 68;BA.debugLine="Log(\"base de datos limpia...\")";
Debug.ShouldStop(8);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("base de datos limpia...")));
 BA.debugLineNum = 69;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _chequearclave(RemoteObject __ref,RemoteObject _dni,RemoteObject _claveingresada) throws Exception{
try {
		Debug.PushSubsStack("chequearCLAVE (usuarios) ","usuarios",6,__ref.getField(false, "ba"),__ref,71);
if (RapidSub.canDelegate("chequearclave")) { return __ref.runUserSub(false, "usuarios","chequearclave", __ref, _dni, _claveingresada);}
RemoteObject _dniint = RemoteObject.createImmutable(0);
RemoteObject _cursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _flag = RemoteObject.createImmutable(false);
RemoteObject _claveingresadaint = RemoteObject.createImmutable(0);
int _i = 0;
RemoteObject _datos = RemoteObject.declareNull("b4a.HelmetAPPV3.usuario");
Debug.locals.put("Dni", _dni);
Debug.locals.put("ClaveIngresada", _claveingresada);
 BA.debugLineNum = 71;BA.debugLine="Public Sub chequearCLAVE (Dni As String,ClaveIngre";
Debug.ShouldStop(64);
 BA.debugLineNum = 73;BA.debugLine="Log(\"--------------------------------------------";
Debug.ShouldStop(256);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("--------------------------------------------")));
 BA.debugLineNum = 74;BA.debugLine="Log (\"Chequeando que la Clave coincida con el DNI";
Debug.ShouldStop(512);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Chequeando que la Clave coincida con el DNI ingresado")));
 BA.debugLineNum = 75;BA.debugLine="Dim DniINT As Int";
Debug.ShouldStop(1024);
_dniint = RemoteObject.createImmutable(0);Debug.locals.put("DniINT", _dniint);
 BA.debugLineNum = 76;BA.debugLine="DniINT=Dni'PASO A INTEGER";
Debug.ShouldStop(2048);
_dniint = BA.numberCast(int.class, _dni);Debug.locals.put("DniINT", _dniint);
 BA.debugLineNum = 77;BA.debugLine="Dim cursor As Cursor";
Debug.ShouldStop(4096);
_cursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("cursor", _cursor);
 BA.debugLineNum = 78;BA.debugLine="Dim flag As Boolean";
Debug.ShouldStop(8192);
_flag = RemoteObject.createImmutable(false);Debug.locals.put("flag", _flag);
 BA.debugLineNum = 79;BA.debugLine="Dim claveIngresadaINT As Int";
Debug.ShouldStop(16384);
_claveingresadaint = RemoteObject.createImmutable(0);Debug.locals.put("claveIngresadaINT", _claveingresadaint);
 BA.debugLineNum = 82;BA.debugLine="flag=False";
Debug.ShouldStop(131072);
_flag = usuarios.__c.getField(true,"False");Debug.locals.put("flag", _flag);
 BA.debugLineNum = 83;BA.debugLine="claveIngresadaINT= ClaveIngresada'convierto a int";
Debug.ShouldStop(262144);
_claveingresadaint = BA.numberCast(int.class, _claveingresada);Debug.locals.put("claveIngresadaINT", _claveingresadaint);
 BA.debugLineNum = 84;BA.debugLine="Log (\"la clave ingresada es: \"&claveIngresadaINT)";
Debug.ShouldStop(524288);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("la clave ingresada es: "),_claveingresadaint)));
 BA.debugLineNum = 86;BA.debugLine="cursor=Sql.ExecQuery(\"SELECT * FROM usuarios\")";
Debug.ShouldStop(2097152);
_cursor.setObject(__ref.getField(false,"_sql").runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM usuarios"))));
 BA.debugLineNum = 87;BA.debugLine="For i=0 To cursor.RowCount-1";
Debug.ShouldStop(4194304);
{
final int step12 = 1;
final int limit12 = RemoteObject.solve(new RemoteObject[] {_cursor.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step12 > 0 && _i <= limit12) || (step12 < 0 && _i >= limit12) ;_i = ((int)(0 + _i + step12))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 88;BA.debugLine="cursor.Position=i";
Debug.ShouldStop(8388608);
_cursor.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 90;BA.debugLine="Dim datos As Usuario";
Debug.ShouldStop(33554432);
_datos = RemoteObject.createNew ("b4a.HelmetAPPV3.usuario");Debug.locals.put("datos", _datos);
 BA.debugLineNum = 91;BA.debugLine="datos.Initialize";
Debug.ShouldStop(67108864);
_datos.runClassMethod (b4a.HelmetAPPV3.usuario.class, "_initialize",__ref.getField(false, "ba"));
 BA.debugLineNum = 93;BA.debugLine="datos.dni=cursor.GetInt(\"dni\")";
Debug.ShouldStop(268435456);
_datos.setField ("_dni",_cursor.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("dni"))));
 BA.debugLineNum = 94;BA.debugLine="If datos.dni=DniINT Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",_datos.getField(true,"_dni"),BA.numberCast(double.class, _dniint))) { 
 BA.debugLineNum = 95;BA.debugLine="Log(\"dni detectado\")";
Debug.ShouldStop(1073741824);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("dni detectado")));
 BA.debugLineNum = 96;BA.debugLine="datos.clave=cursor.GetInt(\"clave\")";
Debug.ShouldStop(-2147483648);
_datos.setField ("_clave",_cursor.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("clave"))));
 BA.debugLineNum = 97;BA.debugLine="Log(\"la clave de ese dni es: \"&datos.clave)";
Debug.ShouldStop(1);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("la clave de ese dni es: "),_datos.getField(true,"_clave"))));
 BA.debugLineNum = 98;BA.debugLine="If datos.clave=claveIngresadaINT Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",_datos.getField(true,"_clave"),BA.numberCast(double.class, _claveingresadaint))) { 
 BA.debugLineNum = 99;BA.debugLine="Log(\"Usuario identificado exitósamente\")";
Debug.ShouldStop(4);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Usuario identificado exitósamente")));
 BA.debugLineNum = 100;BA.debugLine="flag=True";
Debug.ShouldStop(8);
_flag = usuarios.__c.getField(true,"True");Debug.locals.put("flag", _flag);
 };
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 106;BA.debugLine="Return flag";
Debug.ShouldStop(512);
if (true) return _flag;
 BA.debugLineNum = 108;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _chequeardni(RemoteObject __ref,RemoteObject _dni) throws Exception{
try {
		Debug.PushSubsStack("chequearDNI (usuarios) ","usuarios",6,__ref.getField(false, "ba"),__ref,17);
if (RapidSub.canDelegate("chequeardni")) { return __ref.runUserSub(false, "usuarios","chequeardni", __ref, _dni);}
RemoteObject _dniint = RemoteObject.createImmutable(0);
RemoteObject _cursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _flag = RemoteObject.createImmutable(false);
int _i = 0;
RemoteObject _datos = RemoteObject.declareNull("b4a.HelmetAPPV3.usuario");
Debug.locals.put("Dni", _dni);
 BA.debugLineNum = 17;BA.debugLine="Public Sub chequearDNI(Dni As String) As Boolean";
Debug.ShouldStop(65536);
 BA.debugLineNum = 19;BA.debugLine="Log(\"--------------------------------------------";
Debug.ShouldStop(262144);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("--------------------------------------------")));
 BA.debugLineNum = 20;BA.debugLine="Log (\"chequeando DNI\")";
Debug.ShouldStop(524288);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("chequeando DNI")));
 BA.debugLineNum = 21;BA.debugLine="Dim DniINT As Int";
Debug.ShouldStop(1048576);
_dniint = RemoteObject.createImmutable(0);Debug.locals.put("DniINT", _dniint);
 BA.debugLineNum = 22;BA.debugLine="DniINT=Dni'PASO A INTEGER";
Debug.ShouldStop(2097152);
_dniint = BA.numberCast(int.class, _dni);Debug.locals.put("DniINT", _dniint);
 BA.debugLineNum = 23;BA.debugLine="Dim cursor As Cursor";
Debug.ShouldStop(4194304);
_cursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("cursor", _cursor);
 BA.debugLineNum = 24;BA.debugLine="Dim flag As Boolean";
Debug.ShouldStop(8388608);
_flag = RemoteObject.createImmutable(false);Debug.locals.put("flag", _flag);
 BA.debugLineNum = 25;BA.debugLine="flag=False";
Debug.ShouldStop(16777216);
_flag = usuarios.__c.getField(true,"False");Debug.locals.put("flag", _flag);
 BA.debugLineNum = 27;BA.debugLine="cursor=Sql.ExecQuery(\"SELECT * FROM usuarios\")";
Debug.ShouldStop(67108864);
_cursor.setObject(__ref.getField(false,"_sql").runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM usuarios"))));
 BA.debugLineNum = 28;BA.debugLine="For i=0 To cursor.RowCount-1";
Debug.ShouldStop(134217728);
{
final int step9 = 1;
final int limit9 = RemoteObject.solve(new RemoteObject[] {_cursor.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step9 > 0 && _i <= limit9) || (step9 < 0 && _i >= limit9) ;_i = ((int)(0 + _i + step9))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 29;BA.debugLine="cursor.Position=i";
Debug.ShouldStop(268435456);
_cursor.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 31;BA.debugLine="Dim datos As Usuario";
Debug.ShouldStop(1073741824);
_datos = RemoteObject.createNew ("b4a.HelmetAPPV3.usuario");Debug.locals.put("datos", _datos);
 BA.debugLineNum = 32;BA.debugLine="datos.Initialize";
Debug.ShouldStop(-2147483648);
_datos.runClassMethod (b4a.HelmetAPPV3.usuario.class, "_initialize",__ref.getField(false, "ba"));
 BA.debugLineNum = 33;BA.debugLine="datos.dni=cursor.GetInt(\"dni\")";
Debug.ShouldStop(1);
_datos.setField ("_dni",_cursor.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("dni"))));
 BA.debugLineNum = 34;BA.debugLine="If datos.dni=DniINT Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",_datos.getField(true,"_dni"),BA.numberCast(double.class, _dniint))) { 
 BA.debugLineNum = 35;BA.debugLine="flag=True";
Debug.ShouldStop(4);
_flag = usuarios.__c.getField(true,"True");Debug.locals.put("flag", _flag);
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 39;BA.debugLine="Return flag";
Debug.ShouldStop(64);
if (true) return _flag;
 BA.debugLineNum = 40;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _chequearhelmetid(RemoteObject __ref,RemoteObject _dni) throws Exception{
try {
		Debug.PushSubsStack("chequearHelmetId (usuarios) ","usuarios",6,__ref.getField(false, "ba"),__ref,110);
if (RapidSub.canDelegate("chequearhelmetid")) { return __ref.runUserSub(false, "usuarios","chequearhelmetid", __ref, _dni);}
RemoteObject _dniint = RemoteObject.createImmutable(0);
RemoteObject _cursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _flag = RemoteObject.createImmutable(false);
int _i = 0;
RemoteObject _datos = RemoteObject.declareNull("b4a.HelmetAPPV3.usuario");
Debug.locals.put("Dni", _dni);
 BA.debugLineNum = 110;BA.debugLine="Public Sub chequearHelmetId (Dni As String) As Boo";
Debug.ShouldStop(8192);
 BA.debugLineNum = 111;BA.debugLine="Log(\"--------------------------------------------";
Debug.ShouldStop(16384);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("--------------------------------------------")));
 BA.debugLineNum = 112;BA.debugLine="Log (\"Chequeando si el DNI ingresado ya contiene";
Debug.ShouldStop(32768);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Chequeando si el DNI ingresado ya contiene un HelmetID")));
 BA.debugLineNum = 113;BA.debugLine="Dim DniINT As Int";
Debug.ShouldStop(65536);
_dniint = RemoteObject.createImmutable(0);Debug.locals.put("DniINT", _dniint);
 BA.debugLineNum = 114;BA.debugLine="DniINT=Dni'PASO A INTEGER";
Debug.ShouldStop(131072);
_dniint = BA.numberCast(int.class, _dni);Debug.locals.put("DniINT", _dniint);
 BA.debugLineNum = 115;BA.debugLine="Dim cursor As Cursor";
Debug.ShouldStop(262144);
_cursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("cursor", _cursor);
 BA.debugLineNum = 116;BA.debugLine="Dim flag As Boolean";
Debug.ShouldStop(524288);
_flag = RemoteObject.createImmutable(false);Debug.locals.put("flag", _flag);
 BA.debugLineNum = 117;BA.debugLine="flag=False";
Debug.ShouldStop(1048576);
_flag = usuarios.__c.getField(true,"False");Debug.locals.put("flag", _flag);
 BA.debugLineNum = 120;BA.debugLine="cursor=Sql.ExecQuery(\"SELECT * FROM usuarios\")";
Debug.ShouldStop(8388608);
_cursor.setObject(__ref.getField(false,"_sql").runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM usuarios"))));
 BA.debugLineNum = 121;BA.debugLine="For i=0 To cursor.RowCount-1";
Debug.ShouldStop(16777216);
{
final int step9 = 1;
final int limit9 = RemoteObject.solve(new RemoteObject[] {_cursor.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step9 > 0 && _i <= limit9) || (step9 < 0 && _i >= limit9) ;_i = ((int)(0 + _i + step9))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 122;BA.debugLine="cursor.Position=i";
Debug.ShouldStop(33554432);
_cursor.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 124;BA.debugLine="Dim datos As Usuario";
Debug.ShouldStop(134217728);
_datos = RemoteObject.createNew ("b4a.HelmetAPPV3.usuario");Debug.locals.put("datos", _datos);
 BA.debugLineNum = 125;BA.debugLine="datos.Initialize";
Debug.ShouldStop(268435456);
_datos.runClassMethod (b4a.HelmetAPPV3.usuario.class, "_initialize",__ref.getField(false, "ba"));
 BA.debugLineNum = 127;BA.debugLine="datos.dni=cursor.GetInt(\"dni\")";
Debug.ShouldStop(1073741824);
_datos.setField ("_dni",_cursor.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("dni"))));
 BA.debugLineNum = 128;BA.debugLine="If datos.dni=DniINT Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",_datos.getField(true,"_dni"),BA.numberCast(double.class, _dniint))) { 
 BA.debugLineNum = 129;BA.debugLine="Log(\"dni detectado\")";
Debug.ShouldStop(1);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("dni detectado")));
 BA.debugLineNum = 130;BA.debugLine="datos.helmetID=cursor.GetInt(\"helmetid\")";
Debug.ShouldStop(2);
_datos.setField ("_helmetid",BA.numberCast(long.class, _cursor.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("helmetid")))));
 BA.debugLineNum = 132;BA.debugLine="If datos.helmetID=0 Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",_datos.getField(true,"_helmetid"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 133;BA.debugLine="Log(\"Ningún HelmetID registrado con el usuario";
Debug.ShouldStop(16);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Ningún HelmetID registrado con el usuario ingresado")));
 BA.debugLineNum = 134;BA.debugLine="flag=False";
Debug.ShouldStop(32);
_flag = usuarios.__c.getField(true,"False");Debug.locals.put("flag", _flag);
 }else {
 BA.debugLineNum = 136;BA.debugLine="flag=True";
Debug.ShouldStop(128);
_flag = usuarios.__c.getField(true,"True");Debug.locals.put("flag", _flag);
 BA.debugLineNum = 137;BA.debugLine="Log(\"Ya hay un HelmetID registrado con este u";
Debug.ShouldStop(256);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Ya hay un HelmetID registrado con este usuario")));
 BA.debugLineNum = 138;BA.debugLine="Log(\"El HelmetID es: \"& datos.helmetID)";
Debug.ShouldStop(512);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("El HelmetID es: "),_datos.getField(true,"_helmetid"))));
 };
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 143;BA.debugLine="Return flag";
Debug.ShouldStop(16384);
if (true) return _flag;
 BA.debugLineNum = 145;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _chequearmotoid(RemoteObject __ref,RemoteObject _motoid) throws Exception{
try {
		Debug.PushSubsStack("chequearMotoID (usuarios) ","usuarios",6,__ref.getField(false, "ba"),__ref,230);
if (RapidSub.canDelegate("chequearmotoid")) { return __ref.runUserSub(false, "usuarios","chequearmotoid", __ref, _motoid);}
RemoteObject _motoidint = RemoteObject.createImmutable(0);
RemoteObject _cursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _flag = RemoteObject.createImmutable(false);
int _i = 0;
RemoteObject _datos = RemoteObject.declareNull("b4a.HelmetAPPV3.usuario");
Debug.locals.put("motoid", _motoid);
 BA.debugLineNum = 230;BA.debugLine="Public Sub chequearMotoID (motoid As String) As Bo";
Debug.ShouldStop(32);
 BA.debugLineNum = 233;BA.debugLine="Log(\"--------------------------------------------";
Debug.ShouldStop(256);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("--------------------------------------------")));
 BA.debugLineNum = 234;BA.debugLine="Log(\"Chequeando en la base de datos si el motoID";
Debug.ShouldStop(512);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Chequeando en la base de datos si el motoID ya se encuentra registrado a nombre de otro usuario...")));
 BA.debugLineNum = 235;BA.debugLine="Dim motoidINT As Int";
Debug.ShouldStop(1024);
_motoidint = RemoteObject.createImmutable(0);Debug.locals.put("motoidINT", _motoidint);
 BA.debugLineNum = 236;BA.debugLine="motoidINT=motoid'PASO A INTEGER";
Debug.ShouldStop(2048);
_motoidint = BA.numberCast(int.class, _motoid);Debug.locals.put("motoidINT", _motoidint);
 BA.debugLineNum = 237;BA.debugLine="Dim cursor As Cursor";
Debug.ShouldStop(4096);
_cursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("cursor", _cursor);
 BA.debugLineNum = 238;BA.debugLine="Dim flag As Boolean";
Debug.ShouldStop(8192);
_flag = RemoteObject.createImmutable(false);Debug.locals.put("flag", _flag);
 BA.debugLineNum = 239;BA.debugLine="flag=False";
Debug.ShouldStop(16384);
_flag = usuarios.__c.getField(true,"False");Debug.locals.put("flag", _flag);
 BA.debugLineNum = 242;BA.debugLine="cursor=Sql.ExecQuery(\"SELECT * FROM usuarios\")";
Debug.ShouldStop(131072);
_cursor.setObject(__ref.getField(false,"_sql").runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM usuarios"))));
 BA.debugLineNum = 243;BA.debugLine="For i=0 To cursor.RowCount-1";
Debug.ShouldStop(262144);
{
final int step9 = 1;
final int limit9 = RemoteObject.solve(new RemoteObject[] {_cursor.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step9 > 0 && _i <= limit9) || (step9 < 0 && _i >= limit9) ;_i = ((int)(0 + _i + step9))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 244;BA.debugLine="cursor.Position=i";
Debug.ShouldStop(524288);
_cursor.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 246;BA.debugLine="Dim datos As Usuario";
Debug.ShouldStop(2097152);
_datos = RemoteObject.createNew ("b4a.HelmetAPPV3.usuario");Debug.locals.put("datos", _datos);
 BA.debugLineNum = 247;BA.debugLine="datos.Initialize";
Debug.ShouldStop(4194304);
_datos.runClassMethod (b4a.HelmetAPPV3.usuario.class, "_initialize",__ref.getField(false, "ba"));
 BA.debugLineNum = 249;BA.debugLine="datos.motoID=cursor.GetInt(\"motoid\")";
Debug.ShouldStop(16777216);
_datos.setField ("_motoid",_cursor.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("motoid"))));
 BA.debugLineNum = 251;BA.debugLine="If datos.motoID=motoidINT Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",_datos.getField(true,"_motoid"),BA.numberCast(double.class, _motoidint))) { 
 BA.debugLineNum = 253;BA.debugLine="Log(\"Ya hay un motoID registrado con este usuar";
Debug.ShouldStop(268435456);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Ya hay un motoID registrado con este usuario!")));
 BA.debugLineNum = 254;BA.debugLine="Log(\"El DNI es: \"& datos.dni)";
Debug.ShouldStop(536870912);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("El DNI es: "),_datos.getField(true,"_dni"))));
 BA.debugLineNum = 255;BA.debugLine="flag=True";
Debug.ShouldStop(1073741824);
_flag = usuarios.__c.getField(true,"True");Debug.locals.put("flag", _flag);
 }else {
 BA.debugLineNum = 258;BA.debugLine="Log(\"Ningún motoID registrado con el usuario in";
Debug.ShouldStop(2);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Ningún motoID registrado con el usuario ingresado")));
 BA.debugLineNum = 259;BA.debugLine="flag=False";
Debug.ShouldStop(4);
_flag = usuarios.__c.getField(true,"False");Debug.locals.put("flag", _flag);
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 263;BA.debugLine="Return flag";
Debug.ShouldStop(64);
if (true) return _flag;
 BA.debugLineNum = 264;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Private Sql As SQL";
usuarios._sql = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");__ref.setField("_sql",usuarios._sql);
 //BA.debugLineNum = 3;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("Initialize (usuarios) ","usuarios",6,__ref.getField(false, "ba"),__ref,6);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "usuarios","initialize", __ref, _ba);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
 BA.debugLineNum = 6;BA.debugLine="Public Sub Initialize";
Debug.ShouldStop(32);
 BA.debugLineNum = 7;BA.debugLine="Sql.Initialize(File.DirInternalCache,\"usuarios.db";
Debug.ShouldStop(64);
__ref.getField(false,"_sql").runVoidMethod ("Initialize",(Object)(usuarios.__c.getField(false,"File").runMethod(true,"getDirInternalCache")),(Object)(BA.ObjectToString("usuarios.db")),(Object)(usuarios.__c.getField(true,"True")));
 BA.debugLineNum = 8;BA.debugLine="Sql.ExecNonQuery(\"CREATE TABLE IF NOT EXISTS usua";
Debug.ShouldStop(128);
__ref.getField(false,"_sql").runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("CREATE TABLE IF NOT EXISTS usuarios (dni integer PRIMARY KEY,clave integer, helmetid long,motoid integer)")));
 BA.debugLineNum = 9;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _insertardniclave(RemoteObject __ref,RemoteObject _dni,RemoteObject _clave) throws Exception{
try {
		Debug.PushSubsStack("insertarDNICLAVE (usuarios) ","usuarios",6,__ref.getField(false, "ba"),__ref,11);
if (RapidSub.canDelegate("insertardniclave")) { return __ref.runUserSub(false, "usuarios","insertardniclave", __ref, _dni, _clave);}
Debug.locals.put("Dni", _dni);
Debug.locals.put("Clave", _clave);
 BA.debugLineNum = 11;BA.debugLine="Public Sub insertarDNICLAVE(Dni As Int, Clave As I";
Debug.ShouldStop(1024);
 BA.debugLineNum = 12;BA.debugLine="Log(\"--------------------------------------------";
Debug.ShouldStop(2048);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("--------------------------------------------")));
 BA.debugLineNum = 13;BA.debugLine="Log(\"ingresando datos en la base de datos\")";
Debug.ShouldStop(4096);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("ingresando datos en la base de datos")));
 BA.debugLineNum = 14;BA.debugLine="Sql.ExecNonQuery2(\"INSERT INTO usuarios (dni,clav";
Debug.ShouldStop(8192);
__ref.getField(false,"_sql").runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO usuarios (dni,clave) VALUES(?,?) ")),(Object)(usuarios.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {(_dni),(_clave)})))));
 BA.debugLineNum = 15;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _insertarhelmetid(RemoteObject __ref,RemoteObject _helmetidingresado,RemoteObject _dniingresado) throws Exception{
try {
		Debug.PushSubsStack("insertarHelmetID (usuarios) ","usuarios",6,__ref.getField(false, "ba"),__ref,185);
if (RapidSub.canDelegate("insertarhelmetid")) { return __ref.runUserSub(false, "usuarios","insertarhelmetid", __ref, _helmetidingresado, _dniingresado);}
RemoteObject _helmetidingresadolong = RemoteObject.createImmutable(0L);
RemoteObject _dniingresadoint = RemoteObject.createImmutable(0);
Debug.locals.put("HelmetIDIngresado", _helmetidingresado);
Debug.locals.put("DniIngresado", _dniingresado);
 BA.debugLineNum = 185;BA.debugLine="Public Sub insertarHelmetID (HelmetIDIngresado As";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 186;BA.debugLine="Dim HelmetIDIngresadoLONG As Long";
Debug.ShouldStop(33554432);
_helmetidingresadolong = RemoteObject.createImmutable(0L);Debug.locals.put("HelmetIDIngresadoLONG", _helmetidingresadolong);
 BA.debugLineNum = 187;BA.debugLine="Dim DniIngresadoINT As Int";
Debug.ShouldStop(67108864);
_dniingresadoint = RemoteObject.createImmutable(0);Debug.locals.put("DniIngresadoINT", _dniingresadoint);
 BA.debugLineNum = 189;BA.debugLine="HelmetIDIngresadoLONG=HelmetIDIngresado'paso de s";
Debug.ShouldStop(268435456);
_helmetidingresadolong = BA.numberCast(long.class, _helmetidingresado);Debug.locals.put("HelmetIDIngresadoLONG", _helmetidingresadolong);
 BA.debugLineNum = 190;BA.debugLine="DniIngresadoINT=DniIngresado'paso de string a int";
Debug.ShouldStop(536870912);
_dniingresadoint = BA.numberCast(int.class, _dniingresado);Debug.locals.put("DniIngresadoINT", _dniingresadoint);
 BA.debugLineNum = 192;BA.debugLine="Log(\"--------------------------------------------";
Debug.ShouldStop(-2147483648);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("--------------------------------------------")));
 BA.debugLineNum = 193;BA.debugLine="Log(\"ingresando HelmetID en la base de datos, baj";
Debug.ShouldStop(1);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("ingresando HelmetID en la base de datos, bajo el DNI: "),_dniingresado)));
 BA.debugLineNum = 194;BA.debugLine="Log (\"el helmet ID es: \"& HelmetIDIngresadoLONG)";
Debug.ShouldStop(2);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("el helmet ID es: "),_helmetidingresadolong)));
 BA.debugLineNum = 195;BA.debugLine="Sql.ExecNonQuery2(\"UPDATE usuarios SET helmetid=?";
Debug.ShouldStop(4);
__ref.getField(false,"_sql").runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE usuarios SET helmetid=? WHERE dni=?")),(Object)(usuarios.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {(_helmetidingresadolong),(_dniingresado)})))));
 BA.debugLineNum = 196;BA.debugLine="Log (\"helmet ID ingresado\")";
Debug.ShouldStop(8);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("helmet ID ingresado")));
 BA.debugLineNum = 198;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _insertarmotoid(RemoteObject __ref,RemoteObject _motoidingresado,RemoteObject _dniingresado) throws Exception{
try {
		Debug.PushSubsStack("insertarMotoID (usuarios) ","usuarios",6,__ref.getField(false, "ba"),__ref,266);
if (RapidSub.canDelegate("insertarmotoid")) { return __ref.runUserSub(false, "usuarios","insertarmotoid", __ref, _motoidingresado, _dniingresado);}
RemoteObject _motoidingresadolong = RemoteObject.createImmutable(0L);
RemoteObject _dniingresadoint = RemoteObject.createImmutable(0);
Debug.locals.put("motoidIngresado", _motoidingresado);
Debug.locals.put("dniIngresado", _dniingresado);
 BA.debugLineNum = 266;BA.debugLine="Public Sub insertarMotoID (motoidIngresado As Stri";
Debug.ShouldStop(512);
 BA.debugLineNum = 268;BA.debugLine="Dim MotoIDIngresadoLONG As Long";
Debug.ShouldStop(2048);
_motoidingresadolong = RemoteObject.createImmutable(0L);Debug.locals.put("MotoIDIngresadoLONG", _motoidingresadolong);
 BA.debugLineNum = 269;BA.debugLine="Dim DniIngresadoINT As Int";
Debug.ShouldStop(4096);
_dniingresadoint = RemoteObject.createImmutable(0);Debug.locals.put("DniIngresadoINT", _dniingresadoint);
 BA.debugLineNum = 271;BA.debugLine="MotoIDIngresadoLONG=motoidIngresado'paso de strin";
Debug.ShouldStop(16384);
_motoidingresadolong = BA.numberCast(long.class, _motoidingresado);Debug.locals.put("MotoIDIngresadoLONG", _motoidingresadolong);
 BA.debugLineNum = 272;BA.debugLine="DniIngresadoINT=dniIngresado'paso de string a int";
Debug.ShouldStop(32768);
_dniingresadoint = BA.numberCast(int.class, _dniingresado);Debug.locals.put("DniIngresadoINT", _dniingresadoint);
 BA.debugLineNum = 274;BA.debugLine="Log(\"--------------------------------------------";
Debug.ShouldStop(131072);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("--------------------------------------------")));
 BA.debugLineNum = 275;BA.debugLine="Log(\"ingresando MotoID: \"& MotoIDIngresadoLONG&\"";
Debug.ShouldStop(262144);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("ingresando MotoID: "),_motoidingresadolong,RemoteObject.createImmutable(" en la base de datos, bajo el DNI: "),_dniingresado)));
 BA.debugLineNum = 276;BA.debugLine="Sql.ExecNonQuery2(\"UPDATE usuarios SET motoid=? W";
Debug.ShouldStop(524288);
__ref.getField(false,"_sql").runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE usuarios SET motoid=? WHERE dni=?")),(Object)(usuarios.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {(_motoidingresadolong),(_dniingresado)})))));
 BA.debugLineNum = 277;BA.debugLine="Log (\"Moto ID ingresado\")";
Debug.ShouldStop(1048576);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Moto ID ingresado")));
 BA.debugLineNum = 278;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _leerhelmetid(RemoteObject __ref,RemoteObject _dni) throws Exception{
try {
		Debug.PushSubsStack("leerHelmetID (usuarios) ","usuarios",6,__ref.getField(false, "ba"),__ref,206);
if (RapidSub.canDelegate("leerhelmetid")) { return __ref.runUserSub(false, "usuarios","leerhelmetid", __ref, _dni);}
RemoteObject _cursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
int _i = 0;
RemoteObject _datos = RemoteObject.declareNull("b4a.HelmetAPPV3.usuario");
Debug.locals.put("dni", _dni);
 BA.debugLineNum = 206;BA.debugLine="Public Sub leerHelmetID (dni As String) As String";
Debug.ShouldStop(8192);
 BA.debugLineNum = 209;BA.debugLine="Log(\"--------------------------------------------";
Debug.ShouldStop(65536);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("--------------------------------------------")));
 BA.debugLineNum = 210;BA.debugLine="Log (\"leyendo HelmetID\")";
Debug.ShouldStop(131072);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("leyendo HelmetID")));
 BA.debugLineNum = 211;BA.debugLine="Dim cursor As Cursor";
Debug.ShouldStop(262144);
_cursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("cursor", _cursor);
 BA.debugLineNum = 213;BA.debugLine="cursor=Sql.ExecQuery(\"SELECT * FROM usuarios\")";
Debug.ShouldStop(1048576);
_cursor.setObject(__ref.getField(false,"_sql").runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM usuarios"))));
 BA.debugLineNum = 214;BA.debugLine="For i=0 To cursor.RowCount-1";
Debug.ShouldStop(2097152);
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {_cursor.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5) ;_i = ((int)(0 + _i + step5))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 215;BA.debugLine="cursor.Position=i";
Debug.ShouldStop(4194304);
_cursor.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 216;BA.debugLine="Dim datos As Usuario";
Debug.ShouldStop(8388608);
_datos = RemoteObject.createNew ("b4a.HelmetAPPV3.usuario");Debug.locals.put("datos", _datos);
 BA.debugLineNum = 217;BA.debugLine="datos.Initialize";
Debug.ShouldStop(16777216);
_datos.runClassMethod (b4a.HelmetAPPV3.usuario.class, "_initialize",__ref.getField(false, "ba"));
 BA.debugLineNum = 218;BA.debugLine="datos.dni=cursor.GetInt(\"dni\")";
Debug.ShouldStop(33554432);
_datos.setField ("_dni",_cursor.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("dni"))));
 BA.debugLineNum = 219;BA.debugLine="datos.clave=cursor.GetInt(\"clave\")";
Debug.ShouldStop(67108864);
_datos.setField ("_clave",_cursor.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("clave"))));
 BA.debugLineNum = 220;BA.debugLine="datos.helmetID=cursor.GetInt(\"helmetid\")";
Debug.ShouldStop(134217728);
_datos.setField ("_helmetid",BA.numberCast(long.class, _cursor.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("helmetid")))));
 BA.debugLineNum = 221;BA.debugLine="datos.motoID=cursor.GetInt(\"motoid\")";
Debug.ShouldStop(268435456);
_datos.setField ("_motoid",_cursor.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("motoid"))));
 BA.debugLineNum = 222;BA.debugLine="If datos.dni=dni Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",_datos.getField(true,"_dni"),BA.numberCast(double.class, _dni))) { 
 BA.debugLineNum = 223;BA.debugLine="Log(\"El HelmetID correspondiente al dni: \" & da";
Debug.ShouldStop(1073741824);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("El HelmetID correspondiente al dni: "),_datos.getField(true,"_dni"),RemoteObject.createImmutable(" es: "),_datos.getField(true,"_helmetid"))));
 BA.debugLineNum = 224;BA.debugLine="Return datos.helmetID";
Debug.ShouldStop(-2147483648);
if (true) return BA.NumberToString(_datos.getField(true,"_helmetid"));
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 228;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _leerusuarios(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("leerUSUARIOS (usuarios) ","usuarios",6,__ref.getField(false, "ba"),__ref,42);
if (RapidSub.canDelegate("leerusuarios")) { return __ref.runUserSub(false, "usuarios","leerusuarios", __ref);}
RemoteObject _cursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
int _i = 0;
RemoteObject _datos = RemoteObject.declareNull("b4a.HelmetAPPV3.usuario");
 BA.debugLineNum = 42;BA.debugLine="Public Sub leerUSUARIOS";
Debug.ShouldStop(512);
 BA.debugLineNum = 43;BA.debugLine="Log(\"--------------------------------------------";
Debug.ShouldStop(1024);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("--------------------------------------------")));
 BA.debugLineNum = 44;BA.debugLine="Log (\"leyendo base de datos\")";
Debug.ShouldStop(2048);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("leyendo base de datos")));
 BA.debugLineNum = 45;BA.debugLine="Dim cursor As Cursor";
Debug.ShouldStop(4096);
_cursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("cursor", _cursor);
 BA.debugLineNum = 48;BA.debugLine="cursor=Sql.ExecQuery(\"SELECT * FROM usuarios\")";
Debug.ShouldStop(32768);
_cursor.setObject(__ref.getField(false,"_sql").runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM usuarios"))));
 BA.debugLineNum = 49;BA.debugLine="For i=0 To cursor.RowCount-1";
Debug.ShouldStop(65536);
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {_cursor.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5) ;_i = ((int)(0 + _i + step5))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 50;BA.debugLine="cursor.Position=i";
Debug.ShouldStop(131072);
_cursor.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 51;BA.debugLine="Dim datos As Usuario";
Debug.ShouldStop(262144);
_datos = RemoteObject.createNew ("b4a.HelmetAPPV3.usuario");Debug.locals.put("datos", _datos);
 BA.debugLineNum = 52;BA.debugLine="datos.Initialize";
Debug.ShouldStop(524288);
_datos.runClassMethod (b4a.HelmetAPPV3.usuario.class, "_initialize",__ref.getField(false, "ba"));
 BA.debugLineNum = 53;BA.debugLine="datos.dni=cursor.GetInt(\"dni\")";
Debug.ShouldStop(1048576);
_datos.setField ("_dni",_cursor.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("dni"))));
 BA.debugLineNum = 54;BA.debugLine="datos.clave=cursor.GetInt(\"clave\")";
Debug.ShouldStop(2097152);
_datos.setField ("_clave",_cursor.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("clave"))));
 BA.debugLineNum = 55;BA.debugLine="datos.helmetID=cursor.GetInt(\"helmetid\")";
Debug.ShouldStop(4194304);
_datos.setField ("_helmetid",BA.numberCast(long.class, _cursor.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("helmetid")))));
 BA.debugLineNum = 56;BA.debugLine="datos.motoID=cursor.GetInt(\"motoid\")";
Debug.ShouldStop(8388608);
_datos.setField ("_motoid",_cursor.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("motoid"))));
 BA.debugLineNum = 57;BA.debugLine="Log(\"Usuario Nº \"&i)";
Debug.ShouldStop(16777216);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Usuario Nº "),RemoteObject.createImmutable(_i))));
 BA.debugLineNum = 58;BA.debugLine="Log(\"DNI: \"&datos.dni)";
Debug.ShouldStop(33554432);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("DNI: "),_datos.getField(true,"_dni"))));
 BA.debugLineNum = 59;BA.debugLine="Log (\"Clave: \"&datos.clave)";
Debug.ShouldStop(67108864);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Clave: "),_datos.getField(true,"_clave"))));
 BA.debugLineNum = 60;BA.debugLine="Log(\"Helmet ID: \"&datos.helmetID)";
Debug.ShouldStop(134217728);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Helmet ID: "),_datos.getField(true,"_helmetid"))));
 BA.debugLineNum = 61;BA.debugLine="Log(\"Moto ID: \"&datos.motoID)";
Debug.ShouldStop(268435456);
usuarios.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Moto ID: "),_datos.getField(true,"_motoid"))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 64;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}