package com.example.android3lesson2.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android3lesson2.databinding.ImageHolderBinding;
import com.example.android3lesson2.models.network_model.Hits;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewholder> {
    List<Hits> list = new ArrayList<>();

    @NonNull
    @Override
    public ImageViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImageViewholder(ImageHolderBinding.inflate(LayoutInflater.from(parent.getContext())));
    }


    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.ImageViewholder holder, int position) {
        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setApiData(List<Hits> list) {
        this.list = list;
    }

    public class ImageViewholder extends RecyclerView.ViewHolder {
        ImageHolderBinding binding;

        public ImageViewholder(@NonNull ImageHolderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Hits pixabayResponse) {
            Glide.with(binding.imImage).load(pixabayResponse.getLargeImageURL()).into(binding.imImage);

        }
    }
}
