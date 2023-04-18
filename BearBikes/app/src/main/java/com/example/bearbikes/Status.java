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
        Nom_Mec.setText("Alfredo Mendoza");
        Desc = (TextView) findViewById(R.id.descripcion);
        Desc.setText("11320, Laguna de Términos 447, Anáhuac I Secc., Miguel Hidalgo, Ciudad de México, CDMX \nDueño: Alfredo Mendoza\nEmpleados: 4 \nTelefono: 5538752232");
        Nom_Rep = (TextView) findViewById(R.id.nom_reparacion);
        Nom_Rep.setText("Reparacion de ruedas");
        Status = (TextView) findViewById(R.id.status);
        Status.setText("Reparando");

        final ProgressBar progreso = (ProgressBar) findViewById(R.id.progressBar2);
        progreso.setVisibility(View.VISIBLE);
        progreso.setProgress(30);
    }

    public void regresar(View v){
        Intent regresarLogin = new Intent(this, Reparacion.class);
        startActivity(regresarLogin);
        finish();
    }
    public void lanzarChat(View v){
        Intent regresarLogin = new Intent(this, Chat.class);
        startActivity(regresarLogin);
        finish();
    }
}
