package com.example.user.skasc_coe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by user on 1/18/2018.
 */

public class OddsemADD extends MainActivity {
    EditText date_odd,schedule_odd;
    Button btnAddodd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.odd_sem_add_activity);

        date_odd=(EditText)findViewById(R.id.txtdateOdd);
        schedule_odd=(EditText)findViewById(R.id.txtscheduleOdd);
        btnAddodd=(Button)findViewById(R.id.btnOddAdd);

        AddOddsem();
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),Odd_sem_plan.class));
    }
    public void AddOddsem(){
        btnAddodd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt1=schedule_odd.getText().toString();
                String txt2=date_odd.getText().toString();
                if(txt1.equals("") || txt2.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter Complete data",Toast.LENGTH_LONG).show();
                }
                else {
                    boolean isInserted = mydb.insertOddSchedule(txt1, txt2);
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
