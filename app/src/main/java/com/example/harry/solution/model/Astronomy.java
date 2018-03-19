package com.example.harry.solution.model;

import com.google.gson.annotations.SerializedName;

public class Astronomy {
    @SerializedName("sunrise")
    private String sunrise;
    @SerializedName("sunset")
    private String sunset;

    public String getSunrise() {
        return sunrise;
    }

    public String getSunset() {
        return sunset;
    }
}
