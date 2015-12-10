package com.example.enseirb.timtim.mapeirb.presenter;

import android.content.Context;

import com.example.enseirb.timtim.mapeirb.exceptions.BadPOICollectionException;
import com.example.enseirb.timtim.mapeirb.model.IPOI;
import com.example.enseirb.timtim.mapeirb.model.POICollection;
import com.example.enseirb.timtim.mapeirb.presenter.popupFactories.MsgPopupDisplayerCancel;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterManager;

public class MapManager {

    private static final String EMPTY_POILIST = "Empty POI list";
    private static final String TRY_AGAIN_TEXT = "No Points Of Interest was found right now in this category, try later.";
    private static final String UNINITIALIZED_POI_COLLECTION = "The POICollection is not initialized";
    private static final String EMPTY_POI_COLLECTION = "The POICollection is empty";
    private final Context context;
    private GoogleMap map;

    public MapManager(Context context) {
        this.context = context;
    }

    private void setMarkers(ClusterManager<ClusterablePOI> clusterManager, POICollection poiCollection) throws BadPOICollectionException {
        if (poiCollection == null) {
            throw new BadPOICollectionException(UNINITIALIZED_POI_COLLECTION);
        }
        else if (poiCollection.getPoiCollection().size() <= 0) {
            throw new BadPOICollectionException(EMPTY_POI_COLLECTION);
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
        LatLng latLong = new LatLng(mapConfig.getLatitude(), mapConfig.getLongitude());
        map.setMyLocationEnabled(true);
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
            new MsgPopupDisplayerCancel().show(EMPTY_POILIST, TRY_AGAIN_TEXT, context);
            e.printStackTrace();
        }
        clusterManager.setOnClusterItemClickListener(new ClusterManager.OnClusterItemClickListener<ClusterablePOI>() {
            @Override
            public boolean onClusterItemClick(ClusterablePOI item) {
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
