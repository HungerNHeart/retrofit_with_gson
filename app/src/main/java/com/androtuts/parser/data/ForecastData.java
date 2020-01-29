package com.androtuts.parser.data;

import java.util.List;

public class ForecastData {

    private String cod;
    private long message;
    private int cnt;
    private List<TemperatureData> list;

    public ForecastData() {
    }

    public ForecastData(String cod, long message, int cnt, List<TemperatureData> list) {
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.list = list;
    }

    public List<TemperatureData> getList() {
        return list;
    }

    public void setList(List<TemperatureData> list) {
        this.list = list;
    }
}
