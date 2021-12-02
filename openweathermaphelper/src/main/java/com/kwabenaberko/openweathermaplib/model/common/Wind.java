package com.kwabenaberko.openweathermaplib.model.common;

import com.google.api.client.util.Key;

/**
 * Created by Kwabena Berko on 7/25/2017.
 */

public class Wind {
    @Key("speed")
    private double speed;

    @Key("deg")
    private double deg;

    @Key("gust")
    private Double gust;

    public double getSpeed() {
        return speed;
    }

    public double getDeg() {
        return deg;
    }

    public Double getGust() {
        return gust;
    }
}
