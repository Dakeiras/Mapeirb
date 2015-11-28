package com.example.enseirb.timtim.mapeirb.dto;


import com.google.android.gms.maps.model.LatLng;

public class POIToiletsDTO extends POIDTO {
    private String type;
    private String address;

    public POIToiletsDTO(LatLng position, String type, String address) {
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
