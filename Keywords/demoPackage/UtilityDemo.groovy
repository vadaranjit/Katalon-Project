package demoPackage
import java.sql.Connection;

import java.sql.DriverManager;
import java.text.SimpleDateFormat

import com.kms.katalon.core.annotation.Keyword
import internal.GlobalVariable

class UtilityDemo {


	@Keyword
	def static String requestNumber() {
		def date = new Date()
		def sdf = new SimpleDateFormat('yyyyMMdd HH:mm:ss')
		String z = sdf.format(date)
		GlobalVariable.RequestDate = z
		println(GlobalVariable.RequestDate)
		String y = z.replace(' ', '')
		String x = y.replace(':', '')
		GlobalVariable.RequestNumber = x
		println(GlobalVariable.RequestNumber)
		return x
	}
	//====================================================================================================================
	@Keyword
	def static String getFilePath(String filePath) {
		String originalFilePath = filePath+readFileName(filePath);
		String newFileName = timeStamp(filePath+readFileName(filePath));

		try {
			File originalFile = new File(originalFilePath);
			File newFile = new File(originalFile.getParent(), newFileName);

			if (originalFile.renameTo(newFile)) {
				System.out.println("File renamed and saved successfully.");
			}
			else {
				System.out.println("Failed to rename file.");
			}
		}

		catch (IOException e) {
			System.out.println("An error occurred: " + e.getMessage());
			e.printStackTrace();
		}

		String filePath1 = "C:\\RANJITV\\" + newFileName;
		return filePath1;
	}

	@Keyword
	def static String readFileName(String folderPath) {

		File folder = new File(folderPath);
		File[] files = folder.listFiles();

		if (folder.exists() && folder.isDirectory()) {

			for (File file : files) {
				if (file.isFile()) {
					System.out.println("File Name: " + file.getName());
					return file.getName()
				}
			}
		}

		else {
			System.out.println("Folder does not exist or is not a directory.");
		}
	}

	@Keyword
	def static String timeStamp(String filePath) {
		File file = new File(filePath);
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String originalFileName = file.getName();
		String[] parts = originalFileName.split("\\.");
		String fileName = parts[0];
		String cutFileName = modifyFileName(fileName);
		String extension = parts[1];
		String uniqueFileName = cutFileName + "_" + timeStamp + "." + extension;
		return uniqueFileName
	}

	@Keyword
	def static String modifyFileName(String filename) {
		return filename.substring(0,15);
	}
	//----------------------------------

	@Keyword
	def static Connection establishDatabaseConnection() {

		String url = "jdbc:informix-sqli://vltifxmozart1:40055/mozart_avianca:INFORMIXSERVER=tmozart1tcp_repbc"
		String username ="bdmozart"
		String password ="bdmozart"
		Connection conn = null;
		try {
			// Load the JDBC driver class
			Class.forName("com.informix.jdbc.IfxDriver");

			// Establish the database connection
			conn = DriverManager.getConnection(url, username, password);
		}

		catch (Exception e) {
			// Handle any errors
			e.printStackTrace();
		}
		return conn;
	}
}