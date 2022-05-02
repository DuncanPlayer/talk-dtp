package com.dtp.common.util;

import com.dtp.common.ApplicationContextHolder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.env.Environment;

/**
 * CommonUtil
 *
 * @author 方便面
 * @date 2022/5/2
 */
public class CommonUtil {

    private CommonUtil() {}

    private static final String APP_NAME;

    static {
        Environment environment = ApplicationContextHolder.getEnvironment();
        String appName = environment.getProperty("spring.application.name");
        APP_NAME = StringUtils.isNoneBlank(appName) ? appName : "application";
    }

    public static String getAppName() {
        return APP_NAME;
    }
}
