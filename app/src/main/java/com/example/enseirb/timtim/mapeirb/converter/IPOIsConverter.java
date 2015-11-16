package com.example.enseirb.timtim.mapeirb.converter;

import com.example.enseirb.timtim.mapeirb.dto.POIDTO;
import com.example.enseirb.timtim.mapeirb.model.POI;

public interface IPOIsConverter {


    POI convertDTO(POIDTO collectionDTO);

}
