package com.example.user.skasc_coe;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by user on 1/3/2018.
 */

public class Login_activity extends AppCompatActivity {
    Button btnlogin,btnsignup;
    EditText username,pwd;
    DataBaseHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        btnlogin=(Button)findViewById(R.id.btnlogin);
        btnsignup=(Button)findViewById(R.id.btnsignup);
        username=(EditText)findViewById(R.id.usernamelogintxt);
        pwd=(EditText)findViewById(R.id.passwordlogintxt);
        mydb=new DataBaseHelper(this);
        username.setText("");
        pwd.setText("");

        login();

        signin();

    }
    @Override
    public void onBackPressed() {
        exit();
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
    public void login()
    {
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=username.getText().toString();
                String pass=pwd.getText().toString();
                if(user.equals("") || pass.equals("")) {
                    Toast.makeText(getApplicationContext(), "Enter username and password", Toast.LENGTH_LONG).show();
                }
                else
                {
                    String password = mydb.Searchpass(user);
                    if (pass.equals(password)) {
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_LONG).show();
                        username.setText("");
                        pwd.setText("");
                    }
                }
            }
        });
    }

    public  void signin()
    {
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(getApplicationContext(),Signup.class);
                startActivity(i);
            }
        });
    }
}
