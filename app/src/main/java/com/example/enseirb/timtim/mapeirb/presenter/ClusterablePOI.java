package com.example.enseirb.timtim.mapeirb.presenter;


import com.example.enseirb.timtim.mapeirb.model.IPOI;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

public class ClusterablePOI implements IPOI,ClusterItem {
    IPOI poi;

    public ClusterablePOI(IPOI poi) {
        this.poi = poi;
    }

    @Override
    public String getTitle() {
        return poi.getTitle();
    }

    @Override
    public String getDescription() {
        return poi.getDescription();
    }

    @Override
    public LatLng getPosition() {
        return poi.getPosition();
    }
}
