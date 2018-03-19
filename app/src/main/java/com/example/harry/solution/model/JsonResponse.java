package com.example.harry.solution.model;

import com.google.gson.annotations.SerializedName;

public class JsonResponse {
    @SerializedName("query")
    private Query query;

    public Query getQuery() {
        return query;
    }
}
