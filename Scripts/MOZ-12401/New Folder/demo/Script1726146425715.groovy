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

//WS Json Path
String filePath = 'Test Data/TKT Quote Json.txt'

//get Json and create key - json path and value - element value
String quoteResponse = new String(Files.readAllBytes(Paths.get(filePath)))

HashMap<String, String> wsMap = processJson.getJsonPathWithValues(quoteResponse)

//get Key- Json path for column and value - db value for column
HashMap<String, String> dbMap = processJson.getColumnsWithJsonPath1("mi_refund_ek_quote_tkt_refund_fare")


mi_refund_ek_quote_tkt_details = CustomKeywords.'database.DatabaseUtils.getColumnNamesAndValues'('select * from bdmozart.mi_refund_ek_quote_tkt_details where idpassenger = \'433\'')
//processJson.verifyJsonElementsValuesWithDatabaseValues1(mi_refund_ek_quote_tkt_details, dbMap, wsMap)
processJson.verifyJsonElementsValuesWithDatabaseValues2(dbMap,mi_refund_ek_quote_tkt_details)

//=====================================
mi_refund_ek_quote = CustomKeywords.'database.DatabaseUtils.getColumnNamesAndValues'("select * from bdmozart.mi_refund_ek_quote where idrequest = 'O090510005'")
println "mi_refund_ek_quote"
//processJson.verifyJsonElementsValuesWithDatabaseValues1(mi_refund_ek_quote, dbMap, wsMap)
//=====================================

mi_refund_ek_quote_passenger = CustomKeywords.'database.DatabaseUtils.getColumnNamesAndValues'("select * from bdmozart.mi_refund_ek_quote_passenger where idquote = '330'")
println "mi_refund_ek_quote_passenger"
//processJson.verifyJsonElementsValuesWithDatabaseValues1(mi_refund_ek_quote_passenger, dbMap, wsMap)
//=====================================

mi_refund_ek_quote_tkt_coupon_details = CustomKeywords.'database.DatabaseUtils.getColumnNamesAndValues'("select * from bdmozart.mi_refund_ek_quote_tkt_coupon_details where idtktdetails = '222'")
println "mi_refund_ek_quote_tkt_coupon_details"
//processJson.verifyJsonElementsValuesWithDatabaseValues1(mi_refund_ek_quote_tkt_coupon_details, dbMap, wsMap)
//=====================================

mi_refund_ek_quote_tkt_original_fare = CustomKeywords.'database.DatabaseUtils.getColumnNamesAndValues'("select * from bdmozart.mi_refund_ek_quote_tkt_original_fare where idtktdetails = '222'")
println "mi_refund_ek_quote_tkt_original_fare"
//processJson.verifyJsonElementsValuesWithDatabaseValues1(mi_refund_ek_quote_tkt_original_fare, dbMap, wsMap)
//=====================================

mi_refund_ek_quote_tkt_penalty_charges = CustomKeywords.'database.DatabaseUtils.getColumnNamesAndValues'("select * from bdmozart.mi_refund_ek_quote_tkt_penalty_charges where idtktdetails = '222'")
println "mi_refund_ek_quote_tkt_penalty_charges"
//processJson.verifyJsonElementsValuesWithDatabaseValues1(mi_refund_ek_quote_tkt_penalty_charges, dbMap, wsMap)
//=====================================

mi_refund_ek_quote_tkt_refund_fare = CustomKeywords.'database.DatabaseUtils.getColumnNamesAndValues'("select * from bdmozart.mi_refund_ek_quote_tkt_refund_fare  where idtktdetails = '222'")
println "mi_refund_ek_quote_tkt_refund_fare"
//processJson.verifyJsonElementsValuesWithDatabaseValues1(mi_refund_ek_quote_tkt_refund_fare, dbMap, wsMap)
processJson.verifyJsonElementsValuesWithDatabaseValues2(dbMap,mi_refund_ek_quote_tkt_refund_fare)
//=====================================

mi_refund_ek_quote_tkt_used_fare = CustomKeywords.'database.DatabaseUtils.getColumnNamesAndValues'("select * from bdmozart.mi_refund_ek_quote_tkt_used_fare where idtktdetails = '222'")
println "mi_refund_ek_quote_tkt_used_fare"
//processJson.verifyJsonElementsValuesWithDatabaseValues1(mi_refund_ek_quote_tkt_used_fare, dbMap, wsMap)
processJson.verifyJsonElementsValuesWithDatabaseValues2(dbMap,mi_refund_ek_quote_tkt_used_fare)
//=====================================

