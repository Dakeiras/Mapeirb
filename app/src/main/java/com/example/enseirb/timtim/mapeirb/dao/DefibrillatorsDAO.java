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
                POICollectionDTO defibrillatorCollectionDTO;
                String jsonDefibrillator = poiCollectionClient.retrievePOICollection(params[0]);
                defibrillatorCollectionDTO = poiCollectionParser.parse(jsonDefibrillator);
                listener.onSuccess(defibrillatorCollectionDTO);
                return defibrillatorCollectionDTO;
            }
        }.execute(URL);
    }
}
