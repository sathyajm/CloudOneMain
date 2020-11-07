package com.rest.license.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.rest.license.model.LicenseKey;
import com.rest.license.model.LicenseKeyOutput;
import com.rest.license.service.LicenseKeyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class LicenseKeyController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	public LicenseKeyService licenseKeyService ;
	
	@RequestMapping(value="/get/temp/key",method = RequestMethod.POST)
	public LicenseKeyOutput getTempLicenseDetails(@RequestBody LicenseKey licenseKeyIn) throws Exception {
		log.info("Inside Controller getLicenseDetails" + licenseKeyIn);
		return licenseKeyService.getTempLicenseKeyDetails(licenseKeyIn);
	}
	
	@RequestMapping(value="/get/perm/key",method = RequestMethod.POST)
	public List<LicenseKeyOutput> getPermLicenseDetails(@RequestBody LicenseKey licenseKeyIn) throws Exception {
		log.info("Inside Controller getLicenseDetails" + licenseKeyIn);
		return licenseKeyService.getPermLicenseKeyDetails(licenseKeyIn);
	}	

}
