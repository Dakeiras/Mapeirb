package com.example.enseirb.timtim.mapeirb.presenter;

import android.content.Context;

import com.example.enseirb.timtim.mapeirb.exceptions.BadPOICollectionException;
import com.example.enseirb.timtim.mapeirb.model.IPOI;
import com.example.enseirb.timtim.mapeirb.model.POICollection;
import com.example.enseirb.timtim.mapeirb.presenter.popupFactories.MsgPopupFactoryCancel;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterManager;

public class MapManager {

    private final Context context;
    private GoogleMap map;

    public MapManager(Context context) {
        this.context = context;
    }

    private void setMarkers(ClusterManager<ClusterablePOI> clusterManager, POICollection poiCollection) throws BadPOICollectionException {
        if (poiCollection == null) {
            throw new BadPOICollectionException("The POICollection is not initialized");
        }
        else if (poiCollection.getPoiCollection().size() <= 0) {
            throw new BadPOICollectionException("The POICollection is empty");
        }
        else {
            for (IPOI poi : poiCollection.getPoiCollection()) {
                if (poi.isSelected()) {
                    clusterManager.addItem(new ClusterablePOI(poi));
                }
            }
        }
    }


    public GoogleMap prepareMap(GoogleMap googleMap, MapConfig mapConfig){
        map = googleMap;
        //LatLng latLong = new LatLng(44.840950, -0.574813);
        LatLng latLong = new LatLng(mapConfig.getLatitude(), mapConfig.getLongitude());
        map.setMyLocationEnabled(true);
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLong, 12));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLong, mapConfig.getZoom()));
        return map;
    }

    public void moveCamera(CameraUpdate cameraUpdate){
        map.moveCamera(cameraUpdate);
    }
    public void setPOIMarkers(POICollection poiCollection){
        ClusterManager<ClusterablePOI> clusterManager = new ClusterManager<>(context, map);
        map.setOnCameraChangeListener(clusterManager);
        map.setOnMarkerClickListener(clusterManager);

        try {

            setMarkers(clusterManager, poiCollection);
        } catch (BadPOICollectionException e) {
            new MsgPopupFactoryCancel().show("Empty POI list", "No Points Of Interest was found " +
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
    }

    public void clear(){
        map.clear();
    }

    public MapConfig getMapConfig() {
        float latitude = (float) map.getCameraPosition().target.latitude;
        float longitude = (float) map.getCameraPosition().target.longitude;
        float zoom = map.getCameraPosition().zoom;
        return new MapConfig(zoom, latitude, longitude);
    }
}
