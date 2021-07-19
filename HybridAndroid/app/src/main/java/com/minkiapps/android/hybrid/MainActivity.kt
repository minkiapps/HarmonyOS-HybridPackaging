package com.minkiapps.android.hybrid

import android.app.Activity
import android.os.Bundle
import android.view.View
import timber.log.Timber

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        findViewById<View>(R.id.btnMainActivityHelloWorld).setOnClickListener {
            Timber.d("Starting MainAbility")
            ConnectionUtil.startAbility(
                this@MainActivity,
                BUNDLE_NAME,
                ABILITY_NAME
            )
        }
    }

    companion object {
        private const val BUNDLE_NAME = "com.minkiapps.android.hybrid"
        private const val ABILITY_NAME = "com.minkiapps.android.hybrid.MainAbility"
    }
}