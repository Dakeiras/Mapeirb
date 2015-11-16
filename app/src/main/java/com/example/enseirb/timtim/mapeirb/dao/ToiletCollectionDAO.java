package com.example.enseirb.timtim.mapeirb.dao;

import android.os.AsyncTask;

import com.example.enseirb.timtim.mapeirb.client.IPOICollectionClient;
import com.example.enseirb.timtim.mapeirb.client.POICollectionClient;
import com.example.enseirb.timtim.mapeirb.dao.listener.IPOICollectionDAOListener;
import com.example.enseirb.timtim.mapeirb.dto.POICollectionDTO;
import com.example.enseirb.timtim.mapeirb.parser.IPOICollectionParser;
import com.example.enseirb.timtim.mapeirb.parser.JSONToiletParser;

public class ToiletCollectionDAO implements IPOICollectionDAO{
    public static final String URL = "http://odata.bordeaux.fr/v1/databordeaux/sigsanitaire/?format=json";

    private IPOICollectionClient poiCollectionClient;
    private IPOICollectionParser poiCollectionParser;

    public ToiletCollectionDAO(){
        poiCollectionClient = new POICollectionClient();
        poiCollectionParser = new JSONToiletParser();
    }

    @Override
    public void retrievePOICollection(final IPOICollectionDAOListener listener) {
        new AsyncTask<String, Integer, POICollectionDTO>() {
            @Override
            protected POICollectionDTO doInBackground(String... params) {
                POICollectionDTO toiletCollectionDTO;
                String jsonToilet = poiCollectionClient.retrievePOICollection(params[0]);
                toiletCollectionDTO = poiCollectionParser.parse(jsonToilet);
                listener.onSuccess(toiletCollectionDTO);
                return toiletCollectionDTO;
            }
        }.execute(URL);
    }

}
