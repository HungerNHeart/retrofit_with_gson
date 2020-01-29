package com.androtuts.parser.data;

import java.util.List;

public class TemperatureData {
    private long dt;
    private TemperatureMain main;
    private List<WeatherData> weather;
    private CloudData clouds;
    private WindData wind;
    private float speed;
    private long deg;
    private String dt_txt;

    public TemperatureData() {
    }

    public TemperatureData(long dt, TemperatureMain main, List<WeatherData> weather, CloudData clouds, WindData wind, float speed, long deg, String dt_txt) {
        this.dt = dt;
        this.main = main;
        this.weather = weather;
        this.clouds = clouds;
        this.wind = wind;
        this.speed = speed;
        this.deg = deg;
        this.dt_txt = dt_txt;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public TemperatureMain getMain() {
        return main;
    }

    public void setMain(TemperatureMain main) {
        this.main = main;
    }

    public List<WeatherData> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherData> weather) {
        this.weather = weather;
    }

    public CloudData getClouds() {
        return clouds;
    }

    public void setClouds(CloudData clouds) {
        this.clouds = clouds;
    }

    public WindData getWind() {
        return wind;
    }

    public void setWind(WindData wind) {
        this.wind = wind;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public long getDeg() {
        return deg;
    }

    public void setDeg(long deg) {
        this.deg = deg;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }
}
