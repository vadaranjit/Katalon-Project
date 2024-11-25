import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//Login With Ek
CustomKeywords.'demoPackage.MozartLogin.LoginWithChromeForEK'()

// Select refund capture
WebUI.click(findTestObject('EK_Objects/Page_Mozart - Dashboard/a_Refunds'))

WebUI.click(findTestObject('EK_Objects/Page_Mozart - Dashboard/a_Refund Capture'))

WebUI.click(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/SelectRefundTypes'))

Thread.sleep(2000)

//Select refund Type
WebUI.selectOptionByValue(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/SelectRefundTypes'), 
    'RF_Both', false)

//fill ticket number
WebUI.setText(findTestObject('Object Repository/EK_Objects/Page_Mozart - RefundsCapture/EnterDocumentNumber'), 
    '6747311818')

WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - RefundsCapture/div_Country'))

Thread.sleep(2000)

WebUI.click(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/EnterCountryName'), FailureHandling.CONTINUE_ON_FAILURE)

Thread.sleep(1000)

WebUI.selectOptionByValue(findTestObject('Object Repository/Demo/RecordingEK/Page_Mozart - RefundsCapture/select_CACCFT'), 'CC', 
    true)

WebUI.setText(findTestObject('Object Repository/Demo/RecordingEK/Page_Mozart - RefundsCapture/input_Coupons Requested_couponsToRefund'), 
    '1')

WebUI.setText(findTestObject('Object Repository/Demo/RecordingEK/Page_Mozart - RefundsCapture/textarea_Passenger Remarks_agentComment'), 
    'TestDemoKT')

WebUI.selectOptionByValue(findTestObject('Object Repository/Demo/RecordingEK/Page_Mozart - RefundsCapture/select_MrMrsMissMstr'), 
    'Mr', true)

WebUI.setText(findTestObject('Object Repository/EK_Objects/Page_Mozart - RefundsCapture/passengerName_PassengerDetails_TextBox'), 
    'ranjit')

WebUI.setText(findTestObject('Object Repository/Demo/RecordingEK/Page_Mozart - RefundsCapture/input_E-mail Address_passengerEmail'), 
    'TEST@GMAIL.COM')

WebUI.selectOptionByValue(findTestObject('Object Repository/Demo/RecordingEK/Page_Mozart - RefundsCapture/select_USDCADMXNESPARSAUDBAMBDTBEFXOFBGNBHD_2314cd'), 
    '1_2', true)

WebUI.click(findTestObject('Object Repository/Demo/RecordingEK/Page_Mozart - RefundsCapture/a_Send'))

Thread.sleep(1000)

String success_msg = WebUI.getText(findTestObject('Object Repository/Demo/RecordingEK/Page_Mozart - RefundsCapture/strong_Success'))

Thread.sleep(500)

String success_msg1 = WebUI.getText(findTestObject('Object Repository/Demo/RecordingEK/Page_Mozart - RefundsCapture/span_Refund correctly sent'))

println((success_msg + '  ') + success_msg1)

WebUI.verifyElementText(findTestObject('Object Repository/Demo/RecordingEK/Page_Mozart - RefundsCapture/strong_Success'), success_msg, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/Demo/RecordingEK/Page_Mozart - RefundsCapture/span_Refund correctly sent'), 
    success_msg1, FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

