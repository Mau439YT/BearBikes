package com.example.bearbikes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Status extends AppCompatActivity {

    TextView Nom_Mec, Desc, Nom_Rep, Status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status);
        getSupportActionBar().hide();

        Nom_Mec = (TextView) findViewById(R.id.mecanico);
        Nom_Mec.setText("Manuel Alberto");
        Desc = (TextView) findViewById(R.id.descripcion);
        Desc.setText("HOLAAAA");
        Nom_Rep = (TextView) findViewById(R.id.nom_reparacion);
        Nom_Rep.setText("Reparacion de ruedas");
        Status = (TextView) findViewById(R.id.status);
        Status.setText("Ensamblado");

        final ProgressBar progreso = (ProgressBar) findViewById(R.id.progressBar2);
        progreso.setVisibility(View.VISIBLE);
        progreso.setProgress(50);
    }

    public void regresar(View v){
        Intent regresarLogin = new Intent(this, Seleccion.class);
        startActivity(regresarLogin);
        finish();
    }
}
