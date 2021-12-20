package com.kwabenaberko.openweathermaplib.model.common;

import com.google.api.client.util.Key;

/**
 * Created by Kwabena Berko on 7/25/2017.
 */

public class Weather {

    @Key("id")
    private Long id;

    @Key("main")
    private String main;

    @Key("description")
    private String description;

    @Key("icon")
    private String icon;

    public Long getId() {
        return id;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }
}
