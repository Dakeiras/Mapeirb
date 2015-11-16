package com.example.enseirb.timtim.mapeirb.dao;

import com.example.enseirb.timtim.mapeirb.dto.ElectricDTO;
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
public class ElectricDAO /*extends DataParser*/ {
    private static final String ELECTRIC_OBJECT ="StationDeCharge";
    private static final String ELECTRIC_NUMBER = "No";
    private static final String ELECTRIC_Address = "adresse";
    private static final String ELECTRIC_NAME = "Nom";
    private static final String ELECTRIC_STATUS = "Etat";
    private static final String ELECTRIC_COORDGPS = "CoordGPS";
    
    private static final String ELECTRIC_APIURL = "http://www.chargepulse.com/download/?type=json&client=MairieBx";
   /* @Override
    public List<DataDTO> parseData() {
        List<DataDTO> electricListDTO = new ArrayList<DataDTO>();
        try{
            InputStream is = connectTo(ELECTRIC_APIURL);
            String result = requestResponseAsString(is);
            JSONArray electricArray;
            JSONObject reader =new JSONObject(result);
            electricArray = reader.getJSONArray(ELECTRIC_OBJECT);

            for (int i = 0; i < electricArray.length(); i++) {
                JSONObject electricObject;
                electricObject = electricArray.getJSONObject(i);

                String longitude = electricObject.getString(ELECTRIC_COORDGPS).split(",")[0];
                String latitude = electricObject.getString(ELECTRIC_COORDGPS).split(",")[1];
                int number = electricObject.getInt(ELECTRIC_NUMBER);
                String address = electricObject.getString(ELECTRIC_Address);
                String name=electricObject.getString(ELECTRIC_NAME);
                String status=electricObject.getString(ELECTRIC_STATUS);
              
                electricListDTO.add(new ElectricDTO(longitude, latitude, number,name,address,status));
            }
            is.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return electricListDTO;
    }*/
}
