package com.example.enseirb.timtim.mapeirb.presenter;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.enseirb.timtim.mapeirb.R;
import com.example.enseirb.timtim.mapeirb.business.IPOICollectionBusiness;
import com.example.enseirb.timtim.mapeirb.business.POICollectionBusiness;
import com.example.enseirb.timtim.mapeirb.business.listener.IPOICollectionBusinessListener;
import com.example.enseirb.timtim.mapeirb.model.IPOI;
import com.example.enseirb.timtim.mapeirb.model.POICollection;
import com.example.enseirb.timtim.mapeirb.model.POIType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 28/11/2015.
 */
public class InformationListFragment extends Fragment {

    private IPOICollectionBusiness poiCollectionBusiness;
    private ListView listView;
    protected static final String DEFIBRILATOR_NAME = "com.example.enseirb.timtim.mapeirb.presenter.DEFIBRILATOR";
    protected static final String ELECTRIC_CAR_NAME = "com.example.enseirb.timtim.mapeirb.presenter.ELECTRICCAR";
    protected static final String TOILET_NAME = "com.example.enseirb.timtim.mapeirb.presenter.TOILET";
    protected static final String INTERNET_NAME = "com.example.enseirb.timtim.mapeirb.presenter.INTERNET";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.information_list_display, container, false);
        return view;
    }

    public void createList(String service) {
        initializeBusiness();
        listView = (ListView) getView().findViewById(R.id.information_layout_list);

        retrieveServiceList(service);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //centerOnItem();
            }
        });
    }

    private void retrieveServiceList(String service) {
        IPOICollectionBusinessListener listener = new IPOICollectionBusinessListener() {
            @Override
            public void onSuccess(final POICollection poiCollection) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
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
}
