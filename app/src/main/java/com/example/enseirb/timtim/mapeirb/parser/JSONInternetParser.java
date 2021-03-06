package com.example.enseirb.timtim.mapeirb.parser;

import com.example.enseirb.timtim.mapeirb.dto.POICollectionDTO;
import com.example.enseirb.timtim.mapeirb.dto.POIInternetAccessDTO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class JSONInternetParser implements IPOICollectionParser {
    private static final String INTERNET_OBJECT ="d";
    private static final String INTERNET_NAME = "nom";
    private static final String INTERNET_NATURE = "type_acces";
    private static final String INTERNET_GRATUITY = "payant";
    private static final String INTERNET_SITUATION = "situation";
    private static final String INTERNET_TYPE_PUBLIC = "type_public";
    private static final String INTERNET_FORMATION = "formation";
    private static final String INTERNET_POST_NUMBER = "nb_postes";
    private static final String LONGITUDE = "x_long";
    private static final String LATITUDE = "y_lat";
    @Override
    public POICollectionDTO parse(String jsonInternet)  {
        POICollectionDTO poiInternetAccess = new POICollectionDTO();
        try {
            JSONObject reader = new JSONObject(jsonInternet);
            JSONArray internetAccessArray = reader.getJSONArray(INTERNET_OBJECT);
            for (int i = 0; i < internetAccessArray.length(); i++) {
                JSONObject internetAccessObject;
                internetAccessObject = internetAccessArray.getJSONObject(i);

                Double longitude = internetAccessObject.optDouble(LONGITUDE, 0);
                Double latitude = internetAccessObject.optDouble(LATITUDE, 0);
                String name = internetAccessObject.optString(INTERNET_NAME, null);
                String nature = internetAccessObject.optString(INTERNET_NATURE, null);
                String paid = internetAccessObject.optString(INTERNET_GRATUITY, null);
                String situation = internetAccessObject.optString(INTERNET_SITUATION, null);
                String typePublic = internetAccessObject.optString(INTERNET_TYPE_PUBLIC, null);
                String formation = internetAccessObject.optString(INTERNET_FORMATION, null);
                int postNumber = internetAccessObject.optInt(INTERNET_POST_NUMBER, -1);

                poiInternetAccess.addPOIDTO(new POIInternetAccessDTO(longitude, latitude, name, nature, paid, situation, typePublic, formation, postNumber));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return poiInternetAccess;
    }
}
