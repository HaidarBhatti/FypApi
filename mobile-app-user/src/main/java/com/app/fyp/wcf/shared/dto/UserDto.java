package com.app.fyp.wcf.shared.dto;

import java.io.Serializable;

public class UserDto implements Serializable {

	private static final long serialVersionUID = 1674591421950327719L;
	private long id;
	private String userId;
	private String fullName;
	private String email;
	private String phoneNumber;
	private String cnicNumber;
	private String address;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCnicNumber() {
		return cnicNumber;
	}

	public void setCnicNumber(String cnicNumber) {
		this.cnicNumber = cnicNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
