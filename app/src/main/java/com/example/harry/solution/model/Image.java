package com.example.harry.solution.model;

import com.google.gson.annotations.SerializedName;

public class Image {
    @SerializedName("title")
    private String title;
    @SerializedName("width")
    private String width;
    @SerializedName("height")
    private String height;
    @SerializedName("link")
    private String link;
    @SerializedName("url")
    private String url;

    public String getTitle() {
        return title;
    }

    public String getWidth() {
        return width;
    }

    public String getHeight() {
        return height;
    }

    public String getLink() {
        return link;
    }

    public String getUrl() {
        return url;
    }
}
