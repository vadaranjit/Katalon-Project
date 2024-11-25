package utilityClass
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.SimpleDateFormat
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
public class GenericMethods {

	//======================================================================================================================================
	/**
	 * Selects roles for a user based on the provided parameters.
	 * We need to call this method before login. This method selects the user role and closes the browser.
	 * In This method we can select single or multiple user roles.
	 * Example usage:
	 * <pre>
	 *     selectRoles('ranajitvadar', 'Auditor', 'Supervisor', 'Admin')
	 * </pre>
	 * @param username The username of the person for whom roles are being assigned.
	 * @param roles A variable number of roles to be assigned to the user. 
	 *              Possible roles include 'Auditor', 'Supervisor', 'Admin', etc.
	 * 
	 * @return A confirmation message indicating that the roles have been assigned.
	 * 
	 * @throws IllegalArgumentException if the username is null or empty, or if no roles are provided.
	 * 
	 */

	@Keyword
	static void selectRoles(String username , String... role) {
		WebUI.openBrowser('')

		WebUI.navigateToUrl(GlobalVariable.Mozart_URL)

		WebUI.maximizeWindow()

		WebUI.deleteAllCookies()

		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/ChromeAdvance/ClickOnAdvanceButton'))

		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/ChromeAdvance/ProccedLink'))

		WebUI.setText(findTestObject('Object Repository/Demo/MozartChrome/Page_/input_Username_Login'), GlobalVariable.Mozart_Username)

		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/Page_/button_Next'))

		WebUI.setEncryptedText(findTestObject('Object Repository/Demo/MozartChrome/Page_/input_Password_Password'), GlobalVariable.Mozart_Passowrd)

		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/Page_/button_Sign in'))

		//click on configuration
		WebUI.click(findTestObject('EK_Objects/Page_Mozart - AirlinesHub/configuration_dropDown'))

		WebUI.click(findTestObject('EK_Objects/Page_Mozart - AirlinesHub/users_button'))

		//main logic
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
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - UserManagement/save_button'))
		//return home page
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - UserManagement/home_hyperlink'))
		//Sign out
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - AirlinesHub/supermozart_Dropdown'))
		WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - AirlinesHub/sign_out_button'))
		//login with username
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/Demo/MozartChrome/Page_/input_Username_Login'), username)
		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/Page_/button_Next'))
		WebUI.setText(findTestObject('Object Repository/Demo/MozartChrome/Page_/input_Password_Password'), 'Accelya.1')
		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/Page_/button_Sign in'))

		//Select Airline
		//WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/Page_Mozart - AirlinesHub/button_Please select'))
		WebUI.delay(1)
		//		WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - AirlinesHub/a_176 Emirates'))
		//		WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - AirlinesHub/click_on_select_button'))
		println('close')
	}

	//======================================================================================================================================
	/**
	 * Generates a unique number based on the current date and time.
	 *
	 * This method creates a unique string by formatting the current date and time,
	 * removing spaces and colons, and storing the result in a global variable.
	 * The unique number is generated in the format 'yyyyMMddHHmmss', ensuring uniqueness
	 * based on the timestamp when the method is called.
	 *
	 * @return A unique string generated from the current date and time.
	 *
	 * @see GlobalVariable#UniqueNumber
	 *
	 * Example usage:
	 * <pre>
	 *     String uniqueNumber = UniqueNumberGenerator()
	 *     println("Generated Unique Number: " + uniqueNumber)
	 * </pre>
	 */
	@Keyword
	def static String UniqueNumberGenerator() {
		def date = new Date()
		def sdf = new SimpleDateFormat('yyyyMMdd HH:mm:ss')
		String z = sdf.format(date)
		String y = z.replace(' ', '')
		String x = y.replace(':', '')
		GlobalVariable.UniqueNumber = x
		println("UniqueNumber = "+GlobalVariable.UniqueNumber)
		return x
	}

	//======================================================================================================================================
	/**
	 * Scrolls the view to the left side of the table within a scrollable container.
	 * The horizontal scroll position is set to the far left (0 pixels).
	 */
	@Keyword
	public static void ScrollLeft() {
		WebUI.executeJavaScript("document.querySelector('.dataTables_scrollBody').scrollLeft = 0;", null)
	}

	/**
	 * Scrolls the view to the right side of the table within a scrollable container.
	 * The horizontal scroll position is set to 1000 pixels, assuming this moves to the far right of the table.
	 */
	@Keyword
	public static void scrollRight() {
		WebUI.executeJavaScript("document.querySelector('.dataTables_scrollBody').scrollLeft = 1000;", null)
	}

	/**
	 * Scrolls the view to the top of the table within a scrollable container.
	 * The vertical scroll position is set to the top (0 pixels).
	 */
	@Keyword
	public static void scrollUp() {
		WebUI.executeJavaScript("document.querySelector('.dataTables_scrollBody').scrollTop = 0;", null)
	}

	/**
	 * Scrolls the view downward within the table inside a scrollable container.
	 * The vertical scroll position is set to 200 pixels down from the top.
	 */
	@Keyword
	public static void scrollDown() {
		WebUI.executeJavaScript("document.querySelector('.dataTables_scrollBody').scrollTop = 200;", null)
	}

	//=============================================================================================================================
	@Keyword
	public String DateFormatter(String dateStr) {

		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy")
		LocalDate date = LocalDate.parse(dateStr, inputFormatter)
		String formattedDate = date.format(outputFormatter)
		System.out.println(formattedDate)
		return formattedDate
	}
}//class
