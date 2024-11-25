<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>MOZ-12909_Full_Refund_Embedded TKT</name>
   <tag></tag>
   <elementGuidId>84369958-5447-43fc-a662-24eb820ca34f</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <authorizationRequest>
      <authorizationInfo>
         <entry>
            <key>bearerToken</key>
            <value>${GlobalVariable.AuthToken}</value>
         </entry>
      </authorizationInfo>
      <authorizationType>Bearer</authorizationType>
   </authorizationRequest>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;API_Version\&quot;: \&quot;1\&quot;,\n    \&quot;Refund_Requests\&quot;: [{\n        \&quot;Refund_Request\&quot;:{\n            \&quot;Refund_source\&quot;: 5,\n            \&quot;Refund_type\&quot;: \&quot;RF\&quot;,\n            \&quot;Non-PAX\&quot;: \&quot;N\&quot;,\n            \&quot;Airline\&quot;: \&quot;176\&quot;,\n            \&quot;Ticket_Number\&quot;: \&quot;6747279577\&quot;,\n            \&quot;Request_Number\&quot;: \&quot;${GlobalVariable.RequestNumber}\&quot;,\n            \&quot;Country\&quot;: \&quot;JO\&quot;,\n            \&quot;Attachments_Indicator\&quot;: \&quot;N\&quot;\n        },\n        \&quot;quote\&quot;: \&quot;$GlobalVariable.QuoteString\&quot;\n    }]\n}&quot;,
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
      <webElementGuid>3df2abff-39ee-4c22-bc4f-48960ed34ef1</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Accept</name>
      <type>Main</type>
      <value>*/*</value>
      <webElementGuid>36f4dbe2-b747-41a7-8cfc-17d9f4cd294a</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Accept-Encoding</name>
      <type>Main</type>
      <value>gzip, deflate, br</value>
      <webElementGuid>162c5217-e38c-4340-8ac8-6c6e8b4a28a2</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Connection</name>
      <type>Main</type>
      <value>keep-alive</value>
      <webElementGuid>e677c0db-8754-4bf3-8caa-78477a4fcb3a</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Cache-Control</name>
      <type>Main</type>
      <value>no-cache</value>
      <webElementGuid>2e36aa95-6214-4451-81a9-9f9b77479091</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer ${GlobalVariable.AuthToken}</value>
      <webElementGuid>5a32c146-9bf9-4952-b7a9-df30f1744457</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>9.4.0</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://vwtwmozart221/Mozart_Webservice/api/refunds/request</restUrl>
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
