import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.contribution.WebUiDriverCleaner
import com.kms.katalon.core.mobile.contribution.MobileDriverCleaner
import com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner
import com.kms.katalon.core.windows.keyword.contribution.WindowsDriverCleaner
import com.kms.katalon.core.testng.keyword.internal.TestNGDriverCleaner


DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.windows.keyword.contribution.WindowsDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.testng.keyword.internal.TestNGDriverCleaner())


RunConfiguration.setExecutionSettingFile('C:\\Users\\RANJIT~1.VAD\\AppData\\Local\\Temp\\Katalon\\Test Cases\\EK Autoamtion\\MOZ-11020\\TC 1_MOZ_11331 Verify Replacement of MARS with PNR in the Webservice Endpoint URL and JSON Structure\\20240618_192438\\execution.properties')

TestCaseMain.beforeStart()

        TestCaseMain.runTestCase('Test Cases/EK Autoamtion/MOZ-11020/TC 1_MOZ_11331 Verify Replacement of MARS with PNR in the Webservice Endpoint URL and JSON Structure', new TestCaseBinding('Test Cases/EK Autoamtion/MOZ-11020/TC 1_MOZ_11331 Verify Replacement of MARS with PNR in the Webservice Endpoint URL and JSON Structure',[:]), FailureHandling.STOP_ON_FAILURE , false)
    
