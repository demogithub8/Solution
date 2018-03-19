package com.example.harry.solution.model;

import com.google.gson.annotations.SerializedName;

public class Units {
    @SerializedName("distance")
    private String distance;
    @SerializedName("pressure")
    private String pressure;
    @SerializedName("speed")
    private String speed;
    @SerializedName("temperature")
    private String temperature;

    public String getDistance() {
        return distance;
    }

    public String getPressure() {
        return pressure;
    }

    public String getSpeed() {
        return speed;
    }

    public String getTemperature() {
        return temperature;
    }
}
