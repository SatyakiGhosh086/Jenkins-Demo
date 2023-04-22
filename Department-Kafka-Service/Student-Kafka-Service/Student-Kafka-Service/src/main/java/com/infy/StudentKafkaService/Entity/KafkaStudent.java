package com.infy.StudentKafkaService.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class KafkaStudent 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;
	private String studentName;
	private int deptId;
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
	public KafkaStudent(int studentId, String studentName, int deptId) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.deptId = deptId;
	}
	public KafkaStudent() {
		super();
	}
	
	
	
	
}
