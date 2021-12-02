package com.kwabenaberko.openweathermap.slice;

import com.kwabenaberko.openweathermap.ResourceTable;
import com.kwabenaberko.openweathermaplib.constant.Languages;
import com.kwabenaberko.openweathermaplib.constant.Units;
import com.kwabenaberko.openweathermaplib.implementation.OpenWeatherMapHelper;
import com.kwabenaberko.openweathermaplib.implementation.callback.CurrentWeatherCallback;
import com.kwabenaberko.openweathermaplib.model.currentweather.CurrentWeather;
import com.kwabenaberko.openweathermaplib.util.LogUtil;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.Text;

public class MainAbilitySlice extends AbilitySlice {
    private String TAG = MainAbilitySlice.class.getSimpleName();
    private static OpenWeatherMapHelper helper;
    private static String weatherReport;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        this.findComponentById(ResourceTable.Id_TvUpdate).setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                updateWeather();
            }
        });
    }

    private void updateWeather() {
        //Instantiate Class With Your ApiKey As The Parameter
        OpenWeatherMapHelper helper = new OpenWeatherMapHelper(getString(ResourceTable.String_OPEN_WEATHER_MAP_API_KEY));

        //Set Units
        helper.setUnits(Units.IMPERIAL);

        //Set Languages
        helper.setLanguage(Languages.ENGLISH);


        new Thread(() -> helper.getCurrentWeatherByCityName("Accra", new CurrentWeatherCallback() {
            @Override
            public void onSuccess(CurrentWeather currentWeather) {
                weatherReport = "Coordinates: " + currentWeather.getCoord().getLat() + ", "+currentWeather.getCoord().getLon() +"\n"
                        +"Weather Description: " + currentWeather.getWeather().get(0).getDescription() + "\n"
                        +"Temperature: " + currentWeather.getMain().getTempMax()+"\n"
                        +"Wind Speed: " + currentWeather.getWind().getSpeed() + "\n"
                        +"City, Country: " + currentWeather.getName() + ", " + currentWeather.getSys().getCountry();
                getContext().getMainTaskDispatcher().asyncDispatch(new Runnable() {
                    @Override
                    public void run() {
                        ((Text)findComponentById(ResourceTable.Id_TvUpdate)).setText(weatherReport);
                    }
                })
            }

            @Override
            public void onFailure(Throwable throwable) {
                LogUtil.error(TAG, throwable.getMessage());
            }
        })).start();
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
