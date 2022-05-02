package com.dtp.common.util;

import cn.hutool.core.collection.CollUtil;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * StreamUtil
 *
 * @author 方便面
 * @date 2022/5/2
 */
public class StreamUtil {

    private StreamUtil() {}

    public static <P, O> Map<O, P> toMap(Collection<P> coll, Function<P, O> key) {
        if (CollUtil.isEmpty(coll) || Objects.isNull(key)) {
            return Collections.emptyMap();
        }

        return coll.stream().collect(Collectors.toMap(key, Function.identity(), (v1, v2) -> v2));
    }
}
