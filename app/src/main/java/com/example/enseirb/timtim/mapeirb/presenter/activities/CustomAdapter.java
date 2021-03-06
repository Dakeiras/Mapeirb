package com.example.enseirb.timtim.mapeirb.presenter.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.enseirb.timtim.mapeirb.R;
import com.example.enseirb.timtim.mapeirb.model.IPOI;
import com.example.enseirb.timtim.mapeirb.model.POI;

import java.util.ArrayList;
import java.util.List;


public class CustomAdapter extends ArrayAdapter<POI> {

    private List<POI> poiList;
    private Context ctx;
    private View falseView;

    public CustomAdapter(Context context, int textViewResourceId, List<POI> serviceList) {
        super(context, textViewResourceId, serviceList);
        this.poiList = new ArrayList<>();
        this.poiList.addAll(serviceList);
        this.ctx = context;
    }

    public void setFalseView(View falseView) {
        this.falseView = falseView;
    }

    private class ViewHolder {
        TextView poiTitle;
        CheckBox checkBox;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.list_check_box, null);

            holder = new ViewHolder();
            holder.poiTitle = (TextView) convertView.findViewById(R.id.poiTitle);
            holder.checkBox = (CheckBox) convertView.findViewById(R.id.checkBox1);
            convertView.setTag(holder);

            holder.checkBox.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    CheckBox cb = (CheckBox) v;
                    IPOI poi = (IPOI) cb.getTag();
                    poi.setSelected(cb.isChecked());
                    if(falseView != null)
                        falseView.performClick();
                }
            });
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        IPOI poi = poiList.get(position);
        holder.poiTitle.setText(poi.getTitle());
        holder.checkBox.setChecked(poi.isSelected());
        holder.checkBox.setTag(poi);

        return convertView;

    }


}
