package com.example.enseirb.timtim.mapeirb.parser;

import com.example.enseirb.timtim.mapeirb.dto.POICollectionDTO;
import com.example.enseirb.timtim.mapeirb.dto.POIToiletsDTO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONToiletParser implements IPOICollectionParser {
    private static final String TOILET_OBJECT ="d";
    private static final String TOILET_TYPOLOGIE = "typologie";
    private static final String TOILET_ADDRESS = "adresse";
    private static final String LONGITUDE = "x_long";
    private static final String LATITUDE = "y_lat";
    @Override
    public POICollectionDTO parse(String jsonToilet) {
        POICollectionDTO poiToilet = new POICollectionDTO();
        try{
            JSONArray toiletsArray;
            JSONObject reader =new JSONObject(jsonToilet);
            toiletsArray = reader.getJSONArray(TOILET_OBJECT);

            for (int i = 0; i < toiletsArray.length(); i++) {
                JSONObject toiletsAccessObject;
                toiletsAccessObject = toiletsArray.getJSONObject(i);

                Double longitude = toiletsAccessObject.getDouble(LONGITUDE);
                Double latitude = toiletsAccessObject.getDouble(LATITUDE);
                String typologie = toiletsAccessObject.getString(TOILET_TYPOLOGIE);
                String address = toiletsAccessObject.getString(TOILET_ADDRESS);

                poiToilet.addPOIDTO(new POIToiletsDTO(longitude, latitude, typologie, address));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return poiToilet;
    }
}
