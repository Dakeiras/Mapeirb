package com.example.enseirb.timtim.mapeirb.dto;

public class ElectricDTO /*extends DataDTO*/{
    public int number;
    public String name;
    public String address;
    public String status;


public ElectricDTO(String longitude, String latitude, int number,  String name, String address,String status) {
   /* this.longitude = longitude;
    this.latitude = latitude;*/
    this.number = number;
    this.address=address;
    this.name=name;
    this.status=status;
    }
}
