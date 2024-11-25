import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import utilityClass.JsonPaths as JsonPaths

//Quote file path
String filePath = 'Test Data/Embbeded TKT Quote - Error in Quote'

//Add the Quote values in Refund request
GlobalVariable.QuoteString = CustomKeywords.'utilityClass.JsonPaths.JsonStringFormatter'(filePath)

// Run authentication token request
CustomKeywords.'apiRequests.apiConnection.runAuthToken'(findTestObject('API/Demo API/Auth Token'))

// Send request for full refund response and verify status
def fullRefundResponse = WS.sendRequest(findTestObject('API/MOZ-12450_API/MOZ-12909_Full_Refund_Embedded TKT'))

WS.verifyResponseStatusCode(fullRefundResponse, 200)

// Get Mozart request ID from the response
def mozartRequestId = WS.getElementPropertyValue(fullRefundResponse, 'data[0].mozart_request_id')

// Prepare SQL queries using the retrieved request ID
String queryTemplate = 'select * from bdmozart.%s where %s = \'%s\''

String mozartRequestCondition = "idrequest = '$mozartRequestId'"

println mozartRequestCondition

String mi_refund_ek_quote = String.format(queryTemplate, 'mi_refund_ek_quote', 'idrequest', mozartRequestId)

String idQuote = CustomKeywords.'database.DatabaseUtils.executeQueryDemo'(mi_refund_ek_quote, 'id', 1)

println idQuote

//No Currect row == No data stored in Database tables
WebUI.verifyMatch(idQuote, "No current row", false)
