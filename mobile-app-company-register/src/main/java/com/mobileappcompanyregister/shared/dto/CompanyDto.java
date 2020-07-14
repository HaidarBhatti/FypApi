package com.mobileappcompanyregister.shared.dto;

import java.io.Serializable;

public class CompanyDto implements Serializable {

	private static final long serialVersionUID = -2773520520440491010L;

	private long id;
	private String companyId;
	private String companyName;
	private String companyEmail;
	private String companyPhoneNumber;
	private String companyRegisterationNumber;
	private String numberOfVehicles;
	private String password;
	private String encryptedPassword;
	private String emailVerificationToken;
	private boolean emailVerificationStatus = false;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getCompanyPhoneNumber() {
		return companyPhoneNumber;
	}

	public void setCompanyPhoneNumber(String companyPhoneNumber) {
		this.companyPhoneNumber = companyPhoneNumber;
	}

	public String getCompanyRegisterationNumber() {
		return companyRegisterationNumber;
	}

	public void setCompanyRegisterationNumber(String companyRegisterationNumber) {
		this.companyRegisterationNumber = companyRegisterationNumber;
	}

	public String getNumberOfVehicles() {
		return numberOfVehicles;
	}

	public void setNumberOfVehicles(String numberOfVehicles) {
		this.numberOfVehicles = numberOfVehicles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getEmailVerificationToken() {
		return emailVerificationToken;
	}

	public void setEmailVerificationToken(String emailVerificationToken) {
		this.emailVerificationToken = emailVerificationToken;
	}

	public boolean isEmailVerificationStatus() {
		return emailVerificationStatus;
	}

	public void setEmailVerificationStatus(boolean emailVerificationStatus) {
		this.emailVerificationStatus = emailVerificationStatus;
	}

}
