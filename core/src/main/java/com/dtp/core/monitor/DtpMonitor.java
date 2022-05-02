package com.dtp.core.monitor;

import cn.hutool.core.collection.CollUtil;
import com.dtp.common.config.DtpProperties;
import com.dtp.common.dto.ThreadPoolStats;
import com.dtp.common.em.NotifyTypeEnum;
import com.dtp.common.event.CollectEvent;
import com.dtp.core.DtpRegistry;
import com.dtp.core.convert.MetricsConverter;
import com.dtp.core.handler.CollectorHandler;
import com.dtp.core.notify.AlarmManager;
import com.dtp.core.support.ExecutorWrapper;
import com.dtp.core.thread.DtpExecutor;
import com.dtp.core.thread.NamedThreadFactory;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.core.Ordered;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static com.dtp.common.em.NotifyTypeEnum.CAPACITY;
import static com.dtp.common.em.NotifyTypeEnum.LIVENESS;
import static com.dtp.core.notify.AlarmManager.doAlarm;

/**
 * DtpMonitor
 *
 * @author 方便面
 * @date 2022/5/2
 */
@Slf4j
public class DtpMonitor implements ApplicationRunner, Ordered {

    private static final List<NotifyTypeEnum> ALARM_TYPES = Lists.newArrayList(LIVENESS, CAPACITY);

    private static final ScheduledExecutorService MONITOR_EXECUTOR = new ScheduledThreadPoolExecutor(
            1, new NamedThreadFactory("dtp-monitor", true));

    @Resource
    private DtpProperties dtpProperties;

    @Resource
    private ApplicationEventMulticaster applicationEventMulticaster;

    @Override
    public void run(ApplicationArguments args) {
        MONITOR_EXECUTOR.scheduleWithFixedDelay(this::run,
                0, dtpProperties.getMonitorInterval(), TimeUnit.SECONDS);
    }

    private void run() {
        List<String> dtpNames = DtpRegistry.listAllDtpNames();
        List<String> commonNames = DtpRegistry.listAllCommonNames();
        if (CollUtil.isEmpty(dtpNames) && CollUtil.isEmpty(commonNames)) {
            return;
        }

        boolean enabledCollect = dtpProperties.isEnabledCollect();
        dtpNames.forEach(x -> {
            DtpExecutor executor = DtpRegistry.getDtpExecutor(x);
            AlarmManager.triggerAlarm(() -> doAlarm(executor, ALARM_TYPES));
            if (enabledCollect) {
                ThreadPoolStats poolStats = MetricsConverter.convert(executor);
                doCollect(poolStats);
            }
        });

        if (!enabledCollect) {
            return;
        }
        commonNames.forEach(x -> {
            ExecutorWrapper wrapper = DtpRegistry.getCommonExecutor(x);
            ThreadPoolStats poolStats = MetricsConverter.convert(wrapper);
            doCollect(poolStats);
        });
        publishEvent();
    }

    private void doCollect(ThreadPoolStats threadPoolStats) {
        try {
            CollectorHandler.getInstance().collect(threadPoolStats, dtpProperties.getCollectorType());
        } catch (Exception e) {
            log.error("DynamicTp monitor, metrics collect error.", e);
        }
    }

    private void publishEvent() {
        CollectEvent event = new CollectEvent(this, dtpProperties);
        applicationEventMulticaster.multicastEvent(event);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 2;
    }
}
