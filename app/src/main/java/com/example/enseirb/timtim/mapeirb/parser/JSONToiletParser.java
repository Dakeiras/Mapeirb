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
    private static final String TOILET_NAME = "nom";
    private static final String TOILET_QUARTIER = "quartier";
    private static final String TOILET_OPTION = "options";
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
                JSONObject toiletsObject;
                toiletsObject = toiletsArray.getJSONObject(i);

                Double longitude = toiletsObject.optDouble(LONGITUDE, 0);
                Double latitude = toiletsObject.optDouble(LATITUDE, 0);
                String typologie = toiletsObject.optString(TOILET_TYPOLOGIE, null);
                String address = toiletsObject.optString(TOILET_ADDRESS, null);
                String name = toiletsObject.optString(TOILET_NAME, null);
                String quartier = toiletsObject.optString(TOILET_QUARTIER, null);
                String option = toiletsObject.optString(TOILET_OPTION, null);

                poiToilet.addPOIDTO(new POIToiletsDTO(longitude, latitude, name, typologie, address, quartier, option));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return poiToilet;
    }
}
