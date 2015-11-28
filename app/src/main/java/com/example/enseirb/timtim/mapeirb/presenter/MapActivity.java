package com.example.enseirb.timtim.mapeirb.presenter;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.enseirb.timtim.mapeirb.R;
import com.example.enseirb.timtim.mapeirb.model.POI;
import com.example.enseirb.timtim.mapeirb.model.POICollection;
import com.example.enseirb.timtim.mapeirb.model.POIDefibrillator;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap map;
    private List<LatLng> poiList = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    private POICollection poiCollectionTest() {
        POICollection poiCollection = new POICollection();
        poiCollection.add(new POIDefibrillator(-0.578, 44.80, "hjkl", "hjlk", "uiop", "fghj", true));
        poiCollection.add(new POIDefibrillator(-0.572, 44.88, "hjiiikl", "ihiijiilk", "uiiioipi", "figihij", true));
        return poiCollection;
    }


    private void setMarkers(GoogleMap map, POICollection poiCollection){
        for (POI poi : poiCollection.getPoiCollection()) {
            String title = poi.getTitle();
            String snippet = poi.getTitle();
            LatLng latLng = new LatLng(poi.latitude, poi.longitude);
            map.addMarker(new MarkerOptions()
                    .title(title)
                    .snippet(snippet)
                    .position(latLng));
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        LatLng bdx = new LatLng(44.840950, -0.574813);
        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(bdx, 12));

        setMarkers(map, poiCollectionTest());
    }

}
