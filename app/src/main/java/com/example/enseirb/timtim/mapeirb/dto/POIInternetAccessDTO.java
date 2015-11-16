package com.example.enseirb.timtim.mapeirb.dto;


public class POIInternetAccessDTO extends POIDTO {
    public String name;
    public String accessType;
    public String paid;

    public POIInternetAccessDTO(String longitude, String latitude, String name, String accessType, String paid) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
        this.accessType = accessType;
        this.paid = paid;
    }

}
