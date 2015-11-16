package com.example.enseirb.timtim.mapeirb.dao;

import android.os.AsyncTask;

import com.example.enseirb.timtim.mapeirb.client.IPOICollectionClient;
import com.example.enseirb.timtim.mapeirb.client.POICollectionClient;
import com.example.enseirb.timtim.mapeirb.dao.listener.IPOICollectionDAOListener;
import com.example.enseirb.timtim.mapeirb.dto.POICollectionDTO;
import com.example.enseirb.timtim.mapeirb.parser.IPOICollectionParser;
import com.example.enseirb.timtim.mapeirb.parser.JSONInternetParser;

public class InternetCollectionDAO implements IPOICollectionDAO{
    public static final String URL = "http://odata.bordeaux.fr/v1/databordeaux/sigaccesinternet/?format=json";

    private IPOICollectionClient poiCollectionClient;
    private IPOICollectionParser poiCollectionParser;

    public InternetCollectionDAO(){
        poiCollectionClient = new POICollectionClient();
        poiCollectionParser = new JSONInternetParser();
    }

    @Override
    public void retrievePOICollection(final IPOICollectionDAOListener listener) {
        new AsyncTask<String, Integer, POICollectionDTO>() {
            @Override
            protected POICollectionDTO doInBackground(String... params) {
                POICollectionDTO internetCollectionDTO;
                String jsonInternet = poiCollectionClient.retrievePOICollection(params[0]);
                internetCollectionDTO = poiCollectionParser.parse(jsonInternet);
                listener.onSuccess(internetCollectionDTO);
                return internetCollectionDTO;
            }
        }.execute(URL);
    }

}
