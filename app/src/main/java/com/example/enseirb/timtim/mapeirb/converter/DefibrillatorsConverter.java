package com.example.enseirb.timtim.mapeirb.converter;

import com.example.enseirb.timtim.mapeirb.dto.POIDTO;
import com.example.enseirb.timtim.mapeirb.dto.POIDefibrillatorDTO;
import com.example.enseirb.timtim.mapeirb.model.POIDefibrillator;
import com.example.enseirb.timtim.mapeirb.model.POI;

public class DefibrillatorsConverter implements IPOIsConverter {

    @Override
    public POI convertDTO(POIDTO collectionDTO) {
        POIDefibrillatorDTO defibrillatorCollectionDTO = (POIDefibrillatorDTO) collectionDTO;
        return new POIDefibrillator(defibrillatorCollectionDTO.getLongitude(),
                defibrillatorCollectionDTO.getLatitude(),
                defibrillatorCollectionDTO .getTypologie(),
                defibrillatorCollectionDTO.getAddress(),
                defibrillatorCollectionDTO.getName(),
                convertPhone(defibrillatorCollectionDTO.getTelephone()),
                convertInstalle(defibrillatorCollectionDTO.getInstalle()));
    }


    private Boolean convertInstalle(String installe) {
        return (installe.equals("OUI"));
    }

    private String convertPhone(String telephone) {
        return telephone.replaceAll(" ", "-");
    }

}
