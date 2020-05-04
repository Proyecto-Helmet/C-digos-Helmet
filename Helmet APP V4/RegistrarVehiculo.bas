B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=8.3
@EndOfDesignText@


#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Private rp As RuntimePermissions
	Dim IDmoto As String
End Sub

Sub Globals
	Dim usuarios As Usuarios
	
	Private lblStatus As Label
	Private btnConnect As Button
	Private lblMessage As Label
	Private ProgressBar1 As ProgressBar
	Private btnDisconnect As Button
	Private btnAgregarCascoPrincipal As Button
	Private btnAgregarCascoSecundario As Button
	Private pnlPrincipal As Panel
	Private lblFondo As Label
	
	Dim bluetoothOn As BitmapDrawable
	Dim bluetoothOff As BitmapDrawable

	
	Private lblTres As Label
	Private tglbtnConexion As ToggleButton
	Private btnLeer As Button
	
	Private btnLimpiar As Button
	
	Private lblAviso As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	usuarios.Initialize
	Activity.LoadLayout("RegistrarVehiculo")
	Activity.Title="Helmet APP - Registrar Vehículo"
	btnConnect.Visible=True
	btnDisconnect.Visible=False
	lblAviso.Visible=False
	
	
	bluetoothOff.Initialize(LoadBitmap(File.DirAssets,"bluetoothoff (1).png"))
	bluetoothOff.Gravity= Gravity.FILL
	btnConnect.Background= bluetoothOff
	
	bluetoothOn.Initialize(LoadBitmap(File.DirAssets,"bluetoothon (1).png"))
	bluetoothOn.Gravity=Gravity.FILL
	btnDisconnect.Background=bluetoothOn
	
	IngresarCascoID.IDcasco=usuarios.leerHelmetID(Main.dni)
	
	
	Log("El formato que se enviará al HelmetRX es: A"&Main.dni&"P"&IngresarCascoID.IDcasco&Chr(10))
	
	
	
End Sub

Sub Activity_Resume
	SetState
End Sub

Public Sub SetState
	
	btnConnect.Enabled = Not(Starter.connected)
	ProgressBar1.Visible = Starter.connecting
	Dim status As String
	If Starter.connected Then
		status = "Conectado"
		CallSub(Starter,"enviar")
	else if Starter.connecting Then
		status = "Procesando..."
	Else
		status = "Desconectado"
	End If
	lblStatus.Text = $"Status: ${status}"$
End Sub

Public Sub MessageFromDevice(msg As String)
	Dim flag As Boolean  'para saber si ya hay un motod registrado
	flag=False
	
	
	Log("El mensaje enviado por HelmetRX es: "& msg)   
	
	If msg="DNINACK" Then   'si ya hay un usuario registrado en la moto el msj será DNINACK
		lblAviso.Text="Ya existe un usuario registrado en este vehículo! "
	Else
		IDmoto=msg  'Si el mensaje no es "DNINACK" entonces necesariamente es el IDmoto en modo string (aunque se trata de un número)
		Log("El dato recibido es: " & IDmoto & " y representa el motoID")
	
		flag=usuarios.chequearMotoID(IDmoto)  'llama al metodo para chequear el motoid
	
		If flag=True Then  'el método devuelve TRUE si ya existe un moto id registrado y FALSE en caso contrario
			lblAviso.Text="Este vehículo ya esta registrado en el sistema y solo puede tener 1 casco principal!"
			lblAviso.Visible=True
			CallSub(Starter,"enviarNACK")
		Else
			Log("No existe ningun usuario registrado en este vehículo, se procederá a guardar")
			usuarios.insertarMotoID(IDmoto,Main.dni)
			CallSub(Starter,"enviarACK")
		End If
	End If
	
End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub Switch1_CheckedChange(Checked As Boolean)
	
	If Checked Then
		CallSub(Starter, "enviarDNIyCASCO")
	End If
End Sub
'
Sub btnConnect_Click
'	btnConnect.Visible=False
'	btnDisconnect.Visible=True
'	rp.CheckAndRequest(rp.PERMISSION_ACCESS_COARSE_LOCATION)
'	Wait For Activity_PermissionResult (Permission As String, Result As Boolean)
'	If Result Then
'		CallSub(Starter, "Connect")
'	Else
'		ToastMessageShow("No permission", True)
'	End If
End Sub

Sub lblStatus_Click
	
End Sub
'
Sub btnDisconnect_Click
btnDisconnect.Visible=False
	btnConnect.Visible=True
End Sub

Sub btnAgregarCascoPrincipal_Click
	'StartActivity(AgregarCascoPrincipal)
End Sub

Sub btnAgregarCascoSecundario_Click
	'StartActivity(AgregarCascoSecundario)
End Sub


Sub tglbtnConexion_CheckedChange(Checked As Boolean)
	If Checked Then
		btnConnect.Visible=False
		btnDisconnect.Visible=True
		rp.CheckAndRequest(rp.PERMISSION_ACCESS_COARSE_LOCATION)
		Wait For Activity_PermissionResult (Permission As String, Result As Boolean)
		If Result Then
			CallSub(Starter, "Connect")
		Else
			ToastMessageShow("No permission", True)
		End If
	End If

End Sub

Sub btnLeer_Click
	CallSub(Starter,"enviarLeer")
End Sub

Sub btnLimpiar_Click
	CallSub(Starter,"enviarLimpiar")
End Sub