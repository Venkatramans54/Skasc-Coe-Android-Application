package com.example.user.skasc_coe;

import android.app.Notification;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    SQLiteDatabase db;
    DataBaseHelper mydb;
    CalendarView calender;
    ListView lv1;
    Cursor cursor1;
    HomeAcademicAdapter academicAdapter;
    String mm;
    String today_date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mydb=new DataBaseHelper(this);
        calender=(CalendarView)findViewById(R.id.calendarView);
        db=mydb.getReadableDatabase();
        lv1=(ListView)findViewById(R.id.mainlist1);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                int m=month+1;
                if(m==0||m==1||m==2||m==3||m==4||m==5||m==6||m==7||m==8||m==9)
                {
                    mm="0"+m;
                }
                else{
                    mm=""+m;
                }
               today_date=""+day+"/"+mm+"/"+year+"";

                Toast.makeText(getApplicationContext(),""+today_date,Toast.LENGTH_SHORT).show();

                cursor1=mydb.getalldatamainn(today_date);
                academicAdapter=new HomeAcademicAdapter(getApplicationContext(),R.layout.row_view);
                if(cursor1.moveToFirst()){
                    do {
                        String date,committee;
                        committee=cursor1.getString(1);
                        date=cursor1.getString(2);
                        AcademicProvider academicprovider=new AcademicProvider(committee,date);
                        academicAdapter.add(academicprovider);

                    }while (cursor1.moveToNext());

                }
                lv1.setAdapter(academicAdapter);
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            exit();

        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.academic) {
            startActivity(new Intent(getApplicationContext(),Academic.class));
        } else if (id == R.id.odd) {
            startActivity(new Intent(getApplicationContext(),Odd_sem_plan.class));
        }
        else if (id == R.id.circular) {
            startActivity(new Intent(getApplicationContext(),Circular_activity.class));
        }else if (id == R.id.even) {
            startActivity(new Intent(getApplicationContext(),Even_sem_plan.class));
        } else if (id == R.id.notifications) {
            startActivity(new Intent(getApplicationContext(),Notification_activity.class));
        } else if (id == R.id.logout) {
            startActivity(new Intent(getApplicationContext(),Login_activity.class));
        } else if (id == R.id.exit) {
            exit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void exit(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Exit Application?");
        alertDialogBuilder
                .setMessage("Click yes to exit!")
                .setCancelable(false)
                .setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                moveTaskToBack(true);
                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(1);
                            }
                        })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


}
