package com.example.enseirb.timtim.mapeirb.presenter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.enseirb.timtim.mapeirb.R;
import com.example.enseirb.timtim.mapeirb.business.IPOICollectionBusiness;
import com.example.enseirb.timtim.mapeirb.business.POICollectionBusiness;
import com.example.enseirb.timtim.mapeirb.business.listener.IPOICollectionBusinessListener;
import com.example.enseirb.timtim.mapeirb.model.POI;
import com.example.enseirb.timtim.mapeirb.model.POICollection;
import com.example.enseirb.timtim.mapeirb.model.POIType;

import java.util.ArrayList;
import java.util.List;

public class InformationListActivity extends AppCompatActivity {

    private static final String SERVICE_NAME = "com.example.enseirb.timtim.mapeirb.presenter.SERVICE";
    protected static final String DEFIBRILATOR_NAME = "com.example.enseirb.timtim.mapeirb.presenter.DEFIBRILATOR";
    protected static final String ELECTRIC_CAR_NAME = "com.example.enseirb.timtim.mapeirb.presenter.ELECTRICCAR";
    protected static final String TOILET_NAME = "com.example.enseirb.timtim.mapeirb.presenter.TOILET";
    protected static final String INTERNET_NAME = "com.example.enseirb.timtim.mapeirb.presenter.INTERNET";
    private IPOICollectionBusiness poiCollectionBusiness;
    private List<String> serviceList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_information_list);
        if(getResources().getBoolean(R.bool.portrait_only)){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        initializeBusiness();
        String service = getIntent().getStringExtra(SERVICE_NAME);
        ListView listView = (ListView) findViewById(R.id.information_layout_list);

        retrieveServiceList(service);

        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, serviceList));



    }

    private void retrieveServiceList(String service) {
        IPOICollectionBusinessListener listener = new com.example.enseirb.timtim.mapeirb.business.listener.IPOICollectionBusinessListener() {
            @Override
            public void onSuccess(POICollection poiCollection) {
                fillList(poiCollection);
            }

            @Override
            public void onError(String message) {

            }
        };

        switch (service) {

            case DEFIBRILATOR_NAME:
                poiCollectionBusiness.retrievePOICollection(POIType.DEFIBRILLATOR,listener);
                break;
            case INTERNET_NAME:
                poiCollectionBusiness.retrievePOICollection(POIType.INTERNET,listener);
                break;
            case ELECTRIC_CAR_NAME:
                poiCollectionBusiness.retrievePOICollection(POIType.ELECTRIC,listener);
                break;
            case TOILET_NAME:
                poiCollectionBusiness.retrievePOICollection(POIType.TOILET,listener);
                break;
            default:
                break;
        }



    }

    private void fillList(POICollection poiCollection) {
        for(POI poi: poiCollection.getPoiCollection()) {
            serviceList.add(poi.getTitle());
        }
    }

    private void initializeBusiness() {
        poiCollectionBusiness = new POICollectionBusiness();
    }

    public static Intent getIntent(Context context, String service) {
        Intent intent = new Intent(context, InformationListActivity.class);
        intent.putExtra(SERVICE_NAME,service);
        return intent;
    }

}
