package com.example.transitmanagement.repository;

import com.example.transitmanagement.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentRepository extends JpaRepository<Incident, Long> {
}
