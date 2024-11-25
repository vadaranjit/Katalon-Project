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

CustomKeywords.'demoPackage.MozartLogin.LoginWithChromeForEK'()

WebUI.click(findTestObject('EK_Objects/Page_Mozart - Dashboard/a_Refunds'))

WebUI.click(findTestObject('EK_Objects/Page_Mozart - Dashboard/Click_On_Local_Settlements'))

WebUI.click(findTestObject('EK_Objects/Page_Mozart - LocalSettlements/filter_button'))

WebUI.verifyOptionSelectedByValue(findTestObject('EK_Objects/Page_Mozart - LocalSettlements/select_filter_column_r1_c1'), 
    'date_processingdate', false, 5)

WebUI.verifyOptionSelectedByValue(findTestObject('EK_Objects/Page_Mozart - LocalSettlements/select_filter_column_r2_c1'), 
    'select_request_fop_settlem', false, 5)

WebUI.verifyOptionSelectedByValue(findTestObject('EK_Objects/Page_Mozart - LocalSettlements/select_filter_column_r3_c1'), 
    'select_ro_isocode_country', false, 5)

WebUI.closeBrowser()