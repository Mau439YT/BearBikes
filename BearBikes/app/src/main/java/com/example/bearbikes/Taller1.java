package com.example.bearbikes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Taller1 extends AppCompatActivity {

    TextView Descripcion;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.taller1);
        getSupportActionBar().hide();
        Descripcion=(TextView) findViewById(R.id.texto);
        Descripcion.setText("Taller Mendoza\n Dirección: 11320, Laguna de Términos 447, Anáhuac I Secc., Miguel Hidalgo, Ciudad de México, CDMX \nDueño: Alfredo Mendoza\nEmpleados: 4\nTelefono: 5538752232");
    }

    public void lanzarChat(View view){
        Intent intent = new Intent(this, Chat.class);
        startActivity(intent);
    }

}
