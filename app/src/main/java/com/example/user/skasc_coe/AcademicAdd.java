package com.example.user.skasc_coe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by user on 1/16/2018.
 */

public class AcademicAdd extends MainActivity {
Button btnadd;
    EditText dateacad,committeeacad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.academicadd_activity);
        btnadd=(Button)findViewById(R.id.button2);
        dateacad=(EditText)findViewById(R.id.datetxt);
        committeeacad=(EditText)findViewById(R.id.committeetxt);


        AddAcademic();

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),Academic.class));
    }
    public void AddAcademic(){
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt1=committeeacad.getText().toString();
                String txt2=dateacad.getText().toString();
                if(txt1.equals("") || txt2.equals("")){
                    Toast.makeText(getApplicationContext(),"Enter Complete data",Toast.LENGTH_LONG).show();
                }
                else{
                    boolean isInserted = mydb.insertacademic(txt1,txt2);
                    if (isInserted==true){
                        Toast.makeText(getApplicationContext(),"successfully inserted",Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"unsuccessfull",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
