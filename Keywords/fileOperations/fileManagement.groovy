package fileOperations

import com.kms.katalon.core.annotation.Keyword
import java.nio.file.*
import java.text.SimpleDateFormat
import java.util.Date

public class FileUtils {

	@Keyword
	def copyFileWithUniqueName() {
		String sourceFilePath = 'C:\\Katalon_TestData\\E6_File\\134_e6_20240614_MX_002'
		String destinationDirPath =  'C:\\Katalon_TestData'
		Path sourcePath = Paths.get(sourceFilePath)
		Path destinationDir = Paths.get(destinationDirPath)

		if (!Files.exists(sourcePath)) {
			println("Source file does not exist: " + sourceFilePath)
			return
		}

		if (!Files.exists(destinationDir)) {
			Files.createDirectories(destinationDir)
		}

		String originalFileName = sourcePath.getFileName().toString()  //134_e6_20240501_CO_001
		String[] fileNameParts = originalFileName.split('_')
		String baseFileName = fileNameParts[0] + '_' + fileNameParts[1]  //134_e6
		String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date()) //20240501
		String countryName = fileNameParts[3] //CO
		String lastPartNumber = fileNameParts[4]  //001

		String newFileName = baseFileName + "_" + currentDate + "_" + countryName +"_" + lastPartNumber
		Path destinationPath = destinationDir.resolve(newFileName)

		int uniqueNumber = Integer.parseInt(lastPartNumber)
		while (Files.exists(destinationPath)) {
			uniqueNumber++
			String newLastPartNumber = String.format("%03d", uniqueNumber)
			newFileName =baseFileName + "_" + currentDate + "_" + countryName +"_" + newLastPartNumber
			destinationPath = destinationDir.resolve(newFileName)
		}

		Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING)
		println("File copied to: " + destinationPath.toString())
	}


	//---------------------------------------------------------------------------
	@Keyword
	def copyFileWithUniqueNameDemo(String sourceFilePath,String destinationDirPath, String processedFile) {

		Path sourcePath = Paths.get(sourceFilePath)  //local file path
		Path destinationDir = Paths.get(destinationDirPath) //in file path
		Path processedFileDir = Paths.get(processedFile) //processed file path

		if (!Files.exists(sourcePath)) {
			println("Source file does not exist: " + sourceFilePath)
			return
		}

		if (!Files.exists(destinationDir)) {
			Files.createDirectories(destinationDir)
		}

		String originalFileName = sourcePath.getFileName().toString()  //134_e6_20240501_CO_001
		String[] fileNameParts = originalFileName.split('_')
		String baseFileName = fileNameParts[0] + '_' + fileNameParts[1]  //134_e6
		String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date()) //20240501
		String countryName = fileNameParts[3] //CO
		String lastPartNumber = fileNameParts[4]  //001

		String newFileName = baseFileName + "_" + currentDate + "_" + countryName +"_" + lastPartNumber
		Path ProcessedFilePath = processedFileDir.resolve(newFileName)

		int uniqueNumber = Integer.parseInt(lastPartNumber)
		while (Files.exists(ProcessedFilePath)) {
			uniqueNumber++
			String newLastPartNumber = String.format("%03d", uniqueNumber)
			newFileName =baseFileName + "_" + currentDate + "_" + countryName +"_" + newLastPartNumber
			ProcessedFilePath = processedFileDir.resolve(newFileName)
		}

		Path destinationPath = destinationDir.resolve(newFileName)
		Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING)
		println("File copied to: " + ProcessedFilePath.toString())
	}

	//---------------------------------------------------------------------------
	@Keyword
	def copyFileWithUniqueNameDemo1() {
		String localFilePath = 'C:\\Katalon_TestData\\E6_File\\134_e6_20240531_MX_001'
		String processedFolderPath = '\\\\vwtmozart221\\C\\Mozart\\FicherosE6_Avianca\\processed_files'
		String serverPath ='\\\\vwtmozart221\\C\\Mozart\\FicherosE6_Avianca\\in_files'

		String sourceFilePath = localFilePath
		String destinationDirPath = serverPath
		String processedFile = processedFolderPath

		Path sourcePath = Paths.get(sourceFilePath)  //local file path
		Path destinationDir = Paths.get(destinationDirPath) //in file path
		Path processedFileDir = Paths.get(processedFile) //processed file path

		if (!Files.exists(sourcePath)) {
			println("Source file does not exist: " + sourceFilePath)
			return
		}

		if (!Files.exists(destinationDir)) {
			Files.createDirectories(destinationDir)
		}

		String originalFileName = sourcePath.getFileName().toString()  //134_e6_20240501_CO_001
		String[] fileNameParts = originalFileName.split('_')
		String baseFileName = fileNameParts[0] + '_' + fileNameParts[1]  //134_e6
		String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date()) //20240501
		String countryName = fileNameParts[3] //CO
		String lastPartNumber = fileNameParts[4]  //001

		String newFileName = baseFileName + "_" + currentDate + "_" + countryName +"_" + lastPartNumber
		Path ProcessedFilePath = processedFileDir.resolve(newFileName)

		int uniqueNumber = Integer.parseInt(lastPartNumber)
		while (Files.exists(ProcessedFilePath)) {
			uniqueNumber++
			String newLastPartNumber = String.format("%03d", uniqueNumber)
			newFileName =baseFileName + "_" + currentDate + "_" + countryName +"_" + newLastPartNumber
			ProcessedFilePath = processedFileDir.resolve(newFileName)
		}

		Path destinationPath = destinationDir.resolve(newFileName)
		Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING)
		println("File copied to: " + ProcessedFilePath.toString())
	}
}
