import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint

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
import org.openqa.selenium.Keys as Keys


import org.openqa.selenium.Dimension
import org.openqa.selenium.JavascriptExecutor
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory


import org.testng.asserts.SoftAssert;
SoftAssert softAssertion = new SoftAssert();


String Passenger_Remarks_text = CustomKeywords.'demoPackage.UtilityDemo.requestNumber'()

String requestID = CustomKeywords.'database.DBConnection.SQL'("select * from bdmozart.mi_refund_capture_main where agentremarks ="+Passenger_Remarks_text,'idrequest', 1)

println requestID
//// Katalon Code
//
//println '1------'
//softAssertion.assertTrue(true);
//
//println '2------'
//softAssertion.assertTrue(false);
//
//println '3------'
//softAssertion.assertTrue(false);
//
//println '4------'
//softAssertion.assertEquals('Google', 'Bing')
//
//println '5------'
//softAssertion.assertAll();

//CustomKeywords.'demoPackage.MozartLogin.LoginWithChromeForEK'()
//
//WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - Dashboard/a_Refunds'))
//
//WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - Dashboard/a_Refund Capture'))
//
//WebUI.selectOptionByValue(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/SelectRefundTypes'), 'RF_Both', false)
//
//WebUI.setText(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/EnterDocumentNumber'), '6747279570')
//
//WebUI.click(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/DocumentSearchButton'))
//
//WebUI.scrollToElement(findTestObject('Object Repository/EK_Objects/Page_Mozart - RefundsCapture/Bank details header'), 30)




//=======================================================================================================================
//var element = document.getElementById("box");
//testObject element = findTestObject('Object Repository/EK_Objects/Page_Mozart - RefundsCapture/Bank details header')

//element.scrollIntoView();
//element.scrollIntoView(false);
//element.scrollIntoView({ block: "end" });
//element.scrollIntoView({ behavior: "smooth", block: "end", inline: "nearest" });

//=======================================================================================================================
//// Get the JavaScript executor
//JavascriptExecutor js = DriverFactory.getWebDriver()
//
//// Find the left slider element (you need to replace 'leftSliderLocator' with the actual locator of your left slider)
////WebElement leftSlider = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/EK_Objects/Page_Mozart - RefundsCapture/Bank details header'))
//TestObject leftSlider = findTestObject('Object Repository/EK_Objects/Page_Mozart - RefundsCapture/Bank details header')
//// Get the location of the left slider element
//int leftSliderLocation = leftSlider.getLocation().getX()
//int leftSliderLocation = leftSlider.
//
//
//// Scroll to the position of the left slider
//js.executeScript("window.scrollTo(0, arguments[0])", leftSliderLocation)

/*
 
  WebUI.scrollToElement(findTestObject('EK_Objects/Page_Mozart - RefundsCapture/Bank Country'), 30)

TestObject bankCountryBox = findTestObject('EK_Objects/Page_Mozart - RefundsCapture/Bank Country')

WebElement dropdownElement = WebUiCommonHelper.findWebElement(bankCountryBox, 30)

Select selectBankCountry = new Select(bankCountryBox)

selectBankCountry.selectByIndex(3)

The error groovy.lang.MissingPropertyException: No such property typically occurs when you try to access a property or variable that doesn't exist in the current context or scope. In this case, the error specifically mentions the property AD not being found in the class Script1714989585492.

Here are some common scenarios where you might encounter this error:

Misspelled Property: Double-check that you spelled the property correctly. Groovy is case-sensitive, so AD, ad, and Ad would be considered different properties.
Undefined Property: If you're trying to access a property that hasn't been defined or initialized in your script, you'll get this error. Ensure that you've declared the property or that it exists in the context you're referencing it.
Accessing Property of Null Object: If you're trying to access a property of an object that is null, you'll get this error. Make sure the object is properly initialized before accessing its properties.
Scope Issues: If you're trying to access a property from a different scope where it's not defined or accessible, you'll encounter this error. Check that the property is defined in the correct scope.
Dynamic Property Access: Groovy allows dynamic property access, so it's possible to access properties that don't exist at compile-time. However, if the property doesn't exist at runtime, you'll get this error.
To resolve this issue, review your code and ensure that the property AD is properly defined, spelled correctly, and accessible in the current context. If you're accessing a property dynamically, make sure it exists at runtime.







  
 */
