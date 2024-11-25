package database
import java.sql.*;

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil

public class DatabaseUtils
{

	@Keyword
	def boolean checkTableExists(String tableName)
	{

		DBConnection obj = new DBConnection()
		Connection connection = obj.connectDB()

		try
		{
			// Get database metadata
			DatabaseMetaData metaData = connection.getMetaData()

			// Check if table exists
			def resultSet = metaData.getTables(null, null, tableName, null)

			if (resultSet.next())
			{
				KeywordUtil.logInfo("Table " + tableName + " exists.")
				return true
			}
			else
			{
				KeywordUtil.logInfo("Table " + tableName + " does not exist.")
				return false
			}
		}

		catch (Exception e)
		{
			KeywordUtil.markFailed("An error occurred: " + e.getMessage())
			return false
		}
	}

	//------------------------------------------------------------------------------------

	@Keyword
	def boolean checkColumnExist(String tableName , String columnName)
	{
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			// Connect to the database
			DBConnection obj = new DBConnection()
			connection = obj.connectDB()

			// Create the SQL query to get the column names from the specified table
			String sqlQuery = "SELECT * FROM bdmozart." + tableName + " WHERE 1=0"; // Use 1=0 to get metadata only -table names

			// Create a statement
			stmt = connection.createStatement();

			// Execute the query to get a ResultSet
			rs = stmt.executeQuery(sqlQuery);

			// Get the metadata
			ResultSetMetaData metaData = rs.getMetaData();

			// Get the number of columns
			int columnCount = metaData.getColumnCount();

			for (int i = 1; i <= columnCount; i++)
			{
				if(columnName == metaData.getColumnName(i))
				{
					System.out.println("Column " + columnName + " exists.")
					return true
				}
			}

			System.out.println("Column " + columnName + " does not exist.")
			return false
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			// Close the ResultSet, Statement, and Connection
			try
			{
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (connection != null) connection.close();
			}

			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

	//-------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------
	@Keyword
	def List<String> getAllColumnNamesFromTable(String tableName)
	{
		Connection connection = null
		Statement stmt = null
		ResultSet rs = null
		List<String> columnList = new ArrayList<>()

		try
		{
			// Connect to the database
			DBConnection obj = new DBConnection()
			connection = obj.connectDB()

			// Create the SQL query to get the column names from the specified table
			String sqlQuery = "SELECT * FROM bdmozart." + tableName + " WHERE 1=0" // Use 1=0 to get metadata only

			// Create a statement
			stmt = connection.createStatement()

			// Execute the query to get a ResultSet
			rs = stmt.executeQuery(sqlQuery)

			// Get the metadata
			ResultSetMetaData metaData = rs.getMetaData()

			// Get the number of columns
			int columnCount = metaData.getColumnCount()

			for (int i = 1; i <= columnCount; i++)
			{
				columnList.add(metaData.getColumnName(i))
			}

			return columnList
		} catch (SQLException e)
		{
			e.printStackTrace()
			return Collections.emptyList() // Return an empty list in case of an error
		} finally
		{
			// Close the ResultSet, Statement, and Connection
			try
			{
				if (rs != null) rs.close()
				if (stmt != null) stmt.close()
				if (connection != null) connection.close()
			} catch (SQLException e)
			{
				e.printStackTrace()
			}
		}
	}


	//-------------------------------------------------------------------------------------------------------

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
	@Keyword
	def String  executeQuery(String sql_query,String column_name,int row_num)
	{

		// Connect to the database
		Connection connection = null;
		DBConnection obj = new DBConnection()
		connection = obj.connectDB()

		if (connection)
		{
			try
			{
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
			catch (Exception e)
			{
				return null
			}
		}
		else
		{
			println('Error: Unable to establish database connection')
		}
	}

	//-------------------------------------------------------------------------------------------------------

	@Keyword
	def int getRowCount(String sql_query)
	{
		// Connect to the database
		Connection connection = null
		DBConnection obj = new DBConnection()
		connection = obj.connectDB()

		if (connection)
		{
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
			ResultSet rs = statement.executeQuery(sql_query)

			// Move to the last row to get the row count
			rs.last()
			int rowCount = rs.getRow()

			rs.close()
			statement.close()
			connection.close()

			return rowCount
		} else
		{
			println('Error: Unable to establish database connection')
			return -1
		}
	}


	//-------------------------------------------------------------------------------------------------------

	@Keyword
	def int getColumnCount(String sql_query)
	{
		// Connect to the database
		Connection connection = null
		DBConnection obj = new DBConnection()
		connection = obj.connectDB()

		if (connection)
		{
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
			ResultSet rs = statement.executeQuery(sql_query)

			// Get metadata from the result set
			ResultSetMetaData rsMetaData = rs.getMetaData()
			int columnCount = rsMetaData.getColumnCount()

			rs.close()
			statement.close()
			connection.close()

			return columnCount
		} else
		{
			println('Error: Unable to establish database connection')
			return -1
		}
	}

	//-------------------------------------------------------------------------------------------------------
	@Keyword
	public Map<String, String> getColumnNamesAndValues(String tableName)
	{
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		Map<String, String> columnValueMap = new HashMap<>();

		try
		{
			// Connect to the database
			DBConnection obj = new DBConnection();
			connection = obj.connectDB();

			// Create the SQL query to get the first row of the specified table
			//String sqlQuery = "SELECT * FROM bdmozart." + tableName + " LIMIT 1";
			String sqlQuery = tableName

			// Create a statement
			stmt = connection.createStatement();

			// Execute the query to get a ResultSet
			rs = stmt.executeQuery(sqlQuery);

			// Check if ResultSet contains a row
			if (rs.next())
			{
				// Get the metadata
				ResultSetMetaData metaData = rs.getMetaData();

				// Get the number of columns
				int columnCount = metaData.getColumnCount();

				// Loop through each column and get the column name and value
				for (int i = 1; i <= columnCount; i++)
				{
					String columnName = metaData.getColumnName(i);
					String columnValue = rs.getString(i);
					String columnType = metaData.getColumnTypeName(i);


					// Check if the column is of boolean type
					if (columnType.equalsIgnoreCase("BOOLEAN"))
					{

						String booleanValue = columnValue.equals("t") ? "true" : "false";
						columnValueMap.put(columnName, booleanValue);
					}

					else if (columnType.equalsIgnoreCase("DECIMAL") || columnType.equalsIgnoreCase("NUMERIC"))
					{
						// Convert decimal to a plain string by stripping trailing zeros
						BigDecimal decimalValue = rs.getBigDecimal(i);
						if(decimalValue == null)
						{
							columnValueMap.put(columnName, columnValue);
							continue
						}
						String formattedValue = decimalValue.stripTrailingZeros().toPlainString();
						columnValueMap.put(columnName, formattedValue);
					}
					else
					{
						println  columnName+"===================================="+columnValue
						// If not boolean, print the value directly
						columnValueMap.put(columnName, columnValue);
					}

					// Add the column name and value to the map
					//columnValueMap.put(columnName, columnValue);
				}
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			// Close resources to avoid memory leaks
			try
			{
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (connection != null) connection.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}

		return columnValueMap;
	}

	//-------------------------------------------------------------------------------------------------------


	@Keyword
	def String  executeQueryDemo(String sql_query,String column_name,int row_num)
	{

		// Connect to the database
		Connection connection = null;
		DBConnection obj = new DBConnection()
		connection = obj.connectDB()
		try
		{
			if (connection)
			{
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

			else
			{
				println('Error: Unable to establish database connection')
			}
		} catch (SQLException e)
		{
			println("SQL Exception occurred: " + e.message)
			//e.printStackTrace()
			return e.message
		} catch (Exception e)
		{
			println("Exception occurred: " + e.message)
			e.printStackTrace()
			return null
		}
	}

	//-------------------------------------------------------------------------------------------------------
}// Class
