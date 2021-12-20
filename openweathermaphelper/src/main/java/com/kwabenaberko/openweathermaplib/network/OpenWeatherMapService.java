package com.kwabenaberko.openweathermaplib.network;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.kwabenaberko.openweathermaplib.model.currentweather.CurrentWeather;
import com.kwabenaberko.openweathermaplib.model.threehourforecast.ThreeHourForecast;

import java.net.HttpURLConnection;
import java.util.Map;

import static com.kwabenaberko.openweathermaplib.network.OpenWeatherMapClient.*;

/**
 * Created by Kwabena Berko on 7/25/2017.
 */

public class OpenWeatherMapService {
    private final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    private final JsonFactory JSON_FACTORY = new JacksonFactory();

    public CurrentWeather getWeather(Map<String, String> options) throws Exception {
        return (CurrentWeather) getWeatherData(createUrl(BASE_URL, CURRENT, options), CurrentWeather.class);
    }

    public ThreeHourForecast getWeatherForeCast(Map<String, String> options) throws Exception {
        return (ThreeHourForecast) getWeatherData(createUrl(BASE_URL, FORECAST, options), ThreeHourForecast.class);
    }

    private String createUrl(String baseUrl, String weathertype, Map<String, String> options) {
        StringBuilder query = new StringBuilder();
        for(Map.Entry<String, String> entry : options.entrySet()) {
            if (query.length() > 0) {
                query.append("&");
            }
            query.append(entry.getKey()).append("=").append(entry.getValue());
        }
        return baseUrl + weathertype + "?" + query;
    }

    /** URL for Dailymotion API. */
    public class WeatherUrl extends GenericUrl {
        public WeatherUrl(String encodedUrl) {
            super(encodedUrl);
        }
    }

    public Object getWeatherData(String link, Class objclass) throws Exception {
        HttpRequestFactory requestFactory =
                HTTP_TRANSPORT.createRequestFactory(
                        request -> request.setParser(new JsonObjectParser(JSON_FACTORY)));
        WeatherUrl url = new WeatherUrl(link);
        HttpRequest request = requestFactory.buildGetRequest(url);
        HttpResponse httpResponse = request.execute();
        if (httpResponse.isSuccessStatusCode())
            return httpResponse.parseAs(objclass);
        throw new Exception(handleCurrentWeatherResponse(httpResponse));
    }

    private String handleCurrentWeatherResponse(HttpResponse response){
        if (response.getStatusCode() == HttpURLConnection.HTTP_FORBIDDEN || response.getStatusCode() == HttpURLConnection.HTTP_UNAUTHORIZED){
            return "UnAuthorized. Please set a valid OpenWeatherMap API KEY.";
        }
        return response.getStatusMessage();
    }
}
