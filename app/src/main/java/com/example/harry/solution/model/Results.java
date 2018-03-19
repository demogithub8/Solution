package com.example.harry.solution.model;

import com.google.gson.annotations.SerializedName;

public class Results {
    @SerializedName("channel")
    private Channel channel;

    public Channel getChannel() {
        return channel;
    }
}
