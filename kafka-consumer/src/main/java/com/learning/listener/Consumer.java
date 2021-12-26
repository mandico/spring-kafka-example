package com.learning.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class Consumer {

	@Value("${topic.message}")
	private String topic_name;

	private final Logger log = LoggerFactory.getLogger(Consumer.class);

	@KafkaListener(topics = "${topic.message}", groupId = "group_id")
	public void consume(ConsumerRecord<String, String> payload) {
		log.info("Tópico: {}", topic_name);
		log.info("Partion: {}", payload.partition());
		log.info("Order: {}", payload.value());
		log.info("*********************************");

	}
}