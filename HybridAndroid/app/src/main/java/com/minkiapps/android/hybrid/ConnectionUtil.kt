package com.minkiapps.android.hybrid

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import com.huawei.ohos.localability.AbilityUtils
import timber.log.Timber

object ConnectionUtil {

    /**
     * 用于链接本地PA
     * @param context
     * @param connection
     */
    fun connectAbility(
        context: Context, bundleName: String,
        paName: String, connection: ServiceConnection
    ) {
        val aaIntent = Intent()
        val component = ComponentName(bundleName, paName)
        aaIntent.component = component
        try {
            AbilityUtils.connectAbility(context, aaIntent, connection)
        } catch (e: IllegalArgumentException) {
            Timber.e("ConnectAbility: Ability can't be found ${e.message}")
        }
    }

    /**
     * 断开PA链接
     * @param context
     * @param connection
     */
    fun disconnectAbility(context: Context, connection: ServiceConnection) {
        AbilityUtils.disconnectAbility(context, connection)
    }

    fun startAbility(context: Context,
                     bundleName: String,
                     className: String) {
        val intent = Intent()
        intent.putExtra("EXTRA_SOURCE", "ANDROID")
        val cmp = ComponentName(bundleName, className)
        intent.component = cmp
        AbilityUtils.startAbility(context, intent)
    }

    fun startAbilityForResult(
        context: Context, bundleName: String,
        className: String, requestCode: Int
    ) {
        val intent = Intent()
        val cmp = ComponentName(bundleName, className)
        intent.component = cmp
        AbilityUtils.startAbilityForResult(context, intent, requestCode)
    }
}