package com.example.demo.boletas.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class BoletasConsumer {

    private static final Logger logger = LoggerFactory.getLogger(BoletasConsumer.class);

    @KafkaListener(topics = "${kafka.topic.boletas}", groupId = "boletas-group")
    public void listen(String message) {
        logger.info("✅ Mensaje recibido aqui: {}", message);
    }
}