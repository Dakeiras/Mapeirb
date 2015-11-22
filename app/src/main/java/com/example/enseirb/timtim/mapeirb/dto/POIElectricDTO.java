package com.example.enseirb.timtim.mapeirb.dto;

public class POIElectricDTO extends POIDTO{
    public int number;
    public String name;
    public String address;
    public String status;


public POIElectricDTO(Double longitude, Double latitude, String name, String address, String status, int number) {
    this.longitude = longitude;
    this.latitude = latitude;
    this.address=address;
    this.name=name;
    this.status=status;
    this.number = number;
    }
}
