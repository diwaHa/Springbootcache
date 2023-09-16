 package com.pratice.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResorceNotFoundException extends RuntimeException{
	
	
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	//when data is'nt exists database to client
	private String resourceName;
	private String fieldName;
	private Object fieldValue; 
	
	//to create constructor for sending error msg's
	public ResorceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
		super(String.format( "%s is not found with %s : '%s'",resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	//getter class
	
	public String getResourceName() {
		return resourceName;
	}
	
	public String getFieldName() {
		return fieldName;
	}
	
	public Object getFieldValue() {
		return fieldValue;
	}
	
		
	
}
