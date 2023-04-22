package com.infy.DepartmentKafkaService.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.infy.DepartmentKafkaService.Entity.KafkaDepartments;

public interface DepartmentRepository extends CrudRepository<KafkaDepartments,Integer>
{
	public KafkaDepartments findByDeptId(int deptId);
	public List<KafkaDepartments> findAllByCollegeId(int collegeId);
	
	
}
