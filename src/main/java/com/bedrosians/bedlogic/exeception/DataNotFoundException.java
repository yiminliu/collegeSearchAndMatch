package com.bedrosians.bedlogic.exeception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.hibernate.exception.DataException;

public class DataNotFoundException extends WebApplicationException{

	private static final long serialVersionUID = -34724706273251377L;
    
	public DataNotFoundException(){
		super();
	}
	
	public DataNotFoundException(String input){
	    ResponseBuilder builder = Response.status(Response.Status.NOT_FOUND);
        builder.entity("Missing idLanguage parameter on request");
        Response response = builder.build();
	}    
	
	DataNotFoundException(Response response){
		super(response);
	}
    
}
