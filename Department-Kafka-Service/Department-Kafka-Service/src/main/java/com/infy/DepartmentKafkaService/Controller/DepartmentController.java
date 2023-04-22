package com.infy.DepartmentKafkaService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infy.CommonKafkaService.ModelDTO.DepartmentDTO;
import com.infy.DepartmentKafkaService.Service.DepartmentService;
import com.infy.DepartmentKafkaService.Service.SendStudentDetailsToCollege;

@RestController
public class DepartmentController 
{
	@Autowired
	private DepartmentService deptService;
	
	@Autowired
	private SendStudentDetailsToCollege sendData;
	
	@RequestMapping(method = RequestMethod.POST,value = "/infyDepartment/add")
	public String addDepartment(@RequestBody DepartmentDTO dept)
	{
		dept = deptService.addDepartment(dept);
		return "New Department has been added";
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/infyDepartment/{deptId}/get")
	public DepartmentDTO getDepartmentById(@PathVariable int deptId)
	{
		return deptService.getDepartmentById(deptId);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/infyDepartment/{collegeId}/all")
	public List<DepartmentDTO> getAllDepartmentsByCollegeId(@PathVariable int collegeId)
	{
		return deptService.getAllDepartmentsByCollegeId(collegeId);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/infyDepartment/all")
	public List<DepartmentDTO> getAllDepartments()
	{
		return deptService.getAllDepartments();
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/infyDepartment/{deptId}/update")
	public void updateDepartment(@PathVariable int deptId,@RequestBody DepartmentDTO deptDTO)
	{
		deptService.updateDepartment(deptId, deptDTO);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/infyDepartment/{deptId}/delete")
	public void deletDepartment(@PathVariable int deptId)
	{
		deptService.deletDepartment(deptId);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/infyDepartment/{dataSentToOrganization}/send")
	public String sendDataToCollege(@PathVariable String dataSentToOrganization)
	{
		sendData.sendStudentsDetailToCollege(dataSentToOrganization);
		return "Data sent to College!!";
	}
}
