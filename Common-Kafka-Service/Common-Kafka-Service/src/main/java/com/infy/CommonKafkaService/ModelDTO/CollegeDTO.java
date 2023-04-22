package com.infy.CommonKafkaService.ModelDTO;

public class CollegeDTO 
{
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
	@Override
	public String toString() {
		return "CollegeDTO [studentId=" + studentId + ", studentName=" + studentName + ", deptId=" + deptId
				+ ", deptName=" + deptName + ", collegeId=" + collegeId + "]";
	}
	public CollegeDTO(int studentId, String studentName, int deptId, String deptName, int collegeId) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.deptId = deptId;
		this.deptName = deptName;
		this.collegeId = collegeId;
	}
	public CollegeDTO() {
		super();
	}
	
	
}
