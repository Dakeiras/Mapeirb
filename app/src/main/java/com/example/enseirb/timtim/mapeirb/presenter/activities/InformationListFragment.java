package com.example.enseirb.timtim.mapeirb.presenter.activities;

import android.app.Fragment;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.enseirb.timtim.mapeirb.R;
import com.example.enseirb.timtim.mapeirb.business.IPOICollectionBusiness;
import com.example.enseirb.timtim.mapeirb.business.POICollectionBusiness;
import com.example.enseirb.timtim.mapeirb.business.listener.IPOICollectionBusinessListener;
import com.example.enseirb.timtim.mapeirb.model.IPOI;
import com.example.enseirb.timtim.mapeirb.model.POI;
import com.example.enseirb.timtim.mapeirb.model.POICollection;
import com.example.enseirb.timtim.mapeirb.model.POIType;
import com.google.android.gms.location.LocationServices;

import org.w3c.dom.Text;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class InformationListFragment extends Fragment {

    private ListView listView;
    private Button nameSortButton;
    private Button distanceSortButton;
    private TextView title;
    protected static final String DEFIBRILATOR_NAME = "com.example.enseirb.timtim.mapeirb.presenter.DEFIBRILATOR";
    protected static final String ELECTRIC_CAR_NAME = "com.example.enseirb.timtim.mapeirb.presenter.ELECTRICCAR";
    protected static final String TOILET_NAME = "com.example.enseirb.timtim.mapeirb.presenter.TOILET";
    protected static final String INTERNET_NAME = "com.example.enseirb.timtim.mapeirb.presenter.INTERNET";

    private POICollection mPOICollection;
    private CustomAdapter dataAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.information_list_display, container, false);
    }

    public void createList(String service, POICollection poiCollection,AdapterView.OnItemClickListener listener) {
        mPOICollection = poiCollection;
        title = (TextView) getView().findViewById(R.id.information_list_service_name);
        nameSortButton = (Button) getView().findViewById(R.id.button_sort_name);
        nameSortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fillListByName(mPOICollection);
            }
        });
        distanceSortButton = (Button) getView().findViewById(R.id.button_sort_distance);
        distanceSortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fillListByDistance(mPOICollection);
            }
        });
        listView = (ListView) getView().findViewById(R.id.information_layout_list);
        retrieveServiceList(service);
        fillListByName(mPOICollection);
        listView.setOnItemClickListener(listener);
    }

    private void retrieveServiceList(String service) {
        switch (service) {
            case InformationListFragment.DEFIBRILATOR_NAME:
                title.setText("Défibrillateur");
                break;
            case InformationListFragment.INTERNET_NAME:
                title.setText("Points WIFI");
                break;
            case InformationListFragment.ELECTRIC_CAR_NAME:
                title.setText("Bornes électriques");
                break;
            case InformationListFragment.TOILET_NAME:
                title.setText("Toilettes");
                break;
            default:
                break;
        }

    }

    protected void fillListByName(POICollection poiCollection) {
        List<POI> poiList = new ArrayList<>();
        for(IPOI poi: poiCollection.getPoiCollection()) {
            poiList.add((POI) poi);
        }
        Collections.sort(poiList);

        dataAdapter = new CustomAdapter(getActivity(), R.layout.list_check_box, poiList);
        listView.setAdapter(dataAdapter);
    }

    protected void fillListByDistance(final POICollection poiCollection) {
        final LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        final String locationProvider = LocationManager.NETWORK_PROVIDER;
        final LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                Location lastKnownLocation = locationManager.getLastKnownLocation(locationProvider);
                if(lastKnownLocation == null) {

                }
                Map<Float,String> serviceList = new TreeMap<>();
                for(IPOI poi: poiCollection.getPoiCollection()) {
                    //System.out.println(poi.getTitle());
                    Location poiLocation = new Location("poi");
                    poiLocation.setLatitude(poi.getPosition().latitude);
                    poiLocation.setLongitude(poi.getPosition().longitude);
                    serviceList.put(lastKnownLocation.distanceTo(poiLocation), poi.getTitle());
                }
                listView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1,
                        new LinkedList<String>(serviceList.values())));
                removeLocationListener(this,locationManager);
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {}

            public void onProviderEnabled(String provider) {}

            public void onProviderDisabled(String provider) {}
        };

        locationManager.requestLocationUpdates(locationProvider, 0, 0, locationListener);

    }

    private void removeLocationListener(LocationListener locationListener, LocationManager locationManager) {
        locationManager.removeUpdates(locationListener);
    }


    public POICollection getPOICollection() {
        return mPOICollection;
    }
}
