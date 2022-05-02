package com.dtp.common.dto;

import com.dtp.common.em.NotifyPlatformEnum;
import com.dtp.common.em.NotifyTypeEnum;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * NotifyItem
 *
 * @author 方便面
 * @date 2022/5/1
 */
@Data
public class NotifyItem {

    /**
     * Notify platform names, see {@link NotifyPlatformEnum}
     */
    private List<String> platforms;

    /**
     * If enabled notify.
     */
    private boolean enabled = true;

    /**
     * Notify type, see {@link NotifyTypeEnum}
     */
    private String type;

    /**
     * Alarm threshold.
     */
    private int threshold;

    /**
     * Alarm interval, time unit（s）
     */
    private int interval = 120;

    /**
     * Default notify items.
     */
    private static final List<NotifyItem> DEFAULT_NOTIFY_ITEMS;

    static {
        NotifyItem changeNotify = new NotifyItem();
        changeNotify.setType(NotifyTypeEnum.CHANGE.getValue());

        NotifyItem livenessNotify = new NotifyItem();
        livenessNotify.setType(NotifyTypeEnum.LIVENESS.getValue());
        livenessNotify.setThreshold(80);

        NotifyItem capacityNotify = new NotifyItem();
        capacityNotify.setType(NotifyTypeEnum.CAPACITY.getValue());
        capacityNotify.setThreshold(80);

        NotifyItem rejectNotify = new NotifyItem();
        rejectNotify.setType(NotifyTypeEnum.REJECT.getValue());
        rejectNotify.setThreshold(1);

        NotifyItem runTimeoutNotify = new NotifyItem();
        runTimeoutNotify.setType(NotifyTypeEnum.RUN_TIMEOUT.getValue());
        runTimeoutNotify.setThreshold(1);

        NotifyItem queueTimeoutNotify = new NotifyItem();
        queueTimeoutNotify.setType(NotifyTypeEnum.QUEUE_TIMEOUT.getValue());
        queueTimeoutNotify.setThreshold(1);

        DEFAULT_NOTIFY_ITEMS = new ArrayList<>(6);
        DEFAULT_NOTIFY_ITEMS.add(livenessNotify);
        DEFAULT_NOTIFY_ITEMS.add(changeNotify);
        DEFAULT_NOTIFY_ITEMS.add(capacityNotify);
        DEFAULT_NOTIFY_ITEMS.add(rejectNotify);
        DEFAULT_NOTIFY_ITEMS.add(runTimeoutNotify);
        DEFAULT_NOTIFY_ITEMS.add(queueTimeoutNotify);
    }

    public static List<NotifyItem> getDefaultNotifyItems() {
        return DEFAULT_NOTIFY_ITEMS;
    }
}
