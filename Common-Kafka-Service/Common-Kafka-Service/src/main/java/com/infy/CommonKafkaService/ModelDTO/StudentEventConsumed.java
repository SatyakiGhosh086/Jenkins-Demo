package com.infy.CommonKafkaService.ModelDTO;

public class StudentEventConsumed 
{
	private int studentId;
	private String studentName;
	private int deptId;
	private String consumedByCollege;
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
	public String getConsumedByCollege() {
		return consumedByCollege;
	}
	public void setConsumedByCollege(String consumedByCollege) {
		this.consumedByCollege = consumedByCollege;
	}
	public StudentEventConsumed(int studentId, String studentName, int deptId, String consumedByCollege) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.deptId = deptId;
		this.consumedByCollege = consumedByCollege;
	}
	public StudentEventConsumed() {
		super();
	}
	@Override
	public String toString() {
		return "StudentEventConsumed [studentId=" + studentId + ", studentName=" + studentName + ", deptId=" + deptId
				+ ", consumedByCollege=" + consumedByCollege + "]";
	}
	
	
}
