package com.example.user.skasc_coe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Venkat on 02-03-2018.
 */

public class Signup extends MainActivity {
    Button btnsignin;
    EditText username,pwd,confirmpwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        btnsignin=(Button)findViewById(R.id.btnsignin);
        username=(EditText)findViewById(R.id.txtusername);
        pwd=(EditText)findViewById(R.id.txtpwd);
        confirmpwd=(EditText)findViewById(R.id.txtpwdconfirm);

        signin();

    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),Login_activity.class));
    }
    public void signin(){
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt1=username.getText().toString();
                String txt2=pwd.getText().toString();
                String txt3=confirmpwd.getText().toString();
                if(txt1.equals("") || txt2.equals("") || txt3.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter Complete data",Toast.LENGTH_LONG).show();
                }
                else{
                    if(txt2.equals(txt3)){
                        boolean isInserted = mydb.signup(txt1,txt2);
                        if (isInserted==true){
                            Toast.makeText(getApplicationContext(),"successfully SIGNED-IN",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"ERROR...!",Toast.LENGTH_LONG).show();
                        }

                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Please Re-Confirm Password",Toast.LENGTH_LONG).show();
                        confirmpwd.setFocusable(true);
                    }
                }

            }
        });
    }
}
