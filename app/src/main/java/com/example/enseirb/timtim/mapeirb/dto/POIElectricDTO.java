package com.example.enseirb.timtim.mapeirb.dto;

import com.google.android.gms.maps.model.LatLng;

public class POIElectricDTO extends POIDTO{
    private int number;
    private String name;
    private String address;
    private String status;

public POIElectricDTO(LatLng position, String name, String address, String status, int number) {
    this.setPosition(position);
    this.address = address;
    this.name = name;
    this.status = status;
    this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }




}
