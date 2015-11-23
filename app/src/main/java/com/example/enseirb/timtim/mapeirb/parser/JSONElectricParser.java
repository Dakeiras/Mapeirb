package com.example.enseirb.timtim.mapeirb.parser;

import com.example.enseirb.timtim.mapeirb.dto.POICollectionDTO;
import com.example.enseirb.timtim.mapeirb.dto.POIElectricDTO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONElectricParser implements IPOICollectionParser {
    private static final String ELECTRIC_OBJECT ="StationDeCharge";
    private static final String ELECTRIC_NAME = "Nom";
    private static final String ELECTRIC_ADDRESS = "Adresse";
    private static final String ELECTRIC_STATUS = "Etat";
    private static final String ELECTRIC_NUMBER = "No";
    private static final String COORD = "CoordGPS";
    @Override
    public POICollectionDTO parse(String jsonElectric)  {
        POICollectionDTO poiCollectionElectric = new POICollectionDTO();
        try {
            JSONArray electricArray;
            JSONObject reader = null;
            reader = new JSONObject(jsonElectric);
            electricArray = reader.getJSONArray(ELECTRIC_OBJECT);
            for (int i = 0; i < electricArray.length(); i++) {
                JSONObject electricObject;
                electricObject = electricArray.getJSONObject(i);

                String coord = electricObject.optString(COORD, null);
                Double latitude;
                Double longitude;
                if (coord != null) {
                    latitude = Double.parseDouble(coord.split(",")[0]);
                    longitude = Double.parseDouble(coord.split(",")[1]);
                }else{
                    latitude = 0.0;
                    longitude = 0.0;
                }

                String name = electricObject.optString(ELECTRIC_NAME, null);
                String address = electricObject.optString(ELECTRIC_ADDRESS, null);
                String status = electricObject.optString(ELECTRIC_STATUS, null);
                int number = electricObject.optInt(ELECTRIC_NUMBER, -1);

                poiCollectionElectric.addPOIDTO(new POIElectricDTO(longitude, latitude, name, address, status, number));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return poiCollectionElectric;
    }
}
