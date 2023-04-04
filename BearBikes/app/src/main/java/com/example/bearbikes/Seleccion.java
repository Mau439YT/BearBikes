package com.example.bearbikes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Seleccion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seleccion);
        getSupportActionBar().hide();
    }

    public void lanzarTienda(View v){
        Intent intent = new Intent(this, Tienda.class);
        startActivity(intent);
        finish();
    }
    public void lanzarReparacion(View v){
        Intent intent = new Intent(this, Reparacion.class);
        startActivity(intent);
        finish();
    }
    public void lanzarRutas(View v){
        Intent intent = new Intent(this, Rutas.class);
        startActivity(intent);
        finish();
    }
    public void lanzarSitios(View v){
        Intent intent = new Intent(this, SitiosTuristicos.class);
        startActivity(intent);
        finish();
    }

    public void salir(View v){
        Intent intent = new Intent(this, LogIn.class);
        startActivity(intent);
        finish();
    }
}
