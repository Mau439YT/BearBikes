package com.example.bearbikes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bearbikes.modeles.DueñoTaller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class VerTalleres extends AppCompatActivity {

    TextView TT1, TT2, T1, T2;
    Button SeleccionBoton1, SeleccionBoton2;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.elegirtaller);
        getSupportActionBar().hide();


        TT1 = (TextView) findViewById(R.id.tituloTaller);
        TT1.setText("Taller Mendoza");
        TT2 = (TextView) findViewById(R.id.tituloTaller2);
        TT2.setText("Taller Hermanos Juarez");
        T1 = (TextView) findViewById(R.id.textoTaller);
        T1.setText("Dirección: 11320, Laguna de Términos 447, Anáhuac I Secc., Miguel Hidalgo, Ciudad de México, CDMX \nDueño: Alfredo Mendoza\nEmpleados: 4");
        T2 = (TextView) findViewById(R.id.textoTaller2);
        T2.setText("Dirección: Lago Chalco 74, Anáhuac I Secc., Anáhuac I Secc, Miguel Hidalgo, 11320 Ciudad de México, CDMX\nDueño: Leonardo Juarez\nEmpleados: 2 ");
        SeleccionBoton1 = (Button) findViewById(R.id.btnST1);
        SeleccionBoton2 = (Button) findViewById(R.id.btnST2);
    }

    OkHttpClient client = new OkHttpClient();

    private void obtenerDueñosDeTaller() {
        Request request = new Request.Builder()
                .url("https://192.168.20.47:9009/workshop/getAll")  // Reemplaza con la URL de la API real
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // Manejo de errores en caso de fallo en la solicitud
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String responseData = response.body().string();
                    List<DueñoTaller> duenosTaller = procesarDatos(responseData);  // Método para procesar los datos en formato JSON
                    // Actualizar el ListView en el hilo principal (UI Thread)
                    runOnUiThread(() -> actualizarListView(duenosTaller));
                    // Procesar los datos de la respuesta en formato JSON o cualquier otro formato


                } else {
                    // Manejo de errores en caso de una respuesta no exitosa
                    // response.code() contiene el código de estado HTTP
                }
            }
        });
    }

    private List<DueñoTaller> procesarDatos(String jsonData) {
        List<DueñoTaller> duenosTaller = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String email = jsonObject.getString("email");
                String password = jsonObject.getString("password");
                String nombre = jsonObject.getString("nombre");  // Reemplaza "nombre" con el nombre del campo en tu JSON
                String apellidoPat = jsonObject.getString("apellidoPat");
                String apellidoMat = jsonObject.getString("apellidoMat");
                String numerocelular = jsonObject.getString("numerocelular");  // Reemplaza "direccion" con el nombre del campo en tu JSON
                String rfcFisica = jsonObject.getString("rfcFisica");
                String type = jsonObject.getString("ROLE");
                DueñoTaller dueñoTaller = new DueñoTaller(email, password, nombre, apellidoPat, apellidoMat, numerocelular, rfcFisica, type);
                duenosTaller.add(dueñoTaller);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return duenosTaller;
    }

    private void actualizarListView(List<DueñoTaller> datos) {
        ArrayAdapter<DueñoTaller> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, datos);
        listView.setAdapter(adapter);
    }

    public void lanzarTaller1Seleccionado(View view){
        Intent intent = new Intent(this, Taller1.class);
        startActivity(intent);
    }
    public void lanzarTaller2Seleccionado(View view){
        Intent intent = new Intent(this, Taller2.class);
        startActivity(intent);
    }

}
