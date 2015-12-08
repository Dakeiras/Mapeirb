package com.example.enseirb.timtim.mapeirb.presenter.activities;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.enseirb.timtim.mapeirb.R;
import com.example.enseirb.timtim.mapeirb.model.IPOI;
import com.example.enseirb.timtim.mapeirb.model.POICollection;

import java.util.List;

/**
 * Created by Home on 08/12/2015.
 */
public class DisplayChoiceFragment extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_choice_fragment);
    }

    public void createList(List<String> POItoDisplayList, String title) {
        ListView listView = (ListView) findViewById(R.id.display_choice_layout_list);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, android.R.id.text1, POItoDisplayList));
        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
    }

}
