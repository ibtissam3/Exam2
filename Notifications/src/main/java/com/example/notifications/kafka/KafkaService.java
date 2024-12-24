package com.example.notifications.kafka;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @CircuitBreaker(name = "kafkaService", fallbackMethod = "fallback")
    public void processMessage(String message) {
        // Logique pour traiter le message
        System.out.println("Traitement du message Kafka : " + message);
    }

    public void fallback(String message, Throwable throwable) {
        System.err.println("Kafka indisponible. Fallback activé pour le message : " + message);
    }
}
