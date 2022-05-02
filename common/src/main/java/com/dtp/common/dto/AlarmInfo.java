package com.dtp.common.dto;

import cn.hutool.core.date.DateUtil;
import com.dtp.common.em.NotifyTypeEnum;
import lombok.Builder;
import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AlarmInfo
 *
 * @author 方便面
 * @date 2022/5/2
 */
@Data
@Builder
public class AlarmInfo {

    private NotifyTypeEnum type;

    private String lastAlarmTime;

    private final AtomicInteger counter = new AtomicInteger(0);

    public void incCounter() {
        counter.incrementAndGet();
    }

    public void reset() {
        lastAlarmTime = DateUtil.now();
        counter.set(0);
    }

    public int getCount() {
        return counter.get();
    }
}
