package com.example.bearbikes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class SitiosTuristicos extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sitiosturisiticos);
        getSupportActionBar().hide();


        webView=(WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl("file:///android_asset/info.html");

        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);

        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
    }

    public void lanzarSitiosLocales(View vista){
        Intent regresarLogin = new Intent(this, VerSitios.class);
        startActivity(regresarLogin);
        finish();
    }

    public void regresar(View vista){
        Intent regresarLogin = new Intent(this, Seleccion.class);
        startActivity(regresarLogin);
        finish();
    }
}
