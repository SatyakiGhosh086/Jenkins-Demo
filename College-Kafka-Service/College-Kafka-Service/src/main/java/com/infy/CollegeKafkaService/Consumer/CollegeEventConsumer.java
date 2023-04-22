package com.infy.CollegeKafkaService.Consumer;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.infy.CollegeKafkaService.Entity.KafkaCollege;
import com.infy.CollegeKafkaService.Repository.CollegeRepository;
import com.infy.CommonKafkaService.Events.CollegeEvent;

@Service
public class CollegeEventConsumer 
{
	private static Logger log = LoggerFactory.getLogger(CollegeEventConsumer.class);
	
	@Autowired
	private CollegeRepository collegeRepo;
	
	@Autowired
	private ModelMapper model;
	
	@KafkaListener(topics = "${spring.kafka.topic.name}",groupId = "${spring.kafka.consumer.group-id}")
	public void consume(CollegeEvent event)
	{
		log.info("College event being consumed : "+event.toString());
		KafkaCollege college = model.map(event.getCollegeDTO(), KafkaCollege.class);
		collegeRepo.save(college);
	}
}
