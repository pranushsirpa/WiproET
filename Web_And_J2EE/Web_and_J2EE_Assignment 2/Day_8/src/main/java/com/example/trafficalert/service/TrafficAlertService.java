package com.example.trafficalert.service;

import com.example.trafficalert.model.TrafficAlert;
import com.example.trafficalert.repository.TrafficAlertRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;
import reactor.core.publisher.UnicastProcessor;

@Service
public class TrafficAlertService {
    private final TrafficAlertRepository repository;
    private final UnicastProcessor<TrafficAlert> processor;
    private final FluxSink<TrafficAlert> sink;

    public TrafficAlertService(TrafficAlertRepository repository) {
        this.repository = repository;
        this.processor = UnicastProcessor.create();
        this.sink = processor.sink();
    }

    public Mono<TrafficAlert> sendAlert(TrafficAlert alert) {
        return repository.save(alert).doOnNext(sink::next);
    }

    public Flux<TrafficAlert> getAlerts() {
        return processor.replay(1).autoConnect();
    }

    public Flux<TrafficAlert> getAllAlerts() {
        return repository.findAll();
    }
}
