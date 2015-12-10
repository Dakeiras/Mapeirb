package com.example.enseirb.timtim.mapeirb.presenter.popupFactories;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.example.enseirb.timtim.mapeirb.R;

public class ProgressPopupFactory {
    Context context;
    ProgressDialog progressDialog;

    public ProgressPopupFactory(Context context) {
        this.context = context;
    }

    public void show(){
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(context.getString(R.string.loading_popup_msg));
        progressDialog.setCancelable(true);
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, context.getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        progressDialog.show();
    }
    public void dismiss(){
        progressDialog.dismiss();
    }
}
