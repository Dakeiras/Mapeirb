package com.example.enseirb.timtim.mapeirb.converter;

import com.example.enseirb.timtim.mapeirb.dto.POIDTO;
import com.example.enseirb.timtim.mapeirb.dto.POIInternetAccessDTO;
import com.example.enseirb.timtim.mapeirb.model.POIInternet;
import com.example.enseirb.timtim.mapeirb.model.POI;
import com.google.android.gms.maps.model.LatLng;

public class InternetsConverter implements IPOIsConverter {

    @Override
    public POI convertDTO(POIDTO collectionDTO) {
        POIInternetAccessDTO internetCollectionDTO = (POIInternetAccessDTO) collectionDTO;
        return new POIInternet(convertPosition(internetCollectionDTO.getLatitude(), internetCollectionDTO.getLongitude()),
                convertName(internetCollectionDTO .getName()),
                convertAccessType(internetCollectionDTO.getAccessType()),
                convertPaid(internetCollectionDTO.getPaid()),
                convertSituation(internetCollectionDTO.getSituation()),
                convertTypePublic(internetCollectionDTO.getTypePublic()),
                convertFormation(internetCollectionDTO.getFormation()),
                convertPostNumber(internetCollectionDTO.getPostNumber()));
    }

    private LatLng convertPosition(Double latitude, Double longitude) {
        return new LatLng(latitude, longitude);
    }

    private String convertName(String name) {
        return name;
    }

    private String convertAccessType(String accessType) {
        return accessType;
    }

    private Boolean convertPaid(String paid) {
        return paid.equals("OUI");
    }
    private String convertSituation(String situation) {
        return situation;
    }

    private String convertTypePublic(String typePublic) {
        return typePublic;
    }

    private String convertFormation(String formation) {
        return formation;
    }

    private int convertPostNumber(int postNumber) {
        return postNumber;
    }

}
