import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

String documentNumber = "6720801174"

// Query to get all NSF coupon data at once
String mi_nsf = "SELECT * FROM bdmozart.mi_nsf WHERE document_number = '${documentNumber}'"
int rowCount = CustomKeywords.'database.DatabaseUtils.getRowCount'(mi_nsf)

boolean noShowDataMismatch = false

for (int i = 1; i <= rowCount; i++) {
	// Read coupon number
	String couponNumber = CustomKeywords.'database.DatabaseUtils.executeQuery'(mi_nsf, 'coupon_number', i)

	// Read original coupon data in one go
	String md_ticket_coupons = """
        SELECT * 
        FROM bdmozart.md_ticket_coupons 
        WHERE document = '${documentNumber}' 
        AND coupon = '${couponNumber}'
    """
	Map<String, String> originalCouponData = CustomKeywords.'database.DatabaseUtils.getColumnNamesAndValues'(md_ticket_coupons)

	// Read NSF file coupon data in one go
	String md_ticket_coupon_nsf = """
        SELECT * 
        FROM bdmozart.md_ticket_coupon_nsf 
        WHERE id_tick_coupon = '${originalCouponData.get('id')}'
    """
	Map<String, String> nsfFileCouponData = CustomKeywords.'database.DatabaseUtils.getColumnNamesAndValues'(md_ticket_coupon_nsf)

	// Read airport data for origin and destination in one go
	String mc_airports = """
        SELECT origin_airport.airportcode AS originCode, 
               dest_airport.airportcode AS destCode
        FROM bdmozart.mc_airports origin_airport, bdmozart.mc_airports dest_airport
        WHERE origin_airport.id = '${originalCouponData.get('origin')}' 
        AND dest_airport.id = '${originalCouponData.get('dest')}'
    """
	Map<String, String> airportData = CustomKeywords.'database.DatabaseUtils.getColumnNamesAndValues'(mc_airports)

	// Read country of the ticket
	String md_tickets = """
        SELECT country 
        FROM bdmozart.md_tickets 
        WHERE id = '${originalCouponData.get('id_tick')}'
    """
	String country = CustomKeywords.'database.DatabaseUtils.executeQuery'(md_tickets, 'country', 1)

	// Compare original data with NSF file data
	if (!(country.equals(nsfFileCouponData.get('country')) &&
		  Integer.parseInt(originalCouponData.get('flight_number').trim()) == Integer.parseInt(nsfFileCouponData.get('flight_number').trim()) &&
		  originalCouponData.get('flight_date').equals(nsfFileCouponData.get('flight_date')) &&
		  airportData.get('originCode').equals(nsfFileCouponData.get('from_sector')) &&
		  airportData.get('destCode').equals(nsfFileCouponData.get('to_sector')))) {
		noShowDataMismatch = true
	}

	// Print debug information
	println "Coupon: ${couponNumber} | Data Mismatch: ${noShowDataMismatch}"
	println "Country: ${country} == ${nsfFileCouponData.get('country')} => ${country.equals(nsfFileCouponData.get('country'))}"
	println "Origin: ${airportData.get('originCode')} == ${nsfFileCouponData.get('from_sector')} => ${airportData.get('originCode').equals(nsfFileCouponData.get('from_sector'))}"
	println "Dest: ${airportData.get('destCode')} == ${nsfFileCouponData.get('to_sector')} => ${airportData.get('destCode').equals(nsfFileCouponData.get('to_sector'))}"
	println "Flight Number: ${originalCouponData.get('flight_number').trim()} == ${nsfFileCouponData.get('flight_number').trim()}"
	println "Flight Date: ${originalCouponData.get('flight_date')} == ${nsfFileCouponData.get('flight_date')}"
	println "====================================="
}
