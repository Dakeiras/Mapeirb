package com.example.enseirb.timtim.mapeirb.utils;

import com.example.enseirb.timtim.mapeirb.model.POICollection;

public class SingletonPOICollection {

    private static POICollection poiCollection = new POICollection();


    public static POICollection getInstance(){
        return poiCollection;
    }



}
