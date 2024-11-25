package demoPackage

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class MozartLogin
{

	@Keyword
	def static void loginDemo()
	{
		System.out.println("Login Successfully")
		System.out.println("Login Successfully")
		System.out.println("Login Successfully")
		System.out.println("Login Successfully")
		System.out.println("Login Successfully")
	}

	@Keyword
	def static void LoginWithChrome()
	{
		//Browser CMD
		WebUI.openBrowser('')
		WebUI.navigateToUrl("https://accelyacomtest.accelya.local/MozartTest/AirlinesHub/Index")
		WebUI.maximizeWindow()
		//Click on advance
		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/ChromeAdvance/ClickOnAdvanceButton'))
		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/ChromeAdvance/ProccedLink'))
		// login details
		WebUI.setText(findTestObject('Object Repository/Demo/MozartChrome/Page_/input_Username_Login'), "supermozart")
		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/Page_/button_Next'))
		WebUI.setText(findTestObject('Object Repository/Demo/MozartChrome/Page_/input_Password_Password'), "Accelya.1")
		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/Page_/button_Sign in'))
		//Select Airline
		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/Page_Mozart - AirlinesHub/button_Please select'))
		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/Page_Mozart - AirlinesHub/span_134 Avianca'))
		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/Page_Mozart - AirlinesHub/a_Select'))
	}

	@Keyword
	def void LoginWithChromeForEK()
	{

		WebUI.openBrowser('')
		WebUI.navigateToUrl("https://accelyacomtest.accelya.local/MozartTest/AirlinesHub/Index")
		WebUI.maximizeWindow()
		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/ChromeAdvance/ClickOnAdvanceButton'))
		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/ChromeAdvance/ProccedLink'))
		WebUI.setText(findTestObject('Object Repository/Demo/MozartChrome/Page_/input_Username_Login'), "supermozart")
		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/Page_/button_Next'))
		WebUI.setText(findTestObject('Object Repository/Demo/MozartChrome/Page_/input_Password_Password'), "Accelya.1")
		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/Page_/button_Sign in'))
		//Select Airline
		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/Page_Mozart - AirlinesHub/button_Please select'))
		WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - AirlinesHub/a_176 Emirates'))
		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/Page_Mozart - AirlinesHub/a_Select'))
	}

	@Keyword
	def void mozartLoginWithUser()
	{

		WebUI.openBrowser('')
		WebUI.navigateToUrl("https://accelyacomtest.accelya.local/MozartTest/AirlinesHub/Index")
		WebUI.maximizeWindow()
		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/ChromeAdvance/ClickOnAdvanceButton'))
		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/ChromeAdvance/ProccedLink'))
		WebUI.setText(findTestObject('Object Repository/Demo/MozartChrome/Page_/input_Username_Login'), "ranajitvadar")
		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/Page_/button_Next'))
		WebUI.setText(findTestObject('Object Repository/Demo/MozartChrome/Page_/input_Password_Password'), "Accelya.1")
		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/Page_/button_Sign in'))
	}

	@Keyword
	def static void LoginForAll()
	{
		//Browser CMD
		WebUI.openBrowser('')
		WebUI.navigateToUrl("https://accelyacomtest.accelya.local/MozartTest/AirlinesHub/Index")
		WebUI.maximizeWindow()
		//Click on advance
		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/ChromeAdvance/ClickOnAdvanceButton'), FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/ChromeAdvance/ProccedLink'), FailureHandling.CONTINUE_ON_FAILURE)
		// login details
		WebUI.setText(findTestObject('Object Repository/Demo/MozartChrome/Page_/input_Username_Login'), "supermozart")
		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/Page_/button_Next'))
		WebUI.setText(findTestObject('Object Repository/Demo/MozartChrome/Page_/input_Password_Password'), "Accelya.1")
		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/Page_/button_Sign in'))
		//Select Airline
		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/Page_Mozart - AirlinesHub/button_Please select'))
		WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - AirlinesHub/a_176 Emirates'))
		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/Page_Mozart - AirlinesHub/a_Select'))
	}
}
