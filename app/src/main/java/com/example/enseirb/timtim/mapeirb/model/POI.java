package com.example.enseirb.timtim.mapeirb.model;

import com.google.android.gms.maps.model.LatLng;

public abstract class POI {

    private LatLng position;

    public POI(LatLng position) {
        this.position = position;
    }

    public abstract String getTitle();
    public LatLng getPosition(){
        return position;
    }
}
