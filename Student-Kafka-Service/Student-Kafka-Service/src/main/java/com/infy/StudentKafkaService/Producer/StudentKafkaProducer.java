package com.infy.StudentKafkaService.Producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.infy.CommonKafkaService.Events.StudentEvent;

@Service
public class StudentKafkaProducer 
{
	@Autowired
	private NewTopic topic;
	
	private KafkaTemplate<String,StudentEvent> kafkaTemplate;
	
	private static Logger log = LoggerFactory.getLogger(StudentKafkaProducer.class);
	
	public StudentKafkaProducer(NewTopic topic, KafkaTemplate<String, StudentEvent> kafkaTemplate) {
		super();
		this.topic = topic;
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(StudentEvent event)
	{
		log.info("Student Event : "+event.toString());
		Message<StudentEvent> message = MessageBuilder.withPayload(event).setHeader(KafkaHeaders.TOPIC, topic.name()).build();
		kafkaTemplate.send(message);
	}
	
}
