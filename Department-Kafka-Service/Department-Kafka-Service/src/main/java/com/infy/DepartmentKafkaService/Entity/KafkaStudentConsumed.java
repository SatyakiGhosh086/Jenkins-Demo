package com.infy.DepartmentKafkaService.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class KafkaStudentConsumed 
{
	@Id
	private int studentId;
	private String studentName;
	private int deptId;
	private String dataSentToOrganization = "N";
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDataSentToOrganization() {
		return dataSentToOrganization;
	}
	public void setDataSentToOrganization(String dataSentToOrganization) {
		this.dataSentToOrganization = dataSentToOrganization;
	}
	public KafkaStudentConsumed(int studentId, String studentName, int deptId, String dataSentToOrganization) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.deptId = deptId;
		this.dataSentToOrganization = dataSentToOrganization;
	}
	public KafkaStudentConsumed() {
		super();
	}
	
	
}
