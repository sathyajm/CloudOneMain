package com.rest.license.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.rest.license.model.LicenseKey;
import com.rest.license.model.LicenseKeyOutput;

@Service
public class LicenseKeyServiceImpl implements LicenseKeyService {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	public SoapEndPointSerivce soapEndPointSerivce;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public LicenseKeyOutput getTempLicenseKeyDetails(LicenseKey LicenseKeyIn) throws Exception {
		// TODO Auto-generated method stub
		log.info("Inside LicenseKeyServiceImpl getTempLicenseKeyDetails LicenseKeyIn=" + LicenseKeyIn);
		LicenseKeyOutput licenseKeyOutput = new LicenseKeyOutput();

		String resXml = soapEndPointSerivce.getLicenceDetailsFromSOA(LicenseKeyIn);
		
		log.info("Got Response XML for TEMP=" + resXml);
		
		return soapEndPointSerivce.getTempLicenseKeyObject(resXml);
		
	}

	@Override
	public List<LicenseKeyOutput> getPermLicenseKeyDetails(LicenseKey LicenseKeyIn) throws Exception {
		// TODO Auto-generated method stub
		log.info("Inside LicenseKeyServiceImpl getPermLicenseKeyDetails LicenseKeyIn=" + LicenseKeyIn);
		LicenseKeyOutput licenseKeyOutput = new LicenseKeyOutput();
		
		String resXml = soapEndPointSerivce.getLicenceDetailsFromSOA(LicenseKeyIn);
		
		log.info("Got Response XML for PERM=" + resXml);
		
		return soapEndPointSerivce.getPermLicenseKeyObject(resXml);

		
	}

}
