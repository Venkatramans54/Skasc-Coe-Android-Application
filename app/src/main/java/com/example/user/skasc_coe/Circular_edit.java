package com.example.user.skasc_coe;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by user on 1/19/2018.
 */

public class Circular_edit extends MainActivity {
    int pos=0,pos2;
    String position,currentid,currentdate,currentcircular,currentdue;

    Cursor cursor;

    ArrayList<String> arrayid,arraydate,arraycircular,arraydue;
    EditText dateupcirc,scheduleupcirc,duedate;
    Button updatecirc,deletecirc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circular_edit_activity);


        dateupcirc=(EditText)findViewById(R.id.datetxtcircular);
        scheduleupcirc=(EditText)findViewById(R.id.scheduletxtcircular);
        updatecirc=(Button)findViewById(R.id.btnsavecircular);
        deletecirc=(Button)findViewById(R.id.btndeletecircular);

        Intent mIntent = getIntent();
        pos = mIntent.getIntExtra("position", 0);
        pos2=pos+1;
        position=String.valueOf(pos2);
        getid();
        dateupcirc.setText(currentdate);
        scheduleupcirc.setText(currentcircular);
        updateCircular();

        deletell();
    }
    public void updateCircular(){
        updatecirc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txt1 = dateupcirc.getText().toString();
                String txt2 = scheduleupcirc.getText().toString();

                if(txt1.equals("") || txt2.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter Complete data",Toast.LENGTH_LONG).show();
                }
                else
                {
                boolean isupdate = mydb.updateCircular(currentid, txt1, txt2);
                if (isupdate == true) {
                    Toast.makeText(getApplicationContext(), "successfully updated", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(),Circular_activity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "error...!", Toast.LENGTH_LONG).show();
                }
            }
        }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),Circular_activity.class));
    }
    public void deletell(){
        deletecirc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer deleterows=mydb.deleteCircular(currentid);
                if(deleterows > 0){

                    Toast.makeText(getApplicationContext(),"successfully deleted",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(),Circular_activity.class));
                }
                else{
                    Toast.makeText(getApplicationContext(),"error...!",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    public  void getid() {

        arrayid=mydb.getallCircularId();
        currentid=arrayid.get(pos);
        arraydate=mydb.getallCirulardate();
        arraycircular=mydb.getallCircularschedule();
        currentdate=arraydate.get(pos);
        currentcircular=arraycircular.get(pos);

    }
}
