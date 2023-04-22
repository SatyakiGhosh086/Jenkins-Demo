package com.infy.CommonKafkaService.Events;

import com.infy.CommonKafkaService.ModelDTO.StudentDTO;

public class StudentEvent 
{
	private String message;
	private String status;
	private StudentDTO dtoClass;
	@Override
	public String toString() {
		return "StudentEvent [message=" + message + ", status=" + status + ", dtoClass=" + dtoClass + "]";
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public StudentDTO getDtoClass() {
		return dtoClass;
	}
	public void setDtoClass(StudentDTO dtoClass) {
		this.dtoClass = dtoClass;
	}
	public StudentEvent(String message, String status, StudentDTO dtoClass) {
		super();
		this.message = message;
		this.status = status;
		this.dtoClass = dtoClass;
	}
	public StudentEvent() {
		super();
	}
	
}
