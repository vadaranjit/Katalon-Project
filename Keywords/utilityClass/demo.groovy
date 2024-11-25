package utilityClass

import groovy.json.JsonSlurper
import com.kms.katalon.core.annotation.Keyword
import java.nio.file.Files
import java.nio.file.Paths
import database.DatabaseUtils

public class demo
{

	@Keyword
	public static Map<String, String> getJsonPathWithValues(String jsonBody)
	{
		// Store JSON paths and values from the WS Response in a Map
		return processJson(jsonBody)
	}

	@Keyword
	public void verifyJsonElementsValuesWithDatabaseValues(String filePath, Map<String, String> dbMap, String sqlQuery)
	{
		// Initialize DatabaseUtils and get column names and values
		DatabaseUtils dbUtils = new DatabaseUtils()
		Map<String, String> tableColumnMap = dbUtils.getColumnNamesAndValues(sqlQuery)

		String jsonResponse = new String(Files.readAllBytes(Paths.get(filePath)))
		Map<String, String> wsMap = getJsonPathWithValues(jsonResponse)

		tableColumnMap.each
		{ column, value ->
			if (dbMap.containsKey(column))
			{
				String jsonPath = dbMap.get(column)
				String wsValue = wsMap.get(jsonPath)

				if (wsValue != null)
				{
					println "$column = $value : $wsValue"
				} else
				{
					println "No matching WS value found for $jsonPath"
				}
			} else
			{
				println "No mapping found for column: $column"
			}
		}
	}

	private static Map<String, String> processJson(String jsonBody)
	{
		def slurper = new JsonSlurper()
		def parsedJson = slurper.parseText(jsonBody)
		return extractKeyValuePairs(parsedJson, "")
	}

	private static Map<String, String> extractKeyValuePairs(Object jsonObject, String parentKey)
	{
		Map<String, String> map = [:]

		if (jsonObject instanceof Map)
		{
			jsonObject.each
			{ key, value ->
				String fullKey = parentKey ? "$parentKey.$key" : key
				if (value instanceof Map)
				{
					map.putAll(extractKeyValuePairs(value, fullKey))
				} else if (value instanceof List)
				{
					value.eachWithIndex
					{ item, index ->
						map.putAll(extractKeyValuePairs(item, "$fullKey[$index]"))
					}
				} else
				{
					map.put(fullKey, value.toString())
				}
			}
		}
		return map
	}

	@Keyword
	public static Map<String, String> getColumnsWithJsonPath(String tableName)
	{
		switch (tableName)
		{
			case "mi_refund_ek_quote":
				return [
					"processingstatus"           : "processRefundResponse.refundDetails.pnrProcessingDetails.processingStatus",
					"iswaiverapplied"            : "processRefundResponse.refundDetails.isWaiverApplied",
					"isnoshowfeesapplicable"     : "processRefundResponse.refundDetails.noShowFees.isNoShowFeesApplicable",
					"isnoshowfeesapplied"        : "processRefundResponse.refundDetails.noShowFees.isNoShowFeesApplied",
					"currencycode"               : "processRefundResponse.refundDetails.totalRefundFare.currencyCode",
					"fare"                       : "processRefundResponse.refundDetails.totalRefundFare.fare"
				]
			case "mi_refund_ek_quote_passenger":
				return [
					"passengerreference" : "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].passengerDetails.passengerReference",
					"passengername"      : "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].passengerDetails.personName.fullName"
				]
			case "mi_refund_ek_quote_tkt_details":
				return [
					"eticketnumber"        : "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.eticketNumber",
					"conjunctiveticketrange": "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.conjunctiveTicketRange",
					"passengertype"        : "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.passengerType",
					"ticketutilization"    : "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.ticketUtilization",
					"issuingcountrycode"   : "processRefundResponse.refundDetails.passengersRefundDetails.passengerRefundDetails[0].eticketsRefundDetails.eticketRefundDetails[0].eticketDetails.issuingCountryCode"
				]
			// Add other cases similarly
			default:
				println "Table name not found: $tableName"
				return [:]
		}
	}
}
