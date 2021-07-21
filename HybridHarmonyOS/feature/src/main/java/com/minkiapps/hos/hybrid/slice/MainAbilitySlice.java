package com.minkiapps.hos.hybrid.slice;

import com.minkiapps.hos.hybrid.AnotherAbility;
import com.minkiapps.hos.hybrid.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.Text;
import ohos.bundle.ElementName;
import ohos.distributedschedule.interwork.DeviceInfo;
import ohos.distributedschedule.interwork.DeviceManager;

import java.util.List;
import java.util.stream.Collectors;

import static com.minkiapps.hos.hybrid.MyApplication.ANDROID_PACKAGE_NAME;
import static com.minkiapps.hos.hybrid.MyApplication.ANDROID_MAIN_ABILITY_NAME;

public class MainAbilitySlice extends AbilitySlice {

    private static final String APP_GALLERY_PACKAGE_NAME = "com.huawei.appmarket";
    private static final String APP_GALLERY_MAIN_ACTIVITY = "com.huawei.appmarket.MainActivity";

    private static final String SOFA_SCORE_BUNDLE_NAME = "com.demo.pickem";
    private static final String SOFA_SCORE_ABILITY_NAME = "com.demo.pickem.MainAbility";

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        findComponentById(ResourceTable.Id_btn_ability_main_goto_another_ability)
                .setClickedListener(component -> startAbility(getBundleName(), AnotherAbility.class.getName()));

        findComponentById(ResourceTable.Id_btn_ability_main_goto_main_activity)
                .setClickedListener(component -> startActivity(ANDROID_PACKAGE_NAME, ANDROID_MAIN_ABILITY_NAME));

        findComponentById(ResourceTable.Id_i_ability_main_appgallery)
                .setClickedListener(component -> startActivity(APP_GALLERY_PACKAGE_NAME, APP_GALLERY_MAIN_ACTIVITY));

        findComponentById(ResourceTable.Id_i_ability_main_sofascore)
                .setClickedListener(component -> startAbility(SOFA_SCORE_BUNDLE_NAME, SOFA_SCORE_ABILITY_NAME));

        final String source = intent.getStringParam("EXTRA_SOURCE");
        if (source != null) {
            ((Text) findComponentById(ResourceTable.Id_t_ability_main_source)).setText(source);
        }

        final List<DeviceInfo> deviceList = DeviceManager.getDeviceList(DeviceInfo.FLAG_GET_ONLINE_DEVICE);
        if (!deviceList.isEmpty()) {
            ((Text) findComponentById(ResourceTable.Id_t_ability_main_device_list)).setText(
                    deviceList.stream()
                            .map(d -> d.getDeviceName() + ": " + d.getDeviceId())
                            .collect(Collectors.joining("\n"))
            );
        }
    }

    private void startAbility(final String bundleName, final String abilityName) {
        final Intent i = new Intent();

        final Operation operation = new Intent.OperationBuilder()
                .withBundleName(bundleName)
                .withAbilityName(abilityName)
                .build();

        //i.setOperation(operation);
        i.setElementName(bundleName, abilityName);
        i.addFlags(Intent.FLAG_ABILITYSLICE_MULTI_DEVICE);
        startAbility(i);
    }

    private void startActivity(final String packageName, final String activityName) {
        final Intent newIntent = new Intent();

        final Operation operation = new Intent.OperationBuilder()
                .withFlags(Intent.FLAG_NOT_OHOS_COMPONENT)
                .build();
        newIntent.setOperation(operation);

        final ElementName elementName = new ElementName("", packageName, activityName);
        newIntent.setElement(elementName);

        newIntent.setParam("EXTRA_SOURCE", "HarmonyOS");
        startAbility(newIntent);
    }
}
