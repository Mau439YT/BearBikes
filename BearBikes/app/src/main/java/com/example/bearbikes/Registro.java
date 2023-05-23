package com.example.bearbikes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bearbikes.interfaces.CiclistaAPI;
import com.example.bearbikes.modeles.Ciclista;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Registro extends AppCompatActivity {

    private EditText JEmail, Jpassword, Jname, Japellidopat, Japellidomat, Jcelular;
    private Button registro,regresar;

    String url = "http://192.168.20.47:9009/api/v1/auth/register";

    private CiclistaAPI ciclistaAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);
        getSupportActionBar().hide();

        Jname = (EditText) findViewById(R.id.etNombre);
        JEmail = (EditText) findViewById(R.id.etEmail);
        Japellidopat = (EditText) findViewById(R.id.etAP);
        Japellidomat = (EditText) findViewById(R.id.etAM);
        Jcelular = (EditText) findViewById(R.id.etCelular);
        Jpassword = (EditText) findViewById(R.id.etPassword);
        registro = (Button) findViewById(R.id.BRegistrar);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarCiclista();
            }
        });
    }

    public void registrarCiclista() {

        String type = "ciclista";
        String email = JEmail.getText().toString().trim();
        String password = Jpassword.getText().toString().trim();
        String name = Jname.getText().toString().trim();
        String apellidoPat = Japellidopat.getText().toString().trim();
        String apellidoMat = Japellidomat.getText().toString().trim();
        String celular = Jcelular.getText().toString().trim();

        //Validaciones

        if (email.isEmpty() || password.isEmpty() || name.isEmpty() || apellidoPat.isEmpty() || apellidoMat.isEmpty() || celular.isEmpty()) {
            Toast.makeText(this, "Rellene todos los campos", Toast.LENGTH_SHORT).show();
        }if (celular.length()>15){
            Toast.makeText(this, "Número de telefono muy largo", Toast.LENGTH_SHORT).show();
        }if (celular.length()<8) {
            Toast.makeText(this, "Número de telefono muy corto", Toast.LENGTH_SHORT).show();
        }if (!email.contains("@")||!email.contains(".")){
            Toast.makeText(this, "Ponga un email valido", Toast.LENGTH_SHORT).show();
        }
        else{
        //Registro

            // URL de la API de registro de usuarios


            // Crear un objeto Usuario con los datos ingresados
            Ciclista ciclista = new Ciclista(type, email, password, name, apellidoPat, apellidoMat, celular);

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

            // Envía la solicitud de manera asíncrona
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
                                Toast.makeText(Registro.this, "Solicitud exitosa: " + objetoJson.get("message").getAsString(), Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(Registro.this, LogIn.class);
                                startActivity(intent);
                                finish();
                            } else {
                                // La solicitud falló
                                Toast.makeText(Registro.this, "Error en el registro: " + responseBody, Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(Registro.this, "Error en el registro", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            });
        }//Fin del else
        //Regreso

    }

    public void regresarA(View v) {
        Intent i = new Intent(this, LogIn.class);
        startActivity(i);
        finish();
    }

}
