package com.example.enseirb.timtim.mapeirb.dto;

import com.google.android.gms.maps.model.LatLng;

public abstract class POIDTO {

    LatLng position;


    public LatLng getPosition() {
        return position;
    }

    public void setPosition(LatLng position) {
        this.position = position;
    }
}
