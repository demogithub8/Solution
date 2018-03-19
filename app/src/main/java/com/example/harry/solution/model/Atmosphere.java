package com.example.harry.solution.model;

import com.google.gson.annotations.SerializedName;

public class Atmosphere {
    @SerializedName("humidity")
    private String humidity;
    @SerializedName("pressure")
    private String pressure;
    @SerializedName("rising")
    private String rising;
    @SerializedName("visibility")
    private String visibility;

    public String getHumidity() {
        return humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public String getRising() {
        return rising;
    }

    public String getVisibility() {
        return visibility;
    }
}
