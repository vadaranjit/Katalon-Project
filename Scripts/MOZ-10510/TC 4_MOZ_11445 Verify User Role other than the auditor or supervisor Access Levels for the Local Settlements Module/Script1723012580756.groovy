import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

//Select role Admin

//CustomKeywords.'utilityClass.GenericMethods.selectRoles'('ranajitvadar', 'Admin')
CustomKeywords.'utilityClass.GenericMethods.selectRoles'(GlobalVariable.MozartUser, 'Admin')

WebUI.delay(1)
WebUI.click(findTestObject('EK_Objects/Page_Mozart - Dashboard/a_Refunds'))
WebUI.verifyElementPresent(findTestObject('EK_Objects/Page_Mozart - Dashboard/Click_On_Local_Settlements'),2)

WebUI.closeBrowser()