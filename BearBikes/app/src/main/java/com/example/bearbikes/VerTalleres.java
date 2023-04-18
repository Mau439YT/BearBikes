package com.example.bearbikes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VerTalleres extends AppCompatActivity {

    TextView TT1, TT2, T1, T2;
    Button SeleccionBoton1, SeleccionBoton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.elegirtaller);
        getSupportActionBar().hide();

        TT1 = (TextView) findViewById(R.id.tituloTaller);
        TT1.setText("Taller Mendoza");
        TT2 = (TextView) findViewById(R.id.tituloTaller2);
        TT2.setText("Taller Hermanos Juarez");
        T1 = (TextView) findViewById(R.id.textoTaller);
        T1.setText("Dirección: 11320, Laguna de Términos 447, Anáhuac I Secc., Miguel Hidalgo, Ciudad de México, CDMX \nDueño: Alfredo Mendoza\nEmpleados: 4");
        T2 = (TextView) findViewById(R.id.textoTaller2);
        T2.setText("Dirección: Lago Chalco 74, Anáhuac I Secc., Anáhuac I Secc, Miguel Hidalgo, 11320 Ciudad de México, CDMX\nDueño: Leonardo Juarez\nEmpleados: 2 ");
        SeleccionBoton1=(Button) findViewById(R.id.btnST1);
        SeleccionBoton2=(Button) findViewById(R.id.btnST2);
    }



    public void lanzarTaller1Seleccionado(View view){
        Intent intent = new Intent(this, Taller1.class);
        startActivity(intent);
    }
    public void lanzarTaller2Seleccionado(View view){
        Intent intent = new Intent(this, Taller2.class);
        startActivity(intent);
    }

}
