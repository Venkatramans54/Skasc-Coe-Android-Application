package com.example.user.skasc_coe;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by user on 1/18/2018.
 */

public class EvenSemEDIT extends MainActivity {
    int pos=0,pos2;
    String position,currentid,currentdate,currenteven;
    EditText dateupeven,scheduleupeven;
    Button updateeven,deleteeven;
    Cursor cursor;

    ArrayList<String> arrayid,arraydate,arrayeven;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.even_sem_edit_activity);


        dateupeven=(EditText)findViewById(R.id.datetxtEven);
        scheduleupeven=(EditText)findViewById(R.id.scheduletxtEven);
        updateeven=(Button)findViewById(R.id.btnEvenSave);
        deleteeven=(Button)findViewById(R.id.btndeleteeven);

        Intent mIntent = getIntent();
        pos = mIntent.getIntExtra("position", 0);
        pos2=pos+1;
        position=String.valueOf(pos2);
        getid();
        dateupeven.setText(currentdate);
        scheduleupeven.setText(currenteven);
        updateEven();

        deletell();
    }
    public void updateEven(){
        updateeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt1 = dateupeven.getText().toString();
                String txt2 = scheduleupeven.getText().toString();
                if (txt1.equals("") || txt2.equals("")) {
                    Toast.makeText(getApplicationContext(), "Enter Complete data", Toast.LENGTH_LONG).show();
                } else {
                    boolean isupdate = mydb.updateEvensem(currentid, txt1, txt2);
                    if (isupdate == true) {
                        Toast.makeText(getApplicationContext(), "successfully updated", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "error...!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),Even_sem_plan.class));
    }
    public void deletell(){
        deleteeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer deleterows=mydb.deleteEven(currentid);
                if(deleterows > 0){
                    Toast.makeText(getApplicationContext(),"successfully deleted",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"error...!",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    public  void getid() {

        arrayid=mydb.getallAEvenId();
        currentid=arrayid.get(pos);
        arraydate=mydb.getallEvendate();
        arrayeven=mydb.getallEvenSchedule();
        currentdate=arraydate.get(pos);
        currenteven=arrayeven.get(pos);
    }
}
