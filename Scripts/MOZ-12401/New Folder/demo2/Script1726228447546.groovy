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
import utilityClass.JsonPaths as JsonPaths
import org.openqa.selenium.Keys as Keys
import java.nio.file.Files as Files
import java.nio.file.Paths as Paths
import java.io.IOException as IOException

JsonPaths processJson = new JsonPaths()

String filePath = 'Test Data/TKT Quote Json.txt'

//get Key- Json path for column and value - db value for column
HashMap<String, String> dbMap = processJson.getColumnsWithJsonPath1("mi_refund_ek_quote_tkt_original_fare")
HashMap<String, String> mi_refund_ek_quote_tkt_original_fare = CustomKeywords.'database.DatabaseUtils.getColumnNamesAndValues'("select * from bdmozart.mi_refund_ek_quote_tkt_original_fare where idtktdetails = '222'")
processJson.verifyJsonElementsValuesWithDatabaseValues2(filePath,dbMap,mi_refund_ek_quote_tkt_original_fare)
println "======================================================"
//get Key- Json path for column and value - db value for column
HashMap<String, String> dbMap1 = processJson.getColumnsWithJsonPath1("mi_refund_ek_quote_tkt_refund_fare")
HashMap<String, String> mi_refund_ek_quote_tkt_refund_fare = CustomKeywords.'database.DatabaseUtils.getColumnNamesAndValues'("select * from bdmozart.mi_refund_ek_quote_tkt_refund_fare  where idtktdetails = '222'")
processJson.verifyJsonElementsValuesWithDatabaseValues2(filePath,dbMap1,mi_refund_ek_quote_tkt_refund_fare)
println "======================================================"
//get Key- Json path for column and value - db value for column
HashMap<String, String> dbMap2 = processJson.getColumnsWithJsonPath1("mi_refund_ek_quote_tkt_used_fare")
HashMap<String, String> mi_refund_ek_quote_tkt_used_fare = CustomKeywords.'database.DatabaseUtils.getColumnNamesAndValues'("select * from bdmozart.mi_refund_ek_quote_tkt_used_fare where idtktdetails = '222'")
processJson.verifyJsonElementsValuesWithDatabaseValues2(filePath,dbMap2,mi_refund_ek_quote_tkt_used_fare)

