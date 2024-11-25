import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//CustomKeywords.'demoPackage.MozartLogin.LoginWithChromeForEK'()
CustomKeywords.'mozartLogin.Login.launchBrowser'()

WebUI.click(findTestObject('EK_Objects/Page_Mozart - Dashboard/a_Refunds'))

WebUI.click(findTestObject('EK_Objects/Page_Mozart - Dashboard/Click_On_Local_Settlements'))

WebUI.delay(3)
CustomKeywords.'utilityClass.GenericMethods.scrollRight'()


//WebUI.closeBrowser()

