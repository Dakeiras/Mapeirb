package com.example.enseirb.timtim.mapeirb.presenter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.enseirb.timtim.mapeirb.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class InformationListActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final String SERVICE_NAME = "com.example.enseirb.timtim.mapeirb.presenter.SERVICE";
    private GoogleMap map;
    private List<LatLng> poiList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_information_list);
        if(getResources().getBoolean(R.bool.portrait_only)){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        InformationListFragment fragment = (InformationListFragment) getFragmentManager().findFragmentById(R.id.list_layout_fragment);
        fragment.createList(getIntent().getStringExtra(SERVICE_NAME));

        SupportMapFragment mapFragment;
        if((mapFragment= (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map)) != null) {
            mapFragment.getMapAsync(this);
        }
    }

    private void centerOnItem() {
        
    }



    public static Intent getIntent(Context context, String service) {
        Intent intent = new Intent(context, InformationListActivity.class);
        intent.putExtra(SERVICE_NAME,service);
        return intent;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        LatLng bdx = new LatLng(44.840950, -0.574813);
        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(bdx, 12));

        poiList.add(new LatLng(44.80, -0.574));
        poiList.add(new LatLng(44.84, -0.57));
        poiList.add(new LatLng(44.82, -0.594));
        poiList.add(new LatLng(44.79, -0.525));

        for (LatLng elm: poiList)
            addMarker("cul", "coucou", elm);
    }

    private void addMarker(String title, String snippet, LatLng position){
        map.addMarker(new MarkerOptions()
                .title(title)
                .snippet(snippet)
                .position(position));
    }
}
