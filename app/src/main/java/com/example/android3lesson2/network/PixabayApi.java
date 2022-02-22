package com.example.android3lesson2.network;

import com.example.android3lesson2.models.network_model.PixabayResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PixabayApi {
    @GET("/api?key=25678452-c644ee6efc6979cc35175839e")
    Call<PixabayResponse> getImages(@Query("q") String keyWord);

}
