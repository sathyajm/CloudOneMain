package com.rest.license.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.xml.sax.SAXException;

import com.rest.license.service.LicenseKeyService;
import com.rest.license.service.SoapEndPointSerivce;

@RestController
public class LicenseKeyController {
	
	@Autowired 
	public LicenseKeyService licenseKeyService ;
	
	@Autowired 
	public SoapEndPointSerivce soapEndPointSerivce ;

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value="/licensekey",method = RequestMethod.POST)
	public  Map<String, Object>   checkLogin(@RequestBody LicenseKeyService licenseKeyService) {
		
		if(licenseKeyService.getKeyType().equals("TEMP") || licenseKeyService.getKeyType().equals("PERM")) {
		
	
			licenseKeyService.setKeyType(licenseKeyService.getKeyType());
			licenseKeyService.setKeyProtocol(licenseKeyService.getKeyProtocol());
			licenseKeyService.setKeyVersion(licenseKeyService.getKeyVersion());
			licenseKeyService.setHardwareSerialNumber(licenseKeyService.getHardwareSerialNumber());
			licenseKeyService.setsOLineNumber(licenseKeyService.getsOLineNumber());
			licenseKeyService.setsONumber(licenseKeyService.getsONumber());
		String resXml = soapEndPointSerivce.genderateLicense(licenseKeyService);
		
//		 System.out.println(resXml);
		
		try {
			 Map<String,Object> resObj = new HashMap<String, Object>();
			 if(licenseKeyService.getKeyType().equals("TEMP")) {
				  resObj =	soapEndPointSerivce.xmlStringtodocParser(resXml);
					return resObj; 
			 }
			 if(licenseKeyService.getKeyType().equals("PERM")) {
				 List<Map<String, String>> licenseKeys =	soapEndPointSerivce.xmlPermStringtodocParser(resXml);
				 resObj.put("Message", "Success");
				 resObj.put("licenseKeys", licenseKeys);
			 }
			 return resObj; 
			   
		    
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			 HashMap<String, Object> map = new HashMap<>();
			    map.put("Message", "Failed");
			    map.put("Status", "Failed");
	
			    return map;
			// TODO Auto-generated catch block
		
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 HashMap<String, Object> map = new HashMap<>();
			    map.put("Message", "Failed");
			    map.put("Status", "Failed");
	
			    return map;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 HashMap<String, Object> map = new HashMap<>();
			    map.put("Message", "Failed");
			    map.put("Status", "Failed");
	
			    return map;
		}
		
		}
		
		else {
			HashMap<String, Object> map = new HashMap<>();
		    map.put("Message", "Please provide correct KeyType. Value should be TEMP or PERM");
		    map.put("Status", "Failed");

		    return map;
		}
		
	}
		

}
