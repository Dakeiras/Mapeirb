package com.example.enseirb.timtim.mapeirb.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.enseirb.timtim.mapeirb.R;
import com.example.enseirb.timtim.mapeirb.business.IPOICollectionBusiness;
import com.example.enseirb.timtim.mapeirb.business.POICollectionBusiness;
import com.example.enseirb.timtim.mapeirb.business.listener.IPOICollectionBusinessListener;
import com.example.enseirb.timtim.mapeirb.model.IPOI;
import com.example.enseirb.timtim.mapeirb.model.POICollection;
import com.example.enseirb.timtim.mapeirb.model.POIType;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;

import java.util.ArrayList;
import java.util.List;

public class InformationListActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final String SERVICE_NAME = "com.example.enseirb.timtim.mapeirb.presenter.SERVICE";
    private GoogleMap map;
    private IPOICollectionBusiness poiCollectionBusiness;
    private POICollection mPOICollection;
    private List<LatLng> poiList = new ArrayList<>();
    private OnMapReadyCallback activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_information_list);
        if(getResources().getBoolean(R.bool.portrait_only)){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }


        InformationListFragment fragment;
        if((fragment = (InformationListFragment) getFragmentManager().findFragmentById(R.id.list_layout_fragment))!=null) {
            fragment.createList(getIntent().getStringExtra(SERVICE_NAME));
        }

        SupportMapFragment mapFragment;
        if((mapFragment= (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map)) != null) {
            mapFragment.getMapAsync(this);
            createList(getIntent().getStringExtra(SERVICE_NAME));
        }
    }

    private void centerOnItem() {

    }



    public static Intent getIntent(Context context, String service) {
        Intent intent = new Intent(context, InformationListActivity.class);
        intent.putExtra(SERVICE_NAME, service);
        return intent;
    }

    private void setMarkers(ClusterManager<ClusterablePOI> clusterManager, POICollection poiCollection){
        if(poiCollection!=null) {
            for (IPOI poi : poiCollection.getPoiCollection()) {
                String title = poi.getTitle();
                String snippet = poi.getTitle();
                LatLng latLng = poi.getPosition();
                System.out.println("DEBUG: " + latLng );
                clusterManager.addItem(new ClusterablePOI(poi));

            }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        System.out.println("DEBUG: coucou");
        map = googleMap;
        LatLng bdx = new LatLng(44.840950, -0.574813);
        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(bdx, 12));

        ClusterManager<ClusterablePOI> clusterManager = new ClusterManager<ClusterablePOI>(this, map);
        map.setOnCameraChangeListener(clusterManager);
        map.setOnMarkerClickListener(clusterManager);

//        setMarkers(map, poiCollectionTest());
        setMarkers(clusterManager, mPOICollection);
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
                        System.out.println("DEBUG: test1");
                        mPOICollection = poiCollection;
                        SupportMapFragment mapFragment;
                        if((mapFragment= (SupportMapFragment) getSupportFragmentManager()
                                .findFragmentById(R.id.map)) != null) {
                            System.out.println("DEBUG: test2");
                            mapFragment.getMapAsync(activity);
                        }
                        System.out.println("DEBUG: test3");
                    }
                });

            }

            @Override
            public void onError(String message) {

            }
        };

        switch (service) {

            case InformationListFragment.DEFIBRILATOR_NAME:
                poiCollectionBusiness.retrievePOICollection(POIType.DEFIBRILLATOR,listener);
                break;
            case InformationListFragment.INTERNET_NAME:
                poiCollectionBusiness.retrievePOICollection(POIType.INTERNET,listener);
                break;
            case InformationListFragment.ELECTRIC_CAR_NAME:
                poiCollectionBusiness.retrievePOICollection(POIType.ELECTRIC,listener);
                break;
            case InformationListFragment.TOILET_NAME:
                poiCollectionBusiness.retrievePOICollection(POIType.TOILET,listener);
                break;
            default:
                break;
        }



    }

    private void initializeBusiness() {
        poiCollectionBusiness = new POICollectionBusiness();
    }

}

