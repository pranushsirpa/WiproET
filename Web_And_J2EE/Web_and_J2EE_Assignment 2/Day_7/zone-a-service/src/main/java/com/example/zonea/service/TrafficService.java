package com.example.zonea.service;

import com.example.zonea.model.TrafficData;
import com.example.zonea.repository.TrafficRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrafficService {

    @Autowired
    private TrafficRepository trafficRepository;

    public List<TrafficData> getAllTrafficData() {
        return trafficRepository.findAll();
    }

    public TrafficData addTrafficData(TrafficData trafficData) {
        return trafficRepository.save(trafficData);
    }
}
