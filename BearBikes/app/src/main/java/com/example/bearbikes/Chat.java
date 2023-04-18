package com.example.bearbikes;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Chat extends AppCompatActivity {

    EditText mensaje;
    Image btnMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);
        getSupportActionBar().hide();
        mensaje=(EditText) findViewById(R.id.mensajeEnviar);
    }

    public void enviar (View view){
        String s = mensaje.getText().toString();
        if (s==""){
            Toast.makeText(this, "Debes de llenar el mensaje", Toast.LENGTH_SHORT).show();
        }else{
            mensaje.setText("");
        }
    }


    public void volver (View view){
        Intent intent = new Intent(this, Reparacion.class);
        startActivity(intent);
        finish();
    }

}
