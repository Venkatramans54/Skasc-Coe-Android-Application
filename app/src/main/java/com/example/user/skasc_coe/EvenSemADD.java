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

public class EvenSemADD extends MainActivity {
    EditText date_even,schedule_even;
    Button btnAddeven;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.even_sem_add_activity);
        date_even=(EditText)findViewById(R.id.txtdateEven);
        schedule_even=(EditText)findViewById(R.id.txtscheduleEven);
        btnAddeven=(Button)findViewById(R.id.btnEvenAdd);

        AddEvensem();
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),Even_sem_plan.class));
    }
    public void AddEvensem(){
        btnAddeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt1=schedule_even.getText().toString();
                String txt2=date_even.getText().toString();
                if(txt1.equals("") || txt2.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter Complete data",Toast.LENGTH_LONG).show();
                }
                else {
                    boolean isInserted = mydb.insertEvenSchedule(txt1, txt2);
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
