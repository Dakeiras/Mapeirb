package com.example.enseirb.timtim.mapeirb.dto;


public class POIInternetAccessDTO extends POIDTO {
    private String accessType;
    private String paid;

    public POIInternetAccessDTO(Double longitude, Double latitude, String name, String accessType, String paid) {
        super(longitude, latitude, name);
        this.accessType = accessType;
        this.paid = paid;
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
