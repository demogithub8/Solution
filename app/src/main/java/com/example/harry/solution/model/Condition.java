package com.example.harry.solution.model;

import com.google.gson.annotations.SerializedName;

public class Condition {
    @SerializedName("code")
    private String code;
    @SerializedName("date")
    private String date;
    @SerializedName("temp")
    private String temp;
    @SerializedName("text")
    private String text;

    public String getCode() {
        return code;
    }

    public String getDate() {
        return date;
    }

    public String getTemp() {
        return temp;
    }

    public String getText() {
        return text;
    }
}
