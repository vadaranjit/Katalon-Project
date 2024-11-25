import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject


import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import org.testng.asserts.SoftAssert;
SoftAssert softAssertion = new SoftAssert();
CustomKeywords.'demoPackage.MozartLogin.LoginWithChromeForEK'()

WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - Dashboard/a_Refunds'))

WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - Dashboard/a_Refund Capture'))

WebUI.selectOptionByValue(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/SelectRefundTypes'), 'RF_Both', false)

WebUI.setText(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/EnterDocumentNumber'), '6712345609')

WebUI.click(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/DocumentSearchButton'))

String Header_Country = WebUI.getText(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/Header Country'))

String Currency = WebUI.getText(findTestObject('Object Repository/EK_Objects/Page_Mozart - RefundsCapture/currency_DropDown'))

//checking header country is xx
//assert (Header_Country=='XX - PRUEBA')
softAssertion.assertTrue(Header_Country=='XX - PRUEBA');

//checking currency is UNK
//assert (Currency.contains('UNK'))
softAssertion.assertTrue(Currency.contains('UNK'))

// check agent details is grey out

// check the checkBox is checked or not

TestObject refunding_Agent_Name = ObjectRepository.findTestObject('Object Repository/EK_Objects/Page_Mozart - RefundsCapture/refunding_Agent_Name_TextBox')
// Check refunding_Agent_Name is disabled
if (!(WebUI.verifyElementAttributeValue(refunding_Agent_Name, 'disabled', 'true', 10)))
	{		
		softAssertion.assertTrue(false);
	}
	
	TestObject refunding_Agent_Country = ObjectRepository.findTestObject('Object Repository/EK_Objects/Page_Mozart - RefundsCapture/refunding_Agent_Country_DropDown')
	
	// Check refunding_Agent_Country is disabled
	if ((WebUI.verifyElementAttributeValue(refunding_Agent_Country, 'disabled', 'true', 10)))
		{
			assert true
		}
	 else
		{
			assert false
		}