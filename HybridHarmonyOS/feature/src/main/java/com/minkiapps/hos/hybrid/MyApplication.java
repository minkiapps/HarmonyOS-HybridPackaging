package com.minkiapps.hos.hybrid;

import ohos.aafwk.ability.AbilityPackage;

public class MyApplication extends AbilityPackage {

    public static final String ANDROID_BUNDLE_NAME = "com.minkiapps.android.hybrid";

    public static final String ANDROID_MAIN_ABILITY_NAME = "com.minkiapps.android.hybrid.MainActivity";
    public static final String ANDROID_ANOTHER_ABILITY_NAME = "com.minkiapps.android.hybrid.AnotherActivity";

    @Override
    public void onInitialize() {
        super.onInitialize();
    }
}
