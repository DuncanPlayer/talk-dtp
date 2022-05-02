package com.dtp.core.monitor.collector;

import cn.hutool.json.JSONUtil;
import com.dtp.common.dto.ThreadPoolStats;
import com.dtp.common.em.CollectorTypeEnum;
import com.dtp.common.util.LogUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * LogCollector
 *
 * @author 方便面
 * @date 2022/5/2
 */
@Slf4j
public class LogCollector extends AbstractCollector {

    @Override
    public void collect(ThreadPoolStats threadPoolStats) {
        String metrics = JSONUtil.toJsonStr(threadPoolStats);
        if (LogUtil.getMonitorLogger() == null) {
            log.error("Cannot find monitor logger...");
            return;
        }
        LogUtil.getMonitorLogger().info("{}", metrics);
    }

    @Override
    public String type() {
        return CollectorTypeEnum.LOGGING.name();
    }
}
