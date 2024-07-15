package com.example.myapp.controller;

import com.example.myapp.model.TrafficData;
import com.example.myapp.services.TrafficDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/traffic-data")
public class TrafficDataController {

    @Autowired
    private TrafficDataService trafficDataService;

    @PostMapping("/add")
    @ResponseBody
    public TrafficData addTrafficData(@RequestBody TrafficData trafficData) {
        return trafficDataService.addTrafficData(trafficData);
    }

    @GetMapping("/all")
    @ResponseBody
    public List<TrafficData> getAllTrafficData() {
        return trafficDataService.getAllTrafficData();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<TrafficData> getTrafficDataById(@PathVariable Long id) {
        return trafficDataService.getTrafficDataById(id);
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public TrafficData updateTrafficData(@PathVariable Long id, @RequestBody TrafficData trafficDataDetails) {
        return trafficDataService.updateTrafficData(id, trafficDataDetails);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleteTrafficData(@PathVariable Long id) {
        trafficDataService.deleteTrafficData(id);
    }
}
