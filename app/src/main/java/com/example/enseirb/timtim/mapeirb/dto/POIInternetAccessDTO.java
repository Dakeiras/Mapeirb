package com.example.enseirb.timtim.mapeirb.dto;


public class POIInternetAccessDTO extends POIDTO {
    private String name;
    private String accessType;
    private String paid;

    public POIInternetAccessDTO(Double longitude, Double latitude, String name, String accessType, String paid) {
        this.setLongitude(longitude);
        this.setLatitude(latitude);
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
