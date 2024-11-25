import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.google.common.collect.FilteredEntryMultimap.Keys as Keys
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//Login
CustomKeywords.'mozartLogin.Login.launchBrowser'()

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

WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - RefundsCapture/send_Button'))

WebUI.verifyElementText(findTestObject('Object Repository/EK_Objects/Page_Mozart - RefundsCapture/refund_correctly_sent_popup'), 
    'Refund correctly sent.', FailureHandling.CONTINUE_ON_FAILURE)

Thread.sleep(6000)

String requestID = CustomKeywords.'database.DBConnection.SQL'('select * from bdmozart.mi_refund_capture_main where agentremarks =' + 
    uniqueNumber, 'idrequest', 1)

for (int i = 0; i <= 2; i++) {
    if (requestID != null) {
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

WebUI.selectOptionByLabel(findTestObject('EK_Objects/Page_Mozart - RefundsSearch/search_type_selectTag'), 'Search by request Id', 
    false)

WebUI.setText(findTestObject('EK_Objects/Page_Mozart - RefundsSearch/input_Value_advancedFilter.idrequest'), requestID)

WebUI.click(findTestObject('EK_Objects/Page_Mozart - RefundsSearch/a_Apply'))

WebUI.scrollToElement(findTestObject('EK_Objects/Page_Mozart - RefundsSearch/TextArea Passenger Remarks'), 30)

WebUI.verifyElementHasAttribute(findTestObject('EK_Objects/Page_Mozart - RefundsSearch/TextArea Passenger Remarks'), 'disabled', 
    10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()
//WebUI.verifyElementHasAttribute(findTestObject('Object Repository/EK_Objects/Page_Mozart - RefundsCapture/country_Button'), 'disabled', 10, FailureHandling.CONTINUE_ON_FAILURE)

