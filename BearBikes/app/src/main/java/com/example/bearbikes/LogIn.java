package com.example.bearbikes;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.auth0.android.jwt.JWT;
import com.example.bearbikes.modeles.Ciclista;
import com.example.bearbikes.modeles.CiclistaInicio.CiclistaInicio;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LogIn extends AppCompatActivity {

    EditText Eemail, Epassword;
    Button BtnLogin;
    ProgressBar Circ;


    private JWT token;
    private String nombre;
    private String rol;
    private String emailToken;

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

        Circ= (ProgressBar)findViewById(R.id.progressBar);
        Circ.setVisibility(View.INVISIBLE);

    }


    public void iniciarCiclista() {


        String email = Eemail.getText().toString();
        String password = Epassword.getText().toString();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!email.contains("@") || !email.contains(".")){
            Toast.makeText(this, "Ingresa el formato correcto de correo", Toast.LENGTH_SHORT).show();
            return;
        }

        String url = "http://192.168.20.47:9009/api/v1/auth/authenticate";

        // Crear un objeto Usuario con los datos ingresados
        CiclistaInicio ciclista = new CiclistaInicio(email, password);

        // Crea un objeto OkHttpClient
        OkHttpClient client = new OkHttpClient();

        // Convierte el objeto Usuario a JSON
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        Gson gson = new Gson();
        String jsonBody = gson.toJson(ciclista);
        RequestBody requestBody = RequestBody.create(jsonBody, JSON);

        // Crea una solicitud POST con la URL y el cuerpo JSON
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        Circ.setVisibility(View.VISIBLE);
        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // Manejar la respuesta de la solicitud
                final String responseBody = response.body().string();
                Gson jsonRespuesta = new Gson();
                JsonObject objetoJson = jsonRespuesta.fromJson(responseBody, JsonObject.class);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (response.isSuccessful()) {
                            // La solicitud fue exitosa
                            System.out.println("Registro exitoso: " + objetoJson.get("message").getAsString());
                            Toast.makeText(LogIn.this, objetoJson.get("message").getAsString(), Toast.LENGTH_SHORT).show();
                            System.out.println("Token recibido =>" + objetoJson.get("token").getAsString());
                            token= new JWT(objetoJson.get("token").getAsString());

                            nombre = token.getClaim("name").asString();
                            rol = token.getClaim("role").asString();
                            emailToken = token.getClaim("username").asString();
                            Log.d("mensaje",String.format("NOMBRE: %s || ROLE: %s || EMAIL: %s ", nombre, rol, emailToken));
                            Intent intent = new Intent(LogIn.this, Seleccion.class);
                            intent.putExtra("nombre", nombre);
                            intent.putExtra("rol", rol);
                            intent.putExtra("correo", emailToken);

                            startActivity(intent);
                            finish();
                        } else {
                            // La solicitud falló
                            Toast.makeText(LogIn.this, "Error en el inicio de sesión: " + objetoJson.get("message").getAsString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                // Manejar el error en caso de falla de la solicitud
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(LogIn.this, "Error en el inicio de sesión", Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });


    }


    public void registrar(View v){
        Intent intent = new Intent(this, Registro.class);
        startActivity(intent);
    }
}
