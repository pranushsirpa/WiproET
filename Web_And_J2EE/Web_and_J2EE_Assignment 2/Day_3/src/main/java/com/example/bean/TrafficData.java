package com.example.bean;

public class TrafficData {
    private String location;
    private int trafficLevel;

    // Constructors, getters, and setters
    public TrafficData() {}

    public TrafficData(String location, int trafficLevel) {
        this.location = location;
        this.trafficLevel = trafficLevel;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTrafficLevel() {
        return trafficLevel;
    }

    public void setTrafficLevel(int trafficLevel) {
        this.trafficLevel = trafficLevel;
    }
}
