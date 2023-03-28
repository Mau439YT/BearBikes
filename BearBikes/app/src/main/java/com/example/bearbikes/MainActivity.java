package com.example.bearbikes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.bearbikes.interfaces.CiclistaAPI;
import com.example.bearbikes.modeles.Ciclista;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
    }

    public void lanzarApp(View v){
        Intent intent = new Intent(this, LogIn.class);
        startActivity(intent);
        finish();
    }

}