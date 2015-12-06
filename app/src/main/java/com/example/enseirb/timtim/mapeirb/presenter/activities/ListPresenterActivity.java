package com.example.enseirb.timtim.mapeirb.presenter.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.enseirb.timtim.mapeirb.R;
import com.example.enseirb.timtim.mapeirb.business.IPOICollectionBusiness;
import com.example.enseirb.timtim.mapeirb.business.POICollectionBusiness;
import com.example.enseirb.timtim.mapeirb.business.listener.IPOICollectionBusinessListener;
import com.example.enseirb.timtim.mapeirb.model.IPOI;
import com.example.enseirb.timtim.mapeirb.model.POICollection;
import com.example.enseirb.timtim.mapeirb.model.POIType;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Home on 06/12/2015.
 */
public class ListPresenterActivity extends Activity {

    private static final String SERVICE_NAME = "com.example.enseirb.timtim.mapeirb.presenter.SERVICE";
    private ListView listView;
    private IPOICollectionBusiness poiCollectionBusiness;
    TextView title;
    private POICollection mPOICollection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String serviceName = getIntent().getStringExtra(SERVICE_NAME);
        setContentView(R.layout.information_list_display);
        if(getResources().getBoolean(R.bool.portrait_only)){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        title = (TextView) findViewById(R.id.information_list_service_name);

        listView = (ListView) findViewById(R.id.information_layout_list);

        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = MapPresenterActivity.getResultIntent((String) parent.getItemAtPosition(position));
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        };

        createList(serviceName,listener);
    }

    public static Intent getIntent(Context context, String service) {
        Intent intent = new Intent(context, ListPresenterActivity.class);
        intent.putExtra(SERVICE_NAME, service);
        return intent;
    }

    public void createList(String service,AdapterView.OnItemClickListener listener) {
        initializeBusiness();
        TextView title = (TextView) findViewById(R.id.information_list_service_name);
        title.setText(service);
        listView = (ListView) findViewById(R.id.information_layout_list);
        retrieveServiceList(service);
        listView.setOnItemClickListener(listener);
    }

    private void retrieveServiceList(String service) {
        IPOICollectionBusinessListener listener = new IPOICollectionBusinessListener() {
            @Override
            public void onSuccess(final POICollection poiCollection) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mPOICollection = poiCollection;
                        fillList(poiCollection);
                    }
                });

            }

            @Override
            public void onError(String message) {

            }
        };

        switch (service) {

            case InformationListFragment.DEFIBRILATOR_NAME:
                title.setText("Défibrillateur");
                poiCollectionBusiness.retrievePOICollection(POIType.DEFIBRILLATOR,listener);
                break;
            case InformationListFragment.INTERNET_NAME:
                title.setText("Points WIFI");
                poiCollectionBusiness.retrievePOICollection(POIType.INTERNET,listener);
                break;
            case InformationListFragment.ELECTRIC_CAR_NAME:
                title.setText("Bornes électriques");
                poiCollectionBusiness.retrievePOICollection(POIType.ELECTRIC,listener);
                break;
            case InformationListFragment.TOILET_NAME:
                title.setText("Toilettes");
                poiCollectionBusiness.retrievePOICollection(POIType.TOILET,listener);
                break;
            default:
                break;
        }



    }

    private void fillList(POICollection poiCollection) {
        List<String> serviceList = new ArrayList<>();
        for(IPOI poi: poiCollection.getPoiCollection()) {
            System.out.println(poi.getTitle());
            serviceList.add(poi.getTitle());
        }
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, serviceList));
    }

    private void initializeBusiness() {
        poiCollectionBusiness = new POICollectionBusiness();
    }

}
