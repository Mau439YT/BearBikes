package com.example.bearbikes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Taller2 extends AppCompatActivity {

    TextView Descripcion;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status);
        getSupportActionBar().hide();
        Descripcion=(TextView) findViewById(R.id.texto);
        Descripcion.setText("Dirección: Lago Chalco 74, Anáhuac I Secc., Anáhuac I Secc, Miguel Hidalgo, 11320 Ciudad de México, CDMX\nDueño: Leonardo Juarez\nEmpleados: 2 \nTelefono: 5538752232");
    }
    public void lanzarChat(View view){
        Intent intent = new Intent(this, Chat.class);
        startActivity(intent);
    }
}
