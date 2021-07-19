package com.minkiapps.android.hybrid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;

import com.huawei.ohos.localability.AbilityUtils;

public class ConnectionUtil {
    private static final String TAG = "ConnectionUtil";

    /**
     * 用于链接本地PA
     * @param context
     * @param connection
     */
    public static void connectAbility(Context context, String bundleName,
        String paName, ServiceConnection connection) {
        Intent aaIntent = new Intent();
        ComponentName component = new ComponentName(bundleName, paName);
        aaIntent.setComponent(component);
        try {
            AbilityUtils.connectAbility(context, aaIntent, connection);
        } catch (IllegalArgumentException e) {
            Log.e(TAG, "connectAbility: " + "abilility can't be found " + e.getMessage());
        }
    }

    /**
     * 断开PA链接
     * @param context
     * @param connection
     */
    public static void disconnectAbility(Context context, ServiceConnection connection) {
        AbilityUtils.disconnectAbility(context, connection);
    }

    public static void startAbility(Context context, String bundelName, String className) {
        Intent intent = new Intent();
        ComponentName cmp = new ComponentName(bundelName, className);
        intent.setComponent(cmp);
        AbilityUtils.startAbility(context, intent);
    }

    public static void startAbilityForResult(Context context, String bundelName,
        String className, int requestCode) {
        Intent intent = new Intent();
        ComponentName cmp = new ComponentName(bundelName, className);
        intent.setComponent(cmp);
        AbilityUtils.startAbilityForResult(context, intent, requestCode);
    }
}
