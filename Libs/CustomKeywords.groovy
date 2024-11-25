
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import javax.mail.Message

import java.util.Map

import com.kms.katalon.core.testobject.TestObject

import com.kms.katalon.core.model.FailureHandling

import java.lang.Object

import java.util.List

import com.kms.katalon.core.context.TestSuiteContext

import com.kms.katalon.core.context.TestCaseContext



def static "mozartLogin.Login.launchBrowser"() {
    (new mozartLogin.Login()).launchBrowser()
}


def static "demoPackage.UtilityDemo.requestNumber"() {
    (new demoPackage.UtilityDemo()).requestNumber()
}


def static "demoPackage.UtilityDemo.getFilePath"(
    	String filePath	) {
    (new demoPackage.UtilityDemo()).getFilePath(
        	filePath)
}


def static "demoPackage.UtilityDemo.readFileName"(
    	String folderPath	) {
    (new demoPackage.UtilityDemo()).readFileName(
        	folderPath)
}


def static "demoPackage.UtilityDemo.timeStamp"(
    	String filePath	) {
    (new demoPackage.UtilityDemo()).timeStamp(
        	filePath)
}


def static "demoPackage.UtilityDemo.modifyFileName"(
    	String filename	) {
    (new demoPackage.UtilityDemo()).modifyFileName(
        	filename)
}


def static "demoPackage.UtilityDemo.establishDatabaseConnection"() {
    (new demoPackage.UtilityDemo()).establishDatabaseConnection()
}


def static "customKeywords.OutlookEmailReader.connectToOutlook"(
    	String username	
     , 	String password	) {
    (new customKeywords.OutlookEmailReader()).connectToOutlook(
        	username
         , 	password)
}


def static "customKeywords.OutlookEmailReader.getEmails"(
    	String username	
     , 	String password	
     , 	String folderName	) {
    (new customKeywords.OutlookEmailReader()).getEmails(
        	username
         , 	password
         , 	folderName)
}


def static "customKeywords.OutlookEmailReader.getTextFromMessage"(
    	Message message	) {
    (new customKeywords.OutlookEmailReader()).getTextFromMessage(
        	message)
}


def static "customKeywords.OutlookEmailReader.getEmails"(
    	String username	
     , 	String password	) {
    (new customKeywords.OutlookEmailReader()).getEmails(
        	username
         , 	password)
}


def static "fileOperations.FileUtils.copyFileWithUniqueName"() {
    (new fileOperations.FileUtils()).copyFileWithUniqueName()
}


def static "fileOperations.FileUtils.copyFileWithUniqueNameDemo"(
    	String sourceFilePath	
     , 	String destinationDirPath	
     , 	String processedFile	) {
    (new fileOperations.FileUtils()).copyFileWithUniqueNameDemo(
        	sourceFilePath
         , 	destinationDirPath
         , 	processedFile)
}


def static "fileOperations.FileUtils.copyFileWithUniqueNameDemo1"() {
    (new fileOperations.FileUtils()).copyFileWithUniqueNameDemo1()
}


def static "utilityClass.GenericMethods.selectRoles"(
    	String username	
     , 	String[] role	) {
    (new utilityClass.GenericMethods()).selectRoles(
        	username
         , 	role)
}


def static "utilityClass.GenericMethods.UniqueNumberGenerator"() {
    (new utilityClass.GenericMethods()).UniqueNumberGenerator()
}


def static "utilityClass.GenericMethods.ScrollLeft"() {
    (new utilityClass.GenericMethods()).ScrollLeft()
}


def static "utilityClass.GenericMethods.scrollRight"() {
    (new utilityClass.GenericMethods()).scrollRight()
}


def static "utilityClass.GenericMethods.scrollUp"() {
    (new utilityClass.GenericMethods()).scrollUp()
}


def static "utilityClass.GenericMethods.scrollDown"() {
    (new utilityClass.GenericMethods()).scrollDown()
}


def static "utilityClass.GenericMethods.DateFormatter"(
    	String dateStr	) {
    (new utilityClass.GenericMethods()).DateFormatter(
        	dateStr)
}


def static "utilityClass.JsonPaths.JsonStringFormatter"(
    	String filePath	) {
    (new utilityClass.JsonPaths()).JsonStringFormatter(
        	filePath)
}


def static "utilityClass.JsonPaths.verifyJsonElementsValuesWithDatabaseValues"(
    	String filePath	
     , 	java.util.Map<String, String> dbMap	
     , 	String sqlQuery	) {
    (new utilityClass.JsonPaths()).verifyJsonElementsValuesWithDatabaseValues(
        	filePath
         , 	dbMap
         , 	sqlQuery)
}


def static "utilityClass.JsonPaths.verifyBlankDatabaseValues"(
    	String sqlQuery	) {
    (new utilityClass.JsonPaths()).verifyBlankDatabaseValues(
        	sqlQuery)
}


def static "utilityClass.JsonPaths.getColumnsWithJsonPath"(
    	String tableName	
     , 	String rootElement	) {
    (new utilityClass.JsonPaths()).getColumnsWithJsonPath(
        	tableName
         , 	rootElement)
}


def static "utilityClass.JsonPaths.getColumnsWithJsonPath"(
    	String tableName	) {
    (new utilityClass.JsonPaths()).getColumnsWithJsonPath(
        	tableName)
}


def static "database.DBConnection.connectDB"() {
    (new database.DBConnection()).connectDB()
}


def static "database.DBConnection.mozartAirline"(
    	String databaseName	) {
    (new database.DBConnection()).mozartAirline(
        	databaseName)
}


def static "database.DBConnection.SQL"(
    	String sql_query	
     , 	String column_name	
     , 	int row_num	) {
    (new database.DBConnection()).SQL(
        	sql_query
         , 	column_name
         , 	row_num)
}


def static "database.DBConnection.executeQuerys"(
    	String database_name	
     , 	String sql_query	
     , 	String column_name	
     , 	int row_num	) {
    (new database.DBConnection()).executeQuerys(
        	database_name
         , 	sql_query
         , 	column_name
         , 	row_num)
}

 /**
	 * Asserts that a condition is true.
	 *
	 * If the condition is false, an assertion error is collected to be reported at the end of the test.
	 *
	 * @param condition The condition to evaluate.
	 * @param message The message to include in the assertion error if the condition is false.
	 */ 
def static "utilityClass.CustomSoftAssert.assertTrue"(
    	boolean condition	
     , 	String message	) {
    (new utilityClass.CustomSoftAssert()).assertTrue(
        	condition
         , 	message)
}

 /**
	 * Asserts that two strings are equal.
	 *
	 * If the strings are not equal, an assertion error is collected to be reported at the end of the test.
	 *
	 * @param actual The actual string value.
	 * @param expected The expected string value.
	 * @param message The message to include in the assertion error if the strings are not equal.
	 */ 
def static "utilityClass.CustomSoftAssert.assertEquals"(
    	String actual	
     , 	String expected	
     , 	String message	) {
    (new utilityClass.CustomSoftAssert()).assertEquals(
        	actual
         , 	expected
         , 	message)
}

 /**
	 * Asserts that all collected soft assertions are validated.
	 *
	 * This method should be called at the end of a test to report all collected assertion errors.
	 */ 
def static "utilityClass.CustomSoftAssert.assertAll"() {
    (new utilityClass.CustomSoftAssert()).assertAll()
}


def static "demoPackage.demo.DEMOreadFileName"() {
    (new demoPackage.demo()).DEMOreadFileName()
}


def static "utilityClass.DynamicJSONHandler.dynamicJSONHandler"() {
    (new utilityClass.DynamicJSONHandler()).dynamicJSONHandler()
}


def static "database.DatabaseUtils.checkTableExists"(
    	String tableName	) {
    (new database.DatabaseUtils()).checkTableExists(
        	tableName)
}


def static "database.DatabaseUtils.checkColumnExist"(
    	String tableName	
     , 	String columnName	) {
    (new database.DatabaseUtils()).checkColumnExist(
        	tableName
         , 	columnName)
}


def static "database.DatabaseUtils.getAllColumnNamesFromTable"(
    	String tableName	) {
    (new database.DatabaseUtils()).getAllColumnNamesFromTable(
        	tableName)
}

 /**
	 * Executes a SQL query and retrieves a specific column value from a specified row in the result set.
	 *
	 * @param sql_query The SQL query to be executed.
	 * @param column_name The name of the column from which to retrieve the value.
	 * @param row_num The row number from which to retrieve the value (1-based index).
	 * @return The value from the specified column and row as a String, or null if the connection fails.
	 *
	 * @throws SQLException If a database access error occurs or the SQL query is incorrect.
	 * @throws IllegalArgumentException If the column_name or row_num are invalid.
	 *
	 * Example:
	 * <pre>
	 * {@code
	 * String result = CustomKeywords.'your.package.name.executeQuery'('SELECT * FROM yourTable', 'columnName', row_number);
	 * }
	 * </pre>
	 */ 
def static "database.DatabaseUtils.executeQuery"(
    	String sql_query	
     , 	String column_name	
     , 	int row_num	) {
    (new database.DatabaseUtils()).executeQuery(
        	sql_query
         , 	column_name
         , 	row_num)
}


def static "database.DatabaseUtils.getRowCount"(
    	String sql_query	) {
    (new database.DatabaseUtils()).getRowCount(
        	sql_query)
}


def static "database.DatabaseUtils.getColumnCount"(
    	String sql_query	) {
    (new database.DatabaseUtils()).getColumnCount(
        	sql_query)
}


def static "database.DatabaseUtils.getColumnNamesAndValues"(
    	String tableName	) {
    (new database.DatabaseUtils()).getColumnNamesAndValues(
        	tableName)
}


def static "database.DatabaseUtils.executeQueryDemo"(
    	String sql_query	
     , 	String column_name	
     , 	int row_num	) {
    (new database.DatabaseUtils()).executeQueryDemo(
        	sql_query
         , 	column_name
         , 	row_num)
}


def static "utilityClass.demoPackage.selectRoless"(
    	String username	
     , 	String[] role	) {
    (new utilityClass.demoPackage()).selectRoless(
        	username
         , 	role)
}

 /**
	 * Main function to handle the JSON string.
	 * @param jsonBody The JSON string
	 */ 
def static "utilityClass.demoPackage.processJson"(
    	String jsonBody	) {
    (new utilityClass.demoPackage()).processJson(
        	jsonBody)
}


def static "apiRequests.apiConnection.getJsonKeyValue1"(
    	Object requestObject	
     , 	String keyName	) {
    (new apiRequests.apiConnection()).getJsonKeyValue1(
        	requestObject
         , 	keyName)
}


def static "apiRequests.apiConnection.runAuthToken"(
    	TestObject authObject	) {
    (new apiRequests.apiConnection()).runAuthToken(
        	authObject)
}


def static "apiRequests.apiConnection.getJsonKeyValue"(
    	Object requestObject	
     , 	String keyName	) {
    (new apiRequests.apiConnection()).getJsonKeyValue(
        	requestObject
         , 	keyName)
}


def static "apiRequests.apiConnection.addBasicAuthorizationProperty"(
    	TestObject request	) {
    (new apiRequests.apiConnection()).addBasicAuthorizationProperty(
        	request)
}


def static "utilityClass.demo.getJsonPathWithValues"(
    	String jsonBody	) {
    (new utilityClass.demo()).getJsonPathWithValues(
        	jsonBody)
}


def static "utilityClass.demo.verifyJsonElementsValuesWithDatabaseValues"(
    	String filePath	
     , 	java.util.Map<String, String> dbMap	
     , 	String sqlQuery	) {
    (new utilityClass.demo()).verifyJsonElementsValuesWithDatabaseValues(
        	filePath
         , 	dbMap
         , 	sqlQuery)
}


def static "utilityClass.demo.getColumnsWithJsonPath"(
    	String tableName	) {
    (new utilityClass.demo()).getColumnsWithJsonPath(
        	tableName)
}


def static "demoPackage.MozartLogin.loginDemo"() {
    (new demoPackage.MozartLogin()).loginDemo()
}


def static "demoPackage.MozartLogin.LoginWithChrome"() {
    (new demoPackage.MozartLogin()).LoginWithChrome()
}


def static "demoPackage.MozartLogin.LoginWithChromeForEK"() {
    (new demoPackage.MozartLogin()).LoginWithChromeForEK()
}


def static "demoPackage.MozartLogin.mozartLoginWithUser"() {
    (new demoPackage.MozartLogin()).mozartLoginWithUser()
}


def static "demoPackage.MozartLogin.LoginForAll"() {
    (new demoPackage.MozartLogin()).LoginForAll()
}


def static "fileOperations.FileUploader.uploadFileToServer"() {
    (new fileOperations.FileUploader()).uploadFileToServer()
}


def static "kms.turing.katalon.plugins.assertj.BooleanAssert.isTrue"(
    	boolean expression	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.BooleanAssert()).isTrue(
        	expression
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.BooleanAssert.isTrue"(
    	boolean expression	
     , 	String description	
     , 	FailureHandling flowControl	) {
    (new kms.turing.katalon.plugins.assertj.BooleanAssert()).isTrue(
        	expression
         , 	description
         , 	flowControl)
}


def static "kms.turing.katalon.plugins.assertj.BooleanAssert.isFalse"(
    	boolean expression	
     , 	String description	
     , 	FailureHandling flowControl	) {
    (new kms.turing.katalon.plugins.assertj.BooleanAssert()).isFalse(
        	expression
         , 	description
         , 	flowControl)
}


def static "kms.turing.katalon.plugins.assertj.BooleanAssert.isFalse"(
    	boolean expression	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.BooleanAssert()).isFalse(
        	expression
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.DateTimeAssert.equals"(
    	String verifiedDate	
     , 	String compare2Date	
     , 	String format	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.DateTimeAssert()).equals(
        	verifiedDate
         , 	compare2Date
         , 	format
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.DateTimeAssert.equals"(
    	String verifiedDate	
     , 	String compare2Date	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.DateTimeAssert()).equals(
        	verifiedDate
         , 	compare2Date
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.DateTimeAssert.equals"(
    	String verifiedDate	
     , 	String compare2Date	
     , 	String format	
     , 	String description	
     , 	FailureHandling flowControl	) {
    (new kms.turing.katalon.plugins.assertj.DateTimeAssert()).equals(
        	verifiedDate
         , 	compare2Date
         , 	format
         , 	description
         , 	flowControl)
}


def static "kms.turing.katalon.plugins.assertj.DateTimeAssert.isAfter"(
    	String verifiedDate	
     , 	String compare2Date	
     , 	String format	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.DateTimeAssert()).isAfter(
        	verifiedDate
         , 	compare2Date
         , 	format
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.DateTimeAssert.isAfter"(
    	String verifiedDate	
     , 	String compare2Date	
     , 	String format	
     , 	String description	
     , 	FailureHandling flowControl	) {
    (new kms.turing.katalon.plugins.assertj.DateTimeAssert()).isAfter(
        	verifiedDate
         , 	compare2Date
         , 	format
         , 	description
         , 	flowControl)
}


def static "kms.turing.katalon.plugins.assertj.DateTimeAssert.isAfter"(
    	String verifiedDate	
     , 	String compare2Date	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.DateTimeAssert()).isAfter(
        	verifiedDate
         , 	compare2Date
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.DateTimeAssert.isBefore"(
    	String verifiedDate	
     , 	String compare2Date	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.DateTimeAssert()).isBefore(
        	verifiedDate
         , 	compare2Date
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.DateTimeAssert.isBefore"(
    	String verifiedDate	
     , 	String compare2Date	
     , 	String format	
     , 	String description	
     , 	FailureHandling flowControl	) {
    (new kms.turing.katalon.plugins.assertj.DateTimeAssert()).isBefore(
        	verifiedDate
         , 	compare2Date
         , 	format
         , 	description
         , 	flowControl)
}


def static "kms.turing.katalon.plugins.assertj.DateTimeAssert.isBefore"(
    	String verifiedDate	
     , 	String compare2Date	
     , 	String format	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.DateTimeAssert()).isBefore(
        	verifiedDate
         , 	compare2Date
         , 	format
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.DateTimeAssert.matchesDateTimeFormat"(
    	String dateInString	
     , 	String datetimeFormat	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.DateTimeAssert()).matchesDateTimeFormat(
        	dateInString
         , 	datetimeFormat
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.DateTimeAssert.matchesDateTimeFormat"(
    	String dateInString	
     , 	String datetimeFormat	
     , 	String description	
     , 	FailureHandling flowControl	) {
    (new kms.turing.katalon.plugins.assertj.DateTimeAssert()).matchesDateTimeFormat(
        	dateInString
         , 	datetimeFormat
         , 	description
         , 	flowControl)
}


def static "kms.turing.katalon.plugins.assertj.GenericAssert.isNull"(
    	Object object	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.GenericAssert()).isNull(
        	object
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.GenericAssert.isNull"(
    	Object object	
     , 	String description	
     , 	FailureHandling flowControl	) {
    (new kms.turing.katalon.plugins.assertj.GenericAssert()).isNull(
        	object
         , 	description
         , 	flowControl)
}


def static "kms.turing.katalon.plugins.assertj.GenericAssert.isNotNull"(
    	Object object	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.GenericAssert()).isNotNull(
        	object
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.GenericAssert.isNotNull"(
    	Object object	
     , 	String description	
     , 	FailureHandling flowControl	) {
    (new kms.turing.katalon.plugins.assertj.GenericAssert()).isNotNull(
        	object
         , 	description
         , 	flowControl)
}


def static "kms.turing.katalon.plugins.assertj.ListAssert.contains"(
    	java.util.List<Object> list	
     , 	java.util.List<Object> subList	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.ListAssert()).contains(
        	list
         , 	subList
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.ListAssert.contains"(
    	java.util.List<Object> list	
     , 	java.util.List<Object> subList	
     , 	String description	
     , 	FailureHandling flowControl	) {
    (new kms.turing.katalon.plugins.assertj.ListAssert()).contains(
        	list
         , 	subList
         , 	description
         , 	flowControl)
}


def static "kms.turing.katalon.plugins.assertj.ListAssert.equalsIgnoreOrder"(
    	java.util.List<Object> actual	
     , 	java.util.List<Object> expected	
     , 	String description	
     , 	FailureHandling flowControl	) {
    (new kms.turing.katalon.plugins.assertj.ListAssert()).equalsIgnoreOrder(
        	actual
         , 	expected
         , 	description
         , 	flowControl)
}


def static "kms.turing.katalon.plugins.assertj.ListAssert.equalsIgnoreOrder"(
    	java.util.List<Object> actual	
     , 	java.util.List<Object> expected	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.ListAssert()).equalsIgnoreOrder(
        	actual
         , 	expected
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.ListAssert.equalsWithOrder"(
    	java.util.List<Object> actual	
     , 	java.util.List<Object> expected	
     , 	String description	
     , 	FailureHandling flowControl	) {
    (new kms.turing.katalon.plugins.assertj.ListAssert()).equalsWithOrder(
        	actual
         , 	expected
         , 	description
         , 	flowControl)
}


def static "kms.turing.katalon.plugins.assertj.ListAssert.equalsWithOrder"(
    	java.util.List<Object> actual	
     , 	java.util.List<Object> expected	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.ListAssert()).equalsWithOrder(
        	actual
         , 	expected
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.NumberAssert.equals"(
    	Object actual	
     , 	Object expected	
     , 	String description	
     , 	FailureHandling flowControl	) {
    (new kms.turing.katalon.plugins.assertj.NumberAssert()).equals(
        	actual
         , 	expected
         , 	description
         , 	flowControl)
}


def static "kms.turing.katalon.plugins.assertj.NumberAssert.equals"(
    	Object actual	
     , 	Object expected	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.NumberAssert()).equals(
        	actual
         , 	expected
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.NumberAssert.isNegative"(
    	Object value	
     , 	String description	
     , 	FailureHandling flowControl	) {
    (new kms.turing.katalon.plugins.assertj.NumberAssert()).isNegative(
        	value
         , 	description
         , 	flowControl)
}


def static "kms.turing.katalon.plugins.assertj.NumberAssert.isNegative"(
    	Object value	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.NumberAssert()).isNegative(
        	value
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.NumberAssert.isZero"(
    	Object value	
     , 	String description	
     , 	FailureHandling flowControl	) {
    (new kms.turing.katalon.plugins.assertj.NumberAssert()).isZero(
        	value
         , 	description
         , 	flowControl)
}


def static "kms.turing.katalon.plugins.assertj.NumberAssert.isZero"(
    	Object value	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.NumberAssert()).isZero(
        	value
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.NumberAssert.isPositive"(
    	Object value	
     , 	String description	
     , 	FailureHandling flowControl	) {
    (new kms.turing.katalon.plugins.assertj.NumberAssert()).isPositive(
        	value
         , 	description
         , 	flowControl)
}


def static "kms.turing.katalon.plugins.assertj.NumberAssert.isPositive"(
    	Object value	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.NumberAssert()).isPositive(
        	value
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.NumberAssert.lessThanOrEqual"(
    	Object x	
     , 	Object y	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.NumberAssert()).lessThanOrEqual(
        	x
         , 	y
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.NumberAssert.lessThanOrEqual"(
    	Object x	
     , 	Object y	
     , 	String description	
     , 	FailureHandling flowControl	) {
    (new kms.turing.katalon.plugins.assertj.NumberAssert()).lessThanOrEqual(
        	x
         , 	y
         , 	description
         , 	flowControl)
}


def static "kms.turing.katalon.plugins.assertj.NumberAssert.greaterThanOrEqual"(
    	Object x	
     , 	Object y	
     , 	String description	
     , 	FailureHandling flowControl	) {
    (new kms.turing.katalon.plugins.assertj.NumberAssert()).greaterThanOrEqual(
        	x
         , 	y
         , 	description
         , 	flowControl)
}


def static "kms.turing.katalon.plugins.assertj.NumberAssert.greaterThanOrEqual"(
    	Object x	
     , 	Object y	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.NumberAssert()).greaterThanOrEqual(
        	x
         , 	y
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.NumberAssert.notEqual"(
    	Object actual	
     , 	Object expected	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.NumberAssert()).notEqual(
        	actual
         , 	expected
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.NumberAssert.notEqual"(
    	Object actual	
     , 	Object expected	
     , 	String description	
     , 	FailureHandling flowControl	) {
    (new kms.turing.katalon.plugins.assertj.NumberAssert()).notEqual(
        	actual
         , 	expected
         , 	description
         , 	flowControl)
}


def static "kms.turing.katalon.plugins.assertj.NumberAssert.lessThan"(
    	Object x	
     , 	Object y	
     , 	String description	
     , 	FailureHandling flowControl	) {
    (new kms.turing.katalon.plugins.assertj.NumberAssert()).lessThan(
        	x
         , 	y
         , 	description
         , 	flowControl)
}


def static "kms.turing.katalon.plugins.assertj.NumberAssert.lessThan"(
    	Object x	
     , 	Object y	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.NumberAssert()).lessThan(
        	x
         , 	y
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.NumberAssert.greaterThan"(
    	Object x	
     , 	Object y	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.NumberAssert()).greaterThan(
        	x
         , 	y
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.NumberAssert.greaterThan"(
    	Object x	
     , 	Object y	
     , 	String description	
     , 	FailureHandling flowControl	) {
    (new kms.turing.katalon.plugins.assertj.NumberAssert()).greaterThan(
        	x
         , 	y
         , 	description
         , 	flowControl)
}


def static "kms.turing.katalon.plugins.assertj.StringAssert.equals"(
    	String actual	
     , 	String expected	
     , 	boolean caseSensitive	
     , 	String description	
     , 	FailureHandling flowControl	) {
    (new kms.turing.katalon.plugins.assertj.StringAssert()).equals(
        	actual
         , 	expected
         , 	caseSensitive
         , 	description
         , 	flowControl)
}


def static "kms.turing.katalon.plugins.assertj.StringAssert.equals"(
    	String actual	
     , 	String expected	
     , 	boolean caseSensitive	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.StringAssert()).equals(
        	actual
         , 	expected
         , 	caseSensitive
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.StringAssert.equals"(
    	String actual	
     , 	String expected	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.StringAssert()).equals(
        	actual
         , 	expected
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.StringAssert.startsWith"(
    	String text	
     , 	String prefix	
     , 	boolean caseSensitive	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.StringAssert()).startsWith(
        	text
         , 	prefix
         , 	caseSensitive
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.StringAssert.startsWith"(
    	String text	
     , 	String prefix	
     , 	boolean caseSensitive	
     , 	String description	
     , 	FailureHandling flowControl	) {
    (new kms.turing.katalon.plugins.assertj.StringAssert()).startsWith(
        	text
         , 	prefix
         , 	caseSensitive
         , 	description
         , 	flowControl)
}


def static "kms.turing.katalon.plugins.assertj.StringAssert.startsWith"(
    	String text	
     , 	String prefix	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.StringAssert()).startsWith(
        	text
         , 	prefix
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.StringAssert.matches"(
    	String text	
     , 	String pattern	
     , 	String description	
     , 	FailureHandling flowControl	) {
    (new kms.turing.katalon.plugins.assertj.StringAssert()).matches(
        	text
         , 	pattern
         , 	description
         , 	flowControl)
}


def static "kms.turing.katalon.plugins.assertj.StringAssert.matches"(
    	String text	
     , 	String pattern	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.StringAssert()).matches(
        	text
         , 	pattern
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.StringAssert.endsWith"(
    	String text	
     , 	String suffix	
     , 	boolean caseSensitive	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.StringAssert()).endsWith(
        	text
         , 	suffix
         , 	caseSensitive
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.StringAssert.endsWith"(
    	String text	
     , 	String suffix	
     , 	boolean caseSensitive	
     , 	String description	
     , 	FailureHandling flowControl	) {
    (new kms.turing.katalon.plugins.assertj.StringAssert()).endsWith(
        	text
         , 	suffix
         , 	caseSensitive
         , 	description
         , 	flowControl)
}


def static "kms.turing.katalon.plugins.assertj.StringAssert.endsWith"(
    	String text	
     , 	String suffix	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.StringAssert()).endsWith(
        	text
         , 	suffix
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.StringAssert.contains"(
    	String text	
     , 	String subText	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.StringAssert()).contains(
        	text
         , 	subText
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.StringAssert.contains"(
    	String text	
     , 	String subText	
     , 	boolean caseSensitive	
     , 	String description	
     , 	FailureHandling flowControl	) {
    (new kms.turing.katalon.plugins.assertj.StringAssert()).contains(
        	text
         , 	subText
         , 	caseSensitive
         , 	description
         , 	flowControl)
}


def static "kms.turing.katalon.plugins.assertj.StringAssert.contains"(
    	String text	
     , 	String subText	
     , 	boolean caseSensitive	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.StringAssert()).contains(
        	text
         , 	subText
         , 	caseSensitive
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.StringAssert.notEqual"(
    	String actual	
     , 	String expected	
     , 	boolean caseSensitive	
     , 	String description	
     , 	FailureHandling flowControl	) {
    (new kms.turing.katalon.plugins.assertj.StringAssert()).notEqual(
        	actual
         , 	expected
         , 	caseSensitive
         , 	description
         , 	flowControl)
}


def static "kms.turing.katalon.plugins.assertj.StringAssert.notEqual"(
    	String actual	
     , 	String expected	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.StringAssert()).notEqual(
        	actual
         , 	expected
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.StringAssert.notEqual"(
    	String actual	
     , 	String expected	
     , 	boolean caseSensitive	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.StringAssert()).notEqual(
        	actual
         , 	expected
         , 	caseSensitive
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.StringAssert.notContain"(
    	String text	
     , 	String subText	
     , 	boolean caseSensitive	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.StringAssert()).notContain(
        	text
         , 	subText
         , 	caseSensitive
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.StringAssert.notContain"(
    	String text	
     , 	String subText	
     , 	String description	) {
    (new kms.turing.katalon.plugins.assertj.StringAssert()).notContain(
        	text
         , 	subText
         , 	description)
}


def static "kms.turing.katalon.plugins.assertj.StringAssert.notContain"(
    	String text	
     , 	String subText	
     , 	boolean caseSensitive	
     , 	String description	
     , 	FailureHandling flowControl	) {
    (new kms.turing.katalon.plugins.assertj.StringAssert()).notContain(
        	text
         , 	subText
         , 	caseSensitive
         , 	description
         , 	flowControl)
}


def static "com.kms.katalon.keyword.uploadfile.UploadFile.uploadFile"(
    	TestObject object	
     , 	String file	) {
    (new com.kms.katalon.keyword.uploadfile.UploadFile()).uploadFile(
        	object
         , 	file)
}


def static "com.kms.katalon.keyword.uploadfile.UploadFile.uploadFileUsingRobot"(
    	TestObject object	
     , 	String file	) {
    (new com.kms.katalon.keyword.uploadfile.UploadFile()).uploadFileUsingRobot(
        	object
         , 	file)
}


def static "com.katalon.extent.report.ExtentReport.attachEReport"(
    	TestSuiteContext testSuiteContext	
     , 	String setDocumentTitle	
     , 	String setReportTitle	) {
    (new com.katalon.extent.report.ExtentReport()).attachEReport(
        	testSuiteContext
         , 	setDocumentTitle
         , 	setReportTitle)
}


def static "com.katalon.extent.report.ExtentReport.attachEReport"(
    	TestSuiteContext testSuiteContext	
     , 	String setDocumentTitle	
     , 	String setReportTitle	
     , 	String projectDir	) {
    (new com.katalon.extent.report.ExtentReport()).attachEReport(
        	testSuiteContext
         , 	setDocumentTitle
         , 	setReportTitle
         , 	projectDir)
}


def static "com.katalon.extent.report.ExtentReport.startEReport"(
    	TestCaseContext testCaseContext	) {
    (new com.katalon.extent.report.ExtentReport()).startEReport(
        	testCaseContext)
}


def static "com.katalon.extent.report.ExtentReport.flushEReport"() {
    (new com.katalon.extent.report.ExtentReport()).flushEReport()
}


def static "com.katalon.extent.report.ExtentReport.getScreenshot"() {
    (new com.katalon.extent.report.ExtentReport()).getScreenshot()
}


def static "com.katalon.extent.report.ExtentReport.addScreenshot"(
    	String newScreenshotpath	) {
    (new com.katalon.extent.report.ExtentReport()).addScreenshot(
        	newScreenshotpath)
}


def static "com.katalon.extent.report.ExtentReport.addScreenshot"() {
    (new com.katalon.extent.report.ExtentReport()).addScreenshot()
}


def static "com.katalon.extent.report.ExtentReport.takeScreenshotFailure"(
    	TestCaseContext testCaseContext	) {
    (new com.katalon.extent.report.ExtentReport()).takeScreenshotFailure(
        	testCaseContext)
}


def static "com.katalon.extent.report.ExtentReport.deleteFolderContents"() {
    (new com.katalon.extent.report.ExtentReport()).deleteFolderContents()
}


def static "com.katalon.extent.report.ExtentReport.attachLog"(
    	String details	) {
    (new com.katalon.extent.report.ExtentReport()).attachLog(
        	details)
}
