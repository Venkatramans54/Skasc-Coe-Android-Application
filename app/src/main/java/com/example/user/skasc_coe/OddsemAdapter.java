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
 * Created by user on 1/18/2018.
 */

public class OddsemAdapter extends ArrayAdapter{
    List oddlist = new ArrayList();
    public OddsemAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler{
        TextView date,schedule;
    }

    @Override
    public void add(Object object)
    {
        super.add(object);
        oddlist.add(object);
    }

    @Override
    public int getCount() {
        return oddlist.size();

    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return oddlist.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View row=convertView;
        LayoutHandler layouthandler;
        if(row ==null){
            LayoutInflater inflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.rowviewodd,parent,false);
            layouthandler=new LayoutHandler();
            layouthandler.date=(TextView) row.findViewById(R.id.txtoddschedulename);
            layouthandler.schedule=(TextView) row.findViewById(R.id.txtodddatename);
            row.setTag(layouthandler);

        }
        else{
            layouthandler=(LayoutHandler)row.getTag();
        }
        OddsemProvider oddsemprovider=(OddsemProvider) this.getItem(position);
        layouthandler.schedule.setText(oddsemprovider.getSchedule());
        layouthandler.date.setText(oddsemprovider.getDate());
        return row;
    }
}
