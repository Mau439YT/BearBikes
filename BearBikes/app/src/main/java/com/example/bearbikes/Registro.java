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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Registro extends AppCompatActivity {

    private EditText JEmail, Jpassword, Jname, Japellidopat, Japellidomat, Jcelular;
    private Button registro;

    private Retrofit retrofit;
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

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new AuthInterceptor("tu_token_de_autenticacion"));

        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.20.110:9009/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ciclistaAPI = retrofit.create(CiclistaAPI.class);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarCiclista();
            }
        });
    }

    public void registrarCiclista() {

        String type = "ciclista";
        String email = JEmail.getText().toString();
        String password = Jpassword.getText().toString();
        String name = Jname.getText().toString();
        String apellidoPat = Japellidopat.getText().toString();
        String apellidoMat = Japellidomat.getText().toString();
        String celular = Jcelular.getText().toString();

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
            Ciclista user = new Ciclista(type, email, password, name, apellidoPat, apellidoMat, celular);

            Call<Ciclista> call = ciclistaAPI.createUser(user);

            call.enqueue(new Callback<Ciclista>() {


                @Override
                public void onResponse(Call<Ciclista> call, Response<Ciclista> response) {
                    //Bien
                    String test = response.toString();
                    Toast.makeText(getApplicationContext(), test, Toast.LENGTH_SHORT).show();

                    if (response.isSuccessful()) {
                        // El usuario ha sido registrado exitosamente
                        Ciclista ciclista = response.body();
                        Toast.makeText(Registro.this, "Usuario registrado correctamente", Toast.LENGTH_LONG).show();
                    } else {
                        // Error al registrar el usuario
                        try {
                            String errorBody = response.errorBody().string();
                            JSONObject jsonObject = new JSONObject(errorBody);
                            String errorMessage = jsonObject.getString("message");
                            Toast.makeText(Registro.this, errorMessage, Toast.LENGTH_LONG).show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onFailure(Call<Ciclista> call, Throwable t) {
                    //Error
                    t.printStackTrace();
                    Toast.makeText(Registro.this, "Error al registrar usuario: " + t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
            //Regreso
            Intent intent = new Intent(this, LogIn.class);
            startActivity(intent);
            finish();
        }

    }






}
