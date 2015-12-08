package com.example.enseirb.timtim.mapeirb.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectivityChecker {

    public static boolean isDeviceConnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null)
            return false;
        if (!networkInfo.isConnected())
            return false;
        if (!networkInfo.isAvailable())
            return false;
        return true;
    }
}
