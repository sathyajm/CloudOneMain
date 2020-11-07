package com.rest.license.service;

import java.util.List;

import com.rest.license.model.LicenseKey;
import com.rest.license.model.LicenseKeyOutput;

public interface LicenseKeyService {
	
	public LicenseKeyOutput getTempLicenseKeyDetails(LicenseKey LicenseKeyIn) throws Exception;
	
	public List<LicenseKeyOutput> getPermLicenseKeyDetails(LicenseKey LicenseKeyIn) throws Exception;
	
}