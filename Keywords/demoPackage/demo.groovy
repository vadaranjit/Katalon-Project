package demoPackage

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class demo {
	
	@Keyword
	def static String DEMOreadFileName() 
	{
		String folderPath = "\\vwtmozart221\\C\\Mozart\\OUTPUTS_Emirates\\GAPEFT"
		File folder = new File(folderPath);
		File[] files = folder.listFiles();

		if (folder.exists() && folder.isDirectory()) {

			for (File file : files) 
				{
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
}
