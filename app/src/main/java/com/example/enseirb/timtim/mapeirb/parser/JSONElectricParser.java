package com.example.enseirb.timtim.mapeirb.parser;

import com.example.enseirb.timtim.mapeirb.dto.POICollectionDTO;
import com.example.enseirb.timtim.mapeirb.dto.POIElectricDTO.CarPlaceDTO;
import com.example.enseirb.timtim.mapeirb.dto.POIElectricDTO.POIElectricDTO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSONElectricParser implements IPOICollectionParser {
    private static final String ELECTRIC_OBJECT ="StationDeCharge";
    private static final String ELECTRIC_NAME = "Nom";
    private static final String ELECTRIC_ADDRESS = "Adresse";
    private static final String ELECTRIC_STATUS = "Etat";
    private static final String ELECTRIC_NUMBER = "No";
    private static final String ELECTRIC_ACCESS = "Acces";
    private static final String ELECTRIC_CAR_PLACES = "PCs";

    private static final String CAR_PLACE_NUMBER = "NoPC";
    private static final String CAR_PLACE_STATE = "Etat";

    private static final String COORD = "CoordGPS";
    @Override
    public POICollectionDTO parse(String jsonElectric)  {
        POICollectionDTO poiCollectionElectric = new POICollectionDTO();
        try {
            JSONObject reader = new JSONObject(jsonElectric);
            JSONArray electricArray = reader.getJSONArray(ELECTRIC_OBJECT);
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
                String access = electricObject.optString(ELECTRIC_ACCESS, null);
                JSONArray carPlacesArray = electricObject.getJSONArray(ELECTRIC_CAR_PLACES);
                List<CarPlaceDTO> carPlaces = new ArrayList<>();
                for (int carPlace = 0 ; i < carPlacesArray.length() ; i++){
                     carPlaces.add(parseCarPlace(carPlacesArray.getJSONObject(carPlace)));
                }

                poiCollectionElectric.addPOIDTO(new POIElectricDTO(longitude, latitude, name, number, address, status, access, carPlaces));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return poiCollectionElectric;
    }

    private CarPlaceDTO parseCarPlace(JSONObject jsonObject) {
        CarPlaceDTO carPlace = new CarPlaceDTO();
        carPlace.setNumber(jsonObject.optInt(CAR_PLACE_NUMBER, -1));
        carPlace.setStatus(jsonObject.optString(CAR_PLACE_STATE, null));
        return carPlace;
    }
}
