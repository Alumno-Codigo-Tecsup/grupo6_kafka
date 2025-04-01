package com.example.demo.boletas.controller;

import com.example.demo.boletas.producer.BoletasProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/boletas")
public class BoletasController {

    private final BoletasProducer boletasProducer;

    public BoletasController(BoletasProducer boletasProducer) {
        this.boletasProducer = boletasProducer;
    }

    @PostMapping("/enviar")
    public ResponseEntity<String> enviarMensaje(@RequestBody String mensaje) {
        boletasProducer.sendMessage(mensaje);
        return ResponseEntity.ok("Mensaje enviado correctamente a Kafka");
    }
}
