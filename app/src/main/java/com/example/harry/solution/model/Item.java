package com.example.harry.solution.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Item {
    @SerializedName("title")
    private String title;
    @SerializedName("lat")
    private String lat;
    @SerializedName("long")
    private String _long;
    @SerializedName("link")
    private String link;
    @SerializedName("pubDate")
    private String pubDate;
    @SerializedName("condition")
    private Condition condition;
    @SerializedName("forecast")
    private List<Forecast> forecast = null;
    @SerializedName("description")
    private String description;
    @SerializedName("guid")
    private Guid guid;

    public String getTitle() {
        return title;
    }

    public String getLat() {
        return lat;
    }

    public String get_long() {
        return _long;
    }

    public String getLink() {
        return link;
    }

    public String getPubDate() {
        return pubDate;
    }

    public Condition getCondition() {
        return condition;
    }

    public List<Forecast> getForecast() {
        return forecast;
    }

    public String getDescription() {
        return description;
    }

    public Guid getGuid() {
        return guid;
    }
}
