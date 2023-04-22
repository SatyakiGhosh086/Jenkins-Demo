package com.infy.DepartmentKafkaService.Service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.CommonKafkaService.ModelDTO.DepartmentDTO;
import com.infy.DepartmentKafkaService.Entity.KafkaDepartments;
import com.infy.DepartmentKafkaService.Repository.DepartmentRepository;

@Service
public class DepartmentService 
{
	@Autowired
	private DepartmentRepository deptRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public DepartmentDTO addDepartment(DepartmentDTO dept)
	{
		KafkaDepartments deptObj = modelMapper.map(dept, KafkaDepartments.class);
		deptRepo.save(deptObj);
		dept.setDeptId(deptObj.getDeptId());
		return dept;
	}
	
	public DepartmentDTO getDepartmentById(int deptId)
	{
		KafkaDepartments dept = deptRepo.findByDeptId(deptId);
		DepartmentDTO deptDTO = modelMapper.map(dept, DepartmentDTO.class);
		return deptDTO;
	}
	
	public List<DepartmentDTO> getAllDepartmentsByCollegeId(int collegeId)
	{
		List<KafkaDepartments> depts = new ArrayList<>();
		List<DepartmentDTO> deptsDTO = new ArrayList<>();
		deptRepo.findAllByCollegeId(collegeId).forEach(depts::add);
		for(KafkaDepartments dept : depts)
		{
			deptsDTO.add(modelMapper.map(dept, DepartmentDTO.class));
		}
		return deptsDTO;
	}
	
	public List<DepartmentDTO> getAllDepartments()
	{
		List<KafkaDepartments> depts = new ArrayList<>();
		List<DepartmentDTO> deptsDTO = new ArrayList<>();
		deptRepo.findAll().forEach(depts::add);
		for(KafkaDepartments dept : depts)
		{
			deptsDTO.add(modelMapper.map(dept, DepartmentDTO.class));
		}
		return deptsDTO;
	}
	
	public void updateDepartment(int deptId,DepartmentDTO deptDTO)
	{
		KafkaDepartments updateDept = deptRepo.findByDeptId(deptId);
		updateDept.setDeptId(deptDTO.getDeptId());
		updateDept.setDeptName(deptDTO.getDeptName());
		updateDept.setCollegeId(deptDTO.getCollegeId());
		
		deptRepo.save(updateDept);
	}
	
	public void deletDepartment(int deptId)
	{
		deptRepo.deleteById(deptId);
	}
}
