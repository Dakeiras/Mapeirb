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
        return new POIToilet(convertName(toiletCollectionDTO.getName()),
                convertPosition(toiletCollectionDTO.getLatitude(), toiletCollectionDTO.getLongitude()),
                convertType(toiletCollectionDTO.getType()),
                convertAddress(toiletCollectionDTO.getAddress()),
                convertNeighbourhood(toiletCollectionDTO.getQuartier()),
                convertOption(toiletCollectionDTO.getOption()));
    }

    private String convertName(String name) {
        return name;
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

    private String convertNeighbourhood(String quartier) {
        return quartier;
    }

    private String convertOption(String option) {
        return option;
    }

}
