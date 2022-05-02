package com.dtp.core.support.wrapper;

import com.alibaba.ttl.TtlRunnable;

/**
 * TtlTaskWrapper
 *
 * @author 方便面
 * @date 2022/5/2
 */
public class TtlTaskWrapper implements TaskWrapper {

    private static final String NAME = "ttl";

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public Runnable wrap(Runnable runnable) {
        return TtlRunnable.get(runnable);
    }
}
