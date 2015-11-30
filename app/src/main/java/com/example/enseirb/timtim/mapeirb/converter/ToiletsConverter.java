package com.example.enseirb.timtim.mapeirb.converter;

import com.example.enseirb.timtim.mapeirb.dto.POIDTO;
import com.example.enseirb.timtim.mapeirb.dto.POIToiletsDTO;
import com.example.enseirb.timtim.mapeirb.model.POI;
import com.example.enseirb.timtim.mapeirb.model.POIToilet;
import com.google.android.gms.maps.model.LatLng;

public class ToiletsConverter implements IPOIsConverter {

    @Override
    public POI convertDTO(POIDTO collectionDTO) {
        POIToiletsDTO toiletCollectionDTO = (POIToiletsDTO) collectionDTO;
        return new POIToilet(convertPosition(toiletCollectionDTO.getLatitude(), toiletCollectionDTO.getLongitude()),
                convertType(toiletCollectionDTO.getType()),
                convertAddress(toiletCollectionDTO.getAddress()));
    }

    private LatLng convertPosition(Double latitude, Double longitude) {
        return new LatLng(latitude, longitude);
    }

    private String convertType(String type) {
        return type;
    }

    private String convertAddress(String address) {
        return address;
    }

}
