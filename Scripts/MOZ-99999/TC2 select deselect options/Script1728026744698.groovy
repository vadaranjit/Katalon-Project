import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import java.text.SimpleDateFormat as SimpleDateFormat
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

String role = 'Admin'

String username = 'ranajitvadar'

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
List<WebElement> listOfUsers = WebUI.findWebElements(findTestObject('Object Repository/EK_Objects/Page_Mozart - AirlinesHub/getListOfUsers'), 
    10)
// Define base XPath with placeholders for row and column indices
String baseXPath = '(//table[@id=\'UsersList\']/tbody/tr[%d]/td[%d])'
for (int row = 1; row <= listOfUsers.size(); row++) {
    
    // Construct the dynamic XPath
    //int usernameColumn = 1

    String dynamicXPath = String.format(baseXPath, row, 1)

    // Find the element using the constructed XPath
    TestObject dynamicTestObject = new TestObject()

    dynamicTestObject.addProperty('xpath', ConditionType.EQUALS, dynamicXPath)

    WebElement usernameElement = WebUI.findWebElement(dynamicTestObject, 20)

    if (usernameElement != null) {
        if (usernameElement.getText().equals(username)) {
            println(listOfUsers.get(row - 1).getText())

            int edit_column = 8

            String dynamicXPath1 = String.format(baseXPath, row, edit_column)

            TestObject dynamicTestObject1 = new TestObject()

            dynamicTestObject1.addProperty('xpath', ConditionType.EQUALS, dynamicXPath1)

            WebElement editButtonElement = WebUI.findWebElement(dynamicTestObject1, 20)

            WebUI.scrollToElement(dynamicTestObject1, 10)

            WebUI.delay(2)

            editButtonElement.click()

            break
        }
    }
}

//Select Roles
WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - UserManagement/edit_user_roles'))

WebUI.deselectAllOption(findTestObject('Object Repository/EK_Objects/Page_Mozart - UserManagement/select_list_of_roles'))

WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - UserManagement/Roles_button_after_clear_all_options'))
    
WebUI.selectOptionByLabel(findTestObject('Object Repository/EK_Objects/Page_Mozart - UserManagement/select_list_of_roles'),role, true)
 

