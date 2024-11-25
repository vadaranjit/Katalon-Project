import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import groovy.json.JsonOutput as JsonOutput

//API Connection Auth Token 
CustomKeywords.'apiRequests.apiConnection.runAuthToken'(findTestObject('API/Demo API/Auth Token'))

CustomKeywords.'demoPackage.UtilityDemo.requestNumber'()

//API Send Full Refund
def response = WS.sendRequest(findTestObject('API/MOZ-8872_API/Full Refund'))

def responseBody = response.getResponseText()

println(JsonOutput.prettyPrint(responseBody))

WS.verifyResponseStatusCode(response, 200)

// getting RequestID
String requestID1 = WS.getElementPropertyValue(response, 'data[0].mozart_request_id')

println(requestID1)

//Login Mozart
CustomKeywords.'demoPackage.MozartLogin.LoginWithChromeForEK'()

WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - Dashboard/a_Refunds'))

WebUI.click(findTestObject('EK_Objects/Page_Mozart - Dashboard/Click on PendingRequest'))

WebUI.setText(findTestObject('EK_Objects/Page_Mozart - PendingRequest/Input Search TextBox'), requestID1)

WebUI.click(findTestObject('EK_Objects/Page_Mozart - PendingRequest/Click On Search Icon'))

WebUI.click(findTestObject('EK_Objects/Page_Mozart - PendingRequest/Click On Request ID'))

TestObject textarea = ObjectRepository.findTestObject('Object Repository/EK_Objects/Page_Mozart - RefundAudit/Passenger Remarks TextArea')

// Check textarea is disabled
if (!(WebUI.verifyElementAttributeValue(textarea, 'disabled', 'true', 10))) 
	{
		println('Textarea is enabled. Can edit.')
		assert false
	}
 else 
	{
		println('Textarea is disabled. Cannot edit.')
		assert true
	}

