package com.minkiapps.android.hybrid

import android.app.Application
import android.widget.Toast

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Toast.makeText(this, "Launched from Android Launcher", Toast.LENGTH_SHORT).show();
    }
}