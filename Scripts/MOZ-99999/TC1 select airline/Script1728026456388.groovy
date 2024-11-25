import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


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

println WebUI.getText(findTestObject('EK_Objects/Page_Mozart - AirlinesHub/pleaseSelect_button_selectTag'))

WebUI.selectOptionByLabel(findTestObject('EK_Objects/Page_Mozart - AirlinesHub/pleaseSelect_button_selectTag'), '134 [Avianca]', false)


//-------------------------------------------------------------------------------------------------
WebElement dropdownElement = WebUiCommonHelper.findWebElement(findTestObject('EK_Objects/Page_Mozart - AirlinesHub/pleaseSelect_button_selectTag'), 30)

Select select = new Select(dropdownElement)

WebUI.selectOptionByLabel(findTestObject, null, false) //select.selectByVisibleText("Option Text")

WebUI.selectOptionByValue(findTestObject, null, false)//select.selectByValue("OptionValue")

WebUI.selectOptionByIndex(findTestObject, findTestCase)//select.selectByIndex(1)
