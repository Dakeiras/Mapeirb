package com.example.enseirb.timtim.mapeirb.presenter.popupFactories;

import android.app.ProgressDialog;
import android.content.Context;

public class ProgressPopupFactory {
    Context context;
    ProgressDialog progressDialog;

    public ProgressPopupFactory(Context context) {
        this.context = context;
    }

    public void show(){
        progressDialog = ProgressDialog.show(context, "", "Loading. Please wait...", true);
    }
    public void dismiss(){
        progressDialog.dismiss();
    }
}
