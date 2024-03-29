package com.learning.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
	private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

    @Value("${topic.message}")
    private String topic_name;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
    	logger.info("*******************************************************");
    	logger.info("* KAFKA PRODUCER");
    	logger.info("*******************************************************");
    	logger.info("* Topic........: -> {}", topic_name);
        logger.info("* Message......: -> {}", message);
        logger.info("*******************************************************");
        this.kafkaTemplate.send(topic_name, message);
    }
}
