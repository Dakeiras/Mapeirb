package com.example.enseirb.timtim.mapeirb.dto;


public class POIToiletsDTO extends POIDTO {
    public String type;

    public POIToiletsDTO(Double longitude, Double latitude, String type) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.type = type;
    }
}
