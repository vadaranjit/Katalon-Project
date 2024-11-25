package fileOperations

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import java.nio.file.Files
import java.nio.file.StandardCopyOption
import java.io.File

public class FileUploader {


	@Keyword
	def static uploadFileToServer() {

		String localFilePath = 'C:\\Katalon_TestData\\E6_File\\134_e6_20240614_MX_002'
		String processedFolderPath = '\\\\vwtmozart221\\C\\Mozart\\FicherosE6_Avianca\\processed_files'
		String serverPath ='\\\\vwtmozart221\\C\\Mozart\\FicherosE6_Avianca\\in_files'

		FileUtils file_obj = new FileUtils()

		file_obj.copyFileWithUniqueNameDemo(localFilePath,serverPath,processedFolderPath)

		File localFile = new File(localFilePath)
		File serverDirectory = new File(serverPath)


		if (localFile.exists() && localFile.isFile()) {

			if (serverDirectory.exists() && serverDirectory.isDirectory()) {

				String destinationFilePath = serverPath + "\\" + localFile.getName()
				File destinationFile = new File(destinationFilePath)
				Files.copy(localFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING)
				KeywordUtil.logInfo('File uploaded successfully to: ' + destinationFilePath)
			}

			else {
				KeywordUtil.logInfo('The server directory does not exist or is not a directory.')
			}
		}

		else {
			KeywordUtil.logInfo('The local file does not exist or is not a file.')
		}
	}
}
