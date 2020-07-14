package com.mobileappcompanyregister.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name = "company") // table name that will be created by this class
public class CompanyEntity implements Serializable {

	private static final long serialVersionUID = -1052337995548745186L;

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String companyId;

	@Column(nullable = false, length = 30)
	private String companyName;

	@Column(nullable = false, length = 50)
	private String companyEmail;

	@Column(nullable = false, length = 20)
	private String companyPhoneNumber;

	@Column(nullable = false, length = 50)
	private String companyRegisterationNumber;

	@Column(nullable = false, length = 999)
	private String numberOfVehicles;

	@Column(nullable = false)
	private String encryptedPassword;

	private String emailVerificationToken;

	@Column(nullable = false)
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