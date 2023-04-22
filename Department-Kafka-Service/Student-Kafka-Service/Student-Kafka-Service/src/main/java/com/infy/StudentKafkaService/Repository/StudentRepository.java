package com.infy.StudentKafkaService.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.infy.StudentKafkaService.Entity.KafkaStudent;

public interface StudentRepository extends CrudRepository<KafkaStudent,Integer>
{
	public List<KafkaStudent> findAllByDeptId(int deptId);
	public KafkaStudent findByStudentId(int studentId);
	public KafkaStudent findByStudentName(String studentName);
}
