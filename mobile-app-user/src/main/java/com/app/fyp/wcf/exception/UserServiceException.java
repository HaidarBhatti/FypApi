package com.app.fyp.wcf.exception;

public class UserServiceException extends RuntimeException {

	private static final long serialVersionUID = 1189297034035869265L;

	// customized error we created this just that we don't want to use the runtime
	// exception we want our own exception

	public UserServiceException(String message) {
		super(message);
	}

}
