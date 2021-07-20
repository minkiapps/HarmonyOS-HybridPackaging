package com.minkiapps.hos.hybrid;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.bundle.ElementName;

import static com.minkiapps.hos.hybrid.MyApplication.*;

public class AnotherAbility extends Ability {

    @Override
    protected void onStart(final Intent intent) {
        super.onStart(intent);
        setUIContent(ResourceTable.Layout_ability_another);

        findComponentById(ResourceTable.Id_btn_ability_another_goto_another_activity).setClickedListener(component -> {
            startAnotherActivity();
        });
    }

    private void startAnotherActivity() {
        final Intent newIntent = new Intent();

        final Operation operation = new Intent.OperationBuilder()
                .withFlags(Intent.FLAG_NOT_OHOS_COMPONENT)
                .build();
        newIntent.setOperation(operation);

        final ElementName elementName = new ElementName("", ANDROID_BUNDLE_NAME, ANDROID_ANOTHER_ABILITY_NAME);
        newIntent.setElement(elementName);

        newIntent.setParam("EXTRA_SOURCE", "HarmonyOS");
        startAbility(newIntent);
    }
}
