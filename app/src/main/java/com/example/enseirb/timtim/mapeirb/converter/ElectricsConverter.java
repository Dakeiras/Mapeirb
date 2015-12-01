package com.example.enseirb.timtim.mapeirb.converter;

import com.example.enseirb.timtim.mapeirb.dto.POIDTO;
import com.example.enseirb.timtim.mapeirb.dto.POIElectricDTO.POIElectricDTO;
import com.example.enseirb.timtim.mapeirb.model.POIElectric;
import com.example.enseirb.timtim.mapeirb.model.POI;
import com.google.android.gms.maps.model.LatLng;

public class ElectricsConverter implements IPOIsConverter {

    @Override
    public POI convertDTO(POIDTO collectionDTO) {
        POIElectricDTO electricCollectionDTO = (POIElectricDTO) collectionDTO;
        return new POIElectric(convertPosition(electricCollectionDTO.getLatitude(), electricCollectionDTO.getLongitude()),
                convertName(electricCollectionDTO.getName()),
                convertAddress(electricCollectionDTO.getAddress()),
                convertStatus(electricCollectionDTO.getStatus()),
                convertNumber(electricCollectionDTO.getNumber()));
    }

    private LatLng convertPosition(Double latitude, Double longitude) {
        return new LatLng(latitude, longitude);
    }

    private String convertName(String name) {
        return name;
    }

    private String convertAddress(String address) {
        return address;
    }

    private Boolean convertStatus(String status) {
        return status.equals("OK");
    }

    private int convertNumber(int number) {
        return number;
    }
}
