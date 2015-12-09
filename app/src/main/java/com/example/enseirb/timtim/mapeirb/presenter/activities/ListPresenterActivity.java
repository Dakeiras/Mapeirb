package com.example.enseirb.timtim.mapeirb.presenter.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.enseirb.timtim.mapeirb.R;
import com.example.enseirb.timtim.mapeirb.model.IPOI;
import com.example.enseirb.timtim.mapeirb.model.POI;
import com.example.enseirb.timtim.mapeirb.model.POICollection;
import com.example.enseirb.timtim.mapeirb.presenter.popupFactories.ProgressPopupFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ListPresenterActivity extends Activity {

    private static final String SERVICE_NAME = "com.example.enseirb.timtim.mapeirb.presenter.SERVICE";
    private ListView listView;
    //private IPOICollectionBusiness poiCollectionBusiness;
    private TextView title;
    ProgressPopupFactory progressPopupFactory = new ProgressPopupFactory(this);
    public static POICollection mPOICollection;
    private CustomAdapter dataAdapter;

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

        Button nameSortButton = (Button) findViewById(R.id.button_sort_name);
        nameSortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fillListByName(mPOICollection);
            }
        });
        Button distanceSortButton = (Button) findViewById(R.id.button_sort_distance);
        distanceSortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fillListByDistance(mPOICollection);
            }
        });

        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = MapPresenterActivity.getResultIntent((IPOI) parent.getItemAtPosition(position));
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        };

        createList(serviceName, listener);
    }

    public static Intent getIntent(Context context, String service) {
        Intent intent = new Intent(context, ListPresenterActivity.class);
        intent.putExtra(SERVICE_NAME, service);
        return intent;
    }

    public void createList(String service, AdapterView.OnItemClickListener listener) {
        //initializeBusiness();
        listView = (ListView) findViewById(R.id.information_layout_list);
        retrieveServiceList(service);
        listView.setOnItemClickListener(listener);
    }

    private void retrieveServiceList(String service) {
//        IPOICollectionBusinessListener listener = new IPOICollectionBusinessListener() {
//            @Override
//            public void onSuccess(final POICollection poiCollection) {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        mPOICollection = poiCollection;
//                        fillListByName(poiCollection);
//                    }
//                });
//
//            }
//
//            @Override
//            public void onError(String message) {
//
//            }
//        };

        //mPOICollection = (POICollection) getIntent().getSerializableExtra("POI_COLLECTION");
        System.out.println(mPOICollection.getPoiCollection().size());
        fillListByName(mPOICollection);

        switch (service) {
            case InformationListFragment.DEFIBRILATOR_NAME:
                title.setText("Défibrillateur");
                //poiCollectionBusiness.retrievePOICollection(POIType.DEFIBRILLATOR,listener);
                break;
            case InformationListFragment.INTERNET_NAME:
                title.setText("Points WIFI");
                //poiCollectionBusiness.retrievePOICollection(POIType.INTERNET,listener);
                break;
            case InformationListFragment.ELECTRIC_CAR_NAME:
                title.setText("Bornes électriques");
                //poiCollectionBusiness.retrievePOICollection(POIType.ELECTRIC,listener);
                break;
            case InformationListFragment.TOILET_NAME:
                title.setText("Toilettes");
                //poiCollectionBusiness.retrievePOICollection(POIType.TOILET,listener);
                break;
            default:
                break;
        }



    }

    private void fillListByName(POICollection poiCollection) {
//        progressPopupFactory.show();
//        List<String> serviceList = new ArrayList<>();
//        for(IPOI poi: poiCollection.getPoiCollection()) {
//            serviceList.add(poi.getTitle());
//        }
//        Collections.sort(serviceList, Collator.getInstance());
//        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, serviceList));
//
//
//        progressPopupFactory.dismiss();

        progressPopupFactory.show();

        List<POI> poiList = new ArrayList<>();
        for(IPOI poi: poiCollection.getPoiCollection()) {
            poiList.add((POI) poi);
        }
        Collections.sort(poiList);

        dataAdapter = new CustomAdapter(this, R.layout.list_check_box, poiList);
        listView.setAdapter(dataAdapter);

        progressPopupFactory.dismiss();
    }

    private void fillListByDistance(final POICollection poiCollection) {
        progressPopupFactory.show();
        final LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        final Activity activity = this;
        final String locationProvider = LocationManager.NETWORK_PROVIDER;
        final LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                Location lastKnownLocation = locationManager.getLastKnownLocation(locationProvider);
                Map<Float,String> serviceList = new TreeMap<>();
                for(IPOI poi: poiCollection.getPoiCollection()) {
                    //System.out.println(poi.getTitle());
                    Location poiLocation = new Location("poi");
                    poiLocation.setLatitude(poi.getPosition().latitude);
                    poiLocation.setLongitude(poi.getPosition().longitude);
                    serviceList.put(lastKnownLocation.distanceTo(poiLocation), poi.getTitle());
                }
                listView.setAdapter(new ArrayAdapter<>(activity, android.R.layout.simple_list_item_1, android.R.id.text1,
                        new LinkedList<>(serviceList.values())));
                removeLocationListener(this, locationManager);
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {}

            public void onProviderEnabled(String provider) {}

            public void onProviderDisabled(String provider) {}
        };

        locationManager.requestLocationUpdates(locationProvider, 0, 0, locationListener);
        progressPopupFactory.dismiss();
    }

    private void removeLocationListener(LocationListener locationListener, LocationManager locationManager) {
        locationManager.removeUpdates(locationListener);
    }

    //private void initializeBusiness() {
    //    poiCollectionBusiness = new POICollectionBusiness();
    //}


}
