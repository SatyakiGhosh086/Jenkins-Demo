package com.infy.CommonKafkaService.ModelDTO;

public class DepartmentDTO 
{
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
	@Override
	public String toString() {
		return "DepartmentDTO [deptId=" + deptId + ", deptName=" + deptName + ", collegeId=" + collegeId + "]";
	}
	public DepartmentDTO(int deptId, String deptName, int collegeId) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.collegeId = collegeId;
	}
	public DepartmentDTO() {
		super();
	}
	
	
}
