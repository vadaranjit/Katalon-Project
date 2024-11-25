package utilityClass
import groovy.json.JsonSlurper

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
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
import utilityClass.JsonPaths as JsonPaths
import database.DatabaseUtils
import org.openqa.selenium.Keys as Keys
import java.nio.file.Files as Files
import java.nio.file.Paths as Paths
import java.io.IOException as IOException
public class JsonPaths
{
	@Keyword
	public static String JsonStringFormatter(String filePath)
	{
		try
		{
			String jsonString = new String(Files.readAllBytes(Paths.get(filePath)))
			String formattedJsonString = jsonString
					.replace("\\", "\\\\")  // Escape backslashes
					.replace("\"", "\\\"")  // Escape double quotes
					.replace("\r", "\\r")   // Escape carriage returns
					.replace("\n", "\\n");  // Escape newlines

			//str.substring(1, str.length() - 1)
			return formattedJsonString
		} catch (IOException e)
		{
			e.printStackTrace()
			return null
		}
	}



	@Keyword
	public void verifyJsonElementsValuesWithDatabaseValues(String filePath,Map<String, String> dbMap, String sqlQuery)
	{
		DatabaseUtils obj = new DatabaseUtils()
		Map<String, String> tableColumnNameAndValue = obj.getColumnNamesAndValues(sqlQuery)
		for (Map.Entry<String, String> entry : tableColumnNameAndValue.entrySet())
		{
			String tableColumnNameKey = entry.getKey() // db column name
			String tableColumnValue = entry.getValue() // db column value

			String quoteResponse = new String(Files.readAllBytes(Paths.get(filePath)))
			Map<String, String> wsMap = getJsonPathWithValues(quoteResponse)

			if(dbMap.containsKey(tableColumnNameKey))
			{
				String dbColumnJsonPath = dbMap.get(tableColumnNameKey); // db value - json path
				String wsValue = wsMap.get(dbColumnJsonPath)

				//demo logic
				if(wsMap.containsKey(dbColumnJsonPath))
				{
					String wsValuedemo = wsMap.get(dbColumnJsonPath)
					println (tableColumnNameKey+" = "+ tableColumnValue +" : "+wsValuedemo)
					WebUI.verifyMatch(tableColumnValue,wsValuedemo, false, FailureHandling.CONTINUE_ON_FAILURE)
				}
			}
		}
	}


	@Keyword
	public static void verifyBlankDatabaseValues(String sqlQuery)
	{
		DatabaseUtils obj1 = new DatabaseUtils()
		Map<String, String> tableColumnNameAndValue = obj1.getColumnNamesAndValues(sqlQuery)
		for (Map.Entry<String, String> entry : tableColumnNameAndValue.entrySet())
		{
			String tableColumnNameKey = entry.getKey() // db column name
			String tableColumnValue = entry.getValue() // db column value)
			println (tableColumnValue+"="+tableColumnNameKey)
		}
	}

	public static HashMap<String, String> processJson(String jsonBody)
	{
		HashMap<String, String> map = new HashMap<>()
		def slurper = new JsonSlurper()
		def parsedJson = slurper.parseText(jsonBody)
		map = JsonKeyValuePairs(parsedJson,"")
		return map
	}


	public static HashMap<String, String> JsonKeyValuePairs(Object jsonObject, String parentKey)
	{
		HashMap<String, String> map = new HashMap<>()

		// Check if jsonObject is a Map (i.e., JSON object)
		if (jsonObject instanceof Map)
		{
			Map<String, Object> jsonMap = (Map<String, Object>) jsonObject

			// Iterate over the entries in the JSON object
			for (Map.Entry<String, Object> entry : jsonMap.entrySet())
			{
				String key = entry.getKey()
				Object value = entry.getValue()

				// Construct the full key path
				String fullKey = (parentKey != null && !parentKey.isEmpty()) ? parentKey + "." + key : key

				// If the value is a nested Map (another JSON object), call recursively
				if (value instanceof Map)
				{
					map.putAll(JsonKeyValuePairs(value, fullKey))
				}
				// If the value is a List, iterate over the list and process each element
				else if (value instanceof List)
				{
					List<Object> list = (List<Object>) value
					for (int i = 0; i < list.size(); i++)
					{
						map.putAll(JsonKeyValuePairs(list.get(i), fullKey + "[" + i + "]"))
					}
				}
				// Otherwise, store the key-value pair
				else
				{
					map.put(fullKey, value.toString())
				}
			}
		}

		return map
	}

	public static HashMap<String, String> getJsonPathWithValues(String wsJsonPaths)
	{
		//Store JSON Path keys and values into HashMap which received from WS Response
		//KEY - Json path and VALUE - Data of element
		DatabaseUtils obj = new DatabaseUtils()
		processJson(wsJsonPaths)
		HashMap<String, String> map = processJson(wsJsonPaths)
		return map
	}

	@Keyword
	public static HashMap<String, String> getColumnsWithJsonPath(String tableName,String rootElement)
	{
		HashMap<String, String> jsonPathMap = new HashMap<>()

		if(tableName.equals("mi_refund_ek_quote"))
		{
			jsonPathMap.put("processingstatus", rootElement+".refundDetails.pnrProcessingDetails.processingStatus")
			jsonPathMap.put("iswaiverapplied", rootElement+".refundDetails.isWaiverApplied")
			jsonPathMap.put("isnoshowfeesapplicable", rootElement+".refundDetails.noShowFees.isNoShowFeesApplicable")
			jsonPathMap.put("isnoshowfeesapplied", rootElement+".refundDetails.noShowFees.isNoShowFeesApplied")
			jsonPathMap.put("currencycode", rootElement+".refundDetails.totalRefundFare.currencyCode")
			jsonPathMap.put("fare", rootElement+".refundDetails.totalRefundFare.fare")
		}
		else if (tableName.equals("mi_refund_ek_quote_passenger"))
		{
			jsonPathMap.put("passengerreference", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].passengerDetails.passengerReference")
			jsonPathMap.put("passengername", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].passengerDetails.personName.fullName")
		}
		else if (tableName.equals("mi_refund_ek_quote_tkt_details"))
		{
			jsonPathMap.put("eticketnumber", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.eticketNumber")
			jsonPathMap.put("conjunctiveticketrange", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.conjunctiveTicketRange")
			jsonPathMap.put("passengertype", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.passengerType")
			jsonPathMap.put("ticketutilization", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.ticketUtilization")
			jsonPathMap.put("issuingcountrycode", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.issuingCountryCode")
			jsonPathMap.put("origincountrycode",rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.originCountryCode")
			jsonPathMap.put("issuanceoffice", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.issuanceOffice")
			jsonPathMap.put("issuingdate", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.issuingDate")
			jsonPathMap.put("farecalculationindicator", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareCalculationIndicator")
			jsonPathMap.put("pricetaginfo", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.priceTagInfo")
		}
		else if (tableName.equals("mi_refund_ek_quote_tkt_coupon_details"))
		{
			jsonPathMap.put("couponnumber", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.couponDetails.couponDetails[0].couponNumber")
			jsonPathMap.put("associatedticketnumber",rootElement+ ".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.couponDetails.couponDetails[0].associatedTicketNumber")
			jsonPathMap.put("couponrefundableindicator", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.couponDetails.couponDetails[0].couponRefundableIndicator")
			jsonPathMap.put("couponrefundedindicator", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.couponDetails.couponDetails[0].couponRefundedIndicator")
			jsonPathMap.put("farebasiscode", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.couponDetails.couponDetails[0].fareBasisCode")
			jsonPathMap.put("classoftravel", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.couponDetails.couponDetails[0].classOfTravel")
			jsonPathMap.put("cabinclass", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.couponDetails.couponDetails[0].cabinClass")
			jsonPathMap.put("farebrandcode", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.couponDetails.couponDetails[0].fareBrandCode")
		}

		else if (tableName.equals("mi_refund_ek_quote_tkt_original_fare"))
		{
			jsonPathMap.put("basefarecurrencycode", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.originalFareDetails.totalBaseFare.currencyCode")
			jsonPathMap.put("basefarerefundamount", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.originalFareDetails.totalBaseFare.fare")
			jsonPathMap.put("refundtaxamount", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.originalFareDetails.totalTax.taxValue")
			jsonPathMap.put("refundtaxcurrencycode", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.originalFareDetails.totalTax.currencyCode")
			jsonPathMap.put("totalfarecurrencycode", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.originalFareDetails.totalFare.currencyCode")
			jsonPathMap.put("totalrefundfareamount", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.originalFareDetails.totalFare.fare")
		}
		else if (tableName.equals("mi_refund_ek_quote_tkt_penalty_charges"))
		{
			jsonPathMap.put("penaltycharge", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.penaltyChargesDetails.penaltyCharge")
			jsonPathMap.put("currencycode", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.penaltyChargesDetails.currencyCode")
			jsonPathMap.put("taxvalue", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.penaltyChargesDetails.totalTax.taxValue")
			jsonPathMap.put("taxcurrencycode", "nan")
		}
		else if (tableName.equals("mi_refund_ek_quote_tkt_refund_fare"))
		{
			jsonPathMap.put("basefarecurrencycode", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.refundFareDetails.totalBaseFare.currencyCode")
			jsonPathMap.put("basefarerefundamount", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.refundFareDetails.totalBaseFare.fare")
			jsonPathMap.put("refundtaxamount", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.refundFareDetails.totalTax.taxValue")
			jsonPathMap.put("refundtaxcurrencycode", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.refundFareDetails.totalTax.currencyCode")
			jsonPathMap.put("totalfarecurrencycode", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.refundFareDetails.totalFare.currencyCode")
			jsonPathMap.put("totalfareamount", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.refundFareDetails.totalFare.fare")
			jsonPathMap.put("totalresidualamount", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.refundFareDetails.totalResidualValue.fare")
			jsonPathMap.put("totalresidualcurrencycode", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.refundFareDetails.totalResidualValue.currencyCode")
		}
		else if (tableName.equals("mi_refund_ek_quote_tkt_used_fare"))
		{
			jsonPathMap.put("basefarecurrencycode", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.usedFareDetails.totalBaseFare.currencyCode")
			jsonPathMap.put("basefarerefundamount", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.usedFareDetails.totalBaseFare.fare")
			jsonPathMap.put("totalfarerefundamount", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.usedFareDetails.totalFare.fare")
			jsonPathMap.put("totalfarecurrencycode", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.usedFareDetails.totalFare.currencyCode")
			jsonPathMap.put("nonrefundabletaxamount", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.usedFareDetails.totalNonRefundableTax.taxValue")
			jsonPathMap.put("nonrefundabletaxcurrencycode", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.usedFareDetails.totalNonRefundableTax.currencyCode")
			jsonPathMap.put("totaltaxfareamount", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.usedFareDetails.totalTax.taxValue")
			jsonPathMap.put("totaltaxcurrencycode", rootElement+".refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.usedFareDetails.totalTax.currencyCode")
		}
		else
		{
			println ("table name not found")
		}
		return jsonPathMap;
	}


	//=============================
	@Keyword
	public static HashMap<String, String> getColumnsWithJsonPath(String tableName)
	{
		HashMap<String, String> jsonPathMap = new HashMap<>()

		if(tableName.equals("mi_refund_ek_quote"))
		{
			jsonPathMap.put("processingstatus", "processRefundResponse.refundDetails.pnrProcessingDetails.processingStatus")
			jsonPathMap.put("iswaiverapplied", "processRefundResponse.refundDetails.isWaiverApplied")
			jsonPathMap.put("isnoshowfeesapplicable", "processRefundResponse.refundDetails.noShowFees.isNoShowFeesApplicable")
			jsonPathMap.put("isnoshowfeesapplied", "processRefundResponse.refundDetails.noShowFees.isNoShowFeesApplied")
			jsonPathMap.put("currencycode", "processRefundResponse.refundDetails.totalRefundFare.currencyCode")
			jsonPathMap.put("fare", "processRefundResponse.refundDetails.totalRefundFare.fare")
		}
		else if (tableName.equals("mi_refund_ek_quote_passenger"))
		{
			jsonPathMap.put("passengerreference", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].passengerDetails.passengerReference")
			jsonPathMap.put("passengername", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].passengerDetails.personName.fullName")
		}
		else if (tableName.equals("mi_refund_ek_quote_tkt_details"))
		{
			jsonPathMap.put("eticketnumber", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.eticketNumber")
			jsonPathMap.put("conjunctiveticketrange", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.conjunctiveTicketRange")
			jsonPathMap.put("passengertype", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.passengerType")
			jsonPathMap.put("ticketutilization", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.ticketUtilization")
			jsonPathMap.put("issuingcountrycode", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.issuingCountryCode")
			jsonPathMap.put("origincountrycode", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.originCountryCode")
			jsonPathMap.put("issuanceoffice", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.issuanceOffice")
			jsonPathMap.put("issuingdate", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.issuingDate")
			jsonPathMap.put("farecalculationindicator", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareCalculationIndicator")
			jsonPathMap.put("pricetaginfo", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.priceTagInfo")
		}
		else if (tableName.equals("mi_refund_ek_quote_tkt_coupon_details"))
		{
			jsonPathMap.put("couponnumber", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.couponDetails.couponDetails[0].couponNumber")
			jsonPathMap.put("associatedticketnumber", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.couponDetails.couponDetails[0].associatedTicketNumber")
			jsonPathMap.put("couponrefundableindicator", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.couponDetails.couponDetails[0].couponRefundableIndicator")
			jsonPathMap.put("couponrefundedindicator", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.couponDetails.couponDetails[0].couponRefundedIndicator")
			jsonPathMap.put("farebasiscode", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.couponDetails.couponDetails[0].fareBasisCode")
			jsonPathMap.put("classoftravel", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.couponDetails.couponDetails[0].classOfTravel")
			jsonPathMap.put("cabinclass", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.couponDetails.couponDetails[0].cabinClass")
			jsonPathMap.put("farebrandcode", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.couponDetails.couponDetails[0].fareBrandCode")
		}

		else if (tableName.equals("mi_refund_ek_quote_tkt_original_fare"))
		{
			jsonPathMap.put("basefarecurrencycode", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.originalFareDetails.totalBaseFare.currencyCode")
			jsonPathMap.put("basefarerefundamount", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.originalFareDetails.totalBaseFare.fare")
			jsonPathMap.put("refundtaxamount", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.originalFareDetails.totalTax.taxValue")
			jsonPathMap.put("refundtaxcurrencycode", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.originalFareDetails.totalTax.currencyCode")
			jsonPathMap.put("totalfarecurrencycode", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.originalFareDetails.totalFare.currencyCode")
			jsonPathMap.put("totalrefundfareamount", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.originalFareDetails.totalFare.fare")
		}
		else if (tableName.equals("mi_refund_ek_quote_tkt_penalty_charges"))
		{
			jsonPathMap.put("penaltycharge", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.penaltyChargesDetails.penaltyCharge")
			jsonPathMap.put("currencycode", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.penaltyChargesDetails.currencyCode")
			jsonPathMap.put("taxvalue", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.penaltyChargesDetails.totalTax.taxValue")
			jsonPathMap.put("taxcurrencycode", "nan")
		}
		else if (tableName.equals("mi_refund_ek_quote_tkt_refund_fare"))
		{
			jsonPathMap.put("basefarecurrencycode", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.refundFareDetails.totalBaseFare.currencyCode")
			jsonPathMap.put("basefarerefundamount", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.refundFareDetails.totalBaseFare.fare")
			jsonPathMap.put("refundtaxamount", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.refundFareDetails.totalTax.taxValue")
			jsonPathMap.put("refundtaxcurrencycode", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.refundFareDetails.totalTax.currencyCode")
			jsonPathMap.put("totalfarecurrencycode", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.refundFareDetails.totalFare.currencyCode")
			jsonPathMap.put("totalfareamount", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.refundFareDetails.totalFare.fare")
			jsonPathMap.put("totalresidualamount", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.refundFareDetails.totalResidualValue.fare")
			jsonPathMap.put("totalresidualcurrencycode", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.refundFareDetails.totalResidualValue.currencyCode")
		}
		else if (tableName.equals("mi_refund_ek_quote_tkt_used_fare"))
		{
			jsonPathMap.put("basefarecurrencycode", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.usedFareDetails.totalBaseFare.currencyCode")
			jsonPathMap.put("basefarerefundamount", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.usedFareDetails.totalBaseFare.fare")
			jsonPathMap.put("totalfarerefundamount", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.usedFareDetails.totalFare.fare")
			jsonPathMap.put("totalfarecurrencycode", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.usedFareDetails.totalFare.currencyCode")
			jsonPathMap.put("nonrefundabletaxamount", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.usedFareDetails.totalNonRefundableTax.taxValue")
			jsonPathMap.put("nonrefundabletaxcurrencycode", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.usedFareDetails.totalNonRefundableTax.currencyCode")
			jsonPathMap.put("totaltaxfareamount", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.usedFareDetails.totalTax.taxValue")
			jsonPathMap.put("totaltaxcurrencycode", "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.fareDetails.usedFareDetails.totalTax.currencyCode")
		}
		else
		{
			println ("table name not found")
		}
		return jsonPathMap;
	}
}// class
