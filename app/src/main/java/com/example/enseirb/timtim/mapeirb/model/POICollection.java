package com.example.enseirb.timtim.mapeirb.model;

import java.util.ArrayList;
import java.util.Collection;

public class POICollection {

    private Collection<IPOI> poiCollection;

    public POICollection(){
        poiCollection = new ArrayList<IPOI>();
    }

    public void add(IPOI poi) {
        poiCollection.add(poi);
    }

    public Collection<IPOI> getPoiCollection() {
        return poiCollection;
    }

}
