import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import utilityClass.JsonPaths as JsonPaths
import java.nio.file.Files as Files
import java.nio.file.Paths as Paths
import internal.GlobalVariable as GlobalVariable

JsonPaths processJson = new JsonPaths()

String filePath = 'Test Data/Embedded TKT Quote.txt'

GlobalVariable.QuoteString = processJson.JsonStringFormatter(filePath)

// Run authentication token request
CustomKeywords.'apiRequests.apiConnection.runAuthToken'(findTestObject('API/Demo API/Auth Token'))

// Send request for full refund response and verify status
def fullRefundResponse = WS.sendRequest(findTestObject('API/MOZ-12692_API/MOZ-12692_EK_QUOTE_TRIPS'))

WS.verifyResponseStatusCode(fullRefundResponse, 200)

// Get Mozart request ID from the response
def mozartRequestId = WS.getElementPropertyValue(fullRefundResponse, 'data[0].mozart_request_id')

// Prepare SQL queries using the retrieved request ID
String queryTemplate = 'select * from bdmozart.%s where %s = \'%s\''

String mozartRequestCondition = "idrequest = '$mozartRequestId'"

String mi_refund_ek_quote = String.format(queryTemplate, 'mi_refund_ek_quote', 'idrequest', mozartRequestId)

String idQuote = CustomKeywords.'database.DatabaseUtils.executeQuery'(mi_refund_ek_quote, 'id', 1)

String mi_refund_ek_quote_trips_detail = String.format(queryTemplate, 'mi_refund_ek_quote_trips_detail', 'idquote', idQuote)

String idtripsdetail = CustomKeywords.'database.DatabaseUtils.executeQuery'(mi_refund_ek_quote_trips_detail, 'id', 1)

String mi_refund_ek_quote_trips_ticket_range = String.format(queryTemplate, 'mi_refund_ek_quote_trips_ticket_range', 'idtripsdetail', idtripsdetail)
String mi_refund_ek_quote_trips_tax_refund = String.format(queryTemplate, 'mi_refund_ek_quote_trips_tax_refund', 'idtripsdetail', idtripsdetail)
String mi_refund_ek_quote_trips_form_refund_payment = String.format(queryTemplate, 'mi_refund_ek_quote_trips_form_refund_payment', 'idtripsdetail', idtripsdetail)
String mi_refund_ek_quote_trips_loyalty_fare = String.format(queryTemplate, 'mi_refund_ek_quote_trips_loyalty_fare', 'idtripsdetail', idtripsdetail)



