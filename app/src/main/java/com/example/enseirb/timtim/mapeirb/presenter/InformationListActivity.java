package com.example.enseirb.timtim.mapeirb.presenter;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.enseirb.timtim.mapeirb.R;
import com.example.enseirb.timtim.mapeirb.business.IPOICollectionBusiness;
import com.example.enseirb.timtim.mapeirb.business.POICollectionBusiness;
import com.example.enseirb.timtim.mapeirb.business.listener.IPOICollectionBusinessListener;
import com.example.enseirb.timtim.mapeirb.model.POI;
import com.example.enseirb.timtim.mapeirb.model.POICollection;
import com.example.enseirb.timtim.mapeirb.model.POIType;

import java.util.ArrayList;
import java.util.List;

public class InformationListActivity extends FragmentActivity {

    private static final String SERVICE_NAME = "com.example.enseirb.timtim.mapeirb.presenter.SERVICE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_information_list);
        if(getResources().getBoolean(R.bool.portrait_only)){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        InformationListFragment fragment = (InformationListFragment) getFragmentManager().findFragmentById(R.id.list_layout_fragment);
        fragment.createList(getIntent().getStringExtra(SERVICE_NAME));
    }

    private void centerOnItem() {
        
    }



    public static Intent getIntent(Context context, String service) {
        Intent intent = new Intent(context, InformationListActivity.class);
        intent.putExtra(SERVICE_NAME,service);
        return intent;
    }

}
