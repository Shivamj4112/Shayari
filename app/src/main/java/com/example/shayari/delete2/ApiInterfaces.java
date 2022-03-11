package com.example.shayari.delete2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterfaces {

    @GET("products/1")
    Call<deleteModel> getInterfaces();
}
