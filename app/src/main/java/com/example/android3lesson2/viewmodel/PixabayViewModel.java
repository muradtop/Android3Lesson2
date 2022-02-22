package com.example.android3lesson2.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.android3lesson2.data.local.PreferencesHelper;
import com.example.android3lesson2.models.network_model.Hits;
import com.example.android3lesson2.repository.PixabayRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class PixabayViewModel extends ViewModel {
    public MutableLiveData<List<Hits>> imageList = new MutableLiveData<>();
    PixabayRepository repository;
    PreferencesHelper preferencesHelper;

    @Inject
    public PixabayViewModel(PixabayRepository repository, PreferencesHelper preferencesHelper) {
        this.repository = repository;
        this.preferencesHelper = preferencesHelper;
    }


    public MutableLiveData<List<Hits>> getImages(String word) {
        imageList = repository.getImages(word);
        return imageList;
    }

    public boolean getBoolean() {
        return preferencesHelper.getBoolean();
    }

    public void setBoolean(boolean isShown) {
        preferencesHelper.setBoolean(isShown);
    }
}




