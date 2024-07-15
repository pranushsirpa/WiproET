package com.example.trafficalert.websocket;

import com.example.trafficalert.model.TrafficAlert;
import com.example.trafficalert.service.TrafficAlertService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import org.springframework.web.reactive.socket.WebSocketMessage;
import reactor.core.publisher.Mono;

@Component
public class TrafficAlertHandler implements WebSocketHandler {

    private final TrafficAlertService alertService;

    public TrafficAlertHandler(TrafficAlertService alertService) {
        this.alertService = alertService;
    }

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        // Sending existing alerts and subscribing to new alerts
        return session.send(alertService.getAlerts()
                .map(alert -> session.textMessage(alert.toString())))
                .and(session.receive()
                        .map(WebSocketMessage::getPayloadAsText)
                        .map(this::parseAlert)
                        .flatMap(alertService::sendAlert)
                        .then());
    }

    private TrafficAlert parseAlert(String payload) {
        // Parsing the JSON payload into a TrafficAlert object
        // Assuming you use a JSON library like Jackson or Gson
        // Here we can use Jackson ObjectMapper (needs to be configured as a bean)
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(payload, TrafficAlert.class);
        } catch (Exception e) {
            // Handle parsing exception
            e.printStackTrace();
            return new TrafficAlert(); // Return a default or empty object
        }
    }
}
