package com.minkiapps.hos.hybrid.slice;

import com.minkiapps.hos.hybrid.AnotherAbility;
import com.minkiapps.hos.hybrid.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.Text;
import ohos.bundle.ElementName;

import static com.minkiapps.hos.hybrid.MyApplication.ANDROID_BUNDLE_NAME;
import static com.minkiapps.hos.hybrid.MyApplication.ANDROID_MAIN_ABILITY_NAME;

public class MainAbilitySlice extends AbilitySlice {

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        findComponentById(ResourceTable.Id_btn_ability_main_goto_another_ability)
                .setClickedListener(component -> startAnotherAbility());

        findComponentById(ResourceTable.Id_btn_ability_main_goto_main_activity)
                .setClickedListener(component -> startMainActivity());

        final String source = intent.getStringParam("EXTRA_SOURCE");
        if(source != null) {
            ((Text)findComponentById(ResourceTable.Id_t_ability_main_source)).setText(source);
        }
    }

    private void startAnotherAbility() {
        final Intent i = new Intent();
        final Operation operation = new Intent.OperationBuilder()
                .withBundleName(getBundleName())
                .withAbilityName(AnotherAbility.class.getName())
                .build();

        i.setOperation(operation);
        startAbility(i);
    }

    private void startMainActivity() {
        final Intent newIntent = new Intent();

        final Operation operation = new Intent.OperationBuilder()
                .withFlags(Intent.FLAG_NOT_OHOS_COMPONENT)
                .build();
        newIntent.setOperation(operation);

        final ElementName elementName = new ElementName("", ANDROID_BUNDLE_NAME, ANDROID_MAIN_ABILITY_NAME);
        newIntent.setElement(elementName);

        newIntent.setParam("EXTRA_SOURCE", "HarmonyOS");
        startAbility(newIntent);
    }
}
