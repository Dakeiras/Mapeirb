package com.example.enseirb.timtim.mapeirb.presenter;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.enseirb.timtim.mapeirb.R;
import com.example.enseirb.timtim.mapeirb.model.IPOI;
import com.example.enseirb.timtim.mapeirb.model.POICollection;
import com.example.enseirb.timtim.mapeirb.model.POIDefibrillator;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;

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
        poiCollection.add(new POIDefibrillator(new LatLng(45.440950, -0.574813), "1", "1", "1", "1", true, "Bordeaux", 33000) );
        poiCollection.add(new POIDefibrillator(new LatLng(45.40, -0.572), "2", "2", "2", "2", true, "Bordeaux", 33000));
        poiCollection.add(new POIDefibrillator(new LatLng(45.450, -0.570), "3", "3", "1", "3", true, "Bordeaux", 33000));
        poiCollection.add(new POIDefibrillator(new LatLng(45.790, -0.571), "4", "4", "4", "4", true, "Bordeaux", 33000));
        poiCollection.add(new POIDefibrillator(new LatLng(45.82, -0.5765), "5", "5", "5", "5", true, "Bordeaux", 33000));
        poiCollection.add(new POIDefibrillator(new LatLng(45.83, -0.5765), "5", "5", "5", "5", true, "Bordeaux", 33000));
        poiCollection.add(new POIDefibrillator(new LatLng(45.84, -0.5765), "5", "5", "5", "5", true, "Bordeaux", 33000));
        poiCollection.add(new POIDefibrillator(new LatLng(45.82, -0.577), "6", "6", "6", "6", true, "Bordeaux", 33000));
        poiCollection.add(new POIDefibrillator(new LatLng(45.815, -0.5289), "7", "7", "7", "7", true, "Bordeaux", 33000));
        poiCollection.add(new POIDefibrillator(new LatLng(44.840950, -0.574813), "1", "1", "1", "1", true, "Bordeaux", 33000));
        poiCollection.add(new POIDefibrillator(new LatLng(44.80, -0.572), "2", "2", "2", "2", true, "Bordeaux", 33000));
        poiCollection.add(new POIDefibrillator(new LatLng(44.850, -0.570), "3", "3", "1", "3", true, "Bordeaux", 33000));
        poiCollection.add(new POIDefibrillator(new LatLng(44.790, -0.571), "4", "4", "4", "4", true, "Bordeaux", 33000));
        poiCollection.add(new POIDefibrillator(new LatLng(44.82, -0.5765), "5", "5", "5", "5", true, "Bordeaux", 33000));
        poiCollection.add(new POIDefibrillator(new LatLng(44.82, -0.577), "6", "6", "6", "6", true, "Bordeaux", 33000));
        poiCollection.add(new POIDefibrillator(new LatLng(44.815, -0.5289), "7", "7", "7", "7", true, "Bordeaux", 33000));
        return poiCollection;
    }


    private void setMarkers(GoogleMap map, POICollection poiCollection){
        for (IPOI poi : poiCollection.getPoiCollection()) {
            String title = poi.getTitle();
            String snippet = poi.getTitle();
            LatLng latLng = poi.getPosition();
            map.addMarker(new MarkerOptions()
                    .title(title)
                    .snippet(snippet)
                    .position(latLng));

        }
    }
    private void setMarkers(ClusterManager<ClusterablePOI> clusterManager, POICollection poiCollection){
        for (IPOI poi : poiCollection.getPoiCollection()) {
            String title = poi.getTitle();
            String snippet = poi.getTitle();
            LatLng latLng = poi.getPosition();

            clusterManager.addItem(new ClusterablePOI(poi));

        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        LatLng bdx = new LatLng(44.840950, -0.574813);
        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(bdx, 12));

        ClusterManager<ClusterablePOI> clusterManager = new ClusterManager<ClusterablePOI>(this, map);
        map.setOnCameraChangeListener(clusterManager);
        map.setOnMarkerClickListener(clusterManager);

//        setMarkers(map, poiCollectionTest());
        setMarkers(clusterManager, poiCollectionTest());
    }

}
