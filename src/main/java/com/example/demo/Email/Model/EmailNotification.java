package com.example.demo.Email.Model;

import java.io.Serializable;
import java.util.Objects;

public class EmailNotification implements Serializable {

    private String to;
    private String subject;
    private String body;

    // Constructors
    public EmailNotification() {
    }

    public EmailNotification(String to, String subject, String body) {
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

    // Create notification for new user registration
    public static EmailNotification forNewUserRegistration(String userEmail) {
        String subject = "Bienvenido a nuestro servicio!";
        String body = String.format(
                "Hello %s,\n\n" +
                        "Tu boleta ha sido creado exitosamente.\n\n" +
                        "Saludos,\n" );

        return new EmailNotification(userEmail, subject, body);
    }

    // Getters and Setters
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    // equals, hashCode and toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailNotification that = (EmailNotification) o;
        return Objects.equals(to, that.to) &&
                Objects.equals(subject, that.subject) &&
                Objects.equals(body, that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(to, subject, body);
    }

    @Override
    public String toString() {
        return "EmailNotification{" +
                "to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}