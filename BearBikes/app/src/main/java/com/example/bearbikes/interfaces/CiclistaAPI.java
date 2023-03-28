package com.example.bearbikes.interfaces;

import com.example.bearbikes.modeles.Ciclista;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CiclistaAPI {

    @POST("api/v1/auth/register")
    Call<Ciclista> createUser(@Body Ciclista ciclistaRegistrar);

}