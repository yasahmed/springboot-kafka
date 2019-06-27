package com.springframework.kafka.SpringBootkafkaproducer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.springframework.kafka.SpringBootkafkaproducer.model.User;

@Service
public class KafkaConsumer {

	@KafkaListener(topics="Kafka_Example", groupId="group_id")
	public void consume(String message) {
		System.out.println("Consumer got this message:" + message);
	}
	
	@KafkaListener(topics="Kafka_Example_json", groupId="group_json", containerFactory="concurrentKafkaListenerContainerFactory")
	public void consumeJson(User user) {
		System.out.println(user + " Consumer has consumed in Json Format");
	}
}
