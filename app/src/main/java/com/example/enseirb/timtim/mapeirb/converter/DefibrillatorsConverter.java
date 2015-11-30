package com.example.enseirb.timtim.mapeirb.converter;

import com.example.enseirb.timtim.mapeirb.dto.POIDTO;
import com.example.enseirb.timtim.mapeirb.dto.POIDefibrillatorDTO;
import com.example.enseirb.timtim.mapeirb.model.POIDefibrillator;
import com.example.enseirb.timtim.mapeirb.model.POI;
import com.google.android.gms.maps.model.LatLng;

public class DefibrillatorsConverter implements IPOIsConverter {

    @Override
    public POI convertDTO(POIDTO collectionDTO) {
        POIDefibrillatorDTO defibrillatorCollectionDTO = (POIDefibrillatorDTO) collectionDTO;
        return new POIDefibrillator(convertPosition(defibrillatorCollectionDTO.getLatitude(), defibrillatorCollectionDTO.getLongitude()),
                convertTypologie(defibrillatorCollectionDTO.getTypologie()),
                convertAddress(defibrillatorCollectionDTO.getAddress()),
                convertName(defibrillatorCollectionDTO.getName()),
                convertPhone(defibrillatorCollectionDTO.getTelephone()),
                convertInstalle(defibrillatorCollectionDTO.getInstalle()));
    }

    private LatLng convertPosition(Double latitude, Double longitude) {
        return new LatLng(latitude, longitude);
    }

    private String convertTypologie(String typologie) {
        return typologie;
    }

    private String convertAddress(String address) {
        return address;
    }

    private String convertName(String name) {
        return name;
    }

    private String convertPhone(String telephone) {
        if (telephone != null) {
            return telephone.replaceAll(" ", "-");
        }
        return null;
    }

    private Boolean convertInstalle(String installe) {
        return (installe.equals("OUI"));
    }

}
