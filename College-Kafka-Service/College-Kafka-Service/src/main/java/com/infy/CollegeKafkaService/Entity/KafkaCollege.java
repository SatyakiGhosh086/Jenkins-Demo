package com.infy.CollegeKafkaService.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class KafkaCollege 
{
	@Id
	private int studentId;
	private String studentName;
	private int deptId;
	private String deptName;
	private int collegeId;
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
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	public KafkaCollege(int studentId, String studentName, int deptId, String deptName, int collegeId) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.deptId = deptId;
		this.deptName = deptName;
		this.collegeId = collegeId;
	}
	public KafkaCollege() {
		super();
	}
	
}
