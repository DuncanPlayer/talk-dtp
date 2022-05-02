package com.dtp.common.dto;

import lombok.Data;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * DtpMainProp
 *
 * @author 方便面
 * @date 2022/5/2
 */
@Data
public class DtpMainProp {

    private static final List<Field> FIELD_NAMES;

    static {
        FIELD_NAMES = Arrays.asList(DtpMainProp.class.getDeclaredFields());
    }

    private String dtpName;

    private int corePoolSize;

    private int maxPoolSize;

    private long keepAliveTime;

    private String queueType;

    private int queueCapacity;

    private String rejectType;

    private boolean allowCoreThreadTimeOut;

    public static List<Field> getMainProps() {
        return FIELD_NAMES;
    }
}
