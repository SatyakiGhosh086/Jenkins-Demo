package com.infy.DepartmentKafkaService.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class KafkaDepartments 
{
	@Id
	private int deptId;
	private String deptName;
	private int collegeId;
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
	public KafkaDepartments(int deptId, String deptName, int collegeId) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.collegeId = collegeId;
	}
	public KafkaDepartments() {
		super();
	}
	@Override
	public String toString() {
		return "KafkaDepartments [deptId=" + deptId + ", deptName=" + deptName + ", collegeId=" + collegeId + "]";
	}
	
}
