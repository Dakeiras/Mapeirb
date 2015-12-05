package com.example.enseirb.timtim.mapeirb.dto;

import java.util.ArrayList;
import java.util.Collection;

public class POICollectionDTO {

    private Collection<POIDTO> poiCollection;

    public POICollectionDTO(){
        poiCollection = new ArrayList<POIDTO>();
    }


    public void setterPOICollection(Collection<POIDTO> POICollection){
        this.poiCollection = POICollection;
    }

    public void addPOIDTO(POIDTO poi){
        poiCollection.add(poi);
    }

    public Collection<POIDTO> getPoiCollection(){
        return poiCollection;
    }
}
