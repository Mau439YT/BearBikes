package com.example.bearbikes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Vender extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vender);
        getSupportActionBar().hide();
    }

    public void lanzarMisProductos (View v){
        //Intent i = new Intent(this, MisProductos.class);
        //startActivity(i);
        //finish();
    }

    public void lanzarVenderProducto (View v){
        //Intent i = new Intent(this, RegistroProducto.class);
        //startActivity(i);
        //finish();
    }
}
