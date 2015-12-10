package com.example.enseirb.timtim.mapeirb.presenter.activities;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.enseirb.timtim.mapeirb.R;
import com.example.enseirb.timtim.mapeirb.presenter.popupFactories.MsgPopupDisplayerCancel;
import com.example.enseirb.timtim.mapeirb.presenter.popupFactories.MsgPopupDisplayerFinishApp;
import com.example.enseirb.timtim.mapeirb.utils.ConnectivityChecker;

public class SelectionScreenActivity extends AppCompatActivity {
    private static final String FONT_NAME = "fontawesome-webfont.ttf";
    private static final String ICO_NAME = "icomoon.ttf";
    final Context activityContext = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_selection_screen);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        if(getResources().getBoolean(R.bool.portrait_only))
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        initializePOIButtons();
        displayPopupIfNotConnectedToInternet();
    }

    private void displayPopupIfNotConnectedToInternet(){
        String errorPopupTitle = getResources().getString(R.string.error_popup_title);
        String errorPopupMsg = getResources().getString(R.string.error_popup_msg_not_connected);
        Context context = this;
        if(!ConnectivityChecker.isDeviceConnected(context))
            new MsgPopupDisplayerFinishApp().show(errorPopupTitle, errorPopupMsg, context);
    }

    private void ShowList(String name) {
        Intent intent = MapPresenterActivity.getIntent(this, name);
        startActivity(intent);
    }

    private void initializePOIButtons(){
        Typeface font = Typeface.createFromAsset(getAssets(), FONT_NAME);
        Typeface fontIcomoon = Typeface.createFromAsset(getAssets(), ICO_NAME);

        Button electricCarButton = (Button) findViewById(R.id.selectionscreen_button_electric_car);
        electricCarButton.setTypeface(font);
        Button defibrilatorButton = (Button) findViewById(R.id.selectionscreen_button_defibrilator);
        defibrilatorButton.setTypeface(font);
        Button internetAccessButton = (Button) findViewById(R.id.selectionscreen_button_internet_access);
        internetAccessButton.setTypeface(font);
        Button toiletsButton = (Button) findViewById(R.id.selectionscreen_button_toilets);
        toiletsButton.setTypeface(fontIcomoon);

        defibrilatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowList(InformationListFragment.DEFIBRILATOR_NAME);
            }
        });

        electricCarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowList(InformationListFragment.ELECTRIC_CAR_NAME);
            }
        });

        internetAccessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowList(InformationListFragment.INTERNET_NAME);
            }
        });

        toiletsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowList(InformationListFragment.TOILET_NAME);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.content_selection_screen_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String helpPopupTitle = getResources().getString(R.string.help_popup_title);
        String helpPopupMsg = getResources().getString(R.string.help_popup_msg);
        switch (item.getItemId()) {
            case R.id.action_help:
                new MsgPopupDisplayerCancel().show(helpPopupTitle, helpPopupMsg, activityContext);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
