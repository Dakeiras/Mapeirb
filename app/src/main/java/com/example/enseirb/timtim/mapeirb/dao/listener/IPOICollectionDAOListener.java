package com.example.enseirb.timtim.mapeirb.dao.listener;

import com.example.enseirb.timtim.mapeirb.dto.POICollectionDTO;

public interface IPOICollectionDAOListener {
    void onSuccess(POICollectionDTO poiCollection);
    void onError(String message);
}
