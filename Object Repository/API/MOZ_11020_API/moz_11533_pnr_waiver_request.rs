<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>moz_11533_pnr_waiver_request</name>
   <tag></tag>
   <elementGuidId>186363b3-d034-4cc3-b0e6-d8a8b4ed0e2e</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <authorizationRequest>
      <authorizationInfo>
         <entry>
            <key>bearerToken</key>
         </entry>
      </authorizationInfo>
      <authorizationType>Bearer</authorizationType>
   </authorizationRequest>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{ \n        \&quot;Airline\&quot;: \&quot;176\&quot;, \n        \&quot;PrimeSale\&quot;: \&quot;2234567890\&quot;,\n        \&quot;SaleDate\&quot;: 20240806,\n        \&quot;Document\&quot;: \&quot;6747279623\&quot;,\n        \&quot;Coupon\&quot;: 2, \n        \&quot;FromAirport\&quot;: \&quot;Kat\&quot;,\n        \&quot;ToAirport\&quot;: \&quot;Aut\&quot;, \n        \&quot;TicketedFlightDate\&quot;: 20240815,\n        \&quot;CouponStatus\&quot;: \&quot;I\&quot;, \n        \&quot;CouponLevelRemarks\&quot;: [\n            { \n                \&quot;SeqNo\&quot;: 1,\n                \&quot;RemarksText\&quot;: \&quot;${GlobalVariable.UniqueNumber}\&quot; \n            },\n            {\n                \&quot;SeqNo\&quot;: 2,\n                \&quot;RemarksText\&quot;: \&quot;${GlobalVariable.UniqueNumber}\&quot;\n            }\n        ]\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>76bc48cf-e40d-4988-97e1-17697161b29f</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer ${GlobalVariable.AuthToken}</value>
      <webElementGuid>401333e6-61b7-445b-908f-48d9222998d5</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>9.5.0</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://vwtwmozart221/Mozart_Webservice/api/pnrwaiver/request</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
