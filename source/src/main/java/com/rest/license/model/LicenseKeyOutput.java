package com.rest.license.model;

import java.util.List;

public class LicenseKeyOutput {
	
	private String keyType;
	private String hardwareSerialNumber;
	private String sONumber;
	private String sOLineNumber;
	private String keyVersion;
	private String keyProtocol;
	private String licenseKey;
	private String status;
	private String licenseExpiryDate;
	private String protocol;
	private String keyGenLicenseSerialNumber;
	private String accessKeyId;
	public String getAccessKeyId() {
		return accessKeyId;
	}
	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}
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
	public String getLicenseKey() {
		return licenseKey;
	}
	public void setLicenseKey(String licenseKey) {
		this.licenseKey = licenseKey;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLicenseExpiryDate() {
		return licenseExpiryDate;
	}
	public void setLicenseExpiryDate(String licenseExpiryDate) {
		this.licenseExpiryDate = licenseExpiryDate;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getKeyGenLicenseSerialNumber() {
		return keyGenLicenseSerialNumber;
	}
	public void setKeyGenLicenseSerialNumber(String keyGenLicenseSerialNumber) {
		this.keyGenLicenseSerialNumber = keyGenLicenseSerialNumber;
	}
	
	@Override
	public String toString() {
		return "LicenseKeyOutput [keyType=" + keyType + ", hardwareSerialNumber=" + hardwareSerialNumber + ", sONumber="
				+ sONumber + ", sOLineNumber=" + sOLineNumber + ", keyVersion=" + keyVersion + ", keyProtocol="
				+ keyProtocol + ", licenseKey=" + licenseKey + ", status=" + status + ", licenseExpiryDate="
				+ licenseExpiryDate + ", protocol=" + protocol + ", keyGenLicenseSerialNumber="
				+ keyGenLicenseSerialNumber + "]";
	}
	
	
}