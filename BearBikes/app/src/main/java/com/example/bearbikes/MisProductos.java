package com.example.bearbikes;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bearbikes.modeles.Producto;
import com.example.bearbikes.modeles.Sitio;
import com.example.bearbikes.modeles.Taller;

import java.util.List;

public class MisProductos extends AppCompatActivity {

    ListView listViewProductos;
    BaseDeDatos BD = new BaseDeDatos(this,"BD1",null,1);
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verproductos);
        getSupportActionBar().hide();

        BD.insertarProductoPrueba();

        List<Producto> Productos = BD.getAllProductos();

        listViewProductos = (ListView) findViewById(R.id.ListViewMisProductos);

        ArrayAdapter<Producto> adapter = new ArrayAdapter<Producto>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, Productos);

        listViewProductos.setAdapter(adapter);

        listViewProductos.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Producto productoSeleccionado = (Producto) parent.getItemAtPosition(position);

                new AlertDialog.Builder(MisProductos.this).setTitle("Producto").setMessage("¿Qué deseas hacer?")
                        .setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Intent d = new Intent(VerSitios.this,SitioEditado.class);
                                //d.putExtra("sitioSeleccionado", sitioSeleccionado);
                                //startActivity(d);
                                // Eliminar el producto de la base de datos
                                boolean eliminado = BD.eliminarSitio(productoSeleccionado.getID());

                                if (eliminado) {
                                    // Si se eliminó correctamente, actualizar la lista de productos en el adaptador
                                    ArrayAdapter<Producto> adapter = new ArrayAdapter<Producto>(MisProductos.this,
                                            android.R.layout.simple_list_item_1, android.R.id.text1, Productos);

                                    listViewProductos.setAdapter(adapter);
                                    Toast.makeText(getApplicationContext(), "Producto eliminado", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getApplicationContext(), "No se pudo eliminar el producto", Toast.LENGTH_SHORT).show();
                                }
                                finish();
                                startActivity(getIntent());
                            }
                        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MisProductos.this, "Ta bueno", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }


        });
        adapter.notifyDataSetChanged();

    }
    public void refrescar (View view){
        finish();
        startActivity(getIntent());
    }

    public void volver (View v){
        Intent i = new Intent(this, Vender.class);
        startActivity(i);
        finish();
    }
    
    
}
