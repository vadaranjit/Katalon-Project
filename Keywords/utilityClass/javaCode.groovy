package utilityClass

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

import java.util.List;
import java.util.Map;

public class JsonKeyValuePrinter {

	public static void printJsonKeyValuePairs(Map<String, Object> jsonObject, String parentKey) {
		for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();

			// Construct the full key path
			String fullKey = (parentKey.isEmpty()) ? key : parentKey + "." + key;

			// Check if the value is a nested object (Map) or a list (List)
			if (value instanceof Map) {
				// If the value is a Map, recursively call the function
				printJsonKeyValuePairs((Map<String, Object>) value, fullKey);
			} else if (value instanceof List) {
				// If the value is a List, iterate through the list
				List<?> list = (List<?>) value;
				for (int index = 0; index < list.size(); index++) {
					Object listItem = list.get(index);
					// Recursively call the function for each item in the list
					printJsonKeyValuePairs(Map.of(String.valueOf(index), listItem), fullKey + "[" + index + "]");
				}
			} else {
				// Print the key-value pair
				System.out.println(fullKey + ": " + value);
			}
		}
	}

	public static void printJsonKeyValuePairs(Map<String, Object> jsonObject) {
		printJsonKeyValuePairs(jsonObject, "");
	}

	public static void main(String[] args) {
		// Example usage
		Map<String, Object> json = Map.of(
				"name", "John",
				"address", Map.of(
				"city", "New York",
				"zipcode", "10001"
				),
				"phoneNumbers", List.of("1234567890", "0987654321")
				);

		printJsonKeyValuePairs(json);
	}
}
