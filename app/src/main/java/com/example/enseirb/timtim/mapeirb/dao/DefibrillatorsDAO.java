package com.example.enseirb.timtim.mapeirb.dao;

import android.os.AsyncTask;

import com.example.enseirb.timtim.mapeirb.client.IPOICollectionClient;
import com.example.enseirb.timtim.mapeirb.client.POICollectionClient;
import com.example.enseirb.timtim.mapeirb.dao.listener.IPOICollectionDAOListener;
import com.example.enseirb.timtim.mapeirb.dto.POICollectionDTO;
import com.example.enseirb.timtim.mapeirb.parser.IPOICollectionParser;
import com.example.enseirb.timtim.mapeirb.parser.JSONDefibrillatorParser;

public class DefibrillatorsDAO implements IPOIsDAO {
    public static final String URL = "http://odata.bordeaux.fr/v1/databordeaux/defibrillateurs/?format=json";
    private static final String JSON_ERROR = "Could not retrieve JSON";

    private IPOICollectionClient poiCollectionClient;
    private IPOICollectionParser poiCollectionParser;

    public DefibrillatorsDAO(){
        poiCollectionClient = new POICollectionClient();
        poiCollectionParser = new JSONDefibrillatorParser();
    }

    @Override
    public void retrievePOICollection(final IPOICollectionDAOListener listener) {
        new AsyncTask<String, Integer, POICollectionDTO>() {
            @Override
            protected POICollectionDTO doInBackground(String... params) {
                POICollectionDTO defibrillatorCollectionDTO = null;
                String jsonDefibrillator = poiCollectionClient.retrievePOICollection(params[0]);
                if(jsonDefibrillator == null)
                    listener.onError(JSON_ERROR);
                else {
                defibrillatorCollectionDTO = poiCollectionParser.parse(jsonDefibrillator);
                listener.onSuccess(defibrillatorCollectionDTO);
                }
                return defibrillatorCollectionDTO;
            }
        }.execute(URL);
    }
}
