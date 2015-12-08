package com.example.enseirb.timtim.mapeirb.presenter.popupFactories;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class MsgPopupFactory {
    protected void show(String title, String msg, Context context, DialogInterface.OnClickListener onClickListener){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder
                .setMessage(msg)
                .setCancelable(false)
                .setPositiveButton("Ok", onClickListener);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
