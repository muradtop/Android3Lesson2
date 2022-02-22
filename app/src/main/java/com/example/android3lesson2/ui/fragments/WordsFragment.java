package com.example.android3lesson2.ui.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.android3lesson2.adapters.ImageAdapter;
import com.example.android3lesson2.base.BaseFragment;
import com.example.android3lesson2.databinding.FragmentWordsBinding;
import com.example.android3lesson2.models.network_model.Hits;
import com.example.android3lesson2.viewmodel.PixabayViewModel;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class WordsFragment extends BaseFragment<FragmentWordsBinding> {
    private static final int DELAY = 2000;
    PixabayViewModel viewModel;
    ImageAdapter imageAdapter;
    private Handler handler = new Handler();

    @Override
    public FragmentWordsBinding bind() {
        return FragmentWordsBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(PixabayViewModel.class);
        initAdapter();
        initListeners();

    }


    private void initListeners() {
        binding.etWords.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (handler != null) {
                    handler = null;
                }


            }

            @Override
            public void afterTextChanged(Editable editable) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.progressBar.setVisibility(View.VISIBLE);
                        String word = binding.etWords.getText().toString();
                        viewModel.getImages(word).observe(getViewLifecycleOwner(), images -> {
                            if (images != null) {
                                binding.progressBar.setVisibility(View.GONE);
                                imageAdapter.setApiData((ArrayList<Hits>) images);
                                binding.recyclerview.setAdapter(imageAdapter);

                            }


                        });

                    }
                }, DELAY);

            }


        });


    }

    private void initAdapter() {
        imageAdapter = new ImageAdapter();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}