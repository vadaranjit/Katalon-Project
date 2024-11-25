import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'demoPackage.MozartLogin.LoginWithChromeForEK'()

WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - Dashboard/a_Refunds'))

WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - Dashboard/a_Refund Capture'))

WebUI.selectOptionByValue(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/SelectRefundTypes'), 'RF_Both', false)

WebUI.setText(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/EnterDocumentNumber'), '6747279570')

WebUI.click(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/DocumentSearchButton'))
WebUI.delay(2)
String docNotFound = WebUI.getText(findTestObject('Object Repository/EK_Objects/Page_Mozart - RefundsCapture/document_not_found_popup'))

if (docNotFound.contains('not found.'))
{
	println ('Enter correct Document number')
	assert true
}
// check the checkBox is checked or not

TestObject checkBoxVal = ObjectRepository.findTestObject('Object Repository/EK_Objects/Page_Mozart - RefundsCapture/coupons_Check_Box')

// Check textarea is disabled
if ((WebUI.verifyElementAttributeValue(checkBoxVal, 'checked', 'true', 10))) 
	{
		
		println('checkBoxVal is checked')
		assert true
	}
 else 
	{
		println('checkBoxVal is not checked')
		assert false
	}