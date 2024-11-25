package apiRequests
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import demoPackage.UtilityDemo
import groovy.json.JsonSlurper
import internal.GlobalVariable




class apiConnection {

	UtilityDemo utilitydemo = new UtilityDemo()

	@Keyword
	public String getJsonKeyValue1(def requestObject, String keyName) {
		def response = WS.sendRequest(requestObject)
		def responseContent = response.getResponseText()

		if (responseContent) {
			def slurper = new JsonSlurper()
			def json = slurper.parseText(responseContent)
			return json[keyName]
		} else {
			return null
		}
	}

	@Keyword
	def runAuthToken(TestObject authObject) {
		def responseObj = WS.sendRequest(authObject)

		WS.verifyResponseStatusCode(responseObj, 200)

		def responseContent = responseObj.getResponseText()

		def slurper = new JsonSlurper()

		def json = slurper.parseText(responseContent)

		def encodedValue = json.encoded

		String str = (encodedValue+"")

		GlobalVariable.AuthToken = str

		println('auth value updated'+ GlobalVariable.AuthToken)

		// Call this method for update Request Number or Request date
		utilitydemo.requestNumber()
	}

	@Keyword
	def getJsonKeyValue(def requestObject , String keyName) {
		def responseObj = requestObject

		WS.verifyResponseStatusCode(responseObj, 200)

		def responseContent = responseObj.getResponseText()

		def slurper = new JsonSlurper()

		def json = slurper.parseText(responseContent)

		def KeyValue = json.keyName

		String str = (KeyValue+"")

		println('Value of '+keyName +' : '+ KeyValue)
	}


	@Keyword
	def addBasicAuthorizationProperty(TestObject request) {
		if (request instanceof RequestObject) {

			String authorizationValue = "Basic " + GlobalVariable.AuthToken

			// Find available basic authorization field and change its value to the new one, if any
			List<TestObjectProperty> headerProperties = request.getHttpHeaderProperties()

			boolean fieldExist = false
			for (int i = 0; i < headerProperties.size(); i++) {
				TestObjectProperty headerField = headerProperties.get(i)
				if (headerField.getName().equals('Authorization')) {
					KeywordUtil.logInfo("Found existent basic authorization field. Replacing its value.")
					headerField.setValue(authorizationValue)
					fieldExist = true
					break
				}
			}

			if (!fieldExist) {
				TestObjectProperty authorizationProperty = new TestObjectProperty("Authorization",
						ConditionType.EQUALS, authorizationValue, true)
				headerProperties.add(authorizationProperty)
			}
			KeywordUtil.markPassed("Basic authorization field has been added to request header")
		}
		else {
			KeywordUtil.markFailed(request.getObjectId() + "is not a RequestObject")
		}

		def responseContent = request.getResponseText()

		def slurper = new JsonSlurper()

		def json = slurper.parseText(responseContent)

		def encodedValue = json.encoded

		String str = (encodedValue+"")

		println(str)

		return request
	}
}