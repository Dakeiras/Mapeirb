package com.example.enseirb.timtim.mapeirb.model;

import android.support.annotation.NonNull;

import com.google.android.gms.maps.model.LatLng;

public abstract class POI implements Comparable<IPOI>, IPOI {

    private LatLng position;
    private String name;
    private boolean selected;

    public POI(LatLng position, String name) {
        this.position = position;
        this.name = name;
        this.selected = true;
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

    @Override
    public boolean isSelected() {
        return selected;
    }

    @Override
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public int compareTo(@NonNull IPOI comparePoi) {
        if (getName() == null){
            return 1;
        }
        else if (comparePoi.getName() == null){
            return -1;
        }
        return getName().compareTo(comparePoi.getName());
    }

}
