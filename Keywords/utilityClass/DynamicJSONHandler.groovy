package utilityClass

import org.json.JSONArray;
import org.json.JSONObject;

import com.kms.katalon.core.annotation.Keyword

public class DynamicJSONHandler {

	@Keyword
	public static void dynamicJSONHandler() {
		// Sample unpredictable JSON (replace with your JSON)
		String jsonBody = "{\"logRefundRequest\":{\"refundDetails\":{\"pnrProcessingDetails\":{\"processingStatus\":\"N\"},\"isWaiverApplied\":false,\"noShowFees\":{\"isNoShowFeesApplicable\":false,\"isNoShowFeesApplied\":false},\"totalRefundFare\":{\"currencyCode\":\"AED\",\"fare\":\"8520\"},\"passengersRefundDetails\":{\"passengerRefundDetails\":[{\"passengerDetails\":{\"passengerReference\":\"1\",\"personName\":{\"fullName\":\"ADTNOELLE/BAUMBACHMR\"}},\"eticketsRefundDetails\":{\"eticketRefundDetails\":[{\"eticketDetails\":{\"eticketNumber\":\"1762368172427\",\"ticketProcessingStatus\":true,\"conjunctiveTicketRange\":\"1762368172427\",\"passengerType\":\"ADT\",\"ticketUtilization\":\"Unutilized\",\"issuingCountryCode\":\"AE\",\"originCountryCode\":\"AE\",\"issuanceOffice\":\"EKDXBRV\",\"ticketPurchaseLocation\":\"DXB/EKT3DHO\",\"issuingDate\":\"28FEB\",\"fareCalculationIndicator\":\"R0\",\"priceTagInfo\":\"R0\",\"couponDetails\":{\"couponDetails\":[{\"couponNumber\":\"1\",\"associatedTicketNumber\":\"1762368172427\",\"couponRefundableIndicator\":true,\"couponRefundedIndicator\":true,\"fareBasisCode\":\"YLOWFAE1/EOL4\",\"classOfTravel\":\"Y\",\"cabinClass\":\"Y\",\"fareBrandCode\":\"F\"}]},\"fareDetails\":{\"originalFareDetails\":{\"totalFare\":{\"currencyCode\":\"AED\",\"fare\":\"2970\"},\"totalBaseFare\":{\"currencyCode\":\"AED\",\"fare\":\"2660\"},\"totalTax\":{\"taxValue\":310.0,\"currencyCode\":\"AED\",\"taxComponentDetails\":[{\"code\":\"ZR\",\"currencyCode\":\"AED\",\"value\":5.0},{\"code\":\"AE\",\"currencyCode\":\"AED\",\"value\":75.0},{\"code\":\"TP\",\"currencyCode\":\"AED\",\"value\":5.0},{\"code\":\"F6\",\"currencyCode\":\"AED\",\"value\":35.0},{\"code\":\"YQ\",\"currencyCode\":\"AED\",\"value\":190.0}]}},\"usedFareDetails\":{\"totalFare\":{\"currencyCode\":\"AED\",\"fare\":\"0\"},\"totalBaseFare\":{\"currencyCode\":\"AED\",\"fare\":\"0\"},\"totalNonRefundableTax\":{\"taxValue\":0.0,\"currencyCode\":\"AED\"},\"totalTax\":{\"taxValue\":0.0,\"currencyCode\":\"AED\"}},\"penaltyChargesDetails\":{\"currencyCode\":\"AED\",\"penaltyCharge\":0.0,\"totalTax\":{\"taxValue\":0.0}},\"refundFareDetails\":{\"totalFare\":{\"currencyCode\":\"AED\",\"fare\":\"2970\"},\"totalResidualValue\":{\"currencyCode\":\"AED\",\"fare\":\"2970\"},\"totalBaseFare\":{\"currencyCode\":\"AED\",\"fare\":\"2660\"},\"totalTax\":{\"taxValue\":310.0,\"currencyCode\":\"AED\",\"taxComponentDetails\":[{\"code\":\"AE\",\"currencyCode\":\"AED\",\"value\":75.0},{\"code\":\"TP\",\"currencyCode\":\"AED\",\"value\":5.0},{\"code\":\"F6\",\"currencyCode\":\"AED\",\"value\":35.0},{\"code\":\"YQ\",\"currencyCode\":\"AED\",\"value\":190.0},{\"code\":\"ZR\",\"currencyCode\":\"AED\",\"value\":5.0}]}}}}}]}},{\"passengerDetails\":{\"passengerReference\":\"1\",\"personName\":{\"fullName\":\"TestingErrorQuote/KRISMR\"}},\"eticketsRefundDetails\":{\"eticketRefundDetails\":[{\"eticketDetails\":{\"eticketNumber\":\"1762368172426\",\"ticketProcessingStatus\":true,\"conjunctiveTicketRange\":\"1762368172426\",\"passengerType\":\"ADT\",\"ticketUtilization\":\"Unutilized\",\"issuingCountryCode\":\"AE\",\"originCountryCode\":\"AE\",\"issuanceOffice\":\"EKDXBRV\",\"ticketPurchaseLocation\":\"DXB/EKT3DHO\",\"issuingDate\":\"28FEB2024\",\"fareCalculationIndicator\":\"R0\",\"priceTagInfo\":\"R0\",\"couponDetails\":{\"couponDetails\":[{\"couponNumber\":\"1\",\"associatedTicketNumber\":\"1762368172426\",\"couponRefundableIndicator\":true,\"couponRefundedIndicator\":true,\"fareBasisCode\":\"YLOWFAE1/EOL4\",\"classOfTravel\":\"Y\",\"cabinClass\":\"Y\",\"fareBrandCode\":\"F\"}]},\"fareDetails\":{\"originalFareDetails\":{\"totalFare\":{\"currencyCode\":\"AED\",\"fare\":\"2970\"},\"totalBaseFare\":{\"currencyCode\":\"AED\",\"fare\":\"2660\"},\"totalTax\":{\"taxValue\":310.0,\"currencyCode\":\"AED\",\"taxComponentDetails\":[{\"code\":\"ZR\",\"currencyCode\":\"AED\",\"value\":5.0},{\"code\":\"AE\",\"currencyCode\":\"AED\",\"value\":75.0},{\"code\":\"TP\",\"currencyCode\":\"AED\",\"value\":5.0},{\"code\":\"F6\",\"currencyCode\":\"AED\",\"value\":35.0},{\"code\":\"YQ\",\"currencyCode\":\"AED\",\"value\":190.0}]}},\"usedFareDetails\":{\"totalFare\":{\"currencyCode\":\"AED\",\"fare\":\"0\"},\"totalBaseFare\":{\"currencyCode\":\"AED\",\"fare\":\"0\"},\"totalNonRefundableTax\":{\"taxValue\":0.0,\"currencyCode\":\"AED\"},\"totalTax\":{\"taxValue\":0.0,\"currencyCode\":\"AED\"}},\"penaltyChargesDetails\":{\"currencyCode\":\"AED\",\"penaltyCharge\":0.0,\"totalTax\":{\"taxValue\":0.0}},\"refundFareDetails\":{\"totalFare\":{\"currencyCode\":\"AED\",\"fare\":\"2970\"},\"totalResidualValue\":{\"currencyCode\":\"AED\",\"fare\":\"2970\"},\"totalBaseFare\":{\"currencyCode\":\"AED\",\"fare\":\"2660\"},\"totalTax\":{\"taxValue\":310.0,\"currencyCode\":\"AED\",\"taxComponentDetails\":[{\"code\":\"AE\",\"currencyCode\":\"AED\",\"value\":75.0},{\"code\":\"TP\",\"currencyCode\":\"AED\",\"value\":5.0},{\"code\":\"F6\",\"currencyCode\":\"AED\",\"value\":35.0},{\"code\":\"YQ\",\"currencyCode\":\"AED\",\"value\":190.0},{\"code\":\"ZR\",\"currencyCode\":\"AED\",\"value\":5.0}]}}}}}]}},{\"passengerDetails\":{\"passengerReference\":\"1\",\"personName\":{\"fullName\":\"CHDBILLYE/SPINKAMSTR\"}},\"eticketsRefundDetails\":{\"eticketRefundDetails\":[{\"eticketDetails\":{\"eticketNumber\":\"1762368172428\",\"ticketProcessingStatus\":true,\"conjunctiveTicketRange\":\"1762368172428\",\"passengerType\":\"CNN\",\"ticketUtilization\":\"Unutilized\",\"issuingCountryCode\":\"AE\",\"originCountryCode\":\"AE\",\"issuanceOffice\":\"EKDXBRV\",\"ticketPurchaseLocation\":\"DXB/EKT3DHO\",\"issuingDate\":\"28FEB2024\",\"fareCalculationIndicator\":\"R0\",\"priceTagInfo\":\"R0\",\"couponDetails\":{\"couponDetails\":[{\"couponNumber\":\"1\",\"associatedTicketNumber\":\"1762368172428\",\"couponRefundableIndicator\":true,\"couponRefundedIndicator\":true,\"fareBasisCode\":\"YLOWFAE1/CH/E\",\"classOfTravel\":\"Y\",\"cabinClass\":\"Y\",\"fareBrandCode\":\"F\"}]},\"fareDetails\":{\"originalFareDetails\":{\"totalFare\":{\"currencyCode\":\"AED\",\"fare\":\"2310\"},\"totalBaseFare\":{\"currencyCode\":\"AED\",\"fare\":\"2000\"},\"totalTax\":{\"taxValue\":310.0,\"currencyCode\":\"AED\",\"taxComponentDetails\":[{\"code\":\"ZR\",\"currencyCode\":\"AED\",\"value\":5.0},{\"code\":\"AE\",\"currencyCode\":\"AED\",\"value\":75.0},{\"code\":\"TP\",\"currencyCode\":\"AED\",\"value\":5.0},{\"code\":\"F6\",\"currencyCode\":\"AED\",\"value\":35.0},{\"code\":\"YQ\",\"currencyCode\":\"AED\",\"value\":190.0}]}},\"usedFareDetails\":{\"totalFare\":{\"currencyCode\":\"AED\",\"fare\":\"0\"},\"totalBaseFare\":{\"currencyCode\":\"AED\",\"fare\":\"0\"},\"totalNonRefundableTax\":{\"taxValue\":0.0,\"currencyCode\":\"AED\"},\"totalTax\":{\"taxValue\":0.0,\"currencyCode\":\"AED\"}},\"penaltyChargesDetails\":{\"currencyCode\":\"AED\",\"penaltyCharge\":0.0,\"totalTax\":{\"taxValue\":0.0}},\"refundFareDetails\":{\"totalFare\":{\"currencyCode\":\"AED\",\"fare\":\"2310\"},\"totalResidualValue\":{\"currencyCode\":\"AED\",\"fare\":\"2310\"},\"totalBaseFare\":{\"currencyCode\":\"AED\",\"fare\":\"2000\"},\"totalTax\":{\"taxValue\":310.0,\"currencyCode\":\"AED\",\"taxComponentDetails\":[{\"code\":\"AE\",\"currencyCode\":\"AED\",\"value\":75.0},{\"code\":\"TP\",\"currencyCode\":\"AED\",\"value\":5.0},{\"code\":\"F6\",\"currencyCode\":\"AED\",\"value\":35.0},{\"code\":\"YQ\",\"currencyCode\":\"AED\",\"value\":190.0},{\"code\":\"ZR\",\"currencyCode\":\"AED\",\"value\":5.0}]}}}}}]}},{\"passengerDetails\":{\"passengerReference\":\"1\",\"personName\":{\"fullName\":\"INLHYATT/KITTYMSTR\"}},\"eticketsRefundDetails\":{\"eticketRefundDetails\":[{\"eticketDetails\":{\"eticketNumber\":\"1762368172425\",\"ticketProcessingStatus\":true,\"conjunctiveTicketRange\":\"1762368172425\",\"passengerType\":\"INF\",\"ticketUtilization\":\"Unutilized\",\"issuingCountryCode\":\"AE\",\"originCountryCode\":\"AE\",\"issuanceOffice\":\"EKDXBRV\",\"ticketPurchaseLocation\":\"DXB/EKT3DHO\",\"issuingDate\":\"28FEB2024\",\"fareCalculationIndicator\":\"R0\",\"priceTagInfo\":\"R0\",\"couponDetails\":{\"couponDetails\":[{\"couponNumber\":\"1\",\"associatedTicketNumber\":\"1762368172425\",\"couponRefundableIndicator\":true,\"couponRefundedIndicator\":true,\"fareBasisCode\":\"YLOWFAE1/IN/E\",\"classOfTravel\":\"Y\",\"cabinClass\":\"Y\",\"fareBrandCode\":\"F\"}]},\"fareDetails\":{\"originalFareDetails\":{\"totalFare\":{\"currencyCode\":\"AED\",\"fare\":\"270\"},\"totalBaseFare\":{\"currencyCode\":\"AED\",\"fare\":\"270\"},\"totalTax\":{\"taxValue\":0.0,\"currencyCode\":\"AED\"}},\"usedFareDetails\":{\"totalFare\":{\"currencyCode\":\"AED\",\"fare\":\"0\"},\"totalBaseFare\":{\"currencyCode\":\"AED\",\"fare\":\"0\"},\"totalNonRefundableTax\":{\"taxValue\":0.0,\"currencyCode\":\"AED\"},\"totalTax\":{\"taxValue\":0.0,\"currencyCode\":\"AED\"}},\"penaltyChargesDetails\":{\"currencyCode\":\"AED\",\"penaltyCharge\":0.0,\"totalTax\":{\"taxValue\":0.0}},\"refundFareDetails\":{\"totalFare\":{\"currencyCode\":\"AED\",\"fare\":\"270\"},\"totalResidualValue\":{\"currencyCode\":\"AED\",\"fare\":\"270\"},\"totalBaseFare\":{\"currencyCode\":\"AED\",\"fare\":\"270\"},\"totalTax\":{\"taxValue\":0.0,\"currencyCode\":\"AED\"}}}}}]}}]}},\"uniqueReferenceNumber\":\"2001762368172425\"}}"
		// Create JSONObject from JSON string
		JSONObject jsonObject = new JSONObject(jsonBody);

		// Recursively process the JSON object
		processJSONObject(jsonObject);
	}

	// Recursive function to handle dynamic JSON structures
	public static void processJSONObject(JSONObject jsonObject) {
		Iterator<String> keys = jsonObject.keys();

		while (keys.hasNext()) {
			String key = keys.next();
			Object value = jsonObject.get(key);

			// Check the value type and handle accordingly
			if (value instanceof JSONObject) {
				// Recursively process nested JSON object
				System.out.println("Key: " + key + " is a JSONObject.");
				processJSONObject((JSONObject) value);
			} else if (value instanceof JSONArray) {
				// Process JSON array
				System.out.println("Key: " + key + " is a JSONArray.");
				processJSONArray((JSONArray) value);
			} else {
				// Handle simple values like String, Integer, Boolean, etc.
				System.out.println("Key: " + key + ", Value: " + value.toString());
				// You can store or process this key-value pair as needed
			}
		}
	}

	// Function to handle JSON arrays
	public static void processJSONArray(JSONArray jsonArray) {
		for (int i = 0; i < jsonArray.length(); i++) {
			Object element = jsonArray.get(i);

			if (element instanceof JSONObject) {
				// Recursively process nested JSON object inside array
				processJSONObject((JSONObject) element);
			} else if (element instanceof JSONArray) {
				// Recursively process nested JSON array
				processJSONArray((JSONArray) element);
			} else {
				// Handle simple array elements
				System.out.println("Array Element: " + element.toString());
				// You can store or process this array element as needed
			}
		}
	}
}
