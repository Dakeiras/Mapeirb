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
        try {
            poiCollectionConverter = new POICollectionConverter();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public POICollection retrievePOICollection(POIType poiType, final IPOICollectionBusinessListener listener) {
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
}
