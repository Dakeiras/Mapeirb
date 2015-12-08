package com.example.enseirb.timtim.mapeirb.business;

import com.example.enseirb.timtim.mapeirb.business.listener.IPOICollectionBusinessListener;
import com.example.enseirb.timtim.mapeirb.model.POIType;

public interface IPOICollectionBusiness {


    void retrievePOICollection(POIType poiType, IPOICollectionBusinessListener listener);

}
