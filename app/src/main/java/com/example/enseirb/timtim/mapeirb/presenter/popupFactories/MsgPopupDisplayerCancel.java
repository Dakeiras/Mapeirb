package com.example.enseirb.timtim.mapeirb.presenter.popupFactories;

import android.content.Context;
import android.content.DialogInterface;

public class MsgPopupDisplayerCancel extends MsgPopupDisplayer {

    DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog,int id) {dialog.cancel();}
    };

    public void show(String title, String msg, Context context){
        super.show(title, msg, context, onClickListener);
    }
}
