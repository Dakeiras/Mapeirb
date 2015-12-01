package com.example.enseirb.timtim.mapeirb.dto;

public abstract class POIDTO {

    private Double longitude;
    private Double latitude;
    private String name;

    public POIDTO(Double longitude, Double latitude, String name) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
