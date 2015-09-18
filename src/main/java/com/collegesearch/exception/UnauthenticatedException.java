package com.collegesearch.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.UNAUTHORIZED, reason="Authentication Failed") 
public class UnauthenticatedException extends CollegeSearchException {
	private static final long serialVersionUID = -34724706273251377L;
    public UnauthenticatedException() { 
    	super(); 
    	this.errorMessage = "Authentication Failed"; 
    	if(errorType == null)
    	   errorType = "UnauthenticatedException"; 	
    }
    
    public UnauthenticatedException(String errorMessage) {
    	super("Authentication Failed. " + errorMessage);
    }
    
    public UnauthenticatedException(String errorMessage, Throwable cause) { 
    	super("Authentication Failed: " + errorMessage, cause);
    }

}
