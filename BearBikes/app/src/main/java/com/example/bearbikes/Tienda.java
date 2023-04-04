package com.example.bearbikes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Tienda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tienda);
        getSupportActionBar().hide();
    }
}
