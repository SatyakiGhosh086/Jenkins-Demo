package com.infy.DepartmentKafkaService.Producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.infy.CommonKafkaService.Events.CollegeEvent;

@Service
public class DepartmentProducer 
{
	private static Logger log = LoggerFactory.getLogger(DepartmentProducer.class);
	
	private KafkaTemplate<String,CollegeEvent> kafkaTemplate;
	
	@Autowired
	private NewTopic topic;
	
	public DepartmentProducer(KafkaTemplate<String, CollegeEvent> kafkaTemplate, NewTopic topic) {
		super();
		this.kafkaTemplate = kafkaTemplate;
		this.topic = topic;
	}

	
	public void sendMessage(CollegeEvent event)
	{
		log.info("College event : "+event);
		Message<CollegeEvent> message = MessageBuilder.withPayload(event).setHeader(KafkaHeaders.TOPIC, topic.name()).build();
		kafkaTemplate.send(message);
	}
	
	
}
