import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import utilityClass.JsonPaths as JsonPaths

// Authenticate and send request
CustomKeywords.'apiRequests.apiConnection.runAuthToken'(findTestObject('API/Demo API/Auth Token'))
def fullRefundResponse = WS.sendRequest(findTestObject('null'))
WS.verifyResponseStatusCode(fullRefundResponse, 200)

// Extract mozartRequestId
def mozartRequestId = WS.getElementPropertyValue(fullRefundResponse, 'data[0].mozart_request_id')
println(mozartRequestId)

// String arrays for SQL tables and corresponding IDs
String[] tableNames = ['mi_refund_ek_quote', 'mi_refund_ek_quote_passenger', 'mi_refund_ek_quote_tkt_details']
String[] idFields = ['id', 'id', 'id']
String[] dbMapKeys = [
    'mi_refund_ek_quote',
    'mi_refund_ek_quote_passenger',
    'mi_refund_ek_quote_tkt_details',
    'mi_refund_ek_quote_tkt_coupon_details',
    'mi_refund_ek_quote_tkt_original_fare',
    'mi_refund_ek_quote_tkt_penalty_charges',
    'mi_refund_ek_quote_tkt_refund_fare',
    'mi_refund_ek_quote_tkt_used_fare'
]

// Iterate over tables to execute queries
String lastId = mozartRequestId
for (int i = 0; i < tableNames.length; i++) {
    String query = "select * from bdmozart.${tableNames[i]} where idrequest = '${lastId}'"
    lastId = CustomKeywords.'database.DatabaseUtils.executeQuery'(query, idFields[i], 1)
}

// Add new logic
JsonPaths processJson = new JsonPaths()
String filePath = 'Test Data/Embedded TKT Quote.txt'

// Simplified HashMap population and validation
dbMapKeys.each { key ->
    HashMap<String, String> dbMap = processJson.getColumnsWithJsonPath(key)
    processJson.verifyJsonElementsValuesWithDatabaseValues(filePath, dbMap, key)
}
