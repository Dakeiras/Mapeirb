package com.example.enseirb.timtim.mapeirb.presenter;


import android.content.SharedPreferences;

public class MapConfig {

    private static final String LATITUDE_SHARED = "Latitude";
    private static final float DEFAULT_LATITUDE = (float) 44.840950;
    private static final String LONGITUDE_SHARED = "Longitude";
    private static final float DEFAULT_LONGITUDE = (float) -0.574813;
    private static final String ZOOM_SHARED = "Zoom";
    private static final int DEFAULT_ZOOM = 12;
    private float zoom;
    private float latitude;
    private float longitude;

    public MapConfig(float zoom, float latitude, float longitude) {
        this.zoom = zoom;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public MapConfig(SharedPreferences preferences) {
        this.latitude = preferences.getFloat(LATITUDE_SHARED, DEFAULT_LATITUDE);
        this.longitude = preferences.getFloat(LONGITUDE_SHARED, DEFAULT_LONGITUDE);
        this.zoom = preferences.getFloat(ZOOM_SHARED, DEFAULT_ZOOM);
    }

    public float getZoom() {
        return zoom;
    }

    public void setZoom(float zoom) {
        this.zoom = zoom;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void updateMapPreferences(SharedPreferences preferences) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putFloat(LATITUDE_SHARED, getLatitude());
        editor.putFloat(LONGITUDE_SHARED, getLongitude());
        editor.putFloat(ZOOM_SHARED, getZoom());
        editor.commit();
    }
}
