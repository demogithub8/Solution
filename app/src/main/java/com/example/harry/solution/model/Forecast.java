package com.example.harry.solution.model;

import com.google.gson.annotations.SerializedName;

public class Forecast {
    @SerializedName("code")
    private String code;
    @SerializedName("date")
    private String date;
    @SerializedName("day")
    private String day;
    @SerializedName("high")
    private String high;
    @SerializedName("low")
    private String low;
    @SerializedName("text")
    private String text;

    public String getCode() {
        return code;
    }

    public String getDate() {
        return date;
    }

    public String getDay() {
        return day;
    }

    public String getHigh() {
        return high;
    }

    public String getLow() {
        return low;
    }

    public String getText() {
        return text;
    }
}
