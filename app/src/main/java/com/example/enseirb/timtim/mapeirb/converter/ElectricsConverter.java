package com.example.enseirb.timtim.mapeirb.converter;

import com.example.enseirb.timtim.mapeirb.dto.POIDTO;
import com.example.enseirb.timtim.mapeirb.dto.POIElectricDTO;
import com.example.enseirb.timtim.mapeirb.model.POIElectric;
import com.example.enseirb.timtim.mapeirb.model.POI;

public class ElectricsConverter implements IPOIsConverter {

    @Override
    public POI convertDTO(POIDTO collectionDTO) {
        POIElectricDTO electricCollectionDTO = (POIElectricDTO) collectionDTO;
        return new POIElectric(electricCollectionDTO.getPosition(),
                electricCollectionDTO .getName(),
                electricCollectionDTO.getAddress(),
                convertStatus(electricCollectionDTO.getStatus()),
                electricCollectionDTO.getNumber());
    }

    private Boolean convertStatus(String status) {
        return status.equals("OK");
    }
}
