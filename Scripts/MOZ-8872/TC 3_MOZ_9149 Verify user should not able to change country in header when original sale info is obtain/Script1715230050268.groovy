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
import com.kms.katalon.core.testobject.ObjectRepository


CustomKeywords.'demoPackage.MozartLogin.LoginWithChromeForEK'()

WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - Dashboard/a_Refunds'))

WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - Dashboard/a_Refund Capture'))

WebUI.selectOptionByValue(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/SelectRefundTypes'), 'RF_Both', false)

WebUI.setText(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/EnterDocumentNumber'), '6747279570')

WebUI.click(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/DocumentSearchButton'))

String docNotFound = WebUI.getText(findTestObject('Object Repository/EK_Objects/Page_Mozart - RefundsCapture/document_not_found_popup'))

if (docNotFound.contains('not found.'))
{
	println ('Enter correct Document number')
	assert true
}

TestObject Country_button = ObjectRepository.findTestObject('Object Repository/EK_Objects/Page_Mozart - RefundsCapture/country_Button')

// Check if the country button is disabled

if (WebUI.verifyElementAttributeValue(Country_button, 'disabled', 'true', 30)) 
	{
		println('country button is disabled Cannot edit.')
		assert true
	} 
else 	
	{
		println('country button is enabled. Can edit.')
		assert false
	}
