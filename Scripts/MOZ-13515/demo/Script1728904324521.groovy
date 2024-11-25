import org.openqa.selenium.support.Color

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

String documentNumber = '6720801174'
requestID = 'O101000003'
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

	println md_ticket_coupons
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
			'to_sector')))) {
		NoShowDataMismatch = true
	}
	
	println(couponNumber + '==========================')

	println(NoShowDataMismatch)

	println(originalCouponData.get('carrier'))

	println((((origin + '=') + NsfFileCouponData.get('from_sector')) + '=') + origin.equals(NsfFileCouponData.get('from_sector')))

	println((((dest + '=') + NsfFileCouponData.get('to_sector')) + '=') + dest.equals(NsfFileCouponData.get('to_sector')))

	println((((Integer.parseInt(originalCouponData.get('flight_number').trim()).toString() + '=') + Integer.parseInt(NsfFileCouponData.get(
				'flight_number').trim()).toString()) + '=') + Integer.parseInt(originalCouponData.get('flight_number').trim()).toString().equals(
			Integer.parseInt(NsfFileCouponData.get('flight_number').trim()).toString()))

	println((((originalCouponData.get('flight_date') + '=') + NsfFileCouponData.get('flight_date')) + '=') + originalCouponData.get(
			'flight_date').equals(NsfFileCouponData.get('flight_date')))

	println('=============================')

	// Now read tooltip data
	String baseXPath = ('(//div[@class=\'col col-3 pl-0 ml-1\']//span[@class=\'red-circle  no-seleccionable no-collapsable\' and @data-toggle=\'popover\'])[' +
	i) + ']'

	TestObject dynamicTestObject = new TestObject()

	dynamicTestObject.addProperty('xpath', ConditionType.EQUALS, baseXPath)

	String tooltipData = WebUI.getAttribute(dynamicTestObject, 'data-content')

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

	String FlightNumberDB = ((((Carrier + NsfFileCouponData.get('flight_number')) + ' ') + NsfFileCouponData.get('from_sector')) +
	' - ') + NsfFileCouponData.get('to_sector')

	String FlightDateDB = CustomKeywords.'utilityClass.GenericMethods.DateFormatter'(NsfFileCouponData.get('flight_date'))

	WebUI.verifyMatch(status, 'NO-SHOW', false, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.verifyMatch(flight.replace('<span class = >', '').replace('</span>', '').replace('<span class = text-danger>',
			''), FlightNumberDB, false, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.verifyMatch(flightDate.replace('<span class = >', '').replace('</span>', '').replace('<span class = text-danger>',
			''), FlightDateDB.toUpperCase(), false, FailureHandling.CONTINUE_ON_FAILURE)
}


//     println(couponNumber + '==========================')

    println(NoShowDataMismatch)

    println(originalCouponData.get('carrier'))

    println((((origin + '=') + NsfFileCouponData.get('from_sector')) + '=') + origin.equals(NsfFileCouponData.get('from_sector')))

    println((((dest + '=') + NsfFileCouponData.get('to_sector')) + '=') + dest.equals(NsfFileCouponData.get('to_sector')))

    println((((Integer.parseInt(originalCouponData.get('flight_number').trim()).toString() + '=') + Integer.parseInt(NsfFileCouponData.get(
                'flight_number').trim()).toString()) + '=') + Integer.parseInt(originalCouponData.get('flight_number').trim()).toString().equals(
            Integer.parseInt(NsfFileCouponData.get('flight_number').trim()).toString()))

    println((((originalCouponData.get('flight_date') + '=') + NsfFileCouponData.get('flight_date')) + '=') + originalCouponData.get(
            'flight_date').equals(NsfFileCouponData.get('flight_date')))

    println('=============================')

    // Now read tooltip data
