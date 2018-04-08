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
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by user on 1/3/2018.
 */

public class Academic extends MainActivity {

    DataBaseHelper mydb;
    ListView lv;
    SQLiteDatabase db;
    Cursor cursor;
    AcademicAdapter academicAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.academic_activity);

        DataBaseHelper mydb;
        ListView lv;
        SQLiteDatabase db;
        Cursor cursor;
        AcademicAdapter academicAdapter;
        mydb=new DataBaseHelper(this);
        db=mydb.getReadableDatabase();
        cursor=mydb.getalldata();

        lv=(ListView)findViewById(R.id.academiclist);

        academicAdapter=new AcademicAdapter(getApplicationContext(),R.layout.row_view);
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



        Button btn=(Button)findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AcademicAdd.class));
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent iacad=new Intent(getApplicationContext(),AcademicEdit.class);
                iacad.putExtra("position",position);
                startActivity(iacad);
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
