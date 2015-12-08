package com.example.enseirb.timtim.mapeirb.presenter.activities;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.enseirb.timtim.mapeirb.R;
import com.example.enseirb.timtim.mapeirb.presenter.popupFactories.MsgPopupFactoryCancel;
import com.example.enseirb.timtim.mapeirb.presenter.popupFactories.MsgPopupFactoryFinishApp;
import com.example.enseirb.timtim.mapeirb.utils.ConnectivityChecker;

public class SelectionScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_selection_screen);

        if(getResources().getBoolean(R.bool.portrait_only))
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        initializePOIButtons();
        displayPopupIfNotConnectedToInternet();
        initHelpButton();
    }

    private void displayPopupIfNotConnectedToInternet(){
        Context context = this;
        if(!ConnectivityChecker.isDeviceConnected(context))
            new MsgPopupFactoryFinishApp().show("Device not connected", "Please connect to the internet and try again.", context);
    }

    private void ShowList(String name) {
        Intent intent = MapPresenterActivity.getIntent(this, name);
        startActivity(intent);
    }

    private void initializePOIButtons(){
        Typeface font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
        Typeface fontIcomoon = Typeface.createFromAsset(getAssets(), "icomoon.ttf");

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

    private void initHelpButton(){
        Button helpButton = (Button) findViewById(R.id.content_selection_screen_help_button);

        final Context activityContext = this;
        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String helpContent = "This app allows you to locate useful points of interest in " +
                        "Bordeaux.\n" +
                        "Tap on one of these four button to display respectively :\n" +
                        "- The electric car charging stations\n" +
                        "- The public defibrilators\n" +
                        "- The free WiFi hotspots\n" +
                        "- The public restrooms";
                new MsgPopupFactoryCancel().show("Help", helpContent, activityContext);
            }
        });

    }
}
