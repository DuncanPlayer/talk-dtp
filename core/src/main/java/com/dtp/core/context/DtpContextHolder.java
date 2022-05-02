package com.dtp.core.context;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * DtpContextHolder
 *
 * @author 方便面
 * @date 2022/5/2
 */
public class DtpContextHolder {

    private static final TransmittableThreadLocal<DtpContext> CONTEXT = new TransmittableThreadLocal<>();

    private DtpContextHolder() {}

    public static void set(DtpContext dtpContext) {
        CONTEXT.set(dtpContext);
    }

    public static DtpContext get() {
        return CONTEXT.get();
    }

    public static void remove() {
        CONTEXT.remove();
    }
}
