package com.example.demo.Boletas.Producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BoletasProducer {

    private static final Logger logger = LoggerFactory.getLogger(BoletasProducer.class);

    @Value("${spring.kafka.topic.boletas:boletas-topic}")
    private String topic;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public BoletasProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Envía un mensaje simple al tópico de boletas
     *
     * @param message El mensaje a enviar
     */
    public void sendMessage(String message) {
        logger.info("Enviando mensaje.....: {}", message);
        kafkaTemplate.send(topic, message);
    }
}