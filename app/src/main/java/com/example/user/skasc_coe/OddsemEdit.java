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

public class OddsemEdit extends MainActivity {
    int pos=0,pos2;
    String position,currentid,currentdate,currentcommittee;
    EditText dateupodd,scheduleupodd;
    Button updateodd,deleteodd;
    Cursor cursor;

    ArrayList<String> arrayid,arradate,arrayodd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.odd_sem_edit_activity);
        dateupodd=(EditText)findViewById(R.id.datetxtOdd);
        scheduleupodd=(EditText)findViewById(R.id.scheduletxtOdd);
        updateodd=(Button)findViewById(R.id.btnoddsave);
        deleteodd=(Button)findViewById(R.id.btndeleteodd);

        Intent mIntent = getIntent();
        pos = mIntent.getIntExtra("position", 0);
        pos2=pos+1;
        position=String.valueOf(pos2);

        getid();
        dateupodd.setText(currentdate);
        scheduleupodd.setText(currentcommittee);
        updateOddsem();

        deletell();
    }
    public void updateOddsem(){
        updateodd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt1 = dateupodd.getText().toString();
                String txt2 = scheduleupodd.getText().toString();
                if (txt1.equals("") || txt2.equals("")) {
                    Toast.makeText(getApplicationContext(), "Enter Complete data", Toast.LENGTH_LONG).show();
                } else {
                    boolean isupdate = mydb.updateOddsem(currentid, txt1, txt2);
                    if (isupdate == true) {
                        Toast.makeText(getApplicationContext(), "successfully updated", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(),Odd_sem_plan.class));
                    } else {
                        Toast.makeText(getApplicationContext(), "error...!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),Odd_sem_plan.class));
    }
    public void deletell(){
        deleteodd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer deleterows=mydb.deleteOdd(currentid);
                if(deleterows > 0){
                    Toast.makeText(getApplicationContext(),"successfully deleted",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(),Odd_sem_plan.class));
                }
                else{
                    Toast.makeText(getApplicationContext(),"error...!",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    public  void getid() {

        arrayid=mydb.getallODDId();
        currentid=arrayid.get(pos);
        arradate=mydb.getallOdddate();
        arrayodd=mydb.getallOddSchedule();
        currentdate=arradate.get(pos);
        currentcommittee=arrayodd.get(pos);

    }

}
