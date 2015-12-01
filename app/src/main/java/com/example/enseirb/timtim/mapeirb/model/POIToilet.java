package com.example.enseirb.timtim.mapeirb.model;

import com.google.android.gms.maps.model.LatLng;

public class POIToilet extends POI  {
    private String type;
    private String address;
    private String neighbourhood;
    private String option;

    public POIToilet(String name, LatLng position, String type, String address, String neighbourhood, String option) {
        super(position, name);
        this.type = type;
        this.address = address;
        this.neighbourhood = neighbourhood;
        this.option = option;
    }

    @Override
    public String getTitle() {
        return getName() + address;
    }

    @Override
    public String getDescription() {
        return getTitle();
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
