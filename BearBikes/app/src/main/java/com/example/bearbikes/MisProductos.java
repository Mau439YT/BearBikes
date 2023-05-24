package com.example.bearbikes;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bearbikes.modeles.Sitio;
import com.example.bearbikes.modeles.Taller;

import java.util.List;

public class MisProductos extends AppCompatActivity {



    ListView listViewProductos;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verproductos);
        getSupportActionBar().hide();


    }
    
    
}
