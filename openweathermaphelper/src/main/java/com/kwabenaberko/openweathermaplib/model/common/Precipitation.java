package com.kwabenaberko.openweathermaplib.model.common;

import com.google.api.client.util.Key;

public class Precipitation {

    @Key("1h")
    private Double oneHour;

    @Key("3h")
    private Double threeHour;

    public Double getOneHour() {
        return oneHour;
    }

    public Double getThreeHour() {
        return threeHour;
    }
}
