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
import ohos.agp.components.TextField;
import ohos.bundle.IBundleManager;
import ohos.location.Location;
import ohos.location.Locator;
import ohos.location.LocatorCallback;
import ohos.location.RequestParam;

public class MainAbilitySlice extends AbilitySlice {
    private String TAG = MainAbilitySlice.class.getSimpleName();
    private String weatherReport;
    private double mLatitude;
    private double mLongitude;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        this.findComponentById(ResourceTable.Id_btnCityWeather).setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                updateWeather();
            }
        });
        this.findComponentById(ResourceTable.Id_btnLiveLoc).setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                if (verifySelfPermission("ohos.permission.LOCATION") == IBundleManager.PERMISSION_GRANTED) {
                    getLocation();
                    if (mLatitude > 0)
                        updateWeather2();
                }
            }
        });
    }

    private void updateWeather() {
        //Instantiate Class With Your ApiKey As The Parameter
        String cityName = ((TextField)findComponentById(ResourceTable.Id_TvCity)).getText();

        OpenWeatherMapHelper helper = new OpenWeatherMapHelper(getString(ResourceTable.String_OPEN_WEATHER_MAP_API_KEY));

        //Set Units
        helper.setUnits(Units.IMPERIAL);

        //Set Languages
        helper.setLanguage(Languages.ENGLISH);


        new Thread(() -> helper.getCurrentWeatherByCityName(cityName, new CurrentWeatherCallback() {
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
                        ((Text)findComponentById(ResourceTable.Id_TvCityDetails)).setText(weatherReport);
                    }
                });
            }

            @Override
            public void onFailure(Throwable throwable) {
                LogUtil.error(TAG, throwable.getMessage());
            }
        })).start();
    }

    private void updateWeather2() {
        OpenWeatherMapHelper helper = new OpenWeatherMapHelper(getString(ResourceTable.String_OPEN_WEATHER_MAP_API_KEY));

        //Set Units
        helper.setUnits(Units.IMPERIAL);

        //Set Languages
        helper.setLanguage(Languages.ENGLISH);


        new Thread(() -> helper.getCurrentWeatherByGeoCoordinates(mLatitude, mLongitude, new CurrentWeatherCallback() {
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
                        ((Text)findComponentById(ResourceTable.Id_TvLocDetails)).setText(weatherReport);
                    }
                });
            }

            @Override
            public void onFailure(Throwable throwable) {
                LogUtil.error(TAG, throwable.getMessage());
            }
        })).start();
    }

    private void getLocation() {
        Locator locator = new Locator(this);
        Location cachedLocation = locator.getCachedLocation();

        if (cachedLocation != null){
            mLatitude = cachedLocation.getLatitude();
            mLongitude = cachedLocation.getLongitude();
        } else {
            RequestParam requestParam = new RequestParam(RequestParam.PRIORITY_ACCURACY, 0, 0);
            locator.requestOnce(requestParam, new MyLocatorCallback());
        }

    }

    public class MyLocatorCallback implements LocatorCallback {
        @Override
        public void onLocationReport(Location location) {
            mLatitude = location.getLatitude();
            mLongitude = location.getLongitude();
            if (mLatitude > 0)
                updateWeather2();
        }

        @Override
        public void onStatusChanged(int type) {
            System.out.println("onStatusChanged");
        }

        @Override
        public void onErrorReport(int type) {
            System.out.println("onErrorReport");
        }
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
