package com.example.enseirb.timtim.mapeirb.presenter.activities;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import com.example.enseirb.timtim.mapeirb.R;
import com.example.enseirb.timtim.mapeirb.business.IPOICollectionBusiness;
import com.example.enseirb.timtim.mapeirb.business.POICollectionBusiness;
import com.example.enseirb.timtim.mapeirb.business.listener.IPOICollectionBusinessListener;
import com.example.enseirb.timtim.mapeirb.model.IPOI;
import com.example.enseirb.timtim.mapeirb.model.POICollection;
import com.example.enseirb.timtim.mapeirb.model.POIType;
import com.example.enseirb.timtim.mapeirb.presenter.MapInitializer;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MapPresenterActivity extends FragmentActivity implements OnMapReadyCallback {
    private static final String SERVICE_NAME = "com.example.enseirb.timtim.mapeirb.presenter.SERVICE";
    private static final String RESULT = "com.example.enseirb.timtim.mapeirb.presenter.RESULT";
    private static final int SERVICE_CLICK = 1;
    private GoogleMap map;
    private IPOICollectionBusiness poiCollectionBusiness;
    private POICollection mPOICollection;
    private List<LatLng> poiList = new ArrayList<>();
    private MapPresenterActivity activity = this;
    private String serviceName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_information_list);
        if (getResources().getBoolean(R.bool.portrait_only))
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        InformationListFragment fragment;
        if ((fragment = (InformationListFragment) getFragmentManager().findFragmentById(R.id.list_layout_fragment)) != null){
            AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    for (IPOI ipoi : mPOICollection.getPoiCollection()) {
                        if (ipoi.getTitle().equals(parent.getItemAtPosition(position))) {
                            centerOnPoi(ipoi);
                            break;
                        }
                    }
                }
            };
            fragment.createList(getIntent().getStringExtra(SERVICE_NAME), listener);
        } else {
            Button listButton = (Button) findViewById(R.id.content_information_list_list_button);
            final Context popupContext = this;
            serviceName = getIntent().getStringExtra(SERVICE_NAME);
            listButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = ListPresenterActivity.getIntent(activity, serviceName);
                    startActivityForResult(intent,SERVICE_CLICK);
                }
            });
        }
        SupportMapFragment mapFragment;
        if ((mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map)) != null) {
            mapFragment.getMapAsync(this);
            createList(getIntent().getStringExtra(SERVICE_NAME));
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == SERVICE_CLICK){
            Iterator<IPOI> it = mPOICollection.getPoiCollection().iterator();
            IPOI ipoi;
            while(it.hasNext()) {
                ipoi = it.next();
                if(ipoi.getTitle().equalsIgnoreCase(data.getStringExtra(RESULT))) {
                    centerOnPoi(ipoi);
                    break;
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = new MapInitializer().prepareMap(googleMap, mPOICollection, this);
    }
    public static Intent getIntent(Context context, String service) {
        Intent intent = new Intent(context, MapPresenterActivity.class);
        intent.putExtra(SERVICE_NAME, service);
        return intent;
    }
    public void centerOnPoi(IPOI poi) {
        LatLng poiPos = poi.getPosition();
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(poiPos, 17));
    }
    public void createList(String service) {
        initializeBusiness();
        retrieveServiceList(service);
    }
    private void retrieveServiceList(String service) {
        IPOICollectionBusinessListener listener = new IPOICollectionBusinessListener() {
            @Override
            public void onSuccess(final POICollection poiCollection) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mPOICollection = poiCollection;
                        SupportMapFragment mapFragment;
                        if ((mapFragment = (SupportMapFragment) getSupportFragmentManager()
                                .findFragmentById(R.id.map)) != null) {
                            mapFragment.getMapAsync(activity);
                        }
                    }
                });

            }
            @Override
            public void onError(String message) {

            }
        };
        switch (service) {
            case InformationListFragment.DEFIBRILATOR_NAME:
                poiCollectionBusiness.retrievePOICollection(POIType.DEFIBRILLATOR, listener);
                break;
            case InformationListFragment.INTERNET_NAME:
                poiCollectionBusiness.retrievePOICollection(POIType.INTERNET, listener);
                break;
            case InformationListFragment.ELECTRIC_CAR_NAME:
                poiCollectionBusiness.retrievePOICollection(POIType.ELECTRIC, listener);
                break;
            case InformationListFragment.TOILET_NAME:
                poiCollectionBusiness.retrievePOICollection(POIType.TOILET, listener);
                break;
            default:
                break;
        }
    }
    private void initializeBusiness() {
        poiCollectionBusiness = new POICollectionBusiness();
    }
    public static Intent getResultIntent(String title) {
        Intent intent = new Intent();
        intent.putExtra(RESULT, title);
        return intent;
    }
}