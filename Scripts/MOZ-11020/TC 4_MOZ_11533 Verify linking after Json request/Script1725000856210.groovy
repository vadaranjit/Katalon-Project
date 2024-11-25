import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//Unique Number Generator
String uniqueNumber = CustomKeywords.'utilityClass.GenericMethods.UniqueNumberGenerator'()
CustomKeywords.'demoPackage.UtilityDemo.requestNumber'()

//API Connection Auth Token
CustomKeywords.'apiRequests.apiConnection.runAuthToken'(findTestObject('API/Demo API/Auth Token'))

//Send PNR Waiver Request
def pnrWaiverResponse = WS.sendRequest(findTestObject('API/MOZ_11020_API/moz_11533_pnr_waiver_request'))

WS.verifyResponseStatusCode(pnrWaiverResponse, 200)

//Send FULL REFUND Request - json
def fullRefundResponse = WS.sendRequest(findTestObject('API/MOZ_11020_API/moz_11533_full_refund-json'))

WS.verifyResponseStatusCode(fullRefundResponse, 200)

// Read a requestId element value from the JSON response
def mozartRequestId = WS.getElementPropertyValue(fullRefundResponse, 'data[0].mozart_request_id')

println('The mozart_request_id is: ' + mozartRequestId)

//Read Waiver id
String mi_pnr_waiver_remarks = "select * from bdmozart.mi_pnr_waiver_remarks where remarkstext = '" + uniqueNumber + "'"
String waiverId = CustomKeywords.'database.DatabaseUtils.executeQuery'(mi_pnr_waiver_remarks, 'waiver_id', 1)

println('The Waiver_id is: ' + waiverId)

//Check waiver id is linked to requestId
String md_rfnd_pnr_waivers = "select * from bdmozart.md_rfnd_pnr_waivers where idrequest = '"+mozartRequestId +"'"+" order by id desc"+" "
String waiverIdLinkedToRequestId = CustomKeywords.'database.DatabaseUtils.executeQuery'(md_rfnd_pnr_waivers, 'idmipnrwaiver',1)
WebUI.verifyMatch(waiverIdLinkedToRequestId, waiverId, false)

