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

public class EvenSemAdapter extends ArrayAdapter {
    List evenlist = new ArrayList();
    public EvenSemAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler{
        TextView date,schedule;
    }

    @Override
    public void add(Object object)
    {
        super.add(object);
        evenlist.add(object);
    }

    @Override
    public int getCount() {
        return evenlist.size();

    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return evenlist.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View row=convertView;
        LayoutHandler layouthandler;
        if(row ==null){
            LayoutInflater inflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.rowvieweven,parent,false);
            layouthandler=new LayoutHandler();
            layouthandler.date=(TextView) row.findViewById(R.id.txtevenschedulename);
            layouthandler.schedule=(TextView) row.findViewById(R.id.txtevendatename);
            row.setTag(layouthandler);

        }
        else{
            layouthandler=(LayoutHandler)row.getTag();
        }
        EvenSemProvider evensemprovider=(EvenSemProvider) this.getItem(position);
        layouthandler.schedule.setText(evensemprovider.getSchedule());
        layouthandler.date.setText(evensemprovider.getDate());
        return row;
    }
}
