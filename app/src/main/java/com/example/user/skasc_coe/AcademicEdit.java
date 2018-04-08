package com.example.user.skasc_coe;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import static com.example.user.skasc_coe.DataBaseHelper.ACADEMIC_ID;
import static com.example.user.skasc_coe.DataBaseHelper.TABLE_ACADEMIC;

/**
 * Created by user on 1/17/2018.
 */

public class AcademicEdit extends MainActivity {
    int pos=0,pos2;
    String position,currentid,currentdate,currentcommittee;
    EditText dateupacad,scheduleupacad;
    Button updateacad,deleteacad;
    Cursor cursor;

    ArrayList<String> arrayid,arraydate,arraycommittee;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.academivedit_activity);


        dateupacad=(EditText)findViewById(R.id.txtdateacad);
        scheduleupacad=(EditText)findViewById(R.id.txtcommitteeacad);
        updateacad=(Button)findViewById(R.id.btnsaveacad);
        deleteacad=(Button)findViewById(R.id.btndeleteacad);

        Intent mIntent = getIntent();
        pos = mIntent.getIntExtra("position", 0);
        pos2=pos+1;
        position=String.valueOf(pos2);


        getid();

        dateupacad.setText(currentdate);
        scheduleupacad.setText(currentcommittee);

        updateAcademic();

        deletell();

    }
    public void updateAcademic(){
        updateacad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt1=dateupacad.getText().toString();
                String txt2=scheduleupacad.getText().toString();

                if(txt1.equals("") || txt2.equals("")){
                    Toast.makeText(getApplicationContext(),"Enter Complete data",Toast.LENGTH_LONG).show();
                }
                else{
                    boolean isupdate=mydb.updateAcademic(currentid,txt1,txt2);
                    if(isupdate == true){
                        Toast.makeText(getApplicationContext(),"successfully updated",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(),Academic.class));
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"error...!",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),Academic.class));
    }
    public void deletell(){
        deleteacad.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Integer deleterows=mydb.deleteAcademic(currentid);
        if(deleterows > 0){
            Toast.makeText(getApplicationContext(),"successfully deleted",Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(),Academic.class));
        }
        else{
            Toast.makeText(getApplicationContext(),"error...!",Toast.LENGTH_LONG).show();
        }
    }
});

    }
    public  void getid() {
        int count = mydb.getallAcademinIdCount();
        arrayid=mydb.getallAcademicId();
        currentid=arrayid.get(pos);
        arraydate=mydb.getallAcademicdate();
        arraycommittee=mydb.getallAcademiccommittee();
        currentdate=arraydate.get(pos);
        currentcommittee=arraycommittee.get(pos);


    }

}
