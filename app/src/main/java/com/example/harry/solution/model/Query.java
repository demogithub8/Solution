package com.example.harry.solution.model;

import com.google.gson.annotations.SerializedName;

public class Query {
    @SerializedName("count")
    private Integer count;
    @SerializedName("created")
    private String created;
    @SerializedName("lang")
    private String lang;
    @SerializedName("results")
    private Results results;

    public Integer getCount() {
        return count;
    }

    public String getCreated() {
        return created;
    }

    public String getLang() {
        return lang;
    }

    public Results getResults() {
        return results;
    }
}
