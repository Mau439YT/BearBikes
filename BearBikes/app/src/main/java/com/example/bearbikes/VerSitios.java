package com.example.bearbikes;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bearbikes.modeles.Sitio;

import java.util.List;

public class VerSitios extends AppCompatActivity {

    BaseDeDatos BD = new BaseDeDatos(this,"BD1",null,1);

    EditText sitio;
    ListView listViewSitios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.versitioslocales);
        getSupportActionBar().hide();

        List<Sitio> Sitios = BD.getAllSitios();

        listViewSitios = (ListView) findViewById(R.id.ListViewMisProductos);

        ArrayAdapter<Sitio> adapter = new ArrayAdapter<Sitio>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, Sitios);

        listViewSitios.setAdapter(adapter);

        listViewSitios.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Sitio sitioSeleccionado = (Sitio) parent.getItemAtPosition(position);

                new AlertDialog.Builder(VerSitios.this).setTitle("Sitio").setMessage("¿Qué deseas hacer?")
                        .setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Intent d = new Intent(VerSitios.this,SitioEditado.class);
                                //d.putExtra("sitioSeleccionado", sitioSeleccionado);
                                //startActivity(d);
                                // Eliminar el producto de la base de datos
                                boolean eliminado = BD.eliminarSitio(sitioSeleccionado.getID());

                                if (eliminado) {
                                    // Si se eliminó correctamente, actualizar la lista de productos en el adaptador
                                    ArrayAdapter<Sitio> adapter = new ArrayAdapter<Sitio>(VerSitios.this,
                                            android.R.layout.simple_list_item_1, android.R.id.text1, Sitios);

                                    listViewSitios.setAdapter(adapter);
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
                                Toast.makeText(VerSitios.this, "Ta bueno", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }


        });
        adapter.notifyDataSetChanged();


    }

    public void regresar(View vista){
        Intent regresarLogin = new Intent(this, SitiosTuristicos.class);
        startActivity(regresarLogin);
        finish();
    }
    public void lanzarRegistroSitios(View vista){
        Intent regresarLogin = new Intent(this, RegistroSitios.class);
        startActivity(regresarLogin);
        finish();
    }

    public void refrescar (View view){
        finish();
        startActivity(getIntent());
    }
}
