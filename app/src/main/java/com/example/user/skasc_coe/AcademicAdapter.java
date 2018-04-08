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
 * Created by user on 1/17/2018.
 */

public class AcademicAdapter extends ArrayAdapter {
    List acdemiclist=new ArrayList();
    public AcademicAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler{
        TextView date,committee;
    }

    @Override
    public void add(Object object)
    {
        super.add(object);
        acdemiclist.add(object);
    }

    @Override
    public int getCount() {
        return acdemiclist.size();

    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return acdemiclist.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View row=convertView;
        LayoutHandler layouthandler;
        if(row ==null){
            LayoutInflater inflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.row_view,parent,false);
            layouthandler=new LayoutHandler();
            layouthandler.date=(TextView) row.findViewById(R.id.txtdatename);
            layouthandler.committee=(TextView) row.findViewById(R.id.txtcommitteename);
            row.setTag(layouthandler);

        }
        else{
            layouthandler=(LayoutHandler)row.getTag();
        }
        AcademicProvider academicprovider=(AcademicProvider)this.getItem(position);
        layouthandler.committee.setText(academicprovider.getCommittee());
        layouthandler.date.setText(academicprovider.getDate());
        return row;
    }


}
