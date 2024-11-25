import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import utilityClass.JsonPaths as JsonPaths

// Run authentication token request
CustomKeywords.'apiRequests.apiConnection.runAuthToken'(findTestObject('API/Demo API/Auth Token'))

// Send request for full refund response and verify status
def fullRefundResponse = WS.sendRequest(findTestObject('null'))
WS.verifyResponseStatusCode(fullRefundResponse, 200)

// Get Mozart request ID from the response
def mozartRequestId = WS.getElementPropertyValue(fullRefundResponse, 'data[0].mozart_request_id')
println(mozartRequestId)

// Prepare SQL queries using the retrieved request ID
String queryTemplate = "select * from bdmozart.%s where %s = '%s'"
String mozartRequestCondition = "idrequest = '${mozartRequestId}'"

String mi_refund_ek_quote = String.format(queryTemplate, "mi_refund_ek_quote", "idrequest", mozartRequestId)
String idQuote = CustomKeywords.'database.DatabaseUtils.executeQuery'(mi_refund_ek_quote, 'id', 1)

String mi_refund_ek_quote_passenger = String.format(queryTemplate, "mi_refund_ek_quote_passenger", "idquote", idQuote)
String idpassenger = CustomKeywords.'database.DatabaseUtils.executeQuery'(mi_refund_ek_quote_passenger, 'id', 1)

String mi_refund_ek_quote_tkt_details = String.format(queryTemplate, "mi_refund_ek_quote_tkt_details", "idpassenger", idpassenger)
String idtktdetails = CustomKeywords.'database.DatabaseUtils.executeQuery'(mi_refund_ek_quote_tkt_details, 'id', 1)

// Queries for other tables using idtktdetails
String mi_refund_ek_quote_tkt_coupon_details = String.format(queryTemplate, "mi_refund_ek_quote_tkt_coupon_details", "idtktdetails", idtktdetails)
String mi_refund_ek_quote_tkt_original_fare = String.format(queryTemplate, "mi_refund_ek_quote_tkt_original_fare", "idtktdetails", idtktdetails)
String mi_refund_ek_quote_tkt_penalty_charges = String.format(queryTemplate, "mi_refund_ek_quote_tkt_penalty_charges", "idtktdetails", idtktdetails)
String mi_refund_ek_quote_tkt_refund_fare = String.format(queryTemplate, "mi_refund_ek_quote_tkt_refund_fare", "idtktdetails", idtktdetails)
String mi_refund_ek_quote_tkt_used_fare = String.format(queryTemplate, "mi_refund_ek_quote_tkt_used_fare", "idtktdetails", idtktdetails)

// Initialize JsonPaths object and file path for JSON data comparison
JsonPaths processJson = new JsonPaths()
String filePath = 'Test Data/Embedded TKT Quote.txt'

// List of tables to verify against the database
Map<String, String> tables = new HashMap<>();
tables.put("mi_refund_ek_quote", mi_refund_ek_quote);
tables.put("mi_refund_ek_quote_passenger", mi_refund_ek_quote_passenger);
tables.put("mi_refund_ek_quote_tkt_details", mi_refund_ek_quote_tkt_details);
tables.put("mi_refund_ek_quote_tkt_coupon_details", mi_refund_ek_quote_tkt_coupon_details);
tables.put("mi_refund_ek_quote_tkt_original_fare", mi_refund_ek_quote_tkt_original_fare);
tables.put("mi_refund_ek_quote_tkt_penalty_charges", mi_refund_ek_quote_tkt_penalty_charges);
tables.put("mi_refund_ek_quote_tkt_refund_fare", mi_refund_ek_quote_tkt_refund_fare);
tables.put("mi_refund_ek_quote_tkt_used_fare", mi_refund_ek_quote_tkt_used_fare);

// Loop through each table, get JSON paths, and verify the JSON elements with DB values
for (Map.Entry<String, String> entry : tables.entrySet()) {
    String tableName = entry.getKey();
    String sqlQuery = entry.getValue();

    HashMap<String, String> dbMap = processJson.getColumnsWithJsonPath(tableName, "logRefundRequest");
    processJson.verifyJsonElementsValuesWithDatabaseValues(filePath, dbMap, sqlQuery);
}
