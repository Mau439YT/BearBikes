package com.example.bearbikes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bearbikes.modeles.Taller;

import java.util.List;

public class ProductoSeleccionado extends AppCompatActivity {

    BaseDeDatos BD = new BaseDeDatos(this,"BD1",null,1);

    TextView productoSeleccionado;

    ListView LVTalleres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productoseleccionado);
        getSupportActionBar().hide();

        BD.insertarTalleresPrueba();

        List<Taller> Talleres = BD.getAllTalleres();

        LVTalleres = (ListView) findViewById(R.id.ListViewTalleres);

        ArrayAdapter<Taller> adapter = new ArrayAdapter<Taller>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, Talleres);

        LVTalleres.setAdapter(adapter);

        Intent i = getIntent();

        String Producto = i.getStringExtra("Producto");

        productoSeleccionado=(TextView) findViewById(R.id.proSelec);

        productoSeleccionado.setText(Producto);

    }

}
