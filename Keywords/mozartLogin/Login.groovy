package mozartLogin

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.exception.StepErrorException
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory;
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI;

import internal.GlobalVariable
public class Login {

	@Keyword
	def static void launchBrowser() {
		String currentBrowser = DriverFactory.getExecutedBrowser().getName()
		println currentBrowser
		if (currentBrowser == 'CHROME_DRIVER') {
			ChromeOptions options = new ChromeOptions()
			options.addArguments('--disable-dev-shm-usage', '--disable-gpu', '--ignore-certificate-errors', '--no-sandbox')
			System.setProperty('webdriver.chrome.driver', DriverFactory.getChromeDriverPath())
			DriverFactory.changeWebDriver(new ChromeDriver(options))
			WebUI.deleteAllCookies()
		}

		else if (currentBrowser == 'EDGE_CHROMIUM_DRIVER') {
			try {
				EdgeOptions options = new EdgeOptions();
				// EdgeOptions doesn't have addArguments like ChromeOptions, so we set capabilities directly
				options.setCapability("disable-dev-shm-usage", true);
				options.setCapability("disable-gpu", true);
				options.setCapability("ignore-certificate-errors", true);
				options.setCapability("no-sandbox", true);

				// Retrieve the Edge driver path from Katalon
				String edgeDriverPath = DriverFactory.getEdgeDriverPath();

				// Check if the edgeDriverPath is not null to prevent NullPointerException
				if (edgeDriverPath != null) {
					System.setProperty('webdriver.edge.driver', edgeDriverPath);
					EdgeDriver driver = new EdgeDriver(options);
					DriverFactory.changeWebDriver(driver);  // Set the WebDriver in Katalon
					WebUI.deleteAllCookies();  // Clear all cookies to start fresh
				} else {
					throw new Exception("Edge driver path is null");
				}
			} catch (Exception e) {
				// Print error and throw the exception to mark the step as failed
				e.printStackTrace();
				throw new StepErrorException("Failed to launch Edge browser: " + e.getMessage());
			}
		}

		else {
			WebUI.openBrowser('')
			WebUI.deleteAllCookies()
		}
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(GlobalVariable.Mozart_URL)

		//Login Steps
		WebUI.sendKeys(findTestObject('EK_Objects/Page_Mozart - AirlinesHub/username_textBox'), GlobalVariable.Mozart_Username)
		WebUI.click(findTestObject('EK_Objects/Page_Mozart - AirlinesHub/next_button'))
		WebUI.setEncryptedText(findTestObject('EK_Objects/Page_Mozart - AirlinesHub/password_textBox'), GlobalVariable.Mozart_Passowrd)
		WebUI.click(findTestObject('EK_Objects/Page_Mozart - AirlinesHub/signIn_button'))
		WebUI.delay(15)
		selectAirline(GlobalVariable.Airline)
		WebUI.click(findTestObject('EK_Objects/Page_Mozart - AirlinesHub/btn_select'))
		WebUI.verifyElementText(findTestObject('EK_Objects/Page_Mozart - Dashboard/txt_dashboard'), 'Dashboard')
	}

	public static void selectAirline(String selectAirlineName) {

		int airlineList = WebUI.getNumberOfTotalOption(findTestObject('EK_Objects/Page_Mozart - AirlinesHub/pleaseSelect_button_selectTag'))
		WebUI.click(findTestObject('EK_Objects/Page_Mozart - AirlinesHub/pleaseSelect_Button'))
		println(airlineList)

		for (int i = 1; i < airlineList; i++) {
			String dynamicXPath = ('(//ul[@class=\'dropdown-menu inner show\']/li)[' + i) + ']'
			TestObject dynamicTestObject = new TestObject()
			dynamicTestObject.addProperty('xpath', ConditionType.EQUALS, dynamicXPath)
			String airlineName = WebUI.getText(dynamicTestObject)
			if(airlineName.equals(selectAirlineName)) {
				WebUI.click(dynamicTestObject)
				break
			}
			else {
				//KeywordUtil.markError('Please select valid Airline')
			}
		}
	}
}//class end
