package com.minkiapps.android.hybrid

import timber.log.Timber

fun App.initApp() {
    Timber.plant(Timber.DebugTree())
}