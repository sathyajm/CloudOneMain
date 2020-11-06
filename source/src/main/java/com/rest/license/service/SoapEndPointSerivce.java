package com.rest.license.service;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

@Service
public class SoapEndPointSerivce {
	public String SOAP_END_POINT_URL = "http://soadev1.corp.netapp.com:9009/LicenseKeyRequestor_OSB/ProxyService/LicenseKeyRequestorToBPEL?wsdl";
	
	public String genderateLicense(LicenseKeyService licenseKeyService) {
		
		   final ResponseEntity<String>  response;
			

			 String xmlString = "";
		
			 if(licenseKeyService.getKeyType().equals("TEMP")) {
				 
//				 System.out.println("tempkey");
//				 System.out.println(loginService.getKeyType());
				 
				  xmlString = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:lic=\"http://www.netapp.com/schemas/LicenseKeyCanonical\" xmlns:meta=\"http://www.netapp.com/schemas/Meta\">\r\n"
							+ "   <soapenv:Header/>\r\n"
							+ "   <soapenv:Body>\r\n"
							+ "      <lkc:GenerateLicenseKeyRequest xsi:schemaLocation=\"http://www.netapp.com/schemas/LicenseKeyCanonical bpel/LicenseKeyCanonical.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://www.netapp.com/schemas/LicenseKeyCanonical\" xmlns:lkc=\"http://www.netapp.com/schemas/LicenseKeyCanonical\">\r\n"
							+ "         <lkc:ApplicationArea xmlns=\"http://www.netapp.com/schemas/Meta\">\r\n"
							+ "            <lkc:Sender>SAP</lkc:Sender>\r\n"
							+ "            <lkc:Targets>\r\n"
							+ "               <lkc:Target>\r\n"
							+ "                  <lkc:Name>INTEGRATION</lkc:Name>\r\n"
							+ "               </lkc:Target>\r\n"
							+ "            </lkc:Targets>\r\n"
							+ "            <lkc:ApplicationTransactionId AppName=\"SAP\">AppTrx123</lkc:ApplicationTransactionId>\r\n"
							+ "            <lkc:BizObjectList>\r\n"
							+ "               <lkc:BizObject>\r\n"
							+ "                  <lkc:Name>KEYGENERATIONREQUEST</lkc:Name>\r\n"
							+ "                  <lkc:Value>AppTrx123</lkc:Value>\r\n"
							+ "               </lkc:BizObject>\r\n"
							+ "            </lkc:BizObjectList>\r\n"
							+ "            <lkc:DocumentType>Request</lkc:DocumentType>\r\n"
							+ "            <lkc:Timestamp>2020-10-13T07:28:58</lkc:Timestamp>\r\n"
							+ "         </lkc:ApplicationArea>\r\n"
							+ "         <lkc:DataArea>\r\n"
							+ "            <lkc:Action xmlns=\"http://www.netapp.com/schemas/Meta\">NEW</lkc:Action>\r\n"
							+ "            <lkc:LicenseKeyCanonical>\r\n"
							+ "               <lkc:KeyType>"+licenseKeyService.getKeyType()+"</lkc:KeyType>\r\n"
							+ "               <lkc:KeyVersion>"+licenseKeyService.getKeyVersion()+"</lkc:KeyVersion>\r\n"
							+ "               <lkc:KeyProtocol>"+licenseKeyService.getKeyProtocol()+"</lkc:KeyProtocol>\r\n"
							+ "            </lkc:LicenseKeyCanonical>\r\n"
							+ "         </lkc:DataArea>\r\n"
							+ "      </lkc:GenerateLicenseKeyRequest>\r\n"
							+ "   </soapenv:Body>\r\n"
							+ "</soapenv:Envelope>";
			 }
			 
			 if(licenseKeyService.getKeyType().equals("PERM")) {
				  xmlString = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:lic=\"http://www.netapp.com/schemas/LicenseKeyCanonical\" xmlns:meta=\"http://www.netapp.com/schemas/Meta\">   <soapenv:Header/>\r\n"
				  		+ "<soapenv:Body>\r\n"
				  		+ "<GenerateLicenseKeyRequest xmlns=\"http://www.netapp.com/schemas/LicenseKeyCanonical\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n"
				  		+ "	<ApplicationArea xmlns=\"http://www.netapp.com/schemas/Meta\">\r\n"
				  		+ "		<Sender>OTP</Sender>\r\n"
				  		+ "		<Targets>\r\n"
				  		+ "			<Target>\r\n"
				  		+ "				<Name>INTEGRATION</Name>\r\n"
				  		+ "			</Target>\r\n"
				  		+ "		</Targets>\r\n"
				  		+ "		<ApplicationTransactionId AppName=\"OTP\">CME_"+licenseKeyService.getHardwareSerialNumber()+"_08312018143539</ApplicationTransactionId>\r\n"
				  		+ "		<BizObjectList>\r\n"
				  		+ "			<BizObject>\r\n"
				  		+ "				<Name>KEYGENERATIONREQUEST</Name>\r\n"
				  		+ "				<Value>CME_"+licenseKeyService.getHardwareSerialNumber()+"_08312018143539</Value>\r\n"
				  		+ "			</BizObject>\r\n"
				  		+ "		</BizObjectList>\r\n"
				  		+ "		<DocumentType>Request</DocumentType>\r\n"
				  		+ "	</ApplicationArea>\r\n"
				  		+ "	<DataArea>\r\n"
				  		+ "		<Action xmlns=\"http://www.netapp.com/schemas/Meta\">NEW</Action>\r\n"
				  		+ "		<LicenseKeyCanonical>\r\n"
				  		+ "			<HardwareSerialNumber>"+licenseKeyService.getHardwareSerialNumber()+"</HardwareSerialNumber>\r\n"
				  		+ "			<OldSerialNumber/>\r\n"
				  		+ "			<SONumber>"+licenseKeyService.getsONumber()+"</SONumber>\r\n"
				  		+ "			<SOLineNumber>"+licenseKeyService.getsOLineNumber()+"</SOLineNumber>\r\n"
				  		+ "			<KeyType>"+licenseKeyService.getKeyType()+"</KeyType>\r\n"
				  		+ "		</LicenseKeyCanonical>\r\n"
				  		+ "	</DataArea>\r\n"
				  		+ "</GenerateLicenseKeyRequest>   \r\n"
				  		+ "</soapenv:Body>\r\n"
				  		+ "</soapenv:Envelope>";
				 
			 }
			
		    RestTemplate restTemplate =  new RestTemplate();
		    //Create a list for the message converters
		    List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		    //Add the String Message converter
		    messageConverters.add(new StringHttpMessageConverter());
		    //Add the message converters to the restTemplate
		    restTemplate.setMessageConverters(messageConverters);
		    HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.TEXT_XML);
		    HttpEntity<String> request = new HttpEntity<String>(xmlString, headers);
		    try {
		    	  response = restTemplate.postForEntity(SOAP_END_POINT_URL, request, String.class);
		    	  return response.getBody();
	     } catch (HttpStatusCodeException exception) {
	     	  String errorpayload = exception.getResponseBodyAsString();
	     	  System.out.println(errorpayload);
		     	
	     	 throw new ResponseStatusException(
	     	        HttpStatus.INTERNAL_SERVER_ERROR, "Invalid Payload Message.");
	     	// return new ResponseEntity<>(errorpayload, HttpStatus.EXPECTATION_FAILED);
	     }
  	 	
	}
	
	public  Map<String, Object> xmlStringtodocParser(String xml)  throws ParserConfigurationException, SAXException, IOException {
		  DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
	         Document document = docBuilder.parse(new InputSource(new StringReader(xml)));
	         String KeyGenLicenseSerialNumber = document.getElementsByTagName("ns0:KeyGenLicenseSerialNumber").item(0).getTextContent();   
		      String LicenseKey = document.getElementsByTagName("ns0:LicenseKey").item(0).getTextContent();   
		      String LicenseExpiryDate = document.getElementsByTagName("ns0:LicenseExpiryDate").item(0).getTextContent();  
		      String Protocol = document.getElementsByTagName("ns0:Protocol").item(0).getTextContent(); 
		      HashMap<String, Object> map = new HashMap<>();
		      map.put("KeyGenLicenseSerialNumber", KeyGenLicenseSerialNumber);
		      map.put("LicenseKey", LicenseKey);
		      map.put("Protocol", Protocol);
		      map.put("LicenseExpiryDate", LicenseExpiryDate);
			  map.put("Message", "Success");
		      return map;
	
	}
	
	public  List<Map<String , String>> xmlPermStringtodocParser(String xml)  throws ParserConfigurationException, SAXException, IOException {
		  DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
	         Document document = docBuilder.parse(new InputSource(new StringReader(xml)));
	         NodeList nl = document.getElementsByTagName("ns0:Line");
	         List<Map<String, String>> datax = new ArrayList<>();
	         int length = nl.getLength();
	         String LicenseSerialNumber;
	         String KeyGenLicenseSerialNumber;
	         String LicenseKey;
	         String AccessKeyID;
	         List<Map<String , String>> permKeyArray  = new ArrayList<Map<String,String>>();
	     
	         for (int i=0; i<length; i++) {
	             Map<String,String> permKeyObj = new HashMap<String, String>();
	             Element node = (Element) nl.item(i);
	              LicenseSerialNumber = node.getElementsByTagName("ns0:LicenseSerialNumber").item(0).getTextContent();
	              KeyGenLicenseSerialNumber = node.getElementsByTagName("ns0:KeyGenLicenseSerialNumber").item(0).getTextContent();
	              LicenseKey = node.getElementsByTagName("ns0:LicenseKey").item(0).getTextContent();
	              AccessKeyID = node.getElementsByTagName("ns0:AccessKeyID").item(0).getTextContent();
	              permKeyObj.put("LicenseSerialNumber", LicenseSerialNumber);
	              permKeyObj.put("KeyGenLicenseSerialNumber", KeyGenLicenseSerialNumber);
	              permKeyObj.put("LicenseKey", LicenseKey);
	              permKeyObj.put("AccessKeyID", AccessKeyID);
	              permKeyArray.add(i,permKeyObj);
	            
	         }
	         
	         return permKeyArray;
		   
	}	
}
