package com.example.enseirb.timtim.mapeirb.dto;


public class POIToiletsDTO extends POIDTO {
    private String type;
    private String address;
    private String quartier;
    private String option;

    public POIToiletsDTO(Double longitude, Double latitude, String name, String type, String address, String quartier, String option) {
        super(longitude, latitude, name);
        this.type = type;
        this.address = address;
        this.quartier = quartier;
        this.option = option;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
}
