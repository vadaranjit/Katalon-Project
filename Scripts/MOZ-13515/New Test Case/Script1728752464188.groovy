import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.google.common.collect.FilteredEntryMultimap.Keys as Keys
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys




//DATABASE TEST
//select * from bdmozart.md_ticket_coupons where document = '6720801174'  --- get id and data for tooltip
//select * from bdmozart.md_ticket_coupon_nsf where id_tick_coupon = '12' -- get data for tooltip
//select * from bdmozart.mi_nsf where document_number = '6720801174' --- get coupon number which is reported in NSF File

String mi_nsf = "select * from bdmozart.mi_nsf where document_number = '6720801174'"
int rowCount = CustomKeywords.'database.DatabaseUtils.getRowCount'(mi_nsf)
List<String> listOfNsfCoupons = new ArrayList<>()

for(int i = 1; i <= rowCount; i++) {
    // Read coupons reported in file
    String couponNumber = CustomKeywords.'database.DatabaseUtils.executeQuery'(mi_nsf, 'coupon_number', i)
    listOfNsfCoupons.add(couponNumber)
}

println listOfNsfCoupons

List<String> id_tick_coupons = new ArrayList<>()

for(String coupon : listOfNsfCoupons) {
    String md_ticket_coupons = "select * from bdmozart.md_ticket_coupons where document = '6720801174' and coupon = '${coupon}'"
    String ticketCouponId = CustomKeywords.'database.DatabaseUtils.executeQuery'(md_ticket_coupons, 'id', 1)
    id_tick_coupons.add(ticketCouponId)
}

println id_tick_coupons
//-----------
List<String> id_tick_coupons = new ArrayList<>()

for(String id : id_tick_coupons) {
	String md_ticket_coupons = "select * from bdmozart.md_ticket_coupon_nsf where id_tick_coupon = '${id}'"
	String ticketCouponId = CustomKeywords.'database.DatabaseUtils.executeQuery'(md_ticket_coupons, 'id', 1)
	id_tick_coupons.add(ticketCouponId)
}

println id_tick_coupons

Map<String, String> columnValueMap = new HashMap<>();

for(String id_tick : id_tick_coupons) {
	
	String md_ticket_coupon_nsf = "select * from bdmozart.md_ticket_coupon_nsf where id_tick_coupon = '${id_tick}'"
	columnValueMap = CustomKeywords.'database.DatabaseUtils.getColumnNamesAndValues'(md_ticket_coupon_nsf)
	
	

}


	

// WEB TEST
String documentNumber = '6720801174'
//Unique Number Generator
String uniqueNumber = CustomKeywords.'utilityClass.GenericMethods.UniqueNumberGenerator'()

//Login
CustomKeywords.'mozartLogin.Login.launchBrowser'()

//Capture Refund Request
WebUI.click(findTestObject('EK_Objects/Page_Mozart - Dashboard/a_Refunds'))

WebUI.click(findTestObject('EK_Objects/Page_Mozart - Dashboard/a_Refund Capture'))

WebUI.selectOptionByValue(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/SelectRefundTypes'), 'RF_Both', false)

WebUI.sendKeys(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/documentNumber_Textbox'), documentNumber)

WebUI.click(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/country_Button'))

WebUI.sendKeys(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/country_Button_Inside_TextBox'), 'IN - India')

WebUI.sendKeys(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/country_Button_Inside_TextBox'), Keys.chord(Keys.ENTER))

WebUI.selectOptionByValue(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/requestedFOP_DropDown'), 'CA', false)

WebUI.sendKeys(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/couponsRequested_TextBox'), '1')

WebUI.sendKeys(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/passengerRemarks_TextBox'), uniqueNumber)

WebUI.selectOptionByValue(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/title_PassengerDetails_Select'), 'Mr', 
    false)

WebUI.sendKeys(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/passengerName_PassengerDetails_TextBox'), 'automationTest')

WebUI.sendKeys(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/emailAddress_PassengerDetails_TextBox'), 'Katalon@studio.com')

WebUI.selectOptionByLabel(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/select_Currency'), 'INR', false)

WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - RefundsCapture/send_Button'))

WebUI.verifyElementText(findTestObject('Object Repository/EK_Objects/Page_Mozart - RefundsCapture/refund_correctly_sent_popup'), 
    'Refund correctly sent.', FailureHandling.CONTINUE_ON_FAILURE)

Thread.sleep(6000)

String requestID 

for (int i = 0; i <= 15; i++) {
	
	requestID = CustomKeywords.'database.DBConnection.SQL'('select * from bdmozart.mi_refund_capture_main where agentremarks =' +uniqueNumber, 'idrequest', 1)
	
	
    if (requestID != null) {
        System.out.println('Request var is not null, breaking loop')
        System.out.println(requestID)
        break
    }
    
    Thread.sleep(3000)

    System.out.println('Request var is null, continuing loop')

    System.out.println(requestID)
}

requestID = 'O101000003'

WebUI.click(findTestObject('EK_Objects/Page_Mozart - Dashboard/a_Refunds'))

WebUI.click(findTestObject('EK_Objects/Page_Mozart - Dashboard/click_on_refundSearch'))

WebUI.click(findTestObject('EK_Objects/Page_Mozart - RefundsSearch/button_Search by ticket number'))

WebUI.selectOptionByLabel(findTestObject('EK_Objects/Page_Mozart - RefundsSearch/search_type_selectTag'), 'Search by request Id', 
    false)

WebUI.setText(findTestObject('EK_Objects/Page_Mozart - RefundsSearch/input_Value_advancedFilter.idrequest'), requestID)

WebUI.click(findTestObject('EK_Objects/Page_Mozart - RefundsSearch/a_Apply'))

String tooltipData = WebUI.getAttribute(findTestObject('EK_Objects/Page_Mozart - RefundAudit/noShow_tooltip_coupon1_data'), 'data-content')

// Extract the Status, Flight, and Flight Date from the content
String status = tooltipData.split("Status:")[1].split("<br>")[0].trim()
String flight = tooltipData.split("Flight:")[1].split("<br>")[0].trim()
String flightDate = tooltipData.split("Flight date:")[1].split("<br>")[0].trim()

// Print the extracted values to the console
println "Status: " + status
println "Flight: " + flight.replace("<span class = >", "").replace("</span>", "")
println "Flight Date: " + flightDate.replace("<span class = >", "").replace("</span>", "")

//------------
String tooltipData1 = WebUI.getAttribute(findTestObject('EK_Objects/Page_Mozart - RefundAudit/noShow_tooltip_coupon2_data'), 'data-content')

// Extract the Status, Flight, and Flight Date from the content
String status1 = tooltipData1.split("Status:")[1].split("<br>")[0].trim()
String flight1 = tooltipData1.split("Flight:")[1].split("<br>")[0].trim()
String flightDate1 = tooltipData1.split("Flight date:")[1].split("<br>")[0].trim()

// Print the extracted values to the console
println "Status: " + status1
println "Flight: " + flight1.replace("<span class = >", "").replace("</span>", "")
println "Flight Date: " + flightDate1.replace("<span class = >", "").replace("</span>", "")

//------------
String tooltipData2 = WebUI.getAttribute(findTestObject('EK_Objects/Page_Mozart - RefundAudit/noShow_tooltip_coupon3_data'), 'data-content')

// Extract the Status, Flight, and Flight Date from the content
String status2 = tooltipData2.split("Status:")[1].split("<br>")[0].trim()
String flight2 = tooltipData2.split("Flight:")[1].split("<br>")[0].trim()
String flightDate2 = tooltipData2.split("Flight date:")[1].split("<br>")[0].trim()

// Print the extracted values to the console
println "Status: " + status2
println "Flight: " + flight2.replace("<span class = >", "").replace("</span>", "").replace("<span class = text-danger>", "")
println "Flight Date: " + flightDate2.replace("<span class = >", "").replace("</span>", "").replace("<span class = text-danger>", "")


