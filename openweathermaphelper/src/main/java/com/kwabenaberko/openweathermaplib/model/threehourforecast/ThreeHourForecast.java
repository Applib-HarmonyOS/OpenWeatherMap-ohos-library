package com.kwabenaberko.openweathermaplib.model.threehourforecast;

import com.google.api.client.util.Key;

import java.util.List;

/**
 * Created by Kwabena Berko on 8/6/2017.
 */

public class ThreeHourForecast {

    @Key("cod")
    private String cod;

    @Key("message")
    private double message;

    @Key("cnt")
    private int cnt;

    @Key("list")
    private List<ThreeHourForecastWeather> list;

    @Key("city")
    private City city;


    public String getCod() {
        return cod;
    }

    public double getMessage() {
        return message;
    }

    public int getCnt() {
        return cnt;
    }

    public List<ThreeHourForecastWeather> getList() {
        return list;
    }

    public City getCity() {
        return city;
    }
}
