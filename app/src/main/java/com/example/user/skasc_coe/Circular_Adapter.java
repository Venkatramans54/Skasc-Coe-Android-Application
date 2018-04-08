package com.example.user.skasc_coe;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 1/19/2018.
 */

public class Circular_Adapter extends ArrayAdapter {
    List circularlist=new ArrayList();
    public Circular_Adapter(Context context, int resource) {
        super(context, resource);
    }
    static class LayoutHandler{
        TextView date,schedule,due;
    }

    @Override
    public void add(Object object)
    {
        super.add(object);
        circularlist.add(object);
    }

    @Override
    public int getCount() {
        return circularlist.size();

    }
    @Nullable
    @Override
    public Object getItem(int position) {
        return circularlist.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View row=convertView;
            LayoutHandler layouthandler;
        if(row ==null){
            LayoutInflater inflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.rowview_circular,parent,false);
            layouthandler=new LayoutHandler();
              layouthandler.date=(TextView) row.findViewById(R.id.txtcircularschedulename);

            layouthandler.schedule=(TextView) row.findViewById(R.id.txtcirculardatename);
            row.setTag(layouthandler);

        }
        else{
            layouthandler=(LayoutHandler)row.getTag();
        }
        Circular_provider circularprovider=(Circular_provider) this.getItem(position);

        layouthandler.schedule.setText(circularprovider.getSchedule());
        layouthandler.date.setText(circularprovider.getDate());

        return row;
    }
}
