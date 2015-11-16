package com.example.enseirb.timtim.mapeirb.dto;

import java.util.Collection;

public class POICollectionDTO {

    private Collection<POIDTO> POICollection;

    public void setterPOICollection(Collection<POIDTO> POICollection){
        this.POICollection = POICollection;
    }

    public void addPOIDTO(POIDTO pio){
        POICollection.add(pio);
    }

    public int size() {
        //TODO:
        return 0;
    }

    public POIDTO get(int i) {
        //TODO:
        return null;
    }

    public Collection<POIDTO> getPOICollection(){
        return POICollection;
    }
}
