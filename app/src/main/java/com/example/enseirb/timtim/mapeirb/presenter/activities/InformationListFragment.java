package com.example.enseirb.timtim.mapeirb.presenter.activities;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.enseirb.timtim.mapeirb.R;
import com.example.enseirb.timtim.mapeirb.business.IPOICollectionBusiness;
import com.example.enseirb.timtim.mapeirb.business.POICollectionBusiness;
import com.example.enseirb.timtim.mapeirb.business.listener.IPOICollectionBusinessListener;
import com.example.enseirb.timtim.mapeirb.model.IPOI;
import com.example.enseirb.timtim.mapeirb.model.POICollection;
import com.example.enseirb.timtim.mapeirb.model.POIType;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class InformationListFragment extends Fragment {

    private IPOICollectionBusiness poiCollectionBusiness;
    private ListView listView;
    protected static final String DEFIBRILATOR_NAME = "com.example.enseirb.timtim.mapeirb.presenter.DEFIBRILATOR";
    protected static final String ELECTRIC_CAR_NAME = "com.example.enseirb.timtim.mapeirb.presenter.ELECTRICCAR";
    protected static final String TOILET_NAME = "com.example.enseirb.timtim.mapeirb.presenter.TOILET";
    protected static final String INTERNET_NAME = "com.example.enseirb.timtim.mapeirb.presenter.INTERNET";

    private POICollection mPOICollection;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.information_list_display, container, false);
    }

    public void createList(String service,AdapterView.OnItemClickListener listener) {
        initializeBusiness();
        TextView title = (TextView) getView().findViewById(R.id.information_list_service_name);
        title.setText(service);
        listView = (ListView) getView().findViewById(R.id.information_layout_list);
        retrieveServiceList(service);
        listView.setOnItemClickListener(listener);
    }

    private void retrieveServiceList(String service) {
        IPOICollectionBusinessListener listener = new IPOICollectionBusinessListener() {
            @Override
            public void onSuccess(final POICollection poiCollection) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mPOICollection = poiCollection;
                        fillList(poiCollection);
                    }
                });

            }

            @Override
            public void onError(String message) {

            }
        };

        switch (service) {

            case DEFIBRILATOR_NAME:
                poiCollectionBusiness.retrievePOICollection(POIType.DEFIBRILLATOR,listener);
                break;
            case INTERNET_NAME:
                poiCollectionBusiness.retrievePOICollection(POIType.INTERNET,listener);
                break;
            case ELECTRIC_CAR_NAME:
                poiCollectionBusiness.retrievePOICollection(POIType.ELECTRIC,listener);
                break;
            case TOILET_NAME:
                poiCollectionBusiness.retrievePOICollection(POIType.TOILET,listener);
                break;
            default:
                break;
        }



    }

    private void fillList(POICollection poiCollection) {
        List<String> serviceList = new ArrayList<>();
        for(IPOI poi: poiCollection.getPoiCollection()) {
            System.out.println(poi.getTitle());
            serviceList.add(poi.getTitle());
        }
        listView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, serviceList));
    }

    private void initializeBusiness() {
        poiCollectionBusiness = new POICollectionBusiness();
    }

    public POICollection getPOICollection() {
        return mPOICollection;
    }
}