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

//Login
CustomKeywords.'demoPackage.MozartLogin.LoginWithChromeForEK'()
//CustomKeywords.'demoPackage.MozartLogin.mozartLoginWithUser'()

//Unique Number Generator
String uniqueNumber = CustomKeywords.'utilityClass.GenericMethods.UniqueNumberGenerator'()

//Capture Refund Request
WebUI.click(findTestObject('EK_Objects/Page_Mozart - Dashboard/a_Refunds'))

WebUI.click(findTestObject('EK_Objects/Page_Mozart - Dashboard/a_Refund Capture'))

WebUI.selectOptionByValue(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/SelectRefundTypes'), 'RF_Both', false)

WebUI.sendKeys(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/documentNumber_Textbox'), '6747279623')

WebUI.click(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/country_Button'))

WebUI.sendKeys(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/country_Button_Inside_TextBox'), 'IN - India')

WebUI.sendKeys(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/country_Button_Inside_TextBox'), Keys.chord(Keys.ENTER))

WebUI.selectOptionByValue(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/requestedFOP_DropDown'), 'CA', false)

WebUI.sendKeys(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/couponsRequested_TextBox'), '1')

WebUI.sendKeys(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/passengerRemarks_TextBox'), uniqueNumber)

WebUI.selectOptionByValue(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/title_PassengerDetails_Select'), 'Mr', 
    false)

WebUI.sendKeys(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/passengerName_PassengerDetails_TextBox'), 'automationTest')

WebUI.sendKeys(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/emailAddress_PassengerDetails_TextBox'), 'Katalon@studio.com')

WebUI.selectOptionByLabel(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/select_Currency'), 'INR', false)

WebUI.click(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/send_Button'))


//Get Request Id from DataBase
String requestId
for(int i = 0 ;i<=5;i++) {
	String mi_refund_capture_main = "select * from bdmozart.mi_refund_capture_main where agentremarks = '"+uniqueNumber+"'"
	requestId = CustomKeywords.'database.DatabaseUtils.executeQuery'(mi_refund_capture_main,'idrequest',1)
	if(requestId != null) 
		{
			break
		}
		WebUI.delay(2)
}

//API Connection Auth Token
CustomKeywords.'apiRequests.apiConnection.runAuthToken'(findTestObject('API/Demo API/Auth Token'))

//Send PNR Waiver Request
def pnrWaiverResponse = WS.sendRequest(findTestObject('API/MOZ_11020_API/moz_11533_pnr_waiver_request'))
WS.verifyResponseStatusCode(pnrWaiverResponse, 200)

//Read Waiver id
String mi_pnr_waiver_remarks = "select * from bdmozart.mi_pnr_waiver_remarks where remarkstext = '"+uniqueNumber+"'"
String waiverId = CustomKeywords.'database.DatabaseUtils.executeQuery'(mi_pnr_waiver_remarks, 'waiver_id', 1)

//Check waiver id is linked to requestId
String md_rfnd_pnr_waivers = "select * from bdmozart.md_rfnd_pnr_waivers where idrequest = '"+requestId +"'"+" order by id desc"+" "
String waiverIdLinkedToRequestId = CustomKeywords.'database.DatabaseUtils.executeQuery'(md_rfnd_pnr_waivers, 'idmipnrwaiver', 1)
WebUI.verifyMatch(waiverIdLinkedToRequestId, waiverId, false)
