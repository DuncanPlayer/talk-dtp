package com.dtp.core.support.wrapper;

/**
 * TaskWrapper
 *
 * @author 方便面
 * @date 2022/5/2
 */
@FunctionalInterface
public interface TaskWrapper {

    /**
     * Task wrapper name, for config
     * @return name
     */
    default String name() {
        return null;
    }

    /**
     * Enhance the given runnable.
     * @param runnable source runnable
     * @return target runnable
     */
    Runnable wrap(Runnable runnable);
}
