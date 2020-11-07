package com.rest.license.model;

public class LicenseKey {

	private String keyType;
	private String hardwareSerialNumber;
	private String sONumber;
	private String sOLineNumber;
	private String keyVersion;
	private String keyProtocol;
	
	public String getKeyType() {
		return keyType;
	}
	public void setKeyType(String keyType) {
		this.keyType = keyType;
	}
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
	
	@Override
	public String toString() {
		return "LicenseKey [keyType=" + keyType + ", hardwareSerialNumber=" + hardwareSerialNumber + ", sONumber="
				+ sONumber + ", sOLineNumber=" + sOLineNumber + ", keyVersion=" + keyVersion + ", keyProtocol="
				+ keyProtocol + "]";
	}	
	
}