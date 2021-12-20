package com.kwabenaberko.openweathermaplib.model.threehourforecast;

import com.google.api.client.util.Key;
import com.kwabenaberko.openweathermaplib.model.common.Coord;

/**
 * Created by Kwabena Berko on 8/6/2017.
 */

public class City {

    @Key("id")
    private long id;

    @Key("name")
    private String name;

    @Key("coord")
    private Coord coord;

    @Key("country")
    private String country;

    @Key("timezone")
    private Long timezone;

    @Key("population")
    private Long population;

    @Key("sunrise")
    private Long sunrise;

    @Key("sunset")
    private Long sunset;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coord getCoord() {
        return coord;
    }

    public String getCountry() {
        return country;
    }

    public Long getTimezone() {
        return timezone;
    }

    public Long getPopulation() {
        return population;
    }

    public Long getSunrise() {
        return sunrise;
    }

    public Long getSunset() {
        return sunset;
    }
}
