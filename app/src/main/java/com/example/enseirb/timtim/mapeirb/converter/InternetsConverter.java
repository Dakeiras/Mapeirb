package com.example.enseirb.timtim.mapeirb.converter;

import com.example.enseirb.timtim.mapeirb.dto.POIDTO;
import com.example.enseirb.timtim.mapeirb.dto.POIInternetAccessDTO;
import com.example.enseirb.timtim.mapeirb.model.POIInternet;
import com.example.enseirb.timtim.mapeirb.model.POI;

public class InternetsConverter implements IPOIsConverter {

    @Override
    public POI convertDTO(POIDTO collectionDTO) {
        POIInternetAccessDTO internetCollectionDTO = (POIInternetAccessDTO) collectionDTO;
        return new POIInternet(internetCollectionDTO.getLongitude(),
                internetCollectionDTO.getLatitude(),
                internetCollectionDTO .getName(),
                internetCollectionDTO.getAccessType(),
                convertPaid(internetCollectionDTO.getPaid()));
    }

    private Boolean convertPaid(String paid) {
        return paid.equals("OUI");
    }
}
