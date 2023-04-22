package com.infy.StudentKafkaService.Service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.CommonKafkaService.ModelDTO.StudentDTO;
import com.infy.StudentKafkaService.Entity.KafkaStudent;
import com.infy.StudentKafkaService.Exception.StudentNotFoundException;
import com.infy.StudentKafkaService.Repository.StudentRepository;

@Service
public class StudentKafkaService 
{
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public KafkaStudent addStudent(StudentDTO student)
	{
		KafkaStudent obj = modelMapper.map(student, KafkaStudent.class);
		studentRepo.save(obj);
		return obj;
	}
	
	public List<StudentDTO> getAllStudents()
	{
		List<KafkaStudent> students = new ArrayList<>();
		List<StudentDTO> studentsDTO = new ArrayList<>();
		
		studentRepo.findAll().forEach(students :: add);
		
		for(KafkaStudent student : students)
		{
			studentsDTO.add(modelMapper.map(student,StudentDTO.class));
		}
		
		return studentsDTO;
	}
	
	public List<StudentDTO> getAllStudentsByDeptId(int deptId)
	{
		List<KafkaStudent> students = new ArrayList<>();
		List<StudentDTO> studentsDTO = new ArrayList<>();
		
		studentRepo.findAllByDeptId(deptId).forEach(students :: add);
		
		for(KafkaStudent student : students)
		{
			studentsDTO.add(modelMapper.map(student,StudentDTO.class));
		}
		
		return studentsDTO;
	}
	
	public StudentDTO getStudentById(int studentId)
	{
		KafkaStudent student = studentRepo.findByStudentId(studentId);
		if(student == null)
		{
			throw new StudentNotFoundException("Student ID",studentId,"Student");
		}
		return modelMapper.map(student, StudentDTO.class);
	}
	
	public void updateStudentById(int studentId,StudentDTO student)
	{
		KafkaStudent updatedStudent = studentRepo.findByStudentId(studentId);
		if(updatedStudent == null)
		{
			throw new StudentNotFoundException("Student ID",studentId,"Student");
		}
		updatedStudent.setStudentName(student.getStudentName());
		updatedStudent.setDeptId(student.getDeptId());
		studentRepo.save(updatedStudent);
	}
	
	public void deleteStudentById(int studentId)
	{
		KafkaStudent student = studentRepo.findByStudentId(studentId);
		if(student == null)
		{
			throw new StudentNotFoundException("Student ID",studentId,"Student");
		}
		studentRepo.deleteById(studentId);
	}
	
	public StudentDTO getStudentByName(String studentName)
	{
		KafkaStudent student = studentRepo.findByStudentName(studentName);
		return modelMapper.map(student, StudentDTO.class);
	}
	
}
