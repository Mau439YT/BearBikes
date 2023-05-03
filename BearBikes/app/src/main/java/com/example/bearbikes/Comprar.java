package com.example.bearbikes;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bearbikes.modeles.Sitio;

import java.util.List;

public class Comprar extends AppCompatActivity {

    BaseDeDatos BD = new BaseDeDatos(this,"BD1",null,1);

    ListView listViewSitios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comprar);
        getSupportActionBar().hide();

        List<Sitio> Sitios = BD.getAllSitios();

        listViewSitios = (ListView) findViewById(R.id.ListViewProductos);

        ArrayAdapter<Sitio> adapter = new ArrayAdapter<Sitio>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, Sitios);
        listViewSitios.setAdapter(adapter);
    }
}
