package com.kwabenaberko.openweathermaplib.model.common;

import com.google.api.client.util.Key;

/**
 * Created by Kwabena Berko on 7/25/2017.
 */

public class Main {
    @Key("temp")
    private double temp;

    @Key("feels_like")
    private double feelsLike;

    @Key("temp_min")
    private double tempMin;

    @Key("temp_max")
    private double tempMax;

    @Key("pressure")
    private double pressure;

    @Key("humidity")
    private double humidity;

    @Key("sea_level")
    private Double seaLevel;

    @Key("grnd_level")
    private Double grndLevel;

    @Key("temp_kf")
    private Double tempKf;


    public double getTemp() {
        return temp;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public double getTempMin() {
        return tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public double getPressure() {
        return pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public Double getSeaLevel() {
        return seaLevel;
    }

    public Double getGrndLevel() {
        return grndLevel;
    }

    public Double getTempKf() {
        return tempKf;
    }
}
