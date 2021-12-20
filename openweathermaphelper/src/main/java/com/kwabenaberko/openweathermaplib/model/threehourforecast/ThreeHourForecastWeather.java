package com.kwabenaberko.openweathermaplib.model.threehourforecast;

import com.google.api.client.util.Key;
import com.kwabenaberko.openweathermaplib.model.common.*;

import java.util.List;

/**
 * Created by Kwabena Berko on 8/6/2017.
 */

public class ThreeHourForecastWeather {

    @Key("dt")
    private Long dt;

    @Key("main")
    private Main main;

    @Key("weather")
    private List<Weather> weather;

    @Key("clouds")
    private Clouds clouds;

    @Key("wind")
    private Wind wind;

    @Key("visibility")
    private Long visibility;

    @Key("pop")
    private Double pop;

    @Key("rain")
    private Rain rain;

    @Key("snow")
    private Snow snow;

    @Key("sys")
    private Sys mSys;

    @Key("dt_txt")
    private String dtTxt;

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public Long getVisibility() {
        return visibility;
    }

    public Double getPop() {
        return pop;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Snow getSnow() {
        return snow;
    }

    public void setSnow(Snow snow) {
        this.snow = snow;
    }

    public Sys getmSys() {
        return mSys;
    }

    public void setmSys(Sys mSys) {
        this.mSys = mSys;
    }

    public String getDtTxt() {
        return dtTxt;
    }

    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }
}
