package com.dtp.core.monitor.collector;

import com.dtp.common.dto.ThreadPoolStats;

/**
 * AbstractCollector
 *
 * @author 方便面
 * @date 2022/5/2
 */
public abstract class AbstractCollector implements MetricsCollector {

    @Override
    public boolean support(String type) {
        return this.type().equalsIgnoreCase(type);
    }

    public abstract void collect(ThreadPoolStats threadPoolStats);
}
