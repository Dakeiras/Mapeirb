package com.example.enseirb.timtim.mapeirb.presenter;

import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.enseirb.timtim.mapeirb.R;

public class SelectionScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_screen);
        if(getResources().getBoolean(R.bool.portrait_only)){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
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

    }

}
