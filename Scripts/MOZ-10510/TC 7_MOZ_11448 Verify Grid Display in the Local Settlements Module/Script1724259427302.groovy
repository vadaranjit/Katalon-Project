import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//CustomKeywords.'demoPackage.MozartLogin.LoginWithChromeForEK'()
CustomKeywords.'mozartLogin.Login.launchBrowser'()

WebUI.click(findTestObject('EK_Objects/Page_Mozart - Dashboard/a_Refunds'))

WebUI.click(findTestObject('EK_Objects/Page_Mozart - Dashboard/Click_On_Local_Settlements'))

List<WebElement> listOfHeaderColumns = WebUI.findWebElements(findTestObject('EK_Objects/Page_Mozart - LocalSettlements/filterTable_headers'), 
    10)

println(listOfHeaderColumns.size())

String[] elements = ['Request Id', 'Processing Date (yyyy-mm-dd)', 'Ticket Number', 'Request Number', 'Passenger Name', 'Country'
    , 'Agent code', 'Refund Amount', 'Currency', 'Refund FOP Paid Locally', 'Reason']

for (int i = 1; i < listOfHeaderColumns.size(); i++) {
	
    if (i == (listOfHeaderColumns.size() / 2)) {
		WebUI.delay(3)
        CustomKeywords.'utilityClass.GenericMethods.scrollRight'() //scroll in view
    }
    
    println((listOfHeaderColumns.get(i).getText() + ' ') + i)

    WebUI.verifyMatch(listOfHeaderColumns.get(i).getText(), elements[(i - 1)], false, FailureHandling.CONTINUE_ON_FAILURE) //CustomKeywords.'utilityClass.CustomSoftAssert.assertEquals'(listOfHeaderColumns.get(i).getText(), elements[i-1], 'element is not equal')
}

//WebUI.closeBrowser()

