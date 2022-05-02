package com.dtp.common.em;

import lombok.Getter;

/**
 * ConfigFileTypeEnum
 *
 * @author 方便面
 * @date 2022/5/2
 */
@Getter
public enum ConfigFileTypeEnum {

    /**
     * Config file type.
     */
    PROPERTIES("properties"),
    XML("xml"),
    JSON("json"),
    YML("yml"),
    YAML("yaml"),
    TXT("txt");

    private final String value;

    ConfigFileTypeEnum(String value) {
        this.value = value;
    }

    public static ConfigFileTypeEnum of(String value) {
        for (ConfigFileTypeEnum typeEnum : ConfigFileTypeEnum.values()) {
            if (typeEnum.value.equals(value)) {
                return typeEnum;
            }
        }
        return PROPERTIES;
    }
}
