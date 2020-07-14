package com.mobileappcompanyregister.exceptions;


import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.mobileappcompanyregister.ui.model.response.ErrorMessage;


@ControllerAdvice
public class AppExceptionsHandler {

	// this file is used for custom error messages here we are just send back the
	// time and the cause that is creating an error like missing some fields like
	// last name etc just to save our precious info from disclousier

	@ExceptionHandler(value = { UserServiceException.class })
	public ResponseEntity<Object> handleUserServiceException(UserServiceException ex, WebRequest request) {

		ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage());

		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	//this method below is used for all kind of exceptions 
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleOtherException(Exception ex, WebRequest request) {

		ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage());

		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
