package com.example.enseirb.timtim.mapeirb.dao;

import android.os.AsyncTask;

import com.example.enseirb.timtim.mapeirb.client.IPOICollectionClient;
import com.example.enseirb.timtim.mapeirb.client.POICollectionClient;
import com.example.enseirb.timtim.mapeirb.dao.listener.IPOICollectionDAOListener;
import com.example.enseirb.timtim.mapeirb.dto.POICollectionDTO;
import com.example.enseirb.timtim.mapeirb.parser.IPOICollectionParser;
import com.example.enseirb.timtim.mapeirb.parser.JSONInternetParser;

public class InternetsDAO implements IPOIsDAO {
    public static final String URL = "http://odata.bordeaux.fr/v1/databordeaux/sigaccesinternet/?format=json";
    private static final String JSON_ERROR = "Could not retrieve JSON";

    private IPOICollectionClient poiCollectionClient;
    private IPOICollectionParser poiCollectionParser;

    public InternetsDAO(){
        poiCollectionClient = new POICollectionClient();
        poiCollectionParser = new JSONInternetParser();
    }

    @Override
    public void retrievePOICollection(final IPOICollectionDAOListener listener) {
        new AsyncTask<String, Integer, POICollectionDTO>() {
            @Override
            protected POICollectionDTO doInBackground(String... params) {
                POICollectionDTO internetCollectionDTO = null;
                String jsonInternet = poiCollectionClient.retrievePOICollection(params[0]);
                if(jsonInternet == null)
                    listener.onError(JSON_ERROR);
                else {
                internetCollectionDTO = poiCollectionParser.parse(jsonInternet);
                listener.onSuccess(internetCollectionDTO);
                }
                return internetCollectionDTO;
            }
        }.execute(URL);
    }

}
