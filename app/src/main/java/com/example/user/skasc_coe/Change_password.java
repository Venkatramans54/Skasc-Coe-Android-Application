package com.example.user.skasc_coe;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by user on 1/3/2018.
 */

public class Change_password extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password);
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
}
