package com.kwabenaberko.openweathermap;

import com.kwabenaberko.openweathermap.slice.MainAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.bundle.IBundleManager;

public class MainAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(MainAbilitySlice.class.getName());

        if (verifyCallingPermission("ohos.permission.LOCATION") != IBundleManager.PERMISSION_GRANTED) {
            requestPermissionsFromUser(new String[] { "ohos.permission.LOCATION" } , 1);
        }
    }
}
