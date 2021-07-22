package com.minkiapps.hos.hybrid;

import com.minkiapps.hos.hybrid.slice.MainAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.aafwk.ability.ProviderFormInfo;
import ohos.aafwk.content.Operation;
import ohos.agp.components.ComponentProvider;
import ohos.bundle.IBundleManager;
import ohos.event.intentagent.IntentAgent;
import ohos.event.intentagent.IntentAgentConstant;
import ohos.event.intentagent.IntentAgentHelper;
import ohos.event.intentagent.IntentAgentInfo;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;
import ohos.security.SystemPermission;

import java.util.ArrayList;
import java.util.List;

public class MainAbility extends Ability {

    private static final HiLogLabel TAG = new HiLogLabel(HiLog.DEBUG, 0x0, MainAbility.class.getName());

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(MainAbilitySlice.class.getName());

        if (verifySelfPermission(SystemPermission.DISTRIBUTED_DATASYNC) != IBundleManager.PERMISSION_GRANTED) {
            //申请权限之后需要到Ability处理权限请求结果
            requestPermissionsFromUser(new String[]{SystemPermission.DISTRIBUTED_DATASYNC}, 0);
        }
    }

    @Override
    protected ProviderFormInfo onCreateForm(Intent intent) {
        HiLog.info(TAG, "onCreateForm");
        final ProviderFormInfo formInfo = new ProviderFormInfo(ResourceTable.Layout_form_image_with_information_widget_2_2, this);
        final ComponentProvider componentProvider = new ComponentProvider();
        componentProvider.setIntentAgent(ResourceTable.Id_btn_form_goto_activity, startAbilityIntentAgent());
        formInfo.mergeActions(componentProvider);
        return formInfo;
    }

    private IntentAgent startAbilityIntentAgent() {
        final Intent intent = new Intent();
        final Operation operation = new Intent.OperationBuilder()
                .withFlags(Intent.FLAG_NOT_OHOS_COMPONENT)
                .withDeviceId("")
                .withBundleName(MyApplication.ANDROID_PACKAGE_NAME)
                .withAbilityName(MyApplication.ANDROID_ANOTHER_ABILITY_NAME)
                .build();
        intent.setOperation(operation);
        final List<Intent> intentList = new ArrayList<>();
        intentList.add(intent);
        final List<IntentAgentConstant.Flags> flags = new ArrayList<>();
        flags.add(IntentAgentConstant.Flags.UPDATE_PRESENT_FLAG);
        final IntentAgentInfo paramsInfo = new IntentAgentInfo(10001,
                IntentAgentConstant.OperationType.START_ABILITY, flags, intentList, null);
        return IntentAgentHelper.getIntentAgent(this, paramsInfo);
    }

    @Override
    protected void onUpdateForm(long formId) {
        HiLog.info(TAG, "onUpdateForm");
        super.onUpdateForm(formId);
    }

    @Override
    protected void onDeleteForm(long formId) {
        HiLog.info(TAG, "onDeleteForm: formId=" + formId);
        super.onDeleteForm(formId);
    }

    @Override
    protected void onTriggerFormEvent(long formId, String message) {
        HiLog.info(TAG, "onTriggerFormEvent: " + message);
        super.onTriggerFormEvent(formId, message);
    }
}
