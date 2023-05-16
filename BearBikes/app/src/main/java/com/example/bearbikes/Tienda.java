package com.example.bearbikes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Tienda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tienda);
        getSupportActionBar().hide();
    }

    public void lanzarCompra (View v){
        Intent i = new Intent(this, Comprar.class);
        startActivity(i);
    }

    public void lanzarVender (View v){
        Intent i = new Intent(this, Vender.class);
        startActivity(i);
    }
    public void volver (View v){
        Intent i = new Intent(this, Seleccion.class);
        startActivity(i);
    }
}
