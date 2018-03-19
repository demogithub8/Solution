package com.example.harry.solution.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MyApi {
    String BASE_URL = "https://query.yahooapis.com/";

    static String buildQuery(String city) {
        return "select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"" + city + "\")";
    }

    @GET("v1/public/yql?format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys")
    Call<JsonResponse> getForecast(@Query("q") String query);
}
