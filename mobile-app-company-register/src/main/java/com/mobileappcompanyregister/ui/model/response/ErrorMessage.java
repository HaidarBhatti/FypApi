package com.mobileappcompanyregister.ui.model.response;

import java.util.Date;

public class ErrorMessage {

	// here we can add any variable to show error in our program like here we are
	// showing the time and the cause that is creating the error
	
	// but we can add as many error messages as we want to show

	private Date timestamp;
	private String message;

	public ErrorMessage() {
	}

	public ErrorMessage(Date timestamp, String message) {

		this.timestamp = timestamp;
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
