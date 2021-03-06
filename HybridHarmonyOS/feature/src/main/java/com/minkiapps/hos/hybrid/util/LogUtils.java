package com.minkiapps.hos.hybrid.util;

import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

import java.util.Locale;

public class LogUtils {

    private static final String TAG_LOG = "iTranslate_LOG";

    private static final int DOMAIN_ID = 0x0001;

    private static final HiLogLabel LABEL_LOG = new HiLogLabel(HiLog.LOG_APP, DOMAIN_ID, LogUtils.TAG_LOG);

    private static final String LOG_FORMAT = "%{public}s: %{public}s";

    private LogUtils() {
    }

    /**
     * Print debug log
     *
     * @param tag log tag
     * @param msg log message
     */
    public static void d(String tag, String msg) {
        HiLog.debug(LABEL_LOG, LOG_FORMAT, tag, msg);
    }

    /**
     * Print info log
     *
     * @param tag log tag
     * @param msg log message
     */
    public static void i(String tag, String msg) {
        HiLog.info(LABEL_LOG, LOG_FORMAT, tag, msg);
    }

    /**
     * Print warn log
     *
     * @param tag log tag
     * @param msg log message
     */
    public static void w(String tag, String msg) {
        HiLog.warn(LABEL_LOG, LOG_FORMAT, tag, msg);
    }

    /**
     * Print error log
     *
     * @param tag log tag
     * @param msg log message
     */
    public static void e(String tag, String msg) {
        HiLog.error(LABEL_LOG, LOG_FORMAT, tag, msg);
    }

    public static void e(String tag, final String format, Object... args) {
        String buffMsg = String.format(Locale.ROOT, format, args);
        HiLog.error(LABEL_LOG, LOG_FORMAT, tag, buffMsg);
    }

    public static void i(String tag, final String format, Object... args) {
        String buffMsg = String.format(Locale.ROOT, format, args);
        HiLog.info(LABEL_LOG, LOG_FORMAT, tag, buffMsg);
    }
}
