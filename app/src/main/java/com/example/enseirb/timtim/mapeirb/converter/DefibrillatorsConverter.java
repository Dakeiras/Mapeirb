package com.example.enseirb.timtim.mapeirb.converter;

import com.example.enseirb.timtim.mapeirb.dto.POIDTO;
import com.example.enseirb.timtim.mapeirb.dto.POIDefibrillatorDTO;
import com.example.enseirb.timtim.mapeirb.model.POIDefibrillator;
import com.example.enseirb.timtim.mapeirb.model.POI;
import com.google.android.gms.maps.model.LatLng;

public class DefibrillatorsConverter implements IPOIsConverter {

    private static final String YES_STRING = "OUI";
    private static final String BLANK_STRING = " ";
    private static final String HYPHEN_STRING = "-";

    @Override
    public POI convertDTO(POIDTO collectionDTO) {
        POIDefibrillatorDTO defibrillatorCollectionDTO = (POIDefibrillatorDTO) collectionDTO;
        return new POIDefibrillator(convertPosition(defibrillatorCollectionDTO.getLatitude(), defibrillatorCollectionDTO.getLongitude()),
                convertTypology(defibrillatorCollectionDTO.getTypology()),
                convertAddress(defibrillatorCollectionDTO.getAddress()),
                convertName(defibrillatorCollectionDTO.getName()),
                convertPhone(defibrillatorCollectionDTO.getTelephone()),
                convertInstalled(defibrillatorCollectionDTO.getInstalled()),
                convertCity(defibrillatorCollectionDTO.getCity()),
                convertPostalCode(defibrillatorCollectionDTO.getPostalCode()));
    }


    private LatLng convertPosition(Double latitude, Double longitude) {
        return new LatLng(latitude, longitude);
    }

    private String convertTypology(String typology) {
        return typology;
    }

    private String convertAddress(String address) {
        return address;
    }

    private String convertName(String name) {
        return name;
    }

    private String convertPhone(String telephone) {
        if (telephone != null) {
            return telephone.replaceAll(BLANK_STRING, HYPHEN_STRING);
        }
        return null;
    }

    private Boolean convertInstalled(String installed) {
        return (installed.equals(YES_STRING));
    }

    private String convertCity(String city) {
        return city;
    }

    private int convertPostalCode(int postalCode) {
        return postalCode;
    }

}
