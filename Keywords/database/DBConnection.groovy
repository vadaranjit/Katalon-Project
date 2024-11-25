
package database

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

import com.kms.katalon.core.annotation.Keyword

public class DBConnection {

	private static Connection connection = null;

	@Keyword
	def connectDB() {
		try {
			Class.forName("com.informix.jdbc.IfxDriver");
			connection = DriverManager.getConnection("jdbc:informix-sqli://vltifxmozart1:40055/mozart_emirates:INFORMIXSERVER=tmozart1tcp_repbc;user=bdmozart;password=bdmozart\r;");
			return connection;
		}

		catch (Exception e) {
			println("Error connecting to the database: " + e.getMessage());
			return null;
		}
	}

	//-------------------------------------------------------------------------------------------------------------------
	@Keyword
	def mozartAirline(String databaseName) {
		try {
			Class.forName("com.informix.jdbc.IfxDriver");
			connection = DriverManager.getConnection("jdbc:informix-sqli://vltifxmozart1:40055/"+databaseName+":INFORMIXSERVER=tmozart1tcp_repbc;user=bdmozart;password=bdmozart\r;");
			return connection;
		}

		catch (Exception e) {
			println("Error connecting to the database: " + e.getMessage());
			return null;
		}
	}

	//-------------------------------------------------------------------------------------------------------------------


	@Keyword
	def SQL(String sql_query,String column_name,int row_num) {

		// Call For DB Connection
		connectDB()

		if (connection) {
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)

			ResultSet rs = statement.executeQuery(sql_query)

			rs.next()
			rs.absolute(row_num)

			String valueFromDatabase1 = rs.getString(column_name)

			println(column_name+': ' + valueFromDatabase1)

			rs.close()

			statement.close()

			connection.close()
			return valueFromDatabase1
		}

		else {
			println('Error: Unable to establish database connection')
		}
	}
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------

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
	@Keyword
	def executeQuerys(String database_name,String sql_query,String column_name,int row_num) {

		// Call For DB Connection
		mozartAirline(database_name)

		if (connection) {
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)

			ResultSet rs = statement.executeQuery(sql_query)

			rs.next()
			rs.absolute(row_num)

			String valueFromDatabase1 = rs.getString(column_name)

			println(column_name+': ' + valueFromDatabase1)

			rs.close()

			statement.close()

			connection.close()
			return valueFromDatabase1
		}

		else {
			println('Error: Unable to establish database connection')
		}
	}
}