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

public class Odd_sem_plan extends MainActivity {
    DataBaseHelper mydb;
    ListView lveven;
    SQLiteDatabase db;
    Cursor cursor;
    EvenSemAdapter evensemadapter;
    Button btnoddnew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.odd_sem_plan);

        DataBaseHelper mydb;
        ListView lvodd;
        SQLiteDatabase db;
        Cursor cursor;
        OddsemAdapter oddsemadapter;
        mydb=new DataBaseHelper(this);
        db=mydb.getReadableDatabase();
        cursor=mydb.getallOdddata();


        lvodd=(ListView)findViewById(R.id.listoddsem);

        oddsemadapter=new OddsemAdapter(getApplicationContext(),R.layout.rowviewodd);

        if(cursor.moveToFirst()){
            do {
                String date,schedule;
                schedule=cursor.getString(1);
                date=cursor.getString(2);
                OddsemProvider oddsemprovider=new OddsemProvider(schedule,date);
                oddsemadapter.add(oddsemprovider);

            }while (cursor.moveToNext());
        }
        lvodd.setAdapter(oddsemadapter);

        btnoddnew=(Button)findViewById(R.id.newbtnodd);
        btnoddnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),OddsemADD.class));
            }
        });
        lvodd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent iodd=new Intent(getApplicationContext(),OddsemEdit.class);
                iodd.putExtra("position",position);
                startActivity(iodd);
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
