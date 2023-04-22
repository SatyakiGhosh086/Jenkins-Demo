package com.infy.DepartmentKafkaService.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.infy.CommonKafkaService.Events.StudentEvent;
import com.infy.DepartmentKafkaService.Entity.KafkaStudentConsumed;
import com.infy.DepartmentKafkaService.Repository.StudentConsumerRepository;

@Service
public class StudentConsumer 
{
	private static Logger log = LoggerFactory.getLogger(StudentConsumer.class);
	
	@Autowired
	private StudentConsumerRepository repo;
	
	
	@KafkaListener(topics = "${spring.kafka.topic.name}",groupId = "${spring.kafka.consumer.group-id}")
	public void consumeStudentEvent(StudentEvent event)
	{
		log.info("Student event is being consumed : "+event.toString());
		KafkaStudentConsumed student = new KafkaStudentConsumed();
		student.setStudentId(event.getDtoClass().getStudentId());
		student.setStudentName(event.getDtoClass().getStudentName());
		student.setDeptId(event.getDtoClass().getDeptId());
		repo.save(student);
	}
}
