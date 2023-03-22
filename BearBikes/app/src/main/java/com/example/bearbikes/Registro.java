package com.example.bearbikes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);
        getSupportActionBar().hide();
    }

    public void registrarCiclista(View v){
        Intent intent = new Intent(this, LogIn.class);
        startActivity(intent);
        finish();
        Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show();
    }
}
