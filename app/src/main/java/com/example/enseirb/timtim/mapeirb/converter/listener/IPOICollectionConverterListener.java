package com.example.enseirb.timtim.mapeirb.converter.listener;

import com.example.enseirb.timtim.mapeirb.model.POICollection;

public interface IPOICollectionConverterListener {

    void onSuccess(POICollection poiCollection);
    void onError(String message);

}
