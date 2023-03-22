package com.example.bearbikes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        getSupportActionBar().hide();
    }

    public void iniciar(View v){
        Intent intent = new Intent(this, Seleccion.class);
        startActivity(intent);
    }

    public void registrar(View v){
        Intent intent = new Intent(this, Registro.class);
        startActivity(intent);
    }
}
