package com.example.enseirb.timtim.mapeirb.model;

public abstract class POI {
    public double longitude;
    public double latitude;

    public POI(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public abstract String getTitle();
}
