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
import org.openqa.selenium.support.ui.Select as Select

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

String Header_Country = WebUI.getText(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/Header Country'))

String Reunding_Agent_Country = WebUI.getText(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/Refunding Agent Country'))

WebUI.scrollToElement(findTestObject('Object Repository/EK_Objects/Page_Mozart - RefundsCapture/Bank details header'), 30)

WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - RefundsCapture/Expand Bank details'))

String Bank_Country = WebUI.getText(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/Bank Country'))

println(Header_Country)

println(Reunding_Agent_Country)

println(Bank_Country)

//Change the refunding agent country - 4021128 for JO-JORDEN

WebUI.setText(findTestObject('Object Repository/EK_Objects/Page_Mozart - RefundsCapture/Refund_Agent_Code_TextBox'), '4021128')
WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - RefundsCapture/refund_Agent_Code_Search_Button'))

// Now check for new header country and refunding agent country

String Header_Country1 = WebUI.getText(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/Header Country'))

String Reunding_Agent_Country1 = WebUI.getText(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/Refunding Agent Country'))

String Bank_Country1 = WebUI.getText(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/Bank Country'))

println(Header_Country1)
println(Reunding_Agent_Country1)
println(Bank_Country1)

WebUI.verifyMatch(Header_Country1, Reunding_Agent_Country1, false)
