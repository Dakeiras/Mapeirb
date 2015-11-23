package com.example.enseirb.timtim.mapeirb.model;

import java.util.Collection;

public class POICollection {

    private Collection<POI> poiCollection;

    public void add(POI poi) {
        poiCollection.add(poi);
    }

    public Collection<POI> getPoiCollection() {
        return poiCollection;
    }

}
