package com.example.myapp.repository;

import com.example.myapp.model.TrafficData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrafficDataRepository extends JpaRepository<TrafficData, Long> {
}
