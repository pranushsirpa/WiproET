package com.example.transitdata.controller;

import com.example.transitdata.entity.Route;
import com.example.transitdata.entity.Schedule;
import com.example.transitdata.entity.Vehicle;
import com.example.transitdata.service.TransitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransitController {

    @Autowired
    private TransitService transitService;

    @GetMapping("/routes")
    public List<Route> getAllRoutes() {
        return transitService.findAllRoutes();
    }

    @GetMapping("/schedules")
    public List<Schedule> getAllSchedules() {
        return transitService.findAllSchedules();
    }

    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles() {
        return transitService.findAllVehicles();
    }

    @PostMapping("/routes")
    public Route createRoute(@RequestBody Route route) {
        return transitService.saveRoute(route);
    }

    @PostMapping("/schedules")
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        return transitService.saveSchedule(schedule);
    }

    @PostMapping("/vehicles")
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return transitService.saveVehicle(vehicle);
    }

    @PutMapping("/routes/{id}")
    public Route updateRoute(@PathVariable Long id, @RequestBody Route route) {
        return transitService.updateRoute(id, route);
    }

    @PutMapping("/schedules/{id}")
    public Schedule updateSchedule(@PathVariable Long id, @RequestBody Schedule schedule) {
        return transitService.updateSchedule(id, schedule);
    }

    @PutMapping("/vehicles/{id}")
    public Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        return transitService.updateVehicle(id, vehicle);
    }

    @DeleteMapping("/routes/{id}")
    public void deleteRoute(@PathVariable Long id) {
        transitService.deleteRoute(id);
    }

    @DeleteMapping("/schedules/{id}")
    public void deleteSchedule(@PathVariable Long id) {
        transitService.deleteSchedule(id);
    }

    @DeleteMapping("/vehicles/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        transitService.deleteVehicle(id);
    }
}
