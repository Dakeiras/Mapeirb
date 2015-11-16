package com.example.enseirb.timtim.mapeirb.dto;

public class DefibrillatorDTO /*extends DataDTO*/{
public String typologie;
public String address;
public String name;
public String telephone;
public String information;

public DefibrillatorDTO(String longitude, String latitude, String typologie, String address, String name, String telephone, String information) {
    /*this.longitude = longitude;
    this.latitude = latitude;*/
    this.typologie = typologie;
    this.address=address;
    this.name=name;
    this.telephone=telephone;
    this.information=information;
}
}
