package com.infy.StudentKafkaService.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException
{
	private String fieldName;
	private int fieldValue;
	private String resource;
	public StudentNotFoundException(String fieldName, int fieldValue, String resource) {
		super(resource+" not found for "+fieldName+" : "+fieldValue);
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
		this.resource = resource;
	}
	
}
