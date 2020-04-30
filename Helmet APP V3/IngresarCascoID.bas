B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=8.3
@EndOfDesignText@

'el helmet id son 17 números

#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
     Dim IDcasco As String
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private qrcrv As QRCodeReaderView
	
	Private b1 As Button
	Private b2 As Button
	'Private p1 As Panel
	'Private l1 As Label
	Private lblFondo As Label
	Private pnlContinuar As Panel
	Private lblEscaneoExitoso As Label
	Private Label2 As Label
	Private lblSeguro As Label
	Private btnReescanear As Button
	Private btnContinuar As Button
	Private pnlBorde As Panel
	Private pnlNegro As Panel
	
	Private lblDos As Label
	Dim flag As Boolean
	
	Dim usuarios As Usuarios
	
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("IngresarCascoID")
	Activity.Title="Helmet APP - Registrar Casco"
	qrcrv.Visible = False
	pnlContinuar.Visible=False
    pnlNegro.Visible=True
	flag=False
	usuarios.Initialize
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub b1_Click
	

	qrcrv.Visible = True
	pnlNegro.Visible=False
	DoEvents
	qrcrv.startScan
	
End Sub
Sub b2_Click
	
	qrcrv.stopScan
	DoEvents
	pnlNegro.Visible=True
	qrcrv.Visible = False

End Sub

Sub qrcrv_result_found(retval As String)
	If retval<>"" And flag=False Then 
		flag=True
		IDcasco=retval
		Log("Código escaneado: " & IDcasco)
		pnlContinuar.Visible=True
	End If
	
End Sub

Sub btnReescanear_Click
	flag=False
	pnlContinuar.Visible=False
End Sub

Sub btnContinuar_Click
	
	Log ("valor de dni: "&Main.dni)
	usuarios.insertarHelmetID(IDcasco,Main.dni)
	
	StartActivity("RegistrarVehiculo")
End Sub