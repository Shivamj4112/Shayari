package com.example.shayari.delete2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClients {

    public static final String Base_Url = "https://fakestoreapi.com/";
    public static Retrofit retrofit;

    public static Retrofit getApiClients(){

        retrofit = new Retrofit.Builder()
                .baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
