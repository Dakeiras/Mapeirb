package com.example.enseirb.timtim.mapeirb.dto;


import com.google.android.gms.maps.model.LatLng;

public class POIInternetAccessDTO extends POIDTO {
    private String name;
    private String accessType;
    private String paid;

    public POIInternetAccessDTO(LatLng position, String name, String accessType, String paid) {
        this.setPosition(position);
        this.name = name;
        this.accessType = accessType;
        this.paid = paid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }
}
