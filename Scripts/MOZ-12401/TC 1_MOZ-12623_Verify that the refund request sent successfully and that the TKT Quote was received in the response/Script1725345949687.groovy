import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil

//API Connection Auth Token
CustomKeywords.'apiRequests.apiConnection.runAuthToken'(findTestObject('API/Demo API/Auth Token'))

//Send FULL REFUND Request - json
def fullRefundResponse = WS.sendRequest(findTestObject('API/MOZ-12401_API/MOZ-12623_Full_Refund'))

WS.verifyResponseStatusCode(fullRefundResponse, 200)

// Read a requestId element value from the JSON response
def mozartRequestId = WS.getElementPropertyValue(fullRefundResponse, 'data[0].mozart_request_id')

println(mozartRequestId)

//Check mp_process table for QO = OK
String QO_Task

String mp_process

for (int i = 0; i <= 4; i++) {
    mp_process = (('select * from bdmozart.mp_process where idrequest = \'' + mozartRequestId) + '\' and idprocess = \'QO\'')

    QO_Task = CustomKeywords.'database.DatabaseUtils.executeQuery'(mp_process, 'idprocessstatus', 1)

    if (QO_Task.equals('OK')) {
        break
    } else if (QO_Task.equals('PS')) {
		KeywordUtil.markError("QO Process is Skip")
        WebUI.verifyMatch(QO_Task, 'OK', false, FailureHandling.STOP_ON_FAILURE)
    } else {
        Thread.sleep(3000)
    }
}

//If QO = OK than execute next line code if QO != Ok than Assert error and TC fail
if (!(QO_Task.equals('OK'))) {
	KeywordUtil.markError("Please check Services for Emirates in Running or not")
    WebUI.verifyMatch(QO_Task, 'OK', false, FailureHandling.STOP_ON_FAILURE)
}
KeywordUtil.logInfo("This is an informational log message.")
