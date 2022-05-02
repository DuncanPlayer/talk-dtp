package com.dtp.adapter.webserver.listener;

import com.dtp.adapter.TpHandler;
import com.dtp.adapter.webserver.handler.AbstractWebServerTpHandler;
import com.dtp.common.ApplicationContextHolder;
import com.dtp.common.event.RefreshEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;

/**
 * WebServerRefreshListener
 *
 * @author 方便面
 * @date 2022/5/1
 */
@Slf4j
public class WebServerRefreshListener implements ApplicationListener<RefreshEvent> {


    @Override
    public void onApplicationEvent(RefreshEvent event) {
        try {
            TpHandler webServerTpHandler = ApplicationContextHolder.getBean(AbstractWebServerTpHandler.class);
            webServerTpHandler.updateTp(event.getDtpProperties());
        } catch (Exception e) {
            log.error("DynamicTp refresh, update web server thread pool failed.", e);
        }
    }
}
