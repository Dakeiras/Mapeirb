package com.example.enseirb.timtim.mapeirb.presenter;

import android.content.Context;

import com.example.enseirb.timtim.mapeirb.exceptions.BadPOICollectionException;
import com.example.enseirb.timtim.mapeirb.model.IPOI;
import com.example.enseirb.timtim.mapeirb.model.POICollection;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterManager;

public class MapInitializer {

    private void setMarkers(ClusterManager<ClusterablePOI> clusterManager, POICollection poiCollection) throws BadPOICollectionException {
        if (poiCollection == null)
            throw new BadPOICollectionException("The POICollection is not initialized");
        else if (poiCollection.getPoiCollection().size() <= 0)
            throw new BadPOICollectionException("The POICollection is empty");
        else
            for (IPOI poi : poiCollection.getPoiCollection())
                clusterManager.addItem(new ClusterablePOI(poi));
    }


    public GoogleMap prepareMap(GoogleMap googleMap, POICollection poiCollection, Context context){
        GoogleMap map = googleMap;
        LatLng bdx = new LatLng(44.840950, -0.574813);
        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(bdx, 12));

        ClusterManager<ClusterablePOI> clusterManager = new ClusterManager<>(context, map);
        map.setOnCameraChangeListener(clusterManager);
        map.setOnMarkerClickListener(clusterManager);

        try {
            setMarkers(clusterManager, poiCollection);
        } catch (BadPOICollectionException e) {
            PopupFactory.create("Empty POI list", "No Points Of Interest was found " +
                    "right now in this category, try later :)", context);
            e.printStackTrace();
        }
        clusterManager.setOnClusterItemClickListener(new ClusterManager.OnClusterItemClickListener<ClusterablePOI>() {
            @Override
            public boolean onClusterItemClick(ClusterablePOI item) {
                System.out.println(item.getTitle());
                return false;
            }
        });
        clusterManager.setRenderer(new POIClusterRenderer(context, map, clusterManager));
        return googleMap;
    }
}
