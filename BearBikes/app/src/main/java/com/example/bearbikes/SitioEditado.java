package com.example.bearbikes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bearbikes.modeles.Sitio;

public class SitioEditado extends AppCompatActivity {
    EditText edittextN, edittextD, edittextDR;

    BaseDeDatos BD = new BaseDeDatos(this,"BD1",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar_sitio);
        getSupportActionBar().hide();
        edittextN=(EditText) findViewById(R.id.ETNE);
        edittextD=(EditText) findViewById(R.id.ETDE);
        edittextDR=(EditText) findViewById(R.id.ETDRE);

        Intent intent = getIntent();

        Sitio sitio1 = (Sitio) intent.getSerializableExtra("sitioSeleccionado");

        edittextN.setText(sitio1.getNombre());
        edittextD.setText(sitio1.getDescripcion());
        edittextDR.setText(sitio1.getDireccion());

    }

    public void onClickSE(View v){

        String Nom = edittextN.getText().toString();
        String Des = edittextD.getText().toString();
        String Dir = edittextDR.getText().toString();

        if(Nom.isEmpty()||Des.isEmpty()||Dir.isEmpty()) {
            Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
        }else{

            Intent intent = getIntent();

            Sitio sitio1 = (Sitio) intent.getSerializableExtra("sitioSeleccionado");

            boolean eliminado = BD.eliminarSitio(sitio1.getID());
            BD.abrir();
            BD.actualizarSitio(sitio1);
            BD.close();
            edittextN.setText("");
            edittextD.setText("");
            edittextDR.setText("");
            Toast.makeText(this, "Sitio editado", Toast.LENGTH_SHORT).show();


            Intent i = new Intent (this, VerSitios.class);
            startActivity(i);
            finish();
        }
    }

    public void regresar(View vista){
        Intent regresarLogin = new Intent(this, VerSitios.class);
        startActivity(regresarLogin);
        finish();
    }
}
