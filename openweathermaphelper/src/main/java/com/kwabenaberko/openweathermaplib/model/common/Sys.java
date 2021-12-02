package com.kwabenaberko.openweathermaplib.model.common;

import com.google.api.client.util.Key;

/**
 * Created by Kwabena Berko on 7/25/2017.
 */

public class Sys {

    @Key("type")
    private double type;

    @Key("id")
    private Long id;

    @Key("message")
    private Double message;

    @Key("country")
    private String country;

    @Key("sunrise")
    private Long sunrise;

    @Key("sunset")
    private Long sunset;

    @Key("pod")
    private Character pod;

    public double getType() {
        return type;
    }

    public Long getId() {
        return id;
    }

    public Double getMessage() {
        return message;
    }

    public String getCountry() {
        return country;
    }

    public Long getSunrise() {
        return sunrise;
    }

    public Long getSunset() {
        return sunset;
    }

    public Character getPod() {
        return pod;
    }
}
