import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.support.Color as Color
import com.kms.katalon.core.testobject.ConditionType as ConditionType

//
// WEB TEST - use NSF doc number
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

Thread.sleep(3000)

String requestID

for (int i = 0; i <= 2; i++)
	{
    requestID = CustomKeywords.'database.DBConnection.SQL'('select * from bdmozart.mi_refund_capture_main where agentremarks =' + uniqueNumber, 'idrequest', 1)
    if (requestID != null) 
	{
        System.out.println('Request var is not null, breaking loop')
        System.out.println(requestID)
        break
    }
    
    Thread.sleep(3000)
    System.out.println('Request var is null, continuing loop')
    System.out.println(requestID)
}

requestID = 'O101000003'
//Open request id on web
WebUI.click(findTestObject('EK_Objects/Page_Mozart - Dashboard/a_Refunds'))
WebUI.click(findTestObject('EK_Objects/Page_Mozart - Dashboard/click_on_refundSearch'))
WebUI.click(findTestObject('EK_Objects/Page_Mozart - RefundsSearch/button_Search by ticket number'))
WebUI.selectOptionByLabel(findTestObject('EK_Objects/Page_Mozart - RefundsSearch/search_type_selectTag'), 'Search by request Id', false)
WebUI.setText(findTestObject('EK_Objects/Page_Mozart - RefundsSearch/input_Value_advancedFilter.idrequest'), requestID)
WebUI.click(findTestObject('EK_Objects/Page_Mozart - RefundsSearch/a_Apply'))

//DATABASE TEST
//select * from bdmozart.md_ticket_coupons where document = '6720801174'  --- get id and data for tooltip
//select * from bdmozart.md_ticket_coupon_nsf where id_tick_coupon = '12' -- get data for tooltip
//select * from bdmozart.mi_nsf where document_number = '6720801174' --- get coupon number which is reported in NSF File
String mi_nsf = "select * from bdmozart.mi_nsf where document_number = '$documentNumber'"
int rowCount = CustomKeywords.'database.DatabaseUtils.getRowCount'(mi_nsf)
Map<String, String> originalCouponData = new HashMap()
Map<String, String> NsfFileCouponData = new HashMap()
boolean NoShowDataMismatch = false

for (int i = 1; i <= rowCount; i++) {
    // Read coupons reported in file
    String couponNumber = CustomKeywords.'database.DatabaseUtils.executeQuery'(mi_nsf, 'coupon_number', i)

    //read original coupon data
    String md_ticket_coupons = "select * from bdmozart.md_ticket_coupons where document = '$documentNumber' and coupon = '$couponNumber'"
    originalCouponData = CustomKeywords.'database.DatabaseUtils.getColumnNamesAndValues'(md_ticket_coupons)

    //read NSF File coupon Data
	String md_ticket_coupon_nsf = "select * from bdmozart.md_ticket_coupon_nsf where id_tick_coupon = '"+originalCouponData.get('id')+"'"
	println md_ticket_coupon_nsf
    NsfFileCouponData = CustomKeywords.'database.DatabaseUtils.getColumnNamesAndValues'(md_ticket_coupon_nsf)

    //read airport data
	String mc_airports_origin = "SELECT * FROM bdmozart.mc_airports WHERE id = '"+originalCouponData.get('origin')+"'"
	String mc_airports_dest = "SELECT * FROM bdmozart.mc_airports WHERE id = '"+originalCouponData.get('dest')+"'"
    String origin = CustomKeywords.'database.DatabaseUtils.executeQuery'(mc_airports_origin, 'airportcode', 1)
    String dest = CustomKeywords.'database.DatabaseUtils.executeQuery'(mc_airports_dest, 'airportcode', 1)

    // Compare Orignal data with NSF file data
    if (!(((Integer.parseInt(originalCouponData.get('flight_number').trim()).toString().equals(Integer.parseInt(NsfFileCouponData.get(
                'flight_number').trim()).toString()) && originalCouponData.get('flight_date').equals(NsfFileCouponData.get(
            'flight_date'))) && origin.equals(NsfFileCouponData.get('from_sector'))) && dest.equals(NsfFileCouponData.get(
            'to_sector')))) 
	{
        NoShowDataMismatch = true
    }
    
    String baseXPath = ('(//div[@class=\'col col-3 pl-0 ml-1\']//span[@class=\'red-circle  no-seleccionable no-collapsable\' and @data-toggle=\'popover\'])[' +i) + ']'
    TestObject dynamicTestObject = new TestObject()
    dynamicTestObject.addProperty('xpath', ConditionType.EQUALS, baseXPath)
    String tooltipData = WebUI.getAttribute(dynamicTestObject, 'data-content')
	String NoShowCircleTextN = WebUI.getText(dynamicTestObject)
	println "====================================================================="+NoShowCircleTextN

    //red color of red circle
    String baseXPath2 = ('(//span[@class=\'red-circle  no-seleccionable no-collapsable\'])[' + i) + ']'
    TestObject dynamicTestObject2 = new TestObject()
    dynamicTestObject2.addProperty('xpath', ConditionType.EQUALS, baseXPath2)
    String redCircleNoShowBackgroundColor = WebUI.getCSSValue(dynamicTestObject2, 'background')
    String redCircleBgColor = Color.fromString(redCircleNoShowBackgroundColor.substring(0, 16)).asHex()
    println(('From web = ' + redCircleBgColor) + ': From CSS = #dc3545')
    WebUI.verifyMatch(redCircleBgColor, '#dc3545', false, FailureHandling.CONTINUE_ON_FAILURE)

    // Extract the Status, Flight, and Flight Date from the content
    String status = ((tooltipData.split('Status:')[1]).split('<br>')[0]).trim()
    String flight = ((tooltipData.split('Flight:')[1]).split('<br>')[0]).trim()
    String flightDate = ((tooltipData.split('Flight date:')[1]).split('<br>')[0]).trim()

    //read Carrier 
    String baseXPath1 = ('//div[@class=\'facsimile\']/table/tbody/tr[' + (6 + Integer.parseInt(couponNumber))) + ']/td[4]'
    dynamicTestObject.addProperty('xpath', ConditionType.EQUALS, baseXPath1)
    String Carrier = WebUI.getText(dynamicTestObject)

    // create tooltip from DB
    String StatusDB = status
    String FlightNumberDB = ((((Carrier + NsfFileCouponData.get('flight_number')) + ' ') + NsfFileCouponData.get('from_sector')) +' - ') + NsfFileCouponData.get('to_sector')
    String FlightDateDB = CustomKeywords.'utilityClass.GenericMethods.DateFormatter'(NsfFileCouponData.get('flight_date'))
    WebUI.verifyMatch(status, 'NO-SHOW', false, FailureHandling.CONTINUE_ON_FAILURE)
    WebUI.verifyMatch(flight.replace('<span class = >', '').replace('</span>', '').replace('<span class = text-danger>',''), FlightNumberDB, false, FailureHandling.CONTINUE_ON_FAILURE)
    WebUI.verifyMatch(flightDate.replace('<span class = >', '').replace('</span>', '').replace('<span class = text-danger>',''), FlightDateDB.toUpperCase(), false, FailureHandling.CONTINUE_ON_FAILURE)
	
	//Verify flight data color as pr color priority
	String md_ticket_coupon_flightstatus = "select * from bdmozart.md_ticket_coupon_flightstatus where id_tick_coupon = '"+originalCouponData.get('id')+"'"
	String flight_status = CustomKeywords.'database.DatabaseUtils.executeQuery'(md_ticket_coupon_flightstatus, 'flight_status', 1)
	String baseXPath3 = "(//div[@class='facsimile']/table/tbody/tr["+(6 + Integer.parseInt(couponNumber))+"]/td[4])[1]"
	TestObject dynamicTestObject3 = new TestObject()
	dynamicTestObject3.addProperty('xpath', ConditionType.EQUALS, baseXPath3)
	String flightDataTextColor = WebUI.getCSSValue(dynamicTestObject3, 'color')
	String textColor = Color.fromString(flightDataTextColor).asHex()
	if(flight_status=="D" || flight_status=="S" ) 
		{
			WebUI.verifyMatch(textColor, '#ff8200', false, FailureHandling.CONTINUE_ON_FAILURE)
		}
	else if(flight_status=="C")
		{
			WebUI.verifyMatch(textColor, '#97d700', false, FailureHandling.CONTINUE_ON_FAILURE)
		}
	else 
		{
			WebUI.verifyMatch(textColor, '#ee1f25', false, FailureHandling.CONTINUE_ON_FAILURE)
		}
		
}

