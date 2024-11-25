package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object Mozart_URL
     
    /**
     * <p></p>
     */
    public static Object Mozart_Username
     
    /**
     * <p></p>
     */
    public static Object Mozart_Passowrd
     
    /**
     * <p></p>
     */
    public static Object Airline
     
    /**
     * <p></p>
     */
    public static Object MozartUser
     
    /**
     * <p></p>
     */
    public static Object Hostname
     
    /**
     * <p></p>
     */
    public static Object requestID
     
    /**
     * <p></p>
     */
    public static Object RequestNumber
     
    /**
     * <p></p>
     */
    public static Object token
     
    /**
     * <p></p>
     */
    public static Object AuthToken
     
    /**
     * <p></p>
     */
    public static Object RequestDate
     
    /**
     * <p></p>
     */
    public static Object UniqueNumber
     
    /**
     * <p></p>
     */
    public static Object QuoteString
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += TestCaseMain.getParsedValues(RunConfiguration.getOverridingParameters(), selectedVariables)
    
            Mozart_URL = selectedVariables['Mozart_URL']
            Mozart_Username = selectedVariables['Mozart_Username']
            Mozart_Passowrd = selectedVariables['Mozart_Passowrd']
            Airline = selectedVariables['Airline']
            MozartUser = selectedVariables['MozartUser']
            Hostname = selectedVariables['Hostname']
            requestID = selectedVariables['requestID']
            RequestNumber = selectedVariables['RequestNumber']
            token = selectedVariables['token']
            AuthToken = selectedVariables['AuthToken']
            RequestDate = selectedVariables['RequestDate']
            UniqueNumber = selectedVariables['UniqueNumber']
            QuoteString = selectedVariables['QuoteString']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
