import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//Check table is exist or not
boolean Table_md_rfnd_local_settlement = CustomKeywords.'database.DatabaseUtils.checkTableExists'('md_rfnd_local_settlement')

WebUI.verifyEqual(Table_md_rfnd_local_settlement, true, FailureHandling.CONTINUE_ON_FAILURE)

//Check Column is exist or not
boolean Column_paid_locally = CustomKeywords.'database.DatabaseUtils.checkColumnExist'('mc_fop_types', 'paid_locally')

WebUI.verifyEqual(Column_paid_locally, true, FailureHandling.CONTINUE_ON_FAILURE)

//Check Selected FOPs in DB are available into the grid of Local settlement module
int rowCount = CustomKeywords.'database.DatabaseUtils.getRowCount'('select * from bdmozart.mc_fop_types where paid_locally = \'t\'')

// Create a list to store strings
List<WebElement> DataBaseEnableFopList = new ArrayList()

List<WebElement> FilterFopList = new ArrayList()

for (int i = 1; i <= rowCount; i++) {
    String enableFop = CustomKeywords.'database.DatabaseUtils.executeQuery'('select * from bdmozart.mc_fop_types where paid_locally = \'t\'', 
        'fop_type', i)

    println(enableFop)

    // Add strings to the list
    DataBaseEnableFopList.add(enableFop)
}

//open web
CustomKeywords.'demoPackage.MozartLogin.LoginWithChromeForEK'()

WebUI.click(findTestObject('EK_Objects/Page_Mozart - Dashboard/a_Refunds'))

WebUI.click(findTestObject('EK_Objects/Page_Mozart - Dashboard/Click_On_Local_Settlements'))

WebUI.click(findTestObject('EK_Objects/Page_Mozart - LocalSettlements/filter_button'))

WebUI.click(findTestObject('Object Repository/EK_Objects/Page_Mozart - LocalSettlements/textbox_filter_r2_c3'))

List<WebElement> FopValues = WebUI.findWebElements(findTestObject('EK_Objects/Page_Mozart - LocalSettlements/filter_RefundFopPaidLocally_values'), 
    10)

TestObject dynamicTestObject = new TestObject()

println(FopValues.size())

for (int row = 1; row <= FopValues.size(); row++) {
    String dynamicXPath = ('(//div[@id=\'bs-select-16\']/ul[@class=\'dropdown-menu inner show\']/li)[' + row) + ']'

    dynamicTestObject.addProperty('xpath', ConditionType.EQUALS, dynamicXPath)

    WebElement editButtonElement = WebUI.findWebElement(dynamicTestObject, 10)

    FilterFopList.add(editButtonElement.getText())

    println(editButtonElement.getText())
}

//Validation
WebUI.verifyMatch(DataBaseEnableFopList.size().toString(), FilterFopList.size().toString(), true, FailureHandling.CONTINUE_ON_FAILURE)

Set<String> uniqueFopValues = new HashSet()

try {
    for (int i = 0; i < FilterFopList.size(); i++) {
        uniqueFopValues.add(FilterFopList.get(i).substring(0, 2))
    }
}
catch (Exception e) {
    CustomKeywords.'utilityClass.CustomSoftAssert.assertTrue'(false, 'Duplicate FOP found in filter')
} 

List<WebElement> webFopValues = new ArrayList(uniqueFopValues)

// Sort both lists
Collections.sort(webFopValues)

Collections.sort(DataBaseEnableFopList)

// Compare the sorted lists
for (int i = 0; i < DataBaseEnableFopList.size(); i++) {
    WebUI.verifyMatch(webFopValues[i], DataBaseEnableFopList[i], true, FailureHandling.CONTINUE_ON_FAILURE)
}

//boolean areEqual = webFopValues.equals(DataBaseEnableFopList)
//CustomKeywords.'utilityClass.CustomSoftAssert.assertTrue'(areEqual, 'FOP found in filter is not matchnig')
CustomKeywords.'utilityClass.CustomSoftAssert.assertAll'()
WebUI.closeBrowser()
