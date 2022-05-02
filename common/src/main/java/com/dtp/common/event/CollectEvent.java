package com.dtp.common.event;

import com.dtp.common.config.DtpProperties;
import org.springframework.context.ApplicationEvent;

/**
 * CollectEvent
 *
 * @author 方便面
 * @date 2022/5/1
 */
public class CollectEvent extends ApplicationEvent {

    private final DtpProperties dtpProperties;

    public CollectEvent(Object source, DtpProperties dtpProperties) {
        super(source);
        this.dtpProperties = dtpProperties;
    }

    public DtpProperties getDtpProperties() {
        return dtpProperties;
    }

}
