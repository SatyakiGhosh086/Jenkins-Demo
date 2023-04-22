package com.infy.DepartmentKafkaService.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.CommonKafkaService.Events.CollegeEvent;
import com.infy.CommonKafkaService.ModelDTO.CollegeDTO;
import com.infy.DepartmentKafkaService.Entity.KafkaDepartments;
import com.infy.DepartmentKafkaService.Entity.KafkaStudentConsumed;
import com.infy.DepartmentKafkaService.Producer.DepartmentProducer;
import com.infy.DepartmentKafkaService.Repository.DepartmentRepository;
import com.infy.DepartmentKafkaService.Repository.StudentConsumerRepository;

@Service
public class SendStudentDetailsToCollege 
{
	@Autowired
	private StudentConsumerRepository studentRepo;
	
	@Autowired
	private DepartmentRepository deptRepo;
	
	@Autowired
	private DepartmentProducer deptProd;
	 
	
	public void sendStudentsDetailToCollege(String dataSentToOrganization)
	{
		List<KafkaStudentConsumed> students = new ArrayList<>();
		studentRepo.findAllByDataSentToOrganization(dataSentToOrganization).forEach(students::add);
		for(KafkaStudentConsumed student : students)
		{
			KafkaDepartments dept = deptRepo.findByDeptId(student.getDeptId());
			CollegeDTO college = new CollegeDTO();
			college.setStudentId(student.getStudentId());
			college.setStudentName(student.getStudentName());
			college.setDeptId(student.getDeptId());
			college.setDeptName(dept.getDeptName());
			college.setCollegeId(dept.getCollegeId());
			
			CollegeEvent event = new CollegeEvent();
			event.setMessage("College Event");
			event.setStatus("Test");
			event.setCollegeDTO(college);
			
			deptProd.sendMessage(event);
		}
	}
}
