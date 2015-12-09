package com.example.enseirb.timtim.mapeirb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class POICollection implements Serializable {

    private Collection<IPOI> poiCollection;

    public POICollection(){
        poiCollection = new ArrayList<>();
    }

    public void add(IPOI poi) {
        poiCollection.add(poi);
    }

    public Collection<IPOI> getPoiCollection() {
        return poiCollection;
    }

    @Override
    public String toString() {
        String s = "POICOLLECTION (" + poiCollection.size() + ")\n";
        for (IPOI poi: poiCollection){
            s += poi.getName() + " " + poi.isSelected() + "\n";
        }
        return s;
    }
}
