////API Connection Auth Token
//CustomKeywords.'apiRequests.apiConnection.runAuthToken'(findTestObject('API/Demo API/Auth Token'))
//
////Send FULL REFUND Request - json
//def fullRefundResponse = WS.sendRequest(findTestObject('API/MOZ-12401_API/MOZ-12623_Full_Refund'))
//
//WS.verifyResponseStatusCode(fullRefundResponse, 200)
//
//// Read a requestId element value from the JSON response
//def mozartRequestId = WS.getElementPropertyValue(fullRefundResponse, 'data[0].mozart_request_id')
//
//println(mozartRequestId)
//
////Check mp_process table for QO = OK
//String QO_Task
//
//String mp_process
//
//for (int i = 0; i <= 20; i++) {
//    mp_process = (('select * from bdmozart.mp_process where idrequest = \'' + mozartRequestId) + '\' and idprocess = \'QO\'')
//
//    QO_Task = CustomKeywords.'database.DatabaseUtils.executeQuery'(mp_process, 'idprocessstatus', 1)
//
//    if (QO_Task.equals('OK')) {
//        break
//    } else if (QO_Task.equals('PS')) {
//        KeywordUtil.markError('QO Process is Skip')
//
//        WebUI.verifyMatch(QO_Task, 'OK', false, FailureHandling.STOP_ON_FAILURE)
//    } else {
//        Thread.sleep(3000)
//    }
//}
//
////If QO = OK than execute next line code if QO != Ok than Assert error and TC fail
//if (!(QO_Task.equals('OK'))) {
//    KeywordUtil.markError('Please check Services for Emirates in Running or not')
//
//    WebUI.verifyMatch(QO_Task, 'OK', false, FailureHandling.STOP_ON_FAILURE)
//}

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
mi_refund_ek_quote = "select * from bdmozart.mi_refund_ek_quote where idrequest = 'O090510005'"
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


HashMap<String, String> mi_refund_ek_quote_map = new HashMap<>()
mi_refund_ek_quote_map.put("iswaiverapplied","false")
mi_refund_ek_quote_map.put("isnoshowfeesapplied","false")
mi_refund_ek_quote_map.put("uniquereferencenumber","2001762368172376")
mi_refund_ek_quote_map.put("processingstatus","Y")
mi_refund_ek_quote_map.put("quote_type","null")
mi_refund_ek_quote_map.put("currencycode","AED")
mi_refund_ek_quote_map.put("isnoshowfeesapplicable","false")

mi_refund_ek_quote_table = CustomKeywords.'database.DatabaseUtils.getColumnNamesAndValues'(mi_refund_ek_quote)
CustomKeywords.'utilityClass.JsonPaths.verifyJsonElementsValuesWithDatabaseValues2'(mi_refund_ek_quote_map, mi_refund_ek_quote_table)

//----------

HashMap<String, String> mi_refund_ek_quote_passenger_map = new HashMap<>()
mi_refund_ek_quote_passenger_map.put("passengername","ADTNANCI/QUITZONMR")
mi_refund_ek_quote_passenger_map.put("passengerreference","1")

mi_refund_ek_quote_passenger_table = CustomKeywords.'database.DatabaseUtils.getColumnNamesAndValues'(mi_refund_ek_quote_passenger)
CustomKeywords.'utilityClass.JsonPaths.verifyJsonElementsValuesWithDatabaseValues2'(mi_refund_ek_quote_passenger_map, mi_refund_ek_quote_passenger_table)

//----------
HashMap<String, String> mi_refund_ek_quote_tkt_details_map = new HashMap<>()
mi_refund_ek_quote_tkt_details_map.put("eticketnumber","1762368172376")
mi_refund_ek_quote_tkt_details_map.put("conjunctiveticketrange","1762368172376")
mi_refund_ek_quote_tkt_details_map.put("passengertype","ADT")
mi_refund_ek_quote_tkt_details_map.put("ticketutilization","Unutilized")
mi_refund_ek_quote_tkt_details_map.put("issuingcountrycode","AE")
mi_refund_ek_quote_tkt_details_map.put("origincountrycode","AE")
mi_refund_ek_quote_tkt_details_map.put("issuanceoffice","EKDXBRV")
mi_refund_ek_quote_tkt_details_map.put("issuingdate","28FEB2024")
mi_refund_ek_quote_tkt_details_map.put("farecalculationindicator","R0")
mi_refund_ek_quote_tkt_details_map.put("pricetaginfo","R0")

mi_refund_ek_quote_tkt_details_table = CustomKeywords.'database.DatabaseUtils.getColumnNamesAndValues'(mi_refund_ek_quote_tkt_coupon_details)
CustomKeywords.'utilityClass.JsonPaths.verifyJsonElementsValuesWithDatabaseValues2'(mi_refund_ek_quote_tkt_details_map, mi_refund_ek_quote_tkt_details_table)


//----------

HashMap<String, String> mi_refund_ek_quote_tkt_coupon_details_map = new HashMap<>()
mi_refund_ek_quote_tkt_coupon_details_map.put("couponnumber","1")
mi_refund_ek_quote_tkt_coupon_details_map.put("associatedticketnumber","1762368172376")
mi_refund_ek_quote_tkt_coupon_details_map.put("couponrefundableindicator","true")
mi_refund_ek_quote_tkt_coupon_details_map.put("couponrefundedindicator","true")
mi_refund_ek_quote_tkt_coupon_details_map.put("farebasiscode","YLOWFAE1/EOL4")
mi_refund_ek_quote_tkt_coupon_details_map.put("classoftravel","Y")
mi_refund_ek_quote_tkt_coupon_details_map.put("cabinclass","Y")
mi_refund_ek_quote_tkt_coupon_details_map.put("farebrandcode","F")

mi_refund_ek_quote_tkt_coupon_details_table = CustomKeywords.'database.DatabaseUtils.getColumnNamesAndValues'(mi_refund_ek_quote_tkt_coupon_details)
CustomKeywords.'utilityClass.JsonPaths.verifyJsonElementsValuesWithDatabaseValues2'(mi_refund_ek_quote_tkt_coupon_details_map, mi_refund_ek_quote_tkt_coupon_details_table)

//----------

HashMap<String, String> mi_refund_ek_quote_tkt_original_fare_map = new HashMap<>()
mi_refund_ek_quote_tkt_original_fare_map.put("basefarecurrencycode","AED")
mi_refund_ek_quote_tkt_original_fare_map.put("basefarerefundamount","2660")
mi_refund_ek_quote_tkt_original_fare_map.put("refundtaxamount","310")
mi_refund_ek_quote_tkt_original_fare_map.put("refundtaxcurrencycode","AED")
mi_refund_ek_quote_tkt_original_fare_map.put("totalfarecurrencycode","AED")
mi_refund_ek_quote_tkt_original_fare_map.put("totalrefundfareamount","2970")

mi_refund_ek_quote_tkt_original_fare_table = CustomKeywords.'database.DatabaseUtils.getColumnNamesAndValues'(mi_refund_ek_quote_tkt_original_fare)
CustomKeywords.'utilityClass.JsonPaths.verifyJsonElementsValuesWithDatabaseValues2'(mi_refund_ek_quote_tkt_original_fare_map, mi_refund_ek_quote_tkt_original_fare_table)

//----------

HashMap<String, String> mi_refund_ek_quote_tkt_penalty_charges_map = new HashMap<>()
mi_refund_ek_quote_tkt_penalty_charges_map.put("currencycode","AED")
mi_refund_ek_quote_tkt_penalty_charges_map.put("penaltycharge","0")
mi_refund_ek_quote_tkt_penalty_charges_map.put("taxvalue","0")
mi_refund_ek_quote_tkt_penalty_charges_map.put("taxcurrencycode","null")

mi_refund_ek_quote_tkt_penalty_charges_table = CustomKeywords.'database.DatabaseUtils.getColumnNamesAndValues'(mi_refund_ek_quote_tkt_penalty_charges)
CustomKeywords.'utilityClass.JsonPaths.verifyJsonElementsValuesWithDatabaseValues2'(mi_refund_ek_quote_tkt_penalty_charges_map, mi_refund_ek_quote_tkt_penalty_charges_table)
