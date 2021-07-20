package com.minkiapps.android.hybrid

import timber.log.Timber

const val BUNDLE_NAME = "com.minkiapps.android.hybrid"
const val MAIN_ABILITY_NAME = "com.minkiapps.hos.hybrid.MainAbility"
const val ANOTHER_ABILITY_NAME = "com.minkiapps.hos.hybrid.AnotherAbility"

/**
 * move Kotlin code during App initialisation here
 */
fun App.initApp() {
    Timber.plant(Timber.DebugTree())
}