package com.example.android3lesson2.models.network_model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PixabayResponse {
    @SerializedName("total")
    private Integer total;
    @SerializedName("totalHits")
    private Integer totalHits;
    @SerializedName("hits")
    private List<Hits> hits = null;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(Integer totalHits) {
        this.totalHits = totalHits;
    }

    public List<Hits> getHits() {
        return hits;
    }

    public void setHits(List<Hits> hits) {
        this.hits = hits;
    }
}

