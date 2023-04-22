package com.infy.StudentKafkaService.Exception;

import java.time.LocalDateTime;

public class ErrorDetails 
{
	private LocalDateTime timestamp;
	private String errorMessage;
	private String errorPath;
	private String errorCode;
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorPath() {
		return errorPath;
	}
	public void setErrorPath(String errorPath) {
		this.errorPath = errorPath;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public ErrorDetails(LocalDateTime timestamp, String errorMessage, String errorPath, String errorCode) {
		super();
		this.timestamp = timestamp;
		this.errorMessage = errorMessage;
		this.errorPath = errorPath;
		this.errorCode = errorCode;
	}
	public ErrorDetails() {
		super();
	}
}
