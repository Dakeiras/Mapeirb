package com.example.enseirb.timtim.mapeirb.model;

import com.google.android.gms.maps.model.LatLng;

public abstract class POI implements IPOI{

    private LatLng position;
    private String name;

    public POI(LatLng position, String name) {
        this.position = position;
        this.name = name;
    }

    @Override
    public abstract String getTitle();

    @Override
    public abstract String getDescription();

    @Override
    public LatLng getPosition(){
        return position;
    }

    @Override
    public String getName() {
        return name;
    }

}
