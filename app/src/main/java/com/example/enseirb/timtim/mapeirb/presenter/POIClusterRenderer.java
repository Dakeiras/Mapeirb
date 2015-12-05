package com.example.enseirb.timtim.mapeirb.presenter;

import android.content.Context;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;

public class POIClusterRenderer extends DefaultClusterRenderer<ClusterablePOI> {
    public POIClusterRenderer(Context context, GoogleMap map,
                             ClusterManager<ClusterablePOI> clusterManager) {
        super(context, map, clusterManager);
    }
    @Override
    protected void onBeforeClusterItemRendered(ClusterablePOI item, MarkerOptions markerOptions) {
        super.onBeforeClusterItemRendered(item, markerOptions);
        markerOptions.title(item.getTitle());
        markerOptions.snippet(item.getDescription());
    }
}
