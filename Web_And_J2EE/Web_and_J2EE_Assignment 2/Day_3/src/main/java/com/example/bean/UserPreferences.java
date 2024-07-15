package com.example.bean;

public class UserPreferences {
    private String preferredRoute;
    private String avoidAreas;

    // Constructors, getters, and setters
    public UserPreferences() {}

    public UserPreferences(String preferredRoute, String avoidAreas) {
        this.preferredRoute = preferredRoute;
        this.avoidAreas = avoidAreas;
    }

    public String getPreferredRoute() {
        return preferredRoute;
    }

    public void setPreferredRoute(String preferredRoute) {
        this.preferredRoute = preferredRoute;
    }

    public String getAvoidAreas() {
        return avoidAreas;
    }

    public void setAvoidAreas(String avoidAreas) {
        this.avoidAreas = avoidAreas;
    }
}
