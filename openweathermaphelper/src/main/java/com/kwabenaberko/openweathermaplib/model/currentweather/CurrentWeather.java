package com.kwabenaberko.openweathermaplib.model.currentweather;

import com.google.api.client.util.Key;
import com.kwabenaberko.openweathermaplib.model.common.*;

import java.util.List;

/**
 * Created by Kwabena Berko on 7/25/2017.
 */

public class CurrentWeather {

    @Key("coord")
    private Coord coord;

    @Key("weather")
    private List<Weather> weather;

    @Key("base")
    private String base;

    @Key("main")
    private Main main;

    @Key("visibility")
    private Long visibility;

    @Key("wind")
    private Wind wind;

    @Key("clouds")
    private Clouds clouds;

    @Key("rain")
    private Rain rain;

    @Key("snow")
    private Snow snow;

    @Key("dt")
    private Long dt;

    @Key("sys")
    private Sys sys;

    @Key("timezone")
    private Long timezone;

    @Key("id")
    private Long id;

    @Key("name")
    private String name;

    @Key("cod")
    private Integer cod;

    public Coord getCoord() {
        return coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public String getBase() {
        return base;
    }

    public Main getMain() {
        return main;
    }

    public Long getVisibility() {
        return visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public Rain getRain() {
        return rain;
    }

    public Snow getSnow() {
        return snow;
    }

    public Long getDt() {
        return dt;
    }

    public Sys getSys() {
        return sys;
    }

    public Long getTimezone() {
        return timezone;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCod() {
        return cod;
    }
}
