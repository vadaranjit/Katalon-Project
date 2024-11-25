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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import org.openqa.selenium.By
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import org.openqa.selenium.By
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository

//Mozart WEB
CustomKeywords.'demoPackage.MozartLogin.LoginWithChromeForEK'()

WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - Dashboard/a_Refunds'))

WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - Dashboard/a_Refund Capture'))

WebUI.selectOptionByValue(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/SelectRefundTypes'), 'RF_Both', false)

WebUI.setText(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/EnterDocumentNumber'), '6747279570')

WebUI.click(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/DocumentSearchButton'))

WebUI.selectOptionByValue(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/requestedFOP_DropDown'), 'CA', false)

//generate  number
String Passenger_Remarks_text = CustomKeywords.'demoPackage.UtilityDemo.requestNumber'()
System.out.println(Passenger_Remarks_text)

WebUI.setText(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/passengerRemarks_TextBox'), Passenger_Remarks_text)

WebUI.selectOptionByValue(findTestObject('Object Repository/Demo/RecordingEK/Page_Mozart - RefundsCapture/select_MrMrsMissMstr'), 
    'Mr', true)

WebUI.setText(findTestObject('Object Repository/EK_Objects/Page_Mozart - RefundsCapture/passengerName_PassengerDetails_TextBox'), 
    'XYZ_Test')

WebUI.setText(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/emailAddress_PassengerDetails_TextBox'), 'RV@GMAIL.COM')

WebUI.click(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/Send Button'))

Thread.sleep(6000)

String requestID = CustomKeywords.'database.DBConnection.SQL'("select * from bdmozart.mi_refund_capture_main where agentremarks ="+Passenger_Remarks_text,'idrequest', 1)

for (int i = 0; i <= 2; i++) 
	{
    if (requestID != null) 
		{
        System.out.println('Request var is not null, breaking loop')
		System.out.println(requestID)
        break
		}   
    Thread.sleep(2000)
    System.out.println('Request var is null, continuing loop')
	System.out.println(requestID)
}

WebUI.click(findTestObject('EK_Objects/Page_Mozart - Dashboard/a_Refunds'))

WebUI.click(findTestObject('EK_Objects/Page_Mozart - Dashboard/click_on_refundSearch'))

WebUI.click(findTestObject('EK_Objects/Page_Mozart - RefundsSearch/button_Search by ticket number'))

WebUI.click(findTestObject('EK_Objects/Page_Mozart - RefundsSearch/a_Search by request Id'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('EK_Objects/Page_Mozart - RefundsSearch/input_Value_advancedFilter.idrequest'), requestID)

WebUI.click(findTestObject('EK_Objects/Page_Mozart - RefundsSearch/a_Apply'))

WebUI.scrollToElement(findTestObject('EK_Objects/Page_Mozart - RefundsSearch/TextArea Passenger Remarks'), 30)



// Get the Test Object representing the textarea element
TestObject textarea = ObjectRepository.findTestObject('Object Repository/EK_Objects/Page_Mozart - RefundsSearch/TextArea Passenger Remarks')

// Check if the textarea is disabled
if (!WebUI.verifyElementAttributeValue(textarea, "disabled", "true", 30)) 
	{
		println('Textarea is enabled. Can edit.')
		assert false
	} 
else 
	{
		println('Textarea is disabled. Cannot edit.')
		assert true
	}

