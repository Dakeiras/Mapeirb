package com.example.enseirb.timtim.mapeirb.dto;

public class POIDefibrillatorDTO extends POIDTO{
    public String typologie;
    public String address;
    public String name;
    public String telephone;
    public String installe;

    public POIDefibrillatorDTO(Double longitude, Double latitude, String typologie, String address, String name, String telephone, String installe) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.typologie = typologie;
        this.address=address;
        this.name=name;
        this.telephone=telephone;
        this.installe=installe;
    }
}
