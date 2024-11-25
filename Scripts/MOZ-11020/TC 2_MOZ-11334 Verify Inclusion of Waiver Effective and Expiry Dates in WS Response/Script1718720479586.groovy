import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonOutput as JsonOutput
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

//API Connection Auth Token 
CustomKeywords.'apiRequests.apiConnection.runAuthToken'(findTestObject('API/Demo API/Auth Token'))

//Send PNR waiver request
def response = WS.sendRequest(findTestObject('API/MOZ_11020_API/pnr_waiver_request'))

def responseBody = response.getResponseText()

println(JsonOutput.prettyPrint(responseBody))

WS.verifyResponseStatusCode(response, 200)

// Parse the JSON response

JsonSlurper slurper = new JsonSlurper()

def jsonResponse = slurper.parseText(response.getResponseText())

// Verify that the fields 'waiver_expiry_date' and 'waiver_effective_date' are present
//Both dates are present in file so we can get from there or hard coded

CustomKeywords.'utilityClass.CustomSoftAssert.assertTrue'(jsonResponse.waiver_effective_date != null, 'waiver_effective_date is missing in the response')

CustomKeywords.'utilityClass.CustomSoftAssert.assertTrue'(jsonResponse.waiver_expiry_date != null, 'waiver_expiry_date is missing in the response')

CustomKeywords.'utilityClass.CustomSoftAssert.assertAll'()

