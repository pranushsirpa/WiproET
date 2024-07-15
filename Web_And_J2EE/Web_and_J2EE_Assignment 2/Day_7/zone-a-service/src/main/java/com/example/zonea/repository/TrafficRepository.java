package com.example.zonea.repository;

import com.example.zonea.model.TrafficData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrafficRepository extends JpaRepository<TrafficData, Long> {
}
