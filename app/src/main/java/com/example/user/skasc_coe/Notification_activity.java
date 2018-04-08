package com.example.user.skasc_coe;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;

/**
 * Created by user on 1/3/2018.
 */

public class Notification_activity extends MainActivity {
    DataBaseHelper mydb;
    ListView lv;
    SQLiteDatabase db;
    Cursor cursor;
    HomeAcademicAdapter academicAdapter;
    Calendar c;
    SimpleDateFormat sdf;
    String today_date;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_activity);

        c=Calendar.getInstance();
        sdf=new SimpleDateFormat("dd/MM/yyyy");
        today_date=sdf.format(c.getTime());
        mydb=new DataBaseHelper(this);
        db=mydb.getReadableDatabase();
        cursor=mydb. getalldatamainn(today_date);
        Toast.makeText(getApplicationContext(),""+today_date,Toast.LENGTH_SHORT).show();
        lv=(ListView)findViewById(R.id.notilist);

        academicAdapter=new HomeAcademicAdapter(getApplicationContext(),R.layout.row_view);
        if(cursor.moveToFirst()){
            do {
                String date,committee;
                committee=cursor.getString(1);
                date=cursor.getString(2);
                AcademicProvider academicprovider=new AcademicProvider(committee,date);
                academicAdapter.add(academicprovider);

            }while (cursor.moveToNext());
        }
        lv.setAdapter(academicAdapter);


    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
}
