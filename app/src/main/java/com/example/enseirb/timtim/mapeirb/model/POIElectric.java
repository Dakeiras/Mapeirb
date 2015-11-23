package com.example.enseirb.timtim.mapeirb.model;

public class POIElectric extends POI {

    private int number;
    private String name;
    private String address;
    private Boolean status;

    public POIElectric(Double longitude, Double latitude, String name, String address, Boolean status, int number) {
        super(longitude, latitude);
        this.address = address;
        this.name = name;
        this.status = status;
        this.number = number;
    }

    @Override
    public String getTitle() {
        return name + address;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
