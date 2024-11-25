import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import utilityClass.demo as demo

//CustomKeywords.'apiRequests.apiConnection.runAuthToken'(findTestObject('API/Demo API/Auth Token'))
//
//def fullRefundResponse = WS.sendRequest(findTestObject('API/MOZ-12401_API/MOZ-12623_Full_Refund'))
//
//WS.verifyResponseStatusCode(fullRefundResponse, 200)
//
//def mozartRequestId = WS.getElementPropertyValue(fullRefundResponse, 'data[0].mozart_request_id')
//
//println(mozartRequestId)
//
////Check mp_process table for QO = OK
//String QO_Task
//String mp_process
//
//for (int i = 0; i <= 20; i++) {
//    mp_process = (('select * from bdmozart.mp_process where idrequest = \'' + mozartRequestId) + '\' and idprocess = \'QO\'')
//    QO_Task = CustomKeywords.'database.DatabaseUtils.executeQuery'(mp_process, 'idprocessstatus', 1)
//
//    if (QO_Task.equals('OK')) {
//        break
//    } else if (QO_Task.equals('PS')) {
//        KeywordUtil.markError('QO Process is Skip')
//        WebUI.verifyMatch(QO_Task, 'OK', false, FailureHandling.STOP_ON_FAILURE)
//    } else {
//        Thread.sleep(3000)
//    }
//}
//
////If QO = OK than execute next line code if QO != Ok than Assert error and TC fail
//if (!(QO_Task.equals('OK'))) {
//    KeywordUtil.markError('Please check Services for Emirates in Running or not')
//    WebUI.verifyMatch(QO_Task, 'OK', false, FailureHandling.STOP_ON_FAILURE)
//}


// Now Run DB Query and get QuoteID with All table Data
//List<String> columnName = CustomKeywords.'database.DatabaseUtils.getAllColumnNamesFromTable'("mi_refund_ek_quote")
//================+= Main Logic ======================

// String tables
String mi_refund_ek_quote
String mi_refund_ek_quote_passenger
String mi_refund_ek_quote_tkt_details
String mi_refund_ek_quote_tkt_coupon_details
String mi_refund_ek_quote_tkt_original_fare
String mi_refund_ek_quote_tkt_penalty_charges
String mi_refund_ek_quote_tkt_refund_fare
String mi_refund_ek_quote_tkt_used_fare
String idQuote
String idpassenger
String idtktdetails

//Tables
mozartRequestId = "O090510005"
mi_refund_ek_quote = ('select * from bdmozart.mi_refund_ek_quote where idrequest = \'' + mozartRequestId) + '\''
idQuote = CustomKeywords.'database.DatabaseUtils.executeQuery'(mi_refund_ek_quote, 'id', 1)

mi_refund_ek_quote_passenger = "select * from bdmozart.mi_refund_ek_quote_passenger where idquote = '"+idQuote+"'"
idpassenger = CustomKeywords.'database.DatabaseUtils.executeQuery'(mi_refund_ek_quote_passenger, 'id', 1)

mi_refund_ek_quote_tkt_details = "select * from bdmozart.mi_refund_ek_quote_tkt_details where idpassenger = '"+idpassenger+"'"
idtktdetails = CustomKeywords.'database.DatabaseUtils.executeQuery'(mi_refund_ek_quote_tkt_details, 'id', 1)

mi_refund_ek_quote_tkt_coupon_details ="select * from bdmozart.mi_refund_ek_quote_tkt_coupon_details where idtktdetails = '"+idtktdetails+"'"
mi_refund_ek_quote_tkt_original_fare = "select * from bdmozart.mi_refund_ek_quote_tkt_original_fare where idtktdetails = '"+idtktdetails+"'"
mi_refund_ek_quote_tkt_penalty_charges = "select * from bdmozart.mi_refund_ek_quote_tkt_penalty_charges where idtktdetails = '"+idtktdetails+"'"
mi_refund_ek_quote_tkt_refund_fare = "select * from bdmozart.mi_refund_ek_quote_tkt_refund_fare  where idtktdetails = '"+idtktdetails+"'"
mi_refund_ek_quote_tkt_used_fare = "select * from bdmozart.mi_refund_ek_quote_tkt_used_fare where idtktdetails = '"+idtktdetails+"'"

//add new logic
demo processJson = new demo()

String filePath = 'Test Data/TKT Quote Json.txt'

HashMap<String, String> dbMap = processJson.getColumnsWithJsonPath("mi_refund_ek_quote")
processJson.verifyJsonElementsValuesWithDatabaseValues(filePath,dbMap,mi_refund_ek_quote)
