package com.example.harry.solution.model;

import com.google.gson.annotations.SerializedName;

public class Location {
    @SerializedName("city")
    private String city;
    @SerializedName("country")
    private String country;
    @SerializedName("region")
    private String region;

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }
}
