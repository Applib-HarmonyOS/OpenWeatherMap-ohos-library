package com.kwabenaberko.openweathermaplib.model.common;

import com.google.api.client.util.Key;

/**
 * Created by Kwabena Berko on 7/25/2017.
 */

public class Coord {

    @Key("lon")
    private double lon;

    @Key("lat")
    private double lat;

    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }
}
