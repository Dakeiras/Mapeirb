package com.example.enseirb.timtim.mapeirb.converter;

import com.example.enseirb.timtim.mapeirb.converter.listener.IPOICollectionConverterListener;
import com.example.enseirb.timtim.mapeirb.model.POIType;

public interface IPOICollectionConverter {
    void retrievePOICollection(POIType type, IPOICollectionConverterListener listener);
}

