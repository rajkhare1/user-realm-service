package com.raj.rest.webservices.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.raj.rest.webservices.user.UserNotFoundException;
import com.raj.rest.webservices.user.exception.DuplicateRealmNameException;
import com.raj.rest.webservices.user.exception.InvalidRealmNameException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
		
		Error error = new Error(ex.getMessage());
		
		 return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleAllException(UserNotFoundException ex, WebRequest request) {
		
		Error error = new Error(ex.getMessage());
		
		 return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		Error error = new Error("Validation Failed");
		
		 return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
		 
	}
	
	@ExceptionHandler(DuplicateRealmNameException.class)
	public final ResponseEntity<Object> handleDuplicateRealmNameException(DuplicateRealmNameException ex, WebRequest request) {
		
		Error error = new Error("DuplicateRealmName");
		
		 return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidRealmNameException.class)
	public final ResponseEntity<Object> handleInvalidRealmNameException(InvalidRealmNameException ex, WebRequest request) {
		
		Error error = new Error("InvalidRealmName");
		
		 return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	}
	
}
