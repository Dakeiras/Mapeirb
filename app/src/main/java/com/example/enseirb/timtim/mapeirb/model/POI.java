package com.example.enseirb.timtim.mapeirb.model;

import com.google.android.gms.maps.model.LatLng;

public abstract class POI implements IPOI{

    private LatLng position;

    public POI(LatLng position) {
        this.position = position;
    }

    @Override
    public abstract String getTitle();

    @Override
    public abstract String getDescription();

    @Override
    public LatLng getPosition(){
        return position;
    }
}
