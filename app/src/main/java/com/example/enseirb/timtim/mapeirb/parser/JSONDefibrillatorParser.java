package com.example.enseirb.timtim.mapeirb.parser;

import com.example.enseirb.timtim.mapeirb.dto.POICollectionDTO;
import com.example.enseirb.timtim.mapeirb.dto.POIDefibrillatorDTO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONDefibrillatorParser implements IPOICollectionParser {
    private static final String DEFIBRILLATOR_OBJECT ="d";
    private static final String DEFIBRILLATOR_NAME = "nom";
    private static final String DEFIBRILLATOR_ADDRESS = "adresse";
    private static final String DEFIBRILLATOR_PHONE = "telephone";
    private static final String DEFIBRILLATOR_TYPOLOGIE = "typologie";
    private static final String DEFIBRILLATOR_INSTALLE = "installe";
    private static final String DEFIBRILLATOR_CITY = "commune";
    private static final String DEFIBRILLATOR_POSTAL_CODE = "code_postal";
    private static final String LONGITUDE = "x_long";
    private static final String LATITUDE = "y_lat";
    @Override
    public POICollectionDTO parse(String jsonDefibrillator)  {
        POICollectionDTO poiCollectionDefibrillator = new POICollectionDTO();
        try {
            JSONObject reader = new JSONObject(jsonDefibrillator);
            JSONArray defibrillatorArray = reader.getJSONArray(DEFIBRILLATOR_OBJECT);
            for (int i = 0; i < defibrillatorArray.length(); i++) {
                JSONObject defibrillatorObject;
                defibrillatorObject = defibrillatorArray.getJSONObject(i);

                Double longitude = defibrillatorObject.optDouble(LONGITUDE, 0);
                Double latitude = defibrillatorObject.optDouble(LATITUDE, 0);

                String address = defibrillatorObject.optString(DEFIBRILLATOR_ADDRESS, null);
                String phone = defibrillatorObject.optString(DEFIBRILLATOR_PHONE, null);
                String name = defibrillatorObject.optString(DEFIBRILLATOR_NAME, null);
                String typologie = defibrillatorObject.optString(DEFIBRILLATOR_TYPOLOGIE, null);
                String installe = defibrillatorObject.optString(DEFIBRILLATOR_INSTALLE, null);
                String city = defibrillatorObject.optString(DEFIBRILLATOR_CITY, null);
                int postalCode = defibrillatorObject.optInt(DEFIBRILLATOR_POSTAL_CODE, 33000);

                poiCollectionDefibrillator.addPOIDTO(new POIDefibrillatorDTO(longitude, latitude, typologie, address, name, phone, installe, city, postalCode));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return poiCollectionDefibrillator;
    }
}
