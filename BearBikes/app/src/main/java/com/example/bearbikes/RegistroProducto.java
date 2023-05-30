package com.example.bearbikes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistroProducto extends AppCompatActivity {

    EditText edittextN, edittextD, edittextDR;

    BaseDeDatos BD = new BaseDeDatos(this,"BD1",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_producto);
        getSupportActionBar().hide();
        edittextN=(EditText) findViewById(R.id.ETN2);
        edittextD=(EditText) findViewById(R.id.ETD2);
        edittextDR=(EditText) findViewById(R.id.ETDR2);

    }

    public void onClick(View v){

        String Nom = edittextN.getText().toString();
        String Des = edittextD.getText().toString();
        String Dir = edittextDR.getText().toString();

        if(Nom.isEmpty()||Des.isEmpty()||Dir.isEmpty()) {
            Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
        }else{
            BD.abrir();
            BD.insertarProductos(String.valueOf(edittextN.getText()), String.valueOf(edittextD.getText()),String.valueOf(edittextDR.getText()));
            BD.close();
            edittextN.setText("");
            edittextD.setText("");
            edittextDR.setText("");
            Toast.makeText(this, "Producto registrado", Toast.LENGTH_SHORT).show();
        }
    }

    public void regresar(View vista){
        Intent regresarLogin = new Intent(this, VerSitios.class);
        startActivity(regresarLogin);
        finish();
    }
}
