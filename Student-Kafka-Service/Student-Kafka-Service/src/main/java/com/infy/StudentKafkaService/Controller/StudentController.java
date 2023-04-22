package com.infy.StudentKafkaService.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.infy.CommonKafkaService.Events.StudentEvent;
import com.infy.CommonKafkaService.ModelDTO.StudentDTO;
import com.infy.StudentKafkaService.Entity.KafkaStudent;
import com.infy.StudentKafkaService.Exception.ErrorDetails;
import com.infy.StudentKafkaService.Exception.StudentNotFoundException;
import com.infy.StudentKafkaService.Producer.StudentKafkaProducer;
import com.infy.StudentKafkaService.Service.StudentKafkaService;

@RestController
public class StudentController 
{
	@Autowired
	private StudentKafkaService studentService;
	
	@Autowired
	private StudentKafkaProducer producer;
	
	@RequestMapping(method = RequestMethod.POST,value = "/infyStudent/add")
	public String addStudent(@RequestBody StudentDTO student)
	{
		KafkaStudent obj = studentService.addStudent(student);
		student.setStudentId(obj.getStudentId());
		StudentEvent event = new StudentEvent();
		event.setMessage("Student Event : "+student.toString());
		event.setStatus("Active");
		event.setDtoClass(student);
		producer.sendMessage(event);
		return "Student has been saved and sent to Kafka";
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/infyStudent/all")
	public List<StudentDTO> getAllStudents()
	{
		return studentService.getAllStudents();
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/infyStudent/name/{studentName}/get")
	public StudentDTO getStudentByName(@PathVariable String studentName)
	{
		return studentService.getStudentByName(studentName);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/infyStudent/{deptId}/all")
	public List<StudentDTO> getAllStudentsByDeptId(@PathVariable int deptId)
	{
		return studentService.getAllStudentsByDeptId(deptId);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/infyStudent/student/{studentId}")
	public StudentDTO getStudentById(@PathVariable int studentId)
	{
		return studentService.getStudentById(studentId);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/infyStudent/{studentId}/update")
	public void updateStudentById(@PathVariable int studentId,@RequestBody StudentDTO student)
	{
		studentService.updateStudentById(studentId, student);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/infyStudent/{studentId}/delete")
	public void deleteStudentById(@PathVariable int studentId)
	{
		studentService.deleteStudentById(studentId);	
	}
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ErrorDetails handleStudentNotFoundException(StudentNotFoundException ex,WebRequest webRequest)
	{
		return new ErrorDetails(LocalDateTime.now(),ex.getMessage(),webRequest.getDescription(false),"STUDENT_NOT_FOUND"); 
	}
	
}
