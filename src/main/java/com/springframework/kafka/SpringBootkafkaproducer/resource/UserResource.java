package com.springframework.kafka.SpringBootkafkaproducer.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springframework.kafka.SpringBootkafkaproducer.model.User;

@RestController
@RequestMapping("kafka")
public class UserResource {
	
	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;
	
	private static final String TOPIC = "Kafka_Example";
	
	@GetMapping("/publish/{user}")
	public String post(@PathVariable("user") final String user) {
		
		kafkaTemplate.send(TOPIC, new User(user, "Ticket Collector", 1000L));
		
		return "Message Published Successfully";
	}
	
}
