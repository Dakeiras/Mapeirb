package com.example.enseirb.timtim.mapeirb.presenter.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
import com.example.enseirb.timtim.mapeirb.presenter.MapConfig;
import com.example.enseirb.timtim.mapeirb.presenter.MapManager;
import com.example.enseirb.timtim.mapeirb.utils.SingletonPOICollection;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import java.util.Iterator;

public class MapPresenterActivity extends FragmentActivity implements OnMapReadyCallback {
    private static final String SERVICE_NAME = "com.example.enseirb.timtim.mapeirb.presenter.SERVICE";
    private static final String RESULT = "com.example.enseirb.timtim.mapeirb.presenter.RESULT";
    private static final int SERVICE_CLICK = 1;
    private MapManager mapManager = new MapManager(this);
    private POICollection poiCollection;
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
                    for (IPOI ipoi : poiCollection.getPoiCollection()) {
                        if (ipoi.getTitle().equals(parent.getItemAtPosition(position))) {
                            centerOnPoi(ipoi);
                            break;
                        }
                    }
                }
            };
            fragment.createList(getIntent().getStringExtra(SERVICE_NAME), poiCollection, listener);
        } else {
            Button listButton = (Button) findViewById(R.id.content_information_list_list_button);
            serviceName = getIntent().getStringExtra(SERVICE_NAME);
            listButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = ListPresenterActivity.getIntent(activity, serviceName);
                    savedMapConfig();
                    startActivityForResult(intent, SERVICE_CLICK);
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
        if(resultCode == RESULT_OK) {
            if (requestCode == SERVICE_CLICK) {
                Iterator<IPOI> it = poiCollection.getPoiCollection().iterator();
                IPOI ipoi;
                while (it.hasNext()) {
                    ipoi = it.next();
                    if (ipoi.getTitle().equalsIgnoreCase(data.getStringExtra(RESULT))) {
                        centerOnPoi(ipoi);
                        break;
                    }
                }
            }
        }
        mapManager.clear();
        mapManager.setPOIMarkers(poiCollection);
        savedMapConfig();
        super.onActivityResult(requestCode, resultCode, data);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapManager.prepareMap(googleMap, loadMapConfig());
    }

    private MapConfig loadMapConfig() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        return new MapConfig(preferences);
    }

    private void savedMapConfig() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        MapConfig mapConfig = mapManager.getMapConfig();
        mapConfig.updateMapPreferences(preferences);
    }


    public static Intent getIntent(Context context, String service) {
        Intent intent = new Intent(context, MapPresenterActivity.class);
        intent.putExtra(SERVICE_NAME, service);
        return intent;
    }
    public void centerOnPoi(IPOI poi) {
        LatLng poiPos = poi.getPosition();
        mapManager.moveCamera(CameraUpdateFactory.newLatLngZoom(poiPos, 17));
    }
    public void createList(String service) {
        retrieveServiceList(service);
    }
    private void retrieveServiceList(String service) {
        IPOICollectionBusiness poiCollectionBusiness = new POICollectionBusiness();
        IPOICollectionBusinessListener listener = new IPOICollectionBusinessListener() {
            @Override
            public void onSuccess(final POICollection poiCollection) {
                serviceName = getIntent().getStringExtra(SERVICE_NAME);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //MapPresenterActivity.this.poiCollection = poiCollection;
                        SingletonPOICollection.getInstance().getPoiCollection().clear();
                        SingletonPOICollection.getInstance().getPoiCollection().addAll(poiCollection.getPoiCollection());
                        MapPresenterActivity.this.poiCollection = SingletonPOICollection.getInstance();
                        mapManager.setPOIMarkers(poiCollection);

                        InformationListFragment fragment;
                        if ((fragment = (InformationListFragment) getFragmentManager().findFragmentById(R.id.list_layout_fragment)) != null){
                            AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    for (IPOI ipoi : poiCollection.getPoiCollection()) {
                                        if (ipoi.getTitle().equals(parent.getItemAtPosition(position))) {
                                            centerOnPoi(ipoi);
                                            break;
                                        }
                                    }
                                }
                            };
                            fragment.createList(serviceName, poiCollection, listener);
                        } else {
                            Button listButton = (Button) findViewById(R.id.content_information_list_list_button);

                            listButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = ListPresenterActivity.getIntent(activity, serviceName);
                                    SingletonPOICollection.getInstance().getPoiCollection().clear();
                                    SingletonPOICollection.getInstance().getPoiCollection().addAll(poiCollection.getPoiCollection());
                                    MapPresenterActivity.this.poiCollection = SingletonPOICollection.getInstance();
                                    startActivityForResult(intent, SERVICE_CLICK);
                                }
                            });
                            Typeface font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
                            listButton.setTypeface(font);
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

    @Override
    protected void onStop() {
        super.onStop();
        savedMapConfig();
    }

    public static Intent getResultIntent(IPOI poi) {
        Intent intent = new Intent();
        intent.putExtra(RESULT, poi.getTitle());
        return intent;
    }
}