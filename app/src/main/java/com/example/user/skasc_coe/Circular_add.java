package com.example.user.skasc_coe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by user on 1/19/2018.
 */

public class Circular_add extends MainActivity {
    EditText date_circular,schedule_circular,duedate_circular;
    Button btnAddcircular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circular_add_activity);
        date_circular=(EditText)findViewById(R.id.circulartxtdate);
        schedule_circular=(EditText)findViewById(R.id.circulartxtschedule);
        btnAddcircular=(Button)findViewById(R.id.btncircularsave);


        AddEvensem();
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),Circular_activity.class));
    }
    public void AddEvensem(){
        btnAddcircular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txt1 = schedule_circular.getText().toString();
                String txt2 = date_circular.getText().toString();

                if (txt1.equals("") || txt2.equals("")) {
                    Toast.makeText(getApplicationContext(), "Enter Complete data", Toast.LENGTH_LONG).show();
                } else {
                    boolean isInserted = mydb.insertCircularSchedule(txt1, txt2);
                    if (isInserted == true) {
                        Toast.makeText(getApplicationContext(), "successfully inserted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "unsuccessfull", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
