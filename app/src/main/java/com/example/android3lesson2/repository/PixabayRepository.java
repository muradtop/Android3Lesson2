package com.example.android3lesson2.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.android3lesson2.models.network_model.Hits;
import com.example.android3lesson2.models.network_model.PixabayResponse;
import com.example.android3lesson2.network.PixabayApi;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PixabayRepository {
    public static PixabayRepository pixabayRepository;
    PixabayApi api;

    @Inject
    public PixabayRepository(PixabayApi api) {
        this.api = api;
    }

    public MutableLiveData<List<Hits>> getImages(String word) {
        MutableLiveData<List<Hits>> imagesList = new MutableLiveData<>();

        api.getImages(word).enqueue(new Callback<PixabayResponse>() {
            @Override
            public void onResponse(Call<PixabayResponse> call, Response<PixabayResponse> response) {
                if (response.isSuccessful()) {
                    imagesList.postValue(response.body().getHits());

                }

            }

            @Override
            public void onFailure(Call<PixabayResponse> call, Throwable t) {

            }
        });
        return imagesList;


    }
}
