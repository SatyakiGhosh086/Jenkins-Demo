package com.infy.CommonKafkaService.ModelDTO;

public class StudentDTO 
{
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
	@Override
	public String toString() {
		return "StudentDTO [studentId=" + studentId + ", studentName=" + studentName + ", deptId=" + deptId + "]";
	}
	public StudentDTO(int studentId, String studentName, int deptId, String sendToCollege) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.deptId = deptId;
	}
	public StudentDTO() {
		super();
	}
	
	
}
