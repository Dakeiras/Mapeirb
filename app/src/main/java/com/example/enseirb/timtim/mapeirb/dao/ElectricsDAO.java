package com.example.enseirb.timtim.mapeirb.dao;

import android.os.AsyncTask;

import com.example.enseirb.timtim.mapeirb.client.IPOICollectionClient;
import com.example.enseirb.timtim.mapeirb.client.POICollectionClient;
import com.example.enseirb.timtim.mapeirb.dao.listener.IPOICollectionDAOListener;
import com.example.enseirb.timtim.mapeirb.dto.POICollectionDTO;
import com.example.enseirb.timtim.mapeirb.parser.IPOICollectionParser;
import com.example.enseirb.timtim.mapeirb.parser.JSONElectricParser;

public class ElectricsDAO implements IPOIsDAO {
    public static final String URL = "http://www.chargepulse.com/download/?type=json&client=MairieBx";
    private static final String JSON_ERROR = "Could not retrieve JSON";

    private IPOICollectionClient poiCollectionClient;
    private IPOICollectionParser poiCollectionParser;

    public ElectricsDAO(){
        poiCollectionClient = new POICollectionClient();
        poiCollectionParser = new JSONElectricParser();
    }

    @Override
    public void retrievePOICollection(final IPOICollectionDAOListener listener) {
        new AsyncTask<String, Integer, POICollectionDTO>() {
            @Override
            protected POICollectionDTO doInBackground(String... params) {
                POICollectionDTO electricCollectionDTO = null;
                String jsonElectric = poiCollectionClient.retrievePOICollection(params[0]);
                if(jsonElectric == null)
                    listener.onError(JSON_ERROR);
                else {
                electricCollectionDTO = poiCollectionParser.parse(jsonElectric);
                listener.onSuccess(electricCollectionDTO);
                }
                return electricCollectionDTO;
            }
        }.execute(URL);
    }

}
