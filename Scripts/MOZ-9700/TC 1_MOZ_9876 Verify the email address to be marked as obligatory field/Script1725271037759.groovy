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
CustomKeywords.'demoPackage.MozartLogin.LoginWithChromeForEK'()

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

WebUI.selectOptionByLabel(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/select_Currency'), 'INR', false)

//WebUI.selectOptionByValue(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/title_PassengerDetails_Select'), 'Mr', false)
//WebUI.sendKeys(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/passengerName_PassengerDetails_TextBox'), 'automationTest')
String emailAddressEmpty = WebUI.getText(findTestObject('Object Repository/EK_Objects/Page_Mozart - RefundsCapture/EmailFieldObligatory'))

WebUI.verifyMatch(emailAddressEmpty, 'Field required', false, FailureHandling.CONTINUE_ON_FAILURE)

String passangerName = WebUI.getText(findTestObject('Object Repository/EK_Objects/Page_Mozart - RefundsCapture/passengerName_FieldRequired'))

WebUI.verifyMatch(passangerName, 'Field required', false, FailureHandling.CONTINUE_ON_FAILURE)

String Title = WebUI.getText(findTestObject('Object Repository/EK_Objects/Page_Mozart - RefundsCapture/passengerTitle_FieldRequired'))

WebUI.verifyMatch(Title, 'Field required', false, FailureHandling.CONTINUE_ON_FAILURE)

