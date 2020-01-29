package com.androtuts.parser;

import com.androtuts.parser.data.ForecastData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIController {

    @GET("forecast")
    Call<ForecastData> getWeatherForecast(@Query("lat") String latitude, @Query("lon") String longitude, @Query("units") String units, @Query("lang") String language, @Query("appid") String appId);

    interface Constants{
        String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    }
}
