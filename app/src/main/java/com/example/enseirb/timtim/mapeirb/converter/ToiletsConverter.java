package com.example.enseirb.timtim.mapeirb.converter;

import com.example.enseirb.timtim.mapeirb.dto.POIDTO;
import com.example.enseirb.timtim.mapeirb.dto.POIToiletsDTO;
import com.example.enseirb.timtim.mapeirb.model.POI;
import com.example.enseirb.timtim.mapeirb.model.POIToilet;

public class ToiletsConverter implements IPOIsConverter {

    @Override
    public POI convertDTO(POIDTO collectionDTO) {
        POIToiletsDTO toiletCollectionDTO = (POIToiletsDTO) collectionDTO;
        return new POIToilet(toiletCollectionDTO.getLongitude(),
                toiletCollectionDTO.getLatitude(),
                toiletCollectionDTO .getType(),
                toiletCollectionDTO.getAddress());
    }
}
