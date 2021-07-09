package com.minkiapps.android.hybrid;

import android.app.Application;
import android.widget.Toast;

/**
 * Application class must be Java for hybrid packaging plugin!
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Toast.makeText(this, "Launched from Android Launcher", Toast.LENGTH_SHORT).show();
    }
}
