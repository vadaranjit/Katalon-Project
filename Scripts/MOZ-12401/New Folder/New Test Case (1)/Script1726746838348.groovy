//import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject;
//import com.kms.katalon.core.model.FailureHandling as FailureHandling;
//import com.kms.katalon.core.util.KeywordUtil as KeywordUtil;
//import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS;
//import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI;
//import utilityClass.JsonPaths as JsonPaths;
//
//// Step 1: Run API Auth Token
//CustomKeywords.'apiRequests.apiConnection.runAuthToken'(findTestObject('API/Demo API/Auth Token'));
//
//// Step 2: Send Full Refund Request and Verify Status Code
//def fullRefundResponse = WS.sendRequest(findTestObject('null'));
//WS.verifyResponseStatusCode(fullRefundResponse, 200);
//
//// Step 3: Extract mozartRequestId
//def mozartRequestId = WS.getElementPropertyValue(fullRefundResponse, 'data[0].mozart_request_id');
//println(mozartRequestId);
//
//// Step 4: Define Database Queries
//String mozartRequestId = mozartRequestId;  // Reusing mozartRequestId
//String queryTemplate = "select * from bdmozart.%s where %s = '%s'";
//
//String mi_refund_ek_quote = String.format(queryTemplate, "mi_refund_ek_quote", "idrequest", mozartRequestId);
//String idQuote = CustomKeywords.'database.DatabaseUtils.executeQuery'(mi_refund_ek_quote, 'id', 1);
//
//String mi_refund_ek_quote_passenger = String.format(queryTemplate, "mi_refund_ek_quote_passenger", "idquote", idQuote);
//String idPassenger = CustomKeywords.'database.DatabaseUtils.executeQuery'(mi_refund_ek_quote_passenger, 'id', 1);
//
//String mi_refund_ek_quote_tkt_details = String.format(queryTemplate, "mi_refund_ek_quote_tkt_details", "idpassenger", idPassenger);
//String idTktDetails = CustomKeywords.'database.DatabaseUtils.executeQuery'(mi_refund_ek_quote_tkt_details, 'id', 1);
//
//// Additional tables
//String mi_refund_ek_quote_tkt_coupon_details = String.format(queryTemplate, "mi_refund_ek_quote_tkt_coupon_details", "idtktdetails", idTktDetails);
//String mi_refund_ek_quote_tkt_original_fare = String.format(queryTemplate, "mi_refund_ek_quote_tkt_original_fare", "idtktdetails", idTktDetails);
//String mi_refund_ek_quote_tkt_penalty_charges = String.format(queryTemplate, "mi_refund_ek_quote_tkt_penalty_charges", "idtktdetails", idTktDetails);
//String mi_refund_ek_quote_tkt_refund_fare = String.format(queryTemplate, "mi_refund_ek_quote_tkt_refund_fare", "idtktdetails", idTktDetails);
//String mi_refund_ek_quote_tkt_used_fare = String.format(queryTemplate, "mi_refund_ek_quote_tkt_used_fare", "idtktdetails", idTktDetails);
//
//// Step 5: Perform JSON-Database Verification
//JsonPaths processJson = new JsonPaths();
//String filePath = 'Test Data/Embedded TKT Quote.txt';
//
//// Define the root JSON element
//String rootJsonElement = "logRefundRequest";
//
//// Define an array of table names for easy iteration
//String[] tableNames = {
//	"mi_refund_ek_quote",
//	"mi_refund_ek_quote_passenger",
//	"mi_refund_ek_quote_tkt_details",
//	"mi_refund_ek_quote_tkt_coupon_details",
//	"mi_refund_ek_quote_tkt_original_fare",
//	"mi_refund_ek_quote_tkt_penalty_charges",
//	"mi_refund_ek_quote_tkt_refund_fare",
//	"mi_refund_ek_quote_tkt_used_fare"
//};
//
//// Define the corresponding database query results
//String[] dbResults = {
//	mi_refund_ek_quote,
//	mi_refund_ek_quote_passenger,
//	mi_refund_ek_quote_tkt_details,
//	mi_refund_ek_quote_tkt_coupon_details,
//	mi_refund_ek_quote_tkt_original_fare,
//	mi_refund_ek_quote_tkt_penalty_charges,
//	mi_refund_ek_quote_tkt_refund_fare,
//	mi_refund_ek_quote_tkt_used_fare
//};
//
//// Iterate through each table and verify the values
//for (int i = 0; i < tableNames.length; i++) {
//	HashMap<String, String> dbMap = processJson.getColumnsWithJsonPath(tableNames[i], rootJsonElement);
//	processJson.verifyJsonElementsValuesWithDatabaseValues(filePath, dbMap, dbResults[i]);
//}
