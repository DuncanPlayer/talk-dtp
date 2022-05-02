package com.dtp.core.parser;

import com.dtp.common.em.ConfigFileTypeEnum;

import java.io.IOException;
import java.util.Map;

/**
 * AbstractConfigParser
 *
 * @author 方便面
 * @date 2022/5/2
 */
public abstract class AbstractConfigParser implements ConfigParser {

    @Override
    public boolean supports(ConfigFileTypeEnum type) {
        return this.type().contains(type);
    }

    @Override
    public Map<Object, Object> doParse(String content, String prefix) throws IOException {
        return doParse(content);
    }
}
