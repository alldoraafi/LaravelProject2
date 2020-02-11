package com.example.laravelproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIInterface {
    @POST("win")
    Call<List<Pemenang>> getPemenang(@Body RequestPemenang requestPemenang);
}
