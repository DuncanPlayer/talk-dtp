package com.dtp.adapter.webserver.handler;

import com.dtp.adapter.TpHandler;
import com.dtp.common.ApplicationContextHolder;
import com.dtp.common.config.DtpProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;

import java.util.concurrent.Executor;

/**
 * AbstractWebServerTpHandler
 *
 * @author 方便面
 * @date 2022/5/1
 */
@Slf4j
public abstract class AbstractWebServerTpHandler implements TpHandler, ApplicationListener<ServletWebServerInitializedEvent> {

    protected volatile Executor webServerExecutor;

    @Override
    public void onApplicationEvent(ServletWebServerInitializedEvent event) {
        try {
            DtpProperties dtpProperties = ApplicationContextHolder.getBean(DtpProperties.class);
            updateTp(dtpProperties);
        } catch (Exception e) {
            log.error("Init web server thread pool failed.", e);
        }
    }

    @Override
    public Executor getTp() {
        if (webServerExecutor == null) {
            synchronized (AbstractWebServerTpHandler.class) {
                if (webServerExecutor == null) {
                    ApplicationContext applicationContext = ApplicationContextHolder.getInstance();
                    WebServer webServer = ((WebServerApplicationContext) applicationContext).getWebServer();
                    webServerExecutor = doGetTp(webServer);
                }
            }
        }
        return webServerExecutor;
    }

    /**
     * Get thread pool.
     *
     * @param webServer webServer
     * @return the Executor instance
     */
    protected abstract Executor doGetTp(WebServer webServer);

}
