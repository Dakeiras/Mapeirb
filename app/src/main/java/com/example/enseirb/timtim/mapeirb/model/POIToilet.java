package com.example.enseirb.timtim.mapeirb.model;

import com.google.android.gms.maps.model.LatLng;

public class POIToilet extends POI  {
    private String type;
    private String address;

    public POIToilet(LatLng position, String type, String address) {
        super(position);
        this.type = type;
        this.address = address;
    }

    @Override
    public String getTitle() {
        return type + address;
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
