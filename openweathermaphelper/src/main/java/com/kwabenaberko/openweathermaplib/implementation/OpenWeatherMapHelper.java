package com.kwabenaberko.openweathermaplib.implementation;

import com.kwabenaberko.openweathermaplib.implementation.callback.CurrentWeatherCallback;
import com.kwabenaberko.openweathermaplib.implementation.callback.ThreeHourForecastCallback;
import com.kwabenaberko.openweathermaplib.network.OpenWeatherMapClient;
import com.kwabenaberko.openweathermaplib.network.OpenWeatherMapService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kwabena Berko on 7/25/2017.
 */

public class OpenWeatherMapHelper {

    private static final String APPID = "appId";
    private static final String UNITS = "units";
    private static final String LANGUAGE = "lang";
    private static final String QUERY = "q";
    private static final String CITY_ID = "id";
    private static final String LATITUDE = "lat";
    private static final String LONGITUDE = "lon";
    private static final String ZIP_CODE = "zip";

    private final OpenWeatherMapService openWeatherMapService;
    private final Map<String, String> options;


    public OpenWeatherMapHelper(String apiKey){
        openWeatherMapService = OpenWeatherMapClient.getClient();
        options = new HashMap<>();
        options.put(APPID, apiKey == null ? "" : apiKey);
    }


    //SETUP METHODS
    public void setUnits(String units){
        options.put(UNITS, units);
    }
    public void setLanguage(String lang) {
        options.put(LANGUAGE, lang);
    }

//    CURRENT WEATHER METHODS
//    START

    //GET CURRENT WEATHER BY CITY NAME
    public void getCurrentWeatherByCityName(String city, final CurrentWeatherCallback callback){
        options.put(QUERY, city);
        try {
            callback.onSuccess(openWeatherMapService.getWeather(options));
        } catch (Exception e) {
            callback.onFailure(e);
        }
    }

    //GET CURRENT WEATHER BY CITY ID
    public void getCurrentWeatherByCityID(String id, final CurrentWeatherCallback callback){
        options.put(CITY_ID, id);
        try {
            callback.onSuccess(openWeatherMapService.getWeather(options));
        } catch (Exception e) {
            callback.onFailure(e);
        }
    }

    //GET CURRENT WEATHER BY GEOGRAPHIC COORDINATES
    public void getCurrentWeatherByGeoCoordinates(double latitude, double longitude, final CurrentWeatherCallback callback){
        options.put(LATITUDE, String.valueOf(latitude));
        options.put(LONGITUDE, String.valueOf(longitude));
        try {
            callback.onSuccess(openWeatherMapService.getWeather(options));
        } catch (Exception e) {
            callback.onFailure(e);
        }
    }

    //GET CURRENT WEATHER BY ZIP CODE

    public void getCurrentWeatherByZipCode(String zipCode, final CurrentWeatherCallback callback){
        options.put(ZIP_CODE, zipCode);
        try {
            callback.onSuccess(openWeatherMapService.getWeather(options));
        } catch (Exception e) {
            callback.onFailure(e);
        }
    }

//    CURRENT WEATHER METHODS
//    END

//    THREE HOUR FORECAST METHODS
//    START

    //GET THREE HOUR FORECAST BY CITY NAME
    public void getThreeHourForecastByCityName(String city, final ThreeHourForecastCallback callback){
        options.put(QUERY, city);
        try {
            callback.onSuccess(openWeatherMapService.getWeatherForeCast(options));
        } catch (Exception e) {
            callback.onFailure(e);
        }
    }

    //GET THREE HOUR FORECAST BY CITY ID
    public void getThreeHourForecastByCityID(String id, final ThreeHourForecastCallback callback){
        options.put(CITY_ID, id);
        try {
            callback.onSuccess(openWeatherMapService.getWeatherForeCast(options));
        } catch (Exception e) {
            callback.onFailure(e);
        }
    }

    //GET THREE HOUR FORECAST BY GEO C0ORDINATES
    public void getThreeHourForecastByGeoCoordinates(double latitude, double longitude, final ThreeHourForecastCallback callback){
        options.put(LATITUDE, String.valueOf(latitude));
        options.put(LONGITUDE, String.valueOf(longitude));
        try {
            callback.onSuccess(openWeatherMapService.getWeatherForeCast(options));
        } catch (Exception e) {
            callback.onFailure(e);
        }
    }

    //GET THREE HOUR FORECAST BY ZIP CODE
    public void getThreeHourForecastByZipCode(String zipCode, final ThreeHourForecastCallback callback){
        options.put(ZIP_CODE, zipCode);
        try {
            callback.onSuccess(openWeatherMapService.getWeatherForeCast(options));
        } catch (Exception e) {
            callback.onFailure(e);
        }
    }
}
