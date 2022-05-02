package com.dtp.common.util;

import org.slf4j.Logger;

/**
 * LogUtil
 *
 * @author 方便面
 * @date 2022/5/2
 */
public class LogUtil {

    private LogUtil() {}

    private static Logger monitorLogger = null;

    public static void init(Logger logger) {
        monitorLogger = logger;
    }

    public static Logger getMonitorLogger() {
        return monitorLogger;
    }
}
