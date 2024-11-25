import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Clear the email input field (if any value exists)
WebUI.clearText(findTestObject('Object Repository/EmailInput'))

// Trigger validation by submitting the form or moving focus out of the field
WebUI.click(findTestObject('Object Repository/SubmitButton'))

// Verify if the 'aria-invalid' attribute is set to 'true'
boolean isInvalid = WebUI.verifyAttribute(findTestObject('Object Repository/EmailInput'), 'aria-invalid', 'true', 10)

// Verify if the error message "Field required" is displayed
boolean isErrorDisplayed = WebUI.verifyElementPresent(findTestObject('Object Repository/EmailErrorMessage'), 10)

if (isInvalid && isErrorDisplayed) {
	println("Test Passed: Email field is marked as obligatory.")
} else {
	println("Test Failed: Email field is not correctly marked as obligatory.")
}

//-----------------------
//span[@id='EmailFormat_passengerEmail-error' and contains(text(),'Field required')]
//input[@id='EmailFormat_passengerEmail']
