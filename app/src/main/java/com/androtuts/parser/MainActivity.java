package com.androtuts.parser;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.androtuts.parser.data.ForecastData;
import com.androtuts.parser.data.TemperatureData;
import com.google.gson.Gson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Call<ForecastData> call = MainApplication.getInstance().getApiServices().getWeatherForecast("13.0480017", "80.2391685", "metric", "en", "f30de2bf91e320461b53e56d64cc35f6");
        call.enqueue(new Callback<ForecastData>() {
            @Override
            public void onResponse(Call<ForecastData> call, Response<ForecastData> response) {
                Log.d("MainActivity", "" + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));
                    @SuppressLint("SimpleDateFormat") SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    HashMap<String, List<TemperatureData>> map = new HashMap<String, List<TemperatureData>>();
                    List<TemperatureData> list = response.body().getList();
                    try {
                        for (int i = 0; i < list.size(); i++) {
                            String dateString = list.get(i).getDt_txt();
                            Date date = simpleDateFormat.parse(dateString);
                            String key = outputDateFormat.format(Objects.requireNonNull(date));
                            List<TemperatureData> data = new ArrayList<TemperatureData>();
                            if (map.get(key) == null) {
                                data.add(list.get(i));
                            } else {
                                data.addAll(Objects.requireNonNull(map.get(key)));
                                data.add(list.get(i));
                            }
                            map.put(key, data);
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Log.d("MainActivity", "result: " + new Gson().toJson(map));
                }
            }

            @Override
            public void onFailure(Call<ForecastData> call, Throwable t) {
                Log.d("MainActivity", "cancelled " + t.getMessage());
            }
        });
    }
}
