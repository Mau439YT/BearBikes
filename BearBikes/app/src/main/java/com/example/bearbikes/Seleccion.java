package com.example.bearbikes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Seleccion extends AppCompatActivity {
String nombre;
String rol;
String correo;

TextView saludo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seleccion);
        getSupportActionBar().hide();

        Intent i = getIntent();

        nombre= i.getStringExtra("nombre");
        correo= i.getStringExtra("correo");
        rol= i.getStringExtra("rol");

        rol = rol.toLowerCase();

        saludo=(TextView) findViewById(R.id.etSaludo);

        saludo.setText(String.format("Bienvenido %s %s",rol,nombre));
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
