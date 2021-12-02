package com.kwabenaberko.openweathermaplib.network;

/**
 * Created by Kwabena Berko on 7/25/2017.
 */

public class OpenWeatherMapClient {
    public static final String BASE_URL = "https://api.openweathermap.org";
    public static String CURRENT = "/data/2.5/weather";
    public static String FORECAST = "/data/2.5/forecast";
    private static OpenWeatherMapService weatherService = new OpenWeatherMapService();
    public static OpenWeatherMapService getClient(){
        return weatherService;
    }
}
