package com.example.transitmanagement.repository;

import com.example.transitmanagement.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {
}
