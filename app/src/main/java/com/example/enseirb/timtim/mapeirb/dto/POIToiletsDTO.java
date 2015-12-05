package com.example.enseirb.timtim.mapeirb.dto;


public class POIToiletsDTO extends POIDTO {
    private String type;
    private String address;
    private String neighbourhood;
    private String option;

    public POIToiletsDTO(Double longitude, Double latitude, String name, String type, String address, String neighbourhood, String option) {
        super(longitude, latitude, name);
        this.type = type;
        this.address = address;
        this.neighbourhood = neighbourhood;
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

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
}
