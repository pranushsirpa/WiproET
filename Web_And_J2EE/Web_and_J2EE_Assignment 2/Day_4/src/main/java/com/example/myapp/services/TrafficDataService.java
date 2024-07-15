package com.example.myapp.services;

import com.example.myapp.model.TrafficData;
import com.example.myapp.repository.TrafficDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrafficDataService {

    @Autowired
    private TrafficDataRepository trafficDataRepository;

    public TrafficData addTrafficData(TrafficData trafficData) {
        return trafficDataRepository.save(trafficData);
    }

    public List<TrafficData> getAllTrafficData() {
        return trafficDataRepository.findAll();
    }

    public Optional<TrafficData> getTrafficDataById(Long id) {
        return trafficDataRepository.findById(id);
    }

    public TrafficData updateTrafficData(Long id, TrafficData trafficDataDetails) {
        TrafficData trafficData = trafficDataRepository.findById(id).orElseThrow(() -> new RuntimeException("Traffic Data not found"));

        trafficData.setLocation(trafficDataDetails.getLocation());
        trafficData.setVolume(trafficDataDetails.getVolume());
        trafficData.setTimestamp(trafficDataDetails.getTimestamp());

        return trafficDataRepository.save(trafficData);
    }

    public void deleteTrafficData(Long id) {
        TrafficData trafficData = trafficDataRepository.findById(id).orElseThrow(() -> new RuntimeException("Traffic Data not found"));
        trafficDataRepository.delete(trafficData);
    }
}
