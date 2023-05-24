package com.example.bearbikes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

    public void lanzarRefaccionesCompletas (View v){
        Intent i = new Intent(this, ProductoSeleccionado.class);
        i.putExtra("Producto","Refacciones Completas");
        startActivity(i);
        finish();
    }

    public void lanzarLlantas (View v){
        Intent i = new Intent(this, ProductoSeleccionado.class);
        i.putExtra("Producto","Llantas");
        startActivity(i);
        finish();
    }

    public void lanzarPedales (View v){
        Intent i = new Intent(this, ProductoSeleccionado.class);
        i.putExtra("Producto","Pedales");
        startActivity(i);
        finish();
    }

    public void lanzarSeguro (View v){
        Intent i = new Intent(this, ProductoSeleccionado.class);
        i.putExtra("Producto","Seguro");
        startActivity(i);
        finish();
    }

    public void lanzarFrenos (View v){
        Intent i = new Intent(this, ProductoSeleccionado.class);
        i.putExtra("Producto","Frenos");
        startActivity(i);
        finish();
    }

    public void volver (View v){
        Intent i = new Intent(this, Tienda.class);
        startActivity(i);
        finish();
    }
}
