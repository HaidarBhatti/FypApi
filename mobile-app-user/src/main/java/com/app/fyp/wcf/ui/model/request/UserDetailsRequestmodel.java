package com.app.fyp.wcf.ui.model.request;

public class UserDetailsRequestmodel {

	private String fullName;
	private String email;
	private String phoneNumber;
	private String cnicNumber;
	private String address;
	private String password;

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
		this.email= email;
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

	
}
