package utilityClass

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import groovy.json.JsonSlurper


public class demoPackage {
	@Keyword
	static void selectRoless(String username , String... role) {
		List<WebElement> listOfUsers = WebUI.findWebElements(findTestObject('Object Repository/EK_Objects/Page_Mozart - AirlinesHub/getListOfUsers'), 10)

		for(int row = 1 ; row <= listOfUsers.size(); row++ ) {
			// Define base XPath with placeholders for row and column indices

			String baseXPath = "(//table[@id='UsersList']/tbody/tr[%d]/td[%d])"

			// Construct the dynamic XPath
			int usernameColumn = 1;
			String dynamicXPath = String.format(baseXPath,row, usernameColumn)

			// Find the element using the constructed XPath
			TestObject dynamicTestObject = new TestObject()
			dynamicTestObject.addProperty("xpath", ConditionType.EQUALS, dynamicXPath)
			WebElement usernameElement = WebUI.findWebElement(dynamicTestObject, 20)

			if (usernameElement != null) {
				if(usernameElement.getText().equals(username)) {
					println( listOfUsers.get(row-1).getText() )
					int edit_column = 8;
					String dynamicXPath1 = String.format(baseXPath,row, edit_column)
					TestObject dynamicTestObject1 = new TestObject()
					dynamicTestObject1.addProperty("xpath", ConditionType.EQUALS, dynamicXPath1)
					WebElement editButtonElement = WebUI.findWebElement(dynamicTestObject1, 20)
					WebUI.scrollToElement(dynamicTestObject1, 10)
					WebUI.delay(2)
					editButtonElement.click()
					break;
				}
			}
		}

		//Select Roles
		WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - UserManagement/edit_user_roles'))
		WebUI.deselectAllOption(findTestObject('Object Repository/EK_Objects/Page_Mozart - UserManagement/select_list_of_roles'))
		WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - UserManagement/Roles_button_after_clear_all_options'))

		for(String roles : role) {
			WebUI.selectOptionByLabel(findTestObject('Object Repository/EK_Objects/Page_Mozart - UserManagement/select_list_of_roles'), roles , true)
		}
	}

	//=========================================================================================================================================================
	//	{
	//		"name": "John",
	//		"address": {
	//			"street": "123 Main St",
	//			"city": "Anytown"
	//		},
	//		"phones": ["123-4567", "987-6543"]
	//	}


	/**
	 * This function recursively traverses a JSON object and prints all key-value pairs.
	 * @param jsonObject The parsed JSON object
	 * @param parentKey The key of the parent element, used for nested keys (initially an empty string)
	 */
	public static HashMap<String, String> printJsonKeyValuePairs(def jsonObject, String parentKey = '') {
		HashMap<String, String> map = new HashMap<>();
		jsonObject.each {  key, value ->
			//id , value =
			// Construct the full key path
			String fullKey = parentKey ? "${parentKey}.${key}" : key  //fullkey = id

			// Check if the value is a nested object or an array
			if (value instanceof Map) {
				// If the value is a Map, recursively call the function
				printJsonKeyValuePairs(value, fullKey)
			}
			else if (value instanceof List) {
				// If the value is a List, iterate through the list
				value.eachWithIndex { listItem, index ->
					// Recursively call the function for each item in the list
					printJsonKeyValuePairs(listItem, "${fullKey}[${index}]")
				}
			}
			else {
				// Print the key-value pair
				println "${fullKey}: ${value}"

				map.put("${value}","${fullKey}")
			}
		}

		return map
	}


	//-------------------------------------------java code---------------------------------------------------------------


	//--------------------------------------------------------------------------------------------------------------

	/**
	 * Main function to handle the JSON string.
	 * @param jsonBody The JSON string
	 */
	@Keyword
	public static HashMap<String, String> processJson(String jsonBody) {
		HashMap<String, String> map = new HashMap<>();
		def slurper = new JsonSlurper()
		def parsedJson = slurper.parseText(jsonBody)

		// Print all key-value pairs
		map = printJsonKeyValuePairs1(parsedJson,"")
		return map
	}


	//=========================================================================================================================================================


	public static HashMap<String, String> printJsonKeyValuePairs1(Object jsonObject, String parentKey) {
		HashMap<String, String> map = new HashMap<>();

		// Check if jsonObject is a Map (i.e., JSON object)
		if (jsonObject instanceof Map) {
			Map<String, Object> jsonMap = (Map<String, Object>) jsonObject;

			// Iterate over the entries in the JSON object
			for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
				String key = entry.getKey();
				Object value = entry.getValue();

				// Construct the full key path
				String fullKey = (parentKey != null && !parentKey.isEmpty()) ? parentKey + "." + key : key;

				// If the value is a nested Map (another JSON object), call recursively
				if (value instanceof Map) {
					map.putAll(printJsonKeyValuePairs1(value, fullKey));
				}
				// If the value is a List, iterate over the list and process each element
				else if (value instanceof List) {
					List<Object> list = (List<Object>) value;
					for (int i = 0; i < list.size(); i++) {
						map.putAll(printJsonKeyValuePairs1(list.get(i), fullKey + "[" + i + "]"));
					}
				}
				// Otherwise, store the key-value pair
				else {
					System.out.println(fullKey + ": " + value);
					map.put(fullKey, value.toString());
				}
			}
		}

		return map;
	}




	//==================================================================================================================================
}// class end
