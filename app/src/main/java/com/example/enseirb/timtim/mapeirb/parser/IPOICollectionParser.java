package com.example.enseirb.timtim.mapeirb.parser;

import com.example.enseirb.timtim.mapeirb.dto.POICollectionDTO;

public interface IPOICollectionParser {
    POICollectionDTO parse(String webData);
}
