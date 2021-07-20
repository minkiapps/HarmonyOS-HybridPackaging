package com.minkiapps.android.hybrid;

import android.app.Application;

/**
 * Application class must be Java for hybrid packaging plugin!
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AppInitialiserKt.initApp(this);
    }
}
