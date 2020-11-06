package com.rest.license.service;

import org.springframework.stereotype.Service;

@Service
public class LicenseKeyService {
	

	private String keyType;
	private String hardwareSerialNumber;
	private String sONumber;
	private String sOLineNumber;
	private String keyVersion;
	private String keyProtocol;
	public String getHardwareSerialNumber() {
		return hardwareSerialNumber;
	}
	public void setHardwareSerialNumber(String hardwareSerialNumber) {
		this.hardwareSerialNumber = hardwareSerialNumber;
	}
	public String getsONumber() {
		return sONumber;
	}
	public void setsONumber(String sONumber) {
		this.sONumber = sONumber;
	}
	public String getsOLineNumber() {
		return sOLineNumber;
	}
	public void setsOLineNumber(String sOLineNumber) {
		this.sOLineNumber = sOLineNumber;
	}
	public String getKeyVersion() {
		return keyVersion;
	}
	public void setKeyVersion(String keyVersion) {
		this.keyVersion = keyVersion;
	}
	public String getKeyProtocol() {
		return keyProtocol;
	}
	public void setKeyProtocol(String keyProtocol) {
		this.keyProtocol = keyProtocol;
	}
	
	public String getKeyType() {
		return keyType;
	}
	public void setKeyType(String keyType) {
		this.keyType = keyType;
	}

}
