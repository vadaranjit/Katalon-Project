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

CustomKeywords.'demoPackage.MozartLogin.LoginWithChromeForEK'()

WebUI.click(findTestObject('EK_Objects/Page_Mozart - Dashboard/a_Refunds'))

WebUI.verifyElementPresent(findTestObject('EK_Objects/Page_Mozart - Dashboard/Click_On_Local_Settlements'),2)

WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - Dashboard/Click_On_Local_Settlements'))

WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - LocalSettlements/filter_button'))

WebUI.verifyElementNotPresent(findTestObject('Object Repository/EK_Objects/Page_Mozart - LocalSettlements/compact_mode'), 
    10)

WebUI.verifyElementNotPresent(findTestObject('Object Repository/EK_Objects/Page_Mozart - LocalSettlements/grouped'), 10)

WebUI.verifyElementNotPresent(findTestObject('Object Repository/EK_Objects/Page_Mozart - LocalSettlements/show_exceptions'), 
    10)

CustomKeywords.'utilityClass.CustomSoftAssert.assertAll'()

WebUI.closeBrowser()

