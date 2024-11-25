import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.context.TestSuiteContext
class PrintBrowserName {
    
    /**
     * This method runs before the start of each suite in a collection
     */
    @BeforeTestSuite
    def beforeTestSuite(TestSuiteContext testSuiteContext) {
        // Retrieve the suite ID
        String suiteId = testSuiteContext.getTestSuiteId()

        // Get the browser name specific to the current suite in the collection
        String browserName = RunConfiguration.getExecutionProperties().get("execution.general.browser")

        // Print suite and browser information to the console
        println("Executing Test Suite: " + suiteId)
        println("Browser for this suite: " + browserName)
    }
}
