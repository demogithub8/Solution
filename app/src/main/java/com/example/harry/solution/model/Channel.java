package com.example.harry.solution.model;

import com.google.gson.annotations.SerializedName;

public class Channel {
    @SerializedName("units")
    private Units units;
    @SerializedName("title")
    private String title;
    @SerializedName("link")
    private String link;
    @SerializedName("description")
    private String description;
    @SerializedName("language")
    private String language;
    @SerializedName("lastBuildDate")
    private String lastBuildDate;
    @SerializedName("ttl")
    private String ttl;
    @SerializedName("location")
    private Location location;
    @SerializedName("wind")
    private Wind wind;
    @SerializedName("atmosphere")
    private Atmosphere atmosphere;
    @SerializedName("astronomy")
    private Astronomy astronomy;
    @SerializedName("image")
    private Image image;
    @SerializedName("item")
    private Item item;

    public Units getUnits() {
        return units;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public String getLanguage() {
        return language;
    }

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public String getTtl() {
        return ttl;
    }

    public Location getLocation() {
        return location;
    }

    public Wind getWind() {
        return wind;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    public Astronomy getAstronomy() {
        return astronomy;
    }

    public Image getImage() {
        return image;
    }

    public Item getItem() {
        return item;
    }
}
