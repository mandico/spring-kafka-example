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

	private final Logger logger = LoggerFactory.getLogger(Consumer.class);

	@KafkaListener(topics = "${topic.message}", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(ConsumerRecord<String, String> payload) {
		logger.info("*******************************************************");
    	logger.info("* KAFKA CONSUMER");
    	logger.info("*******************************************************");
		logger.info("* Topic........: {}", topic_name);
		logger.info("* Partion......: {}", payload.partition());
		logger.info("* Message......: {}", payload.value());
		logger.info("*******************************************************");

	}
}