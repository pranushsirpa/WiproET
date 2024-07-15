package com.example.transitdata.service;

import com.example.transitdata.entity.Route;
import com.example.transitdata.entity.Schedule;
import com.example.transitdata.entity.Vehicle;
import com.example.transitdata.repository.RouteRepository;
import com.example.transitdata.repository.ScheduleRepository;
import com.example.transitdata.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransitService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Route> findAllRoutes() {
        return routeRepository.findAll();
    }

    public List<Schedule> findAllSchedules() {
        return scheduleRepository.findAll();
    }

    public List<Vehicle> findAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Route saveRoute(Route route) {
        return routeRepository.save(route);
    }

    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Route updateRoute(Long id, Route route) {
        Route existingRoute = routeRepository.findById(id).orElseThrow(() -> new RuntimeException("Route not found"));
        existingRoute.setRouteName(route.getRouteName());
        return routeRepository.save(existingRoute);
    }

    public Schedule updateSchedule(Long id, Schedule schedule) {
        Schedule existingSchedule = scheduleRepository.findById(id).orElseThrow(() -> new RuntimeException("Schedule not found"));
        existingSchedule.setRoute(schedule.getRoute());
        existingSchedule.setDepartureTime(schedule.getDepartureTime());
        existingSchedule.setArrivalTime(schedule.getArrivalTime());
        existingSchedule.setVehicle(schedule.getVehicle());
        return scheduleRepository.save(existingSchedule);
    }

    public Vehicle updateVehicle(Long id, Vehicle vehicle) {
        Vehicle existingVehicle = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        existingVehicle.setVehicleNumber(vehicle.getVehicleNumber());
        existingVehicle.setCapacity(vehicle.getCapacity());
        return vehicleRepository.save(existingVehicle);
    }

    public void deleteRoute(Long id) {
        routeRepository.deleteById(id);
    }

    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }

    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}
