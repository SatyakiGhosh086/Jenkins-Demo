package com.infy.DepartmentKafkaService.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.infy.DepartmentKafkaService.Entity.KafkaStudentConsumed;

public interface StudentConsumerRepository extends CrudRepository<KafkaStudentConsumed,Integer>
{
	public List<KafkaStudentConsumed> findAllByDataSentToOrganization(String dataSentToOrganization);
}
