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

//API Connection Auth Token
CustomKeywords.'apiRequests.apiConnection.runAuthToken'(findTestObject('API/Demo API/Auth Token'))

String uniqueNumber = CustomKeywords.'utilityClass.GenericMethods.UniqueNumberGenerator'()

def pnrWaiverResponse = WS.sendRequest(findTestObject('API/MOZ_11020_API/moz_11533_pnr_waiver_request'))
WS.verifyResponseStatusCode(pnrWaiverResponse, 200)
CustomKeywords.'demoPackage.UtilityDemo.requestNumber'()

//API Connection Auth Token
CustomKeywords.'apiRequests.apiConnection.runAuthToken'(findTestObject('API/Demo API/Auth Token'))

def fullRefundResponse = WS.sendRequest(findTestObject('API/MOZ_11020_API/moz_11533_full_refund'))
WS.verifyResponseStatusCode(fullRefundResponse, 200)

/*
select * from bdmozart.mi_pnr_waiver
select * from bdmozart.mi_pnr_waiver_remarks order by id desc
select * from bdmozart.md_rfnd_pnr_waivers 
*/

String waiverId = null
for(int i = 1; i <= 6;i++ ) 
	{
String remarksText = CustomKeywords.'database.DBConnection.executeQuerys'('mozart_avianca','select * from bdmozart.mi_pnr_waiver_remarks order by id desc', 'remarkstext', i)
if(remarksText.equals(uniqueNumber)) 
	{
		waiverId = CustomKeywords.'database.DBConnection.executeQuerys'('mozart_avianca','select * from bdmozart.mi_pnr_waiver_remarks order by id desc', 'waiver_id', i)
		break
	}
	

	}
//If remark is not present in DB than test case fail	
CustomKeywords.'utilityClass.CustomSoftAssert.assertTrue'((waiverId != null), 'remark is not present in DB')
	
String documentNo = CustomKeywords.'database.DBConnection.executeQuerys'('mozart_avianca',"select * from bdmozart.mi_pnr_waiver where id = "+waiverId, 'document', 1)
//its fail when Document number is not matching
CustomKeywords.'utilityClass.CustomSoftAssert.assertTrue'(documentNo.equals('2100475785'), 'The document number is different')

//Linking idrequest with waiver id
String idRequest = CustomKeywords.'database.DBConnection.executeQuerys'('mozart_avianca','select * from bdmozart.md_rfnd_pnr_waivers where idmipnrwaiver ='+ waiverId,'idrequest',1)
println (idRequest)

CustomKeywords.'utilityClass.CustomSoftAssert.assertAll'()