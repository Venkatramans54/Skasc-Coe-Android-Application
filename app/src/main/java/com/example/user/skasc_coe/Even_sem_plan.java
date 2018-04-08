package com.example.user.skasc_coe;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by user on 1/3/2018.
 */

public class Even_sem_plan extends MainActivity {
    public View v;
    DataBaseHelper mydb;
    ListView lveven;
    SQLiteDatabase db;
    Cursor cursor;
    EvenSemAdapter evensemadapter;
    Button btnnewevenadd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.even_sem_plan);

        DataBaseHelper mydb;
        ListView lveven;
        SQLiteDatabase db;
        Cursor cursor;
        EvenSemAdapter evensemadapter;
        mydb=new DataBaseHelper(this);
        db=mydb.getReadableDatabase();
        cursor=mydb.getallEvendata();


        lveven=(ListView)findViewById(R.id.evenlistschedule);

        evensemadapter=new EvenSemAdapter(getApplicationContext(),R.layout.rowvieweven);
        if(cursor.moveToFirst()){
            do {
                String date,schedule;
                schedule=cursor.getString(1);
                date=cursor.getString(2);
                EvenSemProvider evensemprovider=new EvenSemProvider(schedule,date);
                evensemadapter.add(evensemprovider);

            }while (cursor.moveToNext());
        }
        lveven.setAdapter(evensemadapter);

        btnnewevenadd=(Button)findViewById(R.id.newbtneven);
        btnnewevenadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),EvenSemADD.class));
            }
        });
        lveven.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent ieven=new Intent(getApplicationContext(),EvenSemEDIT.class);
                ieven.putExtra("position",position);
                startActivity(ieven);
            }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu);
    }


}
