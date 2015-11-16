package com.example.enseirb.timtim.mapeirb.dao;

import com.example.enseirb.timtim.mapeirb.dto.DefibrillatorDTO;
import com.example.enseirb.timtim.mapeirb.parser.DataParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by air on 14/11/2015.
 */
public class DefibrillatorDAO /*extends DataParser*/ {
    private static final String DEFIBRILLATOR_OBJECT ="d";
    private static final String DEFIBRILLATOR_TYPOLOGIE = "typologie";
    private static final String DEFIBRILLATOR_Address = "adresse";
    private static final String DEFIBRILLATOR_NAME = "nom";
    private static final String DEFIBRILLATOR_TELEPHONE = "telephone";
    private static final String DEFIBRILLATOR_INFORMATION = "information";
    private static final String DEFIBRILLATOR_APIURL = "http://odata.bordeaux.fr/v1/databordeaux/defibrillateurs/?format=json";
   /* @Override
    public List<DataDTO> parseData() {
        List<DataDTO> defibrillatorListDTO = new ArrayList<DataDTO>();
        try{
            InputStream is = connectTo(DEFIBRILLATOR_APIURL);
            String result = requestResponseAsString(is);
            JSONArray defibrillatorArray;
            JSONObject reader =new JSONObject(result);
            defibrillatorArray = reader.getJSONArray(DEFIBRILLATOR_OBJECT);

            for (int i = 0; i < defibrillatorArray.length(); i++) {
                JSONObject defibrillatorObject;
                defibrillatorObject = defibrillatorArray.getJSONObject(i);

                String longitude = defibrillatorObject.getString(LONGITUDE);
                String latitude = defibrillatorObject.getString(LATITUDE);
                String typologie = defibrillatorObject.getString(DEFIBRILLATOR_TYPOLOGIE);
                String address = defibrillatorObject.getString(DEFIBRILLATOR_Address);
                String name=defibrillatorObject.getString(DEFIBRILLATOR_NAME);
                String telephone=defibrillatorObject.getString(DEFIBRILLATOR_TELEPHONE);
                String information=defibrillatorObject.getString(DEFIBRILLATOR_INFORMATION);

                defibrillatorListDTO.add(new DefibrillatorDTO(longitude, latitude, typologie,address,name,telephone,information));
            }
            is.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return defibrillatorListDTO;
    }*/
}
