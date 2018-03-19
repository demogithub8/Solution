package com.example.harry.solution.model;

import com.google.gson.annotations.SerializedName;

public class Wind {
    @SerializedName("chill")
    private String chill;
    @SerializedName("direction")
    private String direction;
    @SerializedName("speed")
    private String speed;

    public String getChill() {
        return chill;
    }

    public String getDirection() {
        return direction;
    }

    public String getSpeed() {
        return speed;
    }
}
