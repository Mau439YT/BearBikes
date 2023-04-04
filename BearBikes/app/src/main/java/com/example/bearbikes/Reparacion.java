package com.example.bearbikes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Reparacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reparacion);
        getSupportActionBar().hide();
    }

    public void lanzarStatus (View v){
        Intent intent = new Intent(this, Status.class);
        startActivity(intent);
    }

    public void regresar(View v){
        Intent regresarLogin = new Intent(this, Seleccion.class);
        startActivity(regresarLogin);
        finish();
    }
}
