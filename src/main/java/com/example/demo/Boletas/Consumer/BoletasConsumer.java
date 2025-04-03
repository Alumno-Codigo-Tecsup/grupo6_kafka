package com.example.demo.Boletas.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.demo.Email.Model.EmailNotification;
import com.example.demo.Email.Service.EmailService;

@Component
public class BoletasConsumer {

    private static final Logger logger = LoggerFactory.getLogger(BoletasConsumer.class);

    private final EmailService emailService;

    @Value("${notification.email.recipient:greciadm2596@gmail.com}")
    private String emailRecipient;

    public BoletasConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = "${spring.kafka.topic.boletas}", groupId = "boletas-group")
    public void listen(String message) {
        logger.info("✅ Mensaje recibido: {}", message);

        // Crear y enviar la notificación por email
        EmailNotification notification = new EmailNotification(
                emailRecipient,
                "Nueva Boleta Recibida",
                "Se ha recibido una nueva boleta con el siguiente contenido: \n\n" + message
        );

        try {
            emailService.sendEmail(notification);
            logger.info("Notificación de email enviada correctamente");
        } catch (Exception e) {
            logger.error("Error al enviar la notificación por email: {}", e.getMessage());
        }
    }
}