package com.example.trafficalert.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.example.trafficalert.model.TrafficAlert;

public interface TrafficAlertRepository extends ReactiveCrudRepository<TrafficAlert, String> {
}
