package com.example.shayari.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/public/v2/users")
    Call<List<RetrofitModel>> getImage();

}
