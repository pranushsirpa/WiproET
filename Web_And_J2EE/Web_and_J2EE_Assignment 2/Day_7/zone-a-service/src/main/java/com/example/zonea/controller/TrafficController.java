package com.example.zonea.controller;

import com.example.zonea.model.TrafficData;
import com.example.zonea.service.TrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/traffic")
public class TrafficController {

    @Autowired
    private TrafficService trafficService;

    @GetMapping
    public List<TrafficData> getAllTrafficData() {
        return trafficService.getAllTrafficData();
    }

    @PostMapping
    public TrafficData addTrafficData(@RequestBody TrafficData trafficData) {
        return trafficService.addTrafficData(trafficData);
    }
}