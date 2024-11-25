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
import groovy.json.JsonOutput as JsonOutput

/*
Verify whether the table exists or not


select * from bdmozart.mi_pnr_waiver
select * from bdmozart.mi_pnr_waiver_remarks
select * from bdmozart.md_rfnd_pnr_waivers

*/
boolean mi_pnr_waiver = CustomKeywords.'database.DatabaseUtils.checkTableExists'('mi_pnr_waiver')

CustomKeywords.'utilityClass.CustomSoftAssert.assertTrue'(mi_pnr_waiver, 'The mi_pnr_waiver table should be available in the database.')

boolean mi_pnr_waiver_remarks = CustomKeywords.'database.DatabaseUtils.checkTableExists'('mi_pnr_waiver_remarks')

CustomKeywords.'utilityClass.CustomSoftAssert.assertTrue'(mi_pnr_waiver_remarks, 'The mi_pnr_waiver_remarks table should be available in the database.')

boolean md_rfnd_pnr_waivers = CustomKeywords.'database.DatabaseUtils.checkTableExists'('md_rfnd_pnr_waivers')

CustomKeywords.'utilityClass.CustomSoftAssert.assertTrue'(md_rfnd_pnr_waivers, 'The md_rfnd_pnr_waivers table should be available in the database.')

/*
 Verify whether the table content.

 select * from bdmozart.mc_endpoints_exposed
 select * from bdmozart.mc_file_type 
*/

//select * from bdmozart.mc_endpoints_exposed
String controller_name_column_row_value = CustomKeywords.'database.DBConnection.SQL'('select * from bdmozart.mc_endpoints_exposed where controller_name = \'PnrWaiverController\'','controller_name', 1)

CustomKeywords.'utilityClass.CustomSoftAssert.assertEquals'(controller_name_column_row_value, 'PnrWaiverController', 'Expected Column value is = PnrWaiverController')


//select * from bdmozart.mc_file_type
String description_column_row_value = CustomKeywords.'database.DBConnection.SQL'('select * from bdmozart.mc_file_type where code = \'MWF\'','description', 1)

CustomKeywords.'utilityClass.CustomSoftAssert.assertEquals'(description_column_row_value, 'Pnr Waiver File', 'Expected Column value is = Pnr Waiver File')

CustomKeywords.'utilityClass.CustomSoftAssert.assertAll'()

 



