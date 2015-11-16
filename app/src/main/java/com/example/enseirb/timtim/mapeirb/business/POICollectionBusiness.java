package com.example.enseirb.timtim.mapeirb.business;

import com.example.enseirb.timtim.mapeirb.business.listener.IPOICollectionBusinessListener;
import com.example.enseirb.timtim.mapeirb.converter.IPOICollectionConverter;
import com.example.enseirb.timtim.mapeirb.converter.listener.IPOICollectionConverterListener;
import com.example.enseirb.timtim.mapeirb.converter.POICollectionConverter;
import com.example.enseirb.timtim.mapeirb.model.POICollection;
import com.example.enseirb.timtim.mapeirb.model.POIType;

public class POICollectionBusiness implements IPOICollectionBusiness {

    private IPOICollectionConverter poiCollectionConverter;

    public POICollectionBusiness(){
    }


    @Override
    public POICollection retrievePOICollection(POIType poiType, final IPOICollectionBusinessListener listener) {
        setPoiCollectionConverter(poiType);
        poiCollectionConverter.retrievePOICollection(poiType, new IPOICollectionConverterListener() {

            @Override
            public void onSuccess(POICollection poiCollection) {
                listener.onSuccess(poiCollection);
            }

            @Override
            public void onError(String message) {
                listener.onError(message);
            }

        });

        return null;
    }

    private void setPoiCollectionConverter(POIType poiType) {
        try {
            poiCollectionConverter = new POICollectionConverter(poiType);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
