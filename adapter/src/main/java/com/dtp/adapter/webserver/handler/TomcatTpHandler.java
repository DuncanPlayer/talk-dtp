package com.dtp.adapter.webserver.handler;

import com.dtp.common.config.DtpProperties;
import com.dtp.common.config.web.TomcatThreadPool;
import com.dtp.common.dto.ThreadPoolStats;
import com.dtp.common.ex.DtpException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.boot.web.server.WebServer;

import java.util.Objects;
import java.util.concurrent.Executor;

import static com.dtp.common.constant.DynamicTpConst.PROPERTIES_CHANGE_SHOW_STYLE;

/**
 * TomcatTpHandler
 *
 * @author 方便面
 * @date 2022/5/1
 */
@Slf4j
public class TomcatTpHandler extends AbstractWebServerTpHandler {

    private static final String POOL_NAME = "tomcatWebServerTp";

    @Override
    protected Executor doGetTp(WebServer webServer) {
        TomcatWebServer tomcatWebServer = (TomcatWebServer) webServer;
        return tomcatWebServer.getTomcat().getConnector().getProtocolHandler().getExecutor();
    }

    @Override
    public void updateTp(DtpProperties dtpProperties) {
        TomcatThreadPool tomcatTp = dtpProperties.getTomcatTp();
        if (Objects.isNull(tomcatTp)) {
            return;
        }

        int oldMinSpare = convertAndGet().getCorePoolSize();
        int oldMax = convertAndGet().getMaximumPoolSize();

        convertAndGet().setCorePoolSize(tomcatTp.getMinSpare());
        convertAndGet().setMaximumPoolSize(tomcatTp.getMax());

        log.info("DynamicTp tomcatWebServerTp refreshed end, minSpare: [{}], max: [{}]",
                String.format(PROPERTIES_CHANGE_SHOW_STYLE, oldMinSpare, tomcatTp.getMinSpare()),
                String.format(PROPERTIES_CHANGE_SHOW_STYLE, oldMax, tomcatTp.getMax()));
    }

    @Override
    public ThreadPoolStats getPoolStats() {
        ThreadPoolExecutor executor = convertAndGet();
        return ThreadPoolStats.builder()
                .corePoolSize(executor.getCorePoolSize())
                .maximumPoolSize(executor.getMaximumPoolSize())
                .queueType(executor.getQueue().getClass().getSimpleName())
                .queueCapacity(executor.getQueue().size() + executor.getQueue().remainingCapacity())
                .queueSize(executor.getQueue().size())
                .queueRemainingCapacity(executor.getQueue().remainingCapacity())
                .activeCount(executor.getActiveCount())
                .taskCount(executor.getTaskCount())
                .completedTaskCount(executor.getCompletedTaskCount())
                .largestPoolSize(executor.getLargestPoolSize())
                .poolSize(executor.getPoolSize())
                .waitTaskCount(executor.getQueue().size())
                .poolName(POOL_NAME)
                .build();
    }

    private ThreadPoolExecutor convertAndGet() {
        Executor executor = getTp();
        if (Objects.isNull(executor)) {
            log.warn("Tomcat web server threadPool is null.");
            throw new DtpException("Tomcat web server threadPool is null.");
        }
        return (ThreadPoolExecutor) executor;
    }
}
