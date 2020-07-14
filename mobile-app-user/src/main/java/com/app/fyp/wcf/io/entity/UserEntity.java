package com.app.fyp.wcf.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Users")//table name that will be created by this class 
public class UserEntity implements Serializable {

	
	//this class will create database in the database
	
	
	private static final long serialVersionUID = 8866292531379061199L;

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String userId;

	@Column(nullable = false, length = 50)
	private String fullName;

	@Column(nullable = false, length = 50)
	private String email;

	@Column(nullable = false, length = 20)
	private String phoneNumber;

	@Column(nullable = false, length = 20)
	private String cnicNumber;

	@Column(nullable = false, length = 150)
	private String address;

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
