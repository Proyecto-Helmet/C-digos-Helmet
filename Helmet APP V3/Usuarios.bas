B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=8.3
@EndOfDesignText@
Sub Class_Globals
	Private Sql As SQL
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize
	Sql.Initialize(File.DirInternalCache,"usuarios.db",True)
	Sql.ExecNonQuery("CREATE TABLE IF NOT EXISTS usuarios (dni integer PRIMARY KEY,clave integer, helmetid long,motoid integer)")
End Sub

Public Sub insertarDNICLAVE(Dni As Int, Clave As Int)
	Log("--------------------------------------------")
	Log("ingresando datos en la base de datos")
	Sql.ExecNonQuery2("INSERT INTO usuarios (dni,clave) VALUES(?,?) ", Array As Object (Dni,Clave))	
End Sub

Public Sub chequearDNI(Dni As String) As Boolean  'devuelve TRUE si ya hay un miembro de la lista con ese mismo DNI o FALSO en caso contrario
	
	Log("--------------------------------------------")
	Log ("chequeando DNI")
	Dim DniINT As Int
	DniINT=Dni'PASO A INTEGER
	Dim cursor As Cursor
	Dim flag As Boolean
	flag=False
	
	cursor=Sql.ExecQuery("SELECT * FROM usuarios")
	For i=0 To cursor.RowCount-1
		cursor.Position=i
		
		Dim datos As Usuario
		datos.Initialize
		datos.dni=cursor.GetInt("dni")
		If datos.dni=DniINT Then
			flag=True
		End If
		
	Next
	Return flag		
End Sub

Public Sub leerUSUARIOS
	Log("--------------------------------------------")
	Log ("leyendo base de datos")
	Dim cursor As Cursor

	
	cursor=Sql.ExecQuery("SELECT * FROM usuarios")
	For i=0 To cursor.RowCount-1
		cursor.Position=i
		Dim datos As Usuario
		datos.Initialize
		datos.dni=cursor.GetInt("dni")
		datos.clave=cursor.GetInt("clave")
		datos.helmetID=cursor.GetInt("helmetid")
		datos.motoID=cursor.GetInt("motoid")
		Log("Usuario Nº "&i)
		Log("DNI: "&datos.dni)
		Log ("Clave: "&datos.clave)
		Log("Helmet ID: "&datos.helmetID)
		Log("Moto ID: "&datos.motoID)
	Next
		
End Sub

Public Sub borrarTODO
	Sql.ExecNonQuery("DELETE FROM usuarios")
	Log("base de datos limpia...")
End Sub
	
Public Sub chequearCLAVE (Dni As String,ClaveIngresada As String)	As Boolean
	
	Log("--------------------------------------------")
	Log ("Chequeando que la Clave coincida con el DNI ingresado")
	Dim DniINT As Int
	DniINT=Dni'PASO A INTEGER
	Dim cursor As Cursor
	Dim flag As Boolean
	Dim claveIngresadaINT As Int

    
	flag=False
	claveIngresadaINT= ClaveIngresada'convierto a int
	Log ("la clave ingresada es: "&claveIngresadaINT)
	
	cursor=Sql.ExecQuery("SELECT * FROM usuarios")
	For i=0 To cursor.RowCount-1
		cursor.Position=i
		
		Dim datos As Usuario
		datos.Initialize
		
		datos.dni=cursor.GetInt("dni")
		If datos.dni=DniINT Then
			Log("dni detectado")
			datos.clave=cursor.GetInt("clave")
			Log("la clave de ese dni es: "&datos.clave)
			If datos.clave=claveIngresadaINT Then
				Log("Usuario identificado exitósamente")
				flag=True
				
			End If
		End If
	Next
	
	Return flag
	
End Sub

Public Sub chequearHelmetId (Dni As String) As Boolean   'devuelve TRUE si ya hay un HelmetID registrado con el usuario del DNI
	Log("--------------------------------------------")
	Log ("Chequeando si el DNI ingresado ya contiene un HelmetID")
	Dim DniINT As Int
	DniINT=Dni'PASO A INTEGER
	Dim cursor As Cursor
	Dim flag As Boolean
	flag=False
	'Dim datosString As String

	cursor=Sql.ExecQuery("SELECT * FROM usuarios")
	For i=0 To cursor.RowCount-1
		cursor.Position=i
		
		Dim datos As Usuario
		datos.Initialize
		
		datos.dni=cursor.GetInt("dni")
		If datos.dni=DniINT Then
			Log("dni detectado")
			datos.helmetID=cursor.GetInt("helmetid")
			'datosString=datos.helmetID'convierto de INT a String
			If datos.helmetID=0 Then
				Log("Ningún HelmetID registrado con el usuario ingresado")
				flag=False
				Else
					flag=True
					Log("Ya hay un HelmetID registrado con este usuario")
					Log("El HelmetID es: "& datos.helmetID)
			End If
		End If
	Next
	
	Return flag
	
End Sub

'
'Public Sub chequearMotoID (DniIngresado As String) As Boolean 
'	Log("--------------------------------------------")
'	Log ("Chequeando si el DNI ingresado ya contiene un motoID")
'	Dim DniINT As Int
'	DniINT=Dni'PASO A INTEGER
'	Dim cursor As Cursor
'	Dim flag As Boolean
'	flag=False
'	Dim datosString As String
'
'	cursor=Sql.ExecQuery("SELECT * FROM usuarios")
'	For i=0 To cursor.RowCount-1
'		cursor.Position=i
'		
'		Dim datos As Usuario
'		datos.Initialize
'		
'		datos.dni=cursor.GetInt("dni")
'		If datos.dni=DniINT Then
'			Log("dni detectado")
'			datos.helmetID=cursor.GetInt("helmetid")
'			Log("El HelmetID de ese dni es: "&datos.clave)
'			datosString=datos.helmetID'convierto de INT a String
'			If datosString="" Then
'				Log("Ningún HelmetID registrado con el usuario")
'				flag=False
'				Else
'					flag=True
'					Log("Ya hay un HelmetID registrado con este usuario")
'					Log("El HelmetID es: "& datos.helmetID)
'			End If
'		End If
'	Next
'	
'	Return flag
'End Sub

Public Sub insertarHelmetID (HelmetIDIngresado As String, DniIngresado As String)
	Dim HelmetIDIngresadoLONG As Long
	Dim DniIngresadoINT As Int
	
	HelmetIDIngresadoLONG=HelmetIDIngresado'paso de string a long
	DniIngresadoINT=DniIngresado'paso de string a int
	
	Log("--------------------------------------------")
	Log("ingresando HelmetID en la base de datos, bajo el DNI: "& DniIngresado)
	Log ("el helmet ID es: "& HelmetIDIngresadoLONG)
	Sql.ExecNonQuery2("UPDATE usuarios SET helmetid=? WHERE dni=?" , Array As Object (HelmetIDIngresadoLONG,DniIngresado))
	Log ("helmet ID ingresado")
	
End Sub

'
'UPDATE table_name
'SET column1 = value1, column2 = value2, ...
'WHERE condition;


Public Sub leerHelmetID (dni As String) As String
	

	Log("--------------------------------------------")
	Log ("leyendo HelmetID")
	Dim cursor As Cursor

	cursor=Sql.ExecQuery("SELECT * FROM usuarios")
	For i=0 To cursor.RowCount-1
		cursor.Position=i
		Dim datos As Usuario
		datos.Initialize
		datos.dni=cursor.GetInt("dni")
		datos.clave=cursor.GetInt("clave")
		datos.helmetID=cursor.GetInt("helmetid")
		datos.motoID=cursor.GetInt("motoid")
		If datos.dni=dni Then
			Log("El HelmetID correspondiente al dni: " & datos.dni&" es: "& datos.helmetID)
			Return datos.helmetID
		End If
	Next
		
End Sub


