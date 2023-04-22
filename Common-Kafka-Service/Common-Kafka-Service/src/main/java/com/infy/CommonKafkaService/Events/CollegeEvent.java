package com.infy.CommonKafkaService.Events;

import com.infy.CommonKafkaService.ModelDTO.CollegeDTO;
import com.infy.CommonKafkaService.ModelDTO.DepartmentDTO;

public class CollegeEvent 
{
	private String message;
	private String status;
	private CollegeDTO collegeDTO;
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
	public CollegeDTO getCollegeDTO() {
		return collegeDTO;
	}
	public void setCollegeDTO(CollegeDTO collegeDTO) {
		this.collegeDTO = collegeDTO;
	}
	@Override
	public String toString() {
		return "DepartmentEvent [message=" + message + ", status=" + status + ", collegeDTO=" + collegeDTO + "]";
	}
	public CollegeEvent(String message, String status, CollegeDTO collegeDTO) {
		super();
		this.message = message;
		this.status = status;
		this.collegeDTO = collegeDTO;
	}
	public CollegeEvent() {
		super();
	}
	
}
