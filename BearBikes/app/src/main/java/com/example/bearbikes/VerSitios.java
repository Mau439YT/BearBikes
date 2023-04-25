package com.example.bearbikes;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bearbikes.modeles.Sitios;

import java.util.ArrayList;

public class VerSitios extends AppCompatActivity {

    BaseDeDatos BD = new BaseDeDatos(this,"BD1",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.versitioslocales);
        getSupportActionBar().hide();


        String[] arraySpinner = new String[]{
                "1", "2", "3", "4", "5", "6", "7"
        };
        Spinner s = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);


        //SQLiteDatabase db = dbHelper.getReadableDatabase();
        //String[] columnas = {"Nombre"};
        //Cursor cursor = BD.query("Sitios", columnas, null, null, null, null, null);
        //ArrayList<String> nombres = new ArrayList<>();
        //while (cursor.moveToNext()) {
        //    String nombre = cursor.getString(cursor.getColumnIndex("Nombre"));
        //    nombres.add(nombre);
        //}
        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, nombres);
        //s.setAdapter(adapter);
        //cursor.close();


    }


    public void regresar(View vista){
        Intent regresarLogin = new Intent(this, SitiosTuristicos.class);
        startActivity(regresarLogin);
        finish();
    }
    public void lanzarRegistroSitios(View vista){
        Intent regresarLogin = new Intent(this, VerSitios.class);
        startActivity(regresarLogin);
        finish();
    }
}
