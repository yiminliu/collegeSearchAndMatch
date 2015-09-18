package com.collegesearch.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Input Parameter Error") 
public class InputParamException extends CollegeSearchException {
	private static final long serialVersionUID = -3447273251377L;
    public InputParamException() {
    	super();
    	this.errorMessage = "Input Parameter Error";
    	if(errorType == null)
    	   errorType = "Input Parameter Error";
    }
    
    public InputParamException(String message) { 
       super("Input Parameter Error: " + message);
    }
    
    public InputParamException(String message, Throwable cause) { 
       super("Input Parameter Error: " + message, cause);
    }
}
