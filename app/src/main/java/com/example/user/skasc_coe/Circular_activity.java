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
 * Created by user on 1/19/2018.
 */

public class Circular_activity extends MainActivity {
    DataBaseHelper mydb;
    ListView lv;
    SQLiteDatabase db;
    Cursor cursor;
   Circular_Adapter circularadapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circular_activity);

        DataBaseHelper mydb;
        ListView lvcircular;
        SQLiteDatabase db;
        Cursor cursor;
        Circular_Adapter circularadapter;
        mydb=new DataBaseHelper(this);
        db=mydb.getReadableDatabase();
        cursor=mydb.getallCirculardata();

        lvcircular=(ListView)findViewById(R.id.listcircular);

        circularadapter=new Circular_Adapter(getApplicationContext(),R.layout.rowview_circular);

        if(cursor.moveToFirst()){
            do {
                String date,schedule,due;

                schedule=cursor.getString(1);
                date=cursor.getString(2);

                Circular_provider circularprovider=new Circular_provider(schedule,date);
                circularadapter.add(circularprovider);

            }while (cursor.moveToNext());
        }
        lvcircular.setAdapter(circularadapter);

        Button btn=(Button)findViewById(R.id.btncircularnew);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Circular_add.class));
            }
        });
lvcircular.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent icircular=new Intent(getApplicationContext(),Circular_edit.class);
        icircular.putExtra("position",position);
        startActivity(icircular);
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
