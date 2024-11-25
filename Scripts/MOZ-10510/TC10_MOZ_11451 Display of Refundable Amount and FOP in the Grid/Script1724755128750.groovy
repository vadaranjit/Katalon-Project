import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable


//Send capture request

//Accept and processed this request by Running RPT
String requestIdValue = 'O062400001'

String sqlQuery = 'select * from bdmozart.md_rfnd_local_settlement where idrequest = \'O062400001\''

String fop_types_dbValue = CustomKeywords.'database.DatabaseUtils.executeQuery'(sqlQuery, 'fop_types', 1)

String paid_amount_dbValue = CustomKeywords.'database.DatabaseUtils.executeQuery'(sqlQuery, 'balanceamounttotal', 1)

String value = paid_amount_dbValue
double doubleValue = Double.parseDouble(value)
int paid_amount_dbValue_int = (int) doubleValue
paid_amount_dbValue = paid_amount_dbValue_int.toString()
System.out.println(paid_amount_dbValue); 


CustomKeywords.'demoPackage.MozartLogin.LoginWithChromeForEK'()
//Open Local settalment module and check DB and Web module
WebUI.click(findTestObject('EK_Objects/Page_Mozart - Dashboard/a_Refunds'))

WebUI.click(findTestObject('EK_Objects/Page_Mozart - Dashboard/Click_On_Local_Settlements'))

TestObject dynamicTestObject = new TestObject()

WebUI.refresh()

List<WebElement> listOfRequestIds = WebUI.findWebElements(findTestObject('Object Repository/EK_Objects/Page_Mozart - LocalSettlements/getListOfRequestIdFromGrid'), 
    10)
//to store web values
String refundAmount_web
String refundFopPaidLocally_web

for (int row = 1; row <= listOfRequestIds.size(); row++) {
    String dynamicXpath = ('//table[@class=\'table display compact nowrap cell-border hover dataTable no-footer\']/tbody/tr[' + 
    row) + ']/td[2]'

    dynamicTestObject.addProperty('xpath', ConditionType.EQUALS, dynamicXpath)

    WebElement requestIdWeb = WebUI.findWebElement(dynamicTestObject, 10)

    if (requestIdWeb.getText().equals(requestIdValue)) {
        String dynamicXpathRefundFop = ('//table[@class=\'table display compact nowrap cell-border hover dataTable no-footer\']/tbody/tr[' + 
        row) + ']/td[11]'

        String dynamicXpathRefundAmount = ('//table[@class=\'table display compact nowrap cell-border hover dataTable no-footer\']/tbody/tr[' + 
        row) + ']/td[9]'

        dynamicTestObject.addProperty('xpath', ConditionType.EQUALS, dynamicXpathRefundFop)

        WebElement fopWebElement = WebUI.findWebElement(dynamicTestObject, 10)

        refundFopPaidLocally_web = fopWebElement.getText()

        println(refundFopPaidLocally_web)

        dynamicTestObject.addProperty('xpath', ConditionType.EQUALS, dynamicXpathRefundAmount)

        WebElement refundAmountWebElement = WebUI.findWebElement(dynamicTestObject, 10)

        refundAmount_web = refundAmountWebElement.getText()

		double doubleValue1 = Double.parseDouble(refundAmount_web)
		int refundAmount_int = (int) doubleValue1
		refundAmount_web = refundAmount_int.toString()
		println(refundAmount_web)
				
        break
    }
	
}

WebUI.verifyMatch(refundFopPaidLocally_web, fop_types_dbValue, true, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyMatch(refundAmount_web, paid_amount_dbValue, true, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.closeBrowser()
