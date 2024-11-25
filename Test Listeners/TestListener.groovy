import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

class TestListener {
	
//	@BeforeTestCase
//	def sampleBeforeTestCase(TestCaseContext testCaseContext)
//	 {
//		println 'Before TC'
//	}
//
//	
//	@AfterTestCase
//	def sampleAfterTestCase(TestCaseContext testCaseContext)
//	 {
//		println 'After TC'
//	
//	}
//
//	
//	@BeforeTestSuite
//	def sampleBeforeTestSuite(TestSuiteContext testSuiteContext) 
//	{
//		WebUI.openBrowser('')
//		
//		WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')
//		
//		WebUI.setText(findTestObject('Object Repository/Listeners Obj/Page_OrangeHRM/input_Username_username'), 'Admin')
//		
//		WebUI.setEncryptedText(findTestObject('Object Repository/Listeners Obj/Page_OrangeHRM/input_Password_password'), 'hUKwJTbofgPU9eVlw/CnDQ==')
//		
//		WebUI.click(findTestObject('Object Repository/Listeners Obj/Page_OrangeHRM/button_Login'))
//		println 'Before test suite'
//	}
//
//
//	@AfterTestSuite
//	def sampleAfterTestSuite(TestSuiteContext testSuiteContext) 
//	{
//		WebUI.closeBrowser()
//		println 'After test suite'
//	}
}