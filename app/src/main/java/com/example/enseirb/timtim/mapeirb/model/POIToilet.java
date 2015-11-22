package com.example.enseirb.timtim.mapeirb.model;

public class POIToilet extends POI  {
    private String type;
    private String address;

    public POIToilet(double longitude, double latitude, String type, String address) {
        super(longitude, latitude);
        this.type = type;
        this.address = address;
    }

    @Override
    public String getTitle() {
        return type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
