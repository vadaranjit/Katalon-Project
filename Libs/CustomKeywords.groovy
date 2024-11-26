
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import javax.mail.Message

import java.util.Map

import com.kms.katalon.core.testobject.TestObject



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

 /**
	 * Selects roles for a user based on the provided parameters.
	 * We need to call this method before login. This method selects the user role and closes the browser.
	 * In This method we can select single or multiple user roles.
	 * Example usage:
	 * <pre>
	 *     selectRoles('ranajitvadar', 'Auditor', 'Supervisor', 'Admin')
	 * </pre>
	 * @param username The username of the person for whom roles are being assigned.
	 * @param roles A variable number of roles to be assigned to the user. 
	 *              Possible roles include 'Auditor', 'Supervisor', 'Admin', etc.
	 * 
	 * @return A confirmation message indicating that the roles have been assigned.
	 * 
	 * @throws IllegalArgumentException if the username is null or empty, or if no roles are provided.
	 * 
	 */ 
def static "utilityClass.GenericMethods.selectRoles"(
    	String username	
     , 	String[] role	) {
    (new utilityClass.GenericMethods()).selectRoles(
        	username
         , 	role)
}

 /**
	 * Generates a unique number based on the current date and time.
	 *
	 * This method creates a unique string by formatting the current date and time,
	 * removing spaces and colons, and storing the result in a global variable.
	 * The unique number is generated in the format 'yyyyMMddHHmmss', ensuring uniqueness
	 * based on the timestamp when the method is called.
	 *
	 * @return A unique string generated from the current date and time.
	 *
	 * @see GlobalVariable#UniqueNumber
	 *
	 * Example usage:
	 * <pre>
	 *     String uniqueNumber = UniqueNumberGenerator()
	 *     println("Generated Unique Number: " + uniqueNumber)
	 * </pre>
	 */ 
def static "utilityClass.GenericMethods.UniqueNumberGenerator"() {
    (new utilityClass.GenericMethods()).UniqueNumberGenerator()
}

 /**
	 * Scrolls the view to the left side of the table within a scrollable container.
	 * The horizontal scroll position is set to the far left (0 pixels).
	 */ 
def static "utilityClass.GenericMethods.ScrollLeft"() {
    (new utilityClass.GenericMethods()).ScrollLeft()
}

 /**
	 * Scrolls the view to the right side of the table within a scrollable container.
	 * The horizontal scroll position is set to 1000 pixels, assuming this moves to the far right of the table.
	 */ 
def static "utilityClass.GenericMethods.scrollRight"() {
    (new utilityClass.GenericMethods()).scrollRight()
}

 /**
	 * Scrolls the view to the top of the table within a scrollable container.
	 * The vertical scroll position is set to the top (0 pixels).
	 */ 
def static "utilityClass.GenericMethods.scrollUp"() {
    (new utilityClass.GenericMethods()).scrollUp()
}

 /**
	 * Scrolls the view downward within the table inside a scrollable container.
	 * The vertical scroll position is set to 200 pixels down from the top.
	 */ 
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

 /**
	 * Executes a SQL query and retrieves a specific column value from a specified row in the result set.
	 *
	 * @param database_name The name of the database to connect to.
	 * @param sql_query The SQL query to be executed.
	 * @param column_name The name of the column from which to retrieve the value.
	 * @param row_num The row number from which to retrieve the value (1-based index).
	 * @return The value from the specified column and row as a String.
	 *
	 * @throws SQLException If a database access error occurs or the SQL query is incorrect.
	 * @throws IllegalArgumentException If the column_name or row_num are invalid.
	 *
	 * Example:
	 * <pre>
	 * {@code
	 * String result = CustomKeywords.'your.package.name.executeQuerys'('yourDatabase', 'SELECT * FROM yourTable', 'columnName', 1);
	 * }
	 * </pre>
	 */ 
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
