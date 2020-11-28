package com.cred.io.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	public static final String DEFAULT_ERROR_VIEW = "error";
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<String> defaultErrorHandler(HttpServletResponse req, Exception e) throws Exception {
	
		return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	

}
