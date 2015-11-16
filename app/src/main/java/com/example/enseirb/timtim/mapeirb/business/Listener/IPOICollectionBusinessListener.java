package com.example.enseirb.timtim.mapeirb.business.listener;

import com.example.enseirb.timtim.mapeirb.model.POICollection;

public interface IPOICollectionBusinessListener {

    void onSuccess(POICollection poiCollection);
    void onError(String message);

}
