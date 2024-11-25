<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Full Refund</name>
   <tag></tag>
   <elementGuidId>ca7cec41-6850-408a-a444-957f7017e2e4</elementGuidId>
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
  &quot;text&quot;: &quot;{\n    \&quot;API_Version\&quot;: \&quot;1\&quot;,\n    \&quot;Refund_Requests\&quot;: [{\n        \&quot;Refund_Request\&quot;:{\n            \&quot;Refund_source\&quot;: \&quot;5\&quot;,\n            \&quot;Refund_type\&quot;: \&quot;RF\&quot;,\n            \&quot;Non-PAX\&quot;: \&quot;N\&quot;,\n            \&quot;Request_Number\&quot;: \&quot;${GlobalVariable.RequestNumber}\&quot;,\n            \&quot;Request_Date\&quot;: \&quot;${GlobalVariable.RequestDate}\&quot;,\n            \&quot;Airline\&quot;: \&quot;176\&quot;,\n            \&quot;Ticket_Number\&quot;: \&quot;6747279570\&quot;,\n            \&quot;Country\&quot;: \&quot;IN\&quot;,\n            \&quot;Issue_date\&quot;: \&quot;20221123\&quot;,\n            \&quot;PNR\&quot;: \&quot;123456\&quot;,\n            \&quot;Agent_Remarks\&quot;: \&quot;This request is sent by automation(rv)\&quot;,\n            \&quot;Refund_Reason\&quot;: \&quot;Refund_Reason\&quot;, \n                \n            \n            \&quot;Refundability_Indicator\&quot;: \&quot;N\&quot;,\n            \&quot;Involuntary_Refund\&quot;: \&quot;N\&quot;,\n            \&quot;Secondary_Refund\&quot;: \&quot;Y\&quot;,\n            \&quot;Flag_Stat\&quot;: \&quot;FFF\&quot;,\n            \&quot;Station_Draft\&quot;: \&quot;ST_Draft\&quot;,\n            \&quot;Action_Code\&quot;: \&quot;01\&quot;,\n            \&quot;Gift_Certificate\&quot;: \&quot;Y\&quot;,\n            \&quot;Certificate_Number\&quot;: \&quot;Certificate_Number\&quot;,\n            \&quot;Frequent_Flyer_Number\&quot;: \&quot;FFNumber\&quot;,\n            \&quot;Requested_Amount\&quot;: 20,\n            \&quot;Requested_FOP\&quot;: \&quot;FOP\&quot;,\n            \&quot;Currency\&quot;: \&quot;USD\&quot;,\n            \&quot;Attachments_Indicator\&quot;: \&quot;N\&quot;,\n            \&quot;Business_Reward_Number\&quot;: \&quot;Reward\&quot;,\n            \&quot;Attachment_Url1\&quot;: \&quot;https://google.com\&quot;,\n            \&quot;Attachment_Url2\&quot;: \&quot;https://w3.accelya.com/\&quot;\n        },\n        \&quot;Conjuction_Information\&quot;: [{\n            \&quot;Refunded_Conj_Ticket\&quot;: \&quot;1234567890\&quot;,\n            \&quot;Refunded_Conj_Ticket_Coupon_Number\&quot;: \&quot;1234\&quot;\n        }, {\n            \&quot;Refunded_Conj_Ticket\&quot;: \&quot;0123456789\&quot;,\n            \&quot;Refunded_Conj_Ticket_Coupon_Number\&quot;: \&quot;1200\&quot;\n        }],\n        \&quot;Passenger_Information\&quot;: {\n            \&quot;Passenger_Name\&quot;: \&quot;name\&quot;,\n            \&quot;Passenger_Mail_Name\&quot;: \&quot;mailname\&quot;,\n            \&quot;Passenger_Email_Address\&quot;: \&quot;mail@test.com, second@test.com\&quot;,\n            \&quot;Passenger_Address_1\&quot;: \&quot;addr1\&quot;,\n            \&quot;Passenger_Address_2\&quot;: \&quot;addr2\&quot;,\n            \&quot;Passenger_City\&quot;: \&quot;Atlanta\&quot;,\n            \&quot;Passenger_State\&quot;: \&quot;US\&quot;,\n            \&quot;Passenger_Zip_Code\&quot;: \&quot;zip\&quot;,\n            \&quot;Passenger_Country\&quot;: \&quot;US\&quot;,\n            \&quot;Title\&quot;: \&quot;TruncationTest----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\&quot;,\n            \&quot;First_Name\&quot;: \&quot;First Name\&quot;,\n            \&quot;Last_Name\&quot;: \&quot;Last Name\&quot;,\n            \&quot;Phone\&quot;: \&quot;123123123\&quot;,\n            \&quot;Second_First_Name\&quot;: \&quot;Second First Name\&quot;,\n            \&quot;Second_Last_Name\&quot;: \&quot;Second Last Name\&quot;\n        },\n        \&quot;Agent_Information\&quot;: {\n            \&quot;Refunding_Agent_Name\&quot;: \&quot;Agent Name\&quot;,\n            \&quot;Refunding_Agent\&quot;: \&quot;1111111\&quot;,\n            \&quot;Refunding_Agent_Email_Address\&quot;: \&quot;test@test.com\&quot;,\n            \&quot;Refunding_Agent_Country\&quot;: \&quot;US\&quot;\n        },\n        \&quot;Refund_Calculation_Information\&quot;: {\n            \&quot;Original_Fare\&quot;: 250,\n            \&quot;Used_Fare\&quot;: 100,\n            \&quot;Balance_Fare\&quot;: 200,\n            \&quot;Penalty_Amount\&quot;: 50,\n            \&quot;Original_Commission_Amount\&quot;: 100,\n            \&quot;Balance_Commission_Amount\&quot;: 100,\n            \&quot;Tax_information\&quot;: [{\n                \&quot;Tax_Code\&quot;: \&quot;US\&quot;,\n                \&quot;Original_Tax_Amount\&quot;: 11000,\n                \&quot;Used_Tax_Amount\&quot;: 80.00,\n                \&quot;Balance_Tax_Amount\&quot;: 11.00\n            }, {\n                \&quot;Tax_Code\&quot;: \&quot;AY\&quot;,\n                \&quot;Original_Tax_Amount\&quot;: 12.20,\n                \&quot;Used_Tax_Amount\&quot;: 0,\n                \&quot;Balance_Tax_Amount\&quot;: 12.20\n            }, {\n                \&quot;Tax_Code\&quot;: \&quot;OB\&quot;,\n                \&quot;Original_Tax_Amount\&quot;: 22.90,\n                \&quot;Used_Tax_Amount\&quot;: 0,\n                \&quot;Balance_Tax_Amount\&quot;: 22.90\n            }]\n        },\n        \&quot;Refund_Payment_Details\&quot;: {\n            \&quot;Credit_Card_Number\&quot;: \&quot;\&quot;,\n        },\n        \&quot;Additional_Fields\&quot;: {\n            \&quot;Filler_1\&quot;: \&quot;fill1\&quot;,\n            \&quot;Filler_2\&quot;: \&quot;fill2\&quot;,\n            \&quot;Filler_3\&quot;: \&quot;fill3\&quot;,\n            \&quot;Filler_4\&quot;: \&quot;fill4\&quot;,\n            \&quot;Filler_5\&quot;: \&quot;fill5\&quot;,\n            \&quot;Filler_6\&quot;: \&quot;fill6\&quot;,\n            \&quot;Filler_7\&quot;: \&quot;fill7\&quot;,\n            \&quot;Filler_8\&quot;: \&quot;fill8\&quot;,\n            \&quot;Filler_9\&quot;: \&quot;fill9\&quot;,\n            \&quot;Filler_10\&quot;: \&quot;fill10\&quot;,\n            \&quot;Filler_11\&quot;: \&quot;fill11\&quot;,\n            \&quot;Filler_12\&quot;: \&quot;fill12\&quot;,\n            \&quot;Filler_13\&quot;: \&quot;fill13\&quot;,\n            \&quot;Filler_14\&quot;: \&quot;fill14\&quot;,\n            \&quot;Filler_15\&quot;: \&quot;fill15\&quot;,\n            \&quot;Filler_16\&quot;: \&quot;fill16\&quot;,\n            \&quot;Filler_17\&quot;: \&quot;fill17\&quot;,\n            \&quot;Filler_18\&quot;: \&quot;fill18\&quot;,\n            \&quot;Filler_19\&quot;: \&quot;fill19\&quot;,\n            \&quot;Filler_20\&quot;: \&quot;fill20\&quot;\n        }\n    }]\n}&quot;,
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
