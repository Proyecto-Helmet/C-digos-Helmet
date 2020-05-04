B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Service
Version=5.2
@EndOfDesignText@

#Region  Service Attributes 
	#StartAtBoot: False
	#ExcludeFromLibrary: True
#End Region

Sub Process_Globals
	Private serial As Serial
	Private admin As BluetoothAdmin
	Private ast As AsyncStreamsText
	Public connected As Boolean
	Public connecting As Boolean
	
'	'codigo prueba INICIO	
'	Private foundDevices As List
'	Type NameAndMac (Name As String, Mac As String) 'Es una variable que definimos del tipo que nosotros queremos
'	Private connectedDevice As NameAndMac
'	'codigo prueba FIN
	
End Sub

Sub Service_Create
	serial.Initialize("serial")
	admin.Initialize("admin")
End Sub

Public Sub Connect
	admin.StartDiscovery
	connecting = True
	CallSub(RegistrarVehiculo, "SetState")
End Sub

Private Sub admin_DeviceFound (Name As String, MacAddress As String)
	'codigo nuevo INICIO
'	Private nm As NameAndMac
'	nm.Name = Name
'	nm.Mac = MacAddress
'	foundDevices.Add(nm)
'	ProgressDialogShow("Buscando dispositivos (% encontrados)".Replace("%",foundDevices.Size))
	'codigo nuevo FIN
	
'codigo anterior
	Log($"Device found: ${Name}"$)
	If Name = "SLAVE" Then
		Log("Trying to connect...")
		admin.CancelDiscovery
		serial.Connect(MacAddress)
End If
End Sub

Private Sub admin_DiscoveryFinished
	'codigo de prueba INICIO
'	ProgressDialogHide
'	Private l As List
'	Private nm As NameAndMac
'	Private res As Int
'	l.Initialize
'	For i=0 To foundDevices.Size - 1
'		nm = foundDevices.Get(i)
'		l.Add(nm.Name)
'	Next
'	res = InputList(l,"Elegir BLU",-1)
'	If res <> DialogResponse.CANCEL Then
'		connectedDevice = foundDevices.Get(res)
'		ProgressDialogShow("Intentando conectar con %".Replace("%",connectedDevice.Name))
'		serial.Connect(connectedDevice.Mac)
'	End If
	'codigo de prueba FIN
	
	'codigo anterior INICIO
	connecting = False
'codigo anterior FIN
End Sub

Private Sub Serial_Connected (Success As Boolean)
	If Success Then
		If ast.IsInitialized Then ast.Close
		ast.Initialize(Me, "Ast", serial.InputStream, serial.OutputStream)
		Log("Connected")
		connected = True
		
	Else
		Log(LastException)
	End If
	connecting = False
	CallSub(RegistrarVehiculo, "SetState")
End Sub

Public Sub enviarDNIyCASCO()
	ast.Write("A" & Main.dni & "P" &  IngresarCascoID.IDcasco & Chr(10)) 'EL FORMATO ENVIADO A HelmetRX es: A(dni)P(helmdetid)
	Log("enviar DNI: " & Main.dni )
	Log("enviar ID casco: " & IngresarCascoID.IDcasco )
	Log("A"&Main.dni&"P"&IngresarCascoID.IDcasco&Chr(10))
	
End Sub


Private Sub ast_NewText (Text As String)
	CallSub2(RegistrarVehiculo, "MessageFromDevice", Text)
End Sub

Private Sub ast_Terminated
	connected = False
	CallSub(RegistrarVehiculo, "SetState")
End Sub



Sub Service_Start (StartingIntent As Intent)

End Sub

'Return true to allow the OS default exceptions handler to handle the uncaught exception.
Sub Application_Error (Error As Exception, StackTrace As String) As Boolean
	Return True
End Sub

Sub Service_Destroy

End Sub

Public Sub enviarLeer() 
	Log("Leer datos en la EEPROM de HelmetRX")
	ast.Write("L"&Chr(10))
	Log("Enviando L")
End Sub

Public Sub enviarLimpiar()
	Log("Limpiar datos en la EEPROM de HelmetRX")
	ast.Write("C"&Chr(10))
	Log("Enviando C")
	
End Sub

Public Sub enviarACK()
	Log("Enviando ACK")
	ast.Write("ACK"&Chr(10))
End Sub

Public Sub enviarNACK()
	Log("Enviando NACK")
	ast.Write("NACK"&Chr(10))
End Sub

