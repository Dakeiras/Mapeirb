package com.example.enseirb.timtim.mapeirb.dto;


public class POIToiletsDTO extends POIDTO {
    private String type;
    private String address;

    public POIToiletsDTO(Double longitude, Double latitude, String type, String address) {
        this.setLongitude(longitude);
        this.setLatitude(latitude);
        this.type = type;
        this.address = address;
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
