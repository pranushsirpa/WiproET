package com.example.trafficalert.controller;

import com.example.trafficalert.model.TrafficAlert;
import com.example.trafficalert.service.TrafficAlertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/alerts")
public class TrafficAlertController {
    private final TrafficAlertService alertService;

    public TrafficAlertController(TrafficAlertService alertService) {
        this.alertService = alertService;
    }

    @PostMapping
    public Mono<ResponseEntity<Void>> sendAlert(@RequestBody TrafficAlert alert) {
        return alertService.sendAlert(alert).thenReturn(ResponseEntity.ok().build());
    }

    @GetMapping(produces = "text/event-stream")
    public Flux<TrafficAlert> streamAlerts() {
        return alertService.getAlerts();
    }

    @GetMapping("/all")
    public Flux<TrafficAlert> getAllAlerts() {
        return alertService.getAllAlerts();
    }
}
