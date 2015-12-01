package com.example.enseirb.timtim.mapeirb.dto;

public class POIElectricDTO extends POIDTO{
    private int number;
    private String address;
    private String status;

    public POIElectricDTO(Double longitude, Double latitude, String name, int number, String address, String status) {
        super(longitude, latitude, name);
        this.number = number;
        this.address = address;
        this.status = status;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }




}
