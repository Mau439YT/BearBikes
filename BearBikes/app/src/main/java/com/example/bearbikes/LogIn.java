package com.example.bearbikes;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bearbikes.modeles.Ciclista;
import com.example.bearbikes.modeles.CiclistaInicio.CiclistaInicio;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LogIn extends AppCompatActivity {

    EditText Eemail, Epassword;
    Button BtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        getSupportActionBar().hide();

        Eemail=(EditText) findViewById(R.id.etNLogin);
        Epassword=(EditText) findViewById(R.id.etCLogin);
        BtnLogin=(Button) findViewById(R.id.BLogin);
        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarCiclista();
            }
        });
    }


    public void iniciarCiclista() {

        String email= Eemail.getText().toString();
        String password= Epassword.getText().toString();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        String url = "http://192.168.20.47:9009/api/v1/auth/authenticate?";

        // Crear un objeto Usuario con los datos ingresados
        CiclistaInicio ciclista = new CiclistaInicio(email, password);

        // Crea un objeto OkHttpClient
        OkHttpClient client = new OkHttpClient();

        // Convierte el objeto Usuario a JSON
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        Gson gson = new Gson();
        String jsonBody = gson.toJson(ciclista);
        RequestBody requestBody = new FormBody.Builder()
                .add("email", email)
                .add("password", password)
                .build();

        // Crea una solicitud POST con la URL y el cuerpo JSON
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        // Envía la solicitud de manera síncrona
        try {
            // Envía la solicitud al servidor
            Response response = client.newCall(request).execute();
            final String responseBody = response.body().toString();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (response.isSuccessful()) {
                        // La solicitud fue exitosa
                        Toast.makeText(LogIn.this, "Inicio de sesión exitoso: " + responseBody, Toast.LENGTH_SHORT).show();
                    } else {
                        // La solicitud falló
                        Toast.makeText(LogIn.this, "Error en el inicio de sesión: " + responseBody, Toast.LENGTH_SHORT).show();
                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(LogIn.this, "Error en el inicio de sesión", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }



    public void registrar(View v){
        Intent intent = new Intent(this, Registro.class);
        startActivity(intent);
    }
}
