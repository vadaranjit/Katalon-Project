//import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
//import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
//import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
//import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
//
//import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
//import com.kms.katalon.core.model.FailureHandling as FailureHandling
//import com.kms.katalon.core.testcase.TestCase as TestCase
//import com.kms.katalon.core.testdata.TestData as TestData
//import com.kms.katalon.core.testobject.TestObject as TestObject
//
//import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
//import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
//import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
//
//import internal.GlobalVariable as GlobalVariable
//
//import com.kms.katalon.core.annotation.BeforeTestCase
//import com.kms.katalon.core.annotation.BeforeTestSuite
//import com.kms.katalon.core.annotation.AfterTestCase
//import com.kms.katalon.core.annotation.AfterTestSuite
//import com.kms.katalon.core.context.TestCaseContext
//import com.kms.katalon.core.context.TestSuiteContext
//
//class TestListener_Mozart {
//	
//	@BeforeTestSuite
//	def sampleBeforeTestSuite()
//	{
//		WebUI.openBrowser('')
//		WebUI.navigateToUrl("https://accelyacomtest.accelya.local/MozartTest/AirlinesHub/Index")
//		WebUI.maximizeWindow()
//		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/ChromeAdvance/ClickOnAdvanceButton'))
//		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/ChromeAdvance/ProccedLink'))
//		WebUI.setText(findTestObject('Object Repository/Demo/MozartChrome/Page_/input_Username_Login'), "supermozart")
//		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/Page_/button_Next'))
//		WebUI.setText(findTestObject('Object Repository/Demo/MozartChrome/Page_/input_Password_Password'), "Accelya.1")
//		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/Page_/button_Sign in'))
//		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/Page_Mozart - AirlinesHub/button_Please select'))
//		WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - AirlinesHub/a_176 Emirates'))
//		WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/Page_Mozart - AirlinesHub/a_Select'))
//		Thread.sleep(2000)
//		
//		println 'Before test suite'
//	}
//
//
//	@AfterTestSuite
//	def sampleAfterTestSuite()
//	{
//		WebUI.closeBrowser()
//		
//		println 'After test suite'
//	}
//	
//	@BeforeTestCase
//	def sampleBeforeTestCase()
//	 {
//		Thread.sleep(2000)
//		boolean val = WebUI.verifyElementText(findTestObject('Object Repository/EK_Objects/Page_Mozart - Dashboard/Dashboard text'), 'Dashboard')
//		if(val)
//			 {
//				 ;
//			 }
//		else 
//			{
//				WebUI.closeBrowser()
//				WebUI.openBrowser('')
//				WebUI.navigateToUrl("https://accelyacomtest.accelya.local/MozartTest/AirlinesHub/Index")
//				WebUI.maximizeWindow()
//				WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/ChromeAdvance/ClickOnAdvanceButton'))
//				WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/ChromeAdvance/ProccedLink'))
//				WebUI.setText(findTestObject('Object Repository/Demo/MozartChrome/Page_/input_Username_Login'), "supermozart")
//				WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/Page_/button_Next'))
//				WebUI.setText(findTestObject('Object Repository/Demo/MozartChrome/Page_/input_Password_Password'), "Accelya.1")
//				WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/Page_/button_Sign in'))
//				WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/Page_Mozart - AirlinesHub/button_Please select'))
//				WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - AirlinesHub/a_176 Emirates'))
//				WebUI.click(findTestObject('Object Repository/Demo/MozartChrome/Page_Mozart - AirlinesHub/a_Select'))
//			}
//			
//		println 'Before TC'
//	 }
//
//	
//	@AfterTestCase
//	def sampleAfterTestCase()
//	 {
//		Thread.sleep(2000)
//		WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - Dashboard/Goto Home Page Obj'))
//		println 'After TC'
//	}
//
//}