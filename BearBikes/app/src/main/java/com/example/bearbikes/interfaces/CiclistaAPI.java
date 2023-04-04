package com.example.bearbikes.interfaces;

import com.example.bearbikes.modeles.Ciclista;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CiclistaAPI {

    final String term = "api/v1/auth/register";


    @POST(term)
    Call<Ciclista> createUser(@Body Ciclista ciclistaRegistrar);

}