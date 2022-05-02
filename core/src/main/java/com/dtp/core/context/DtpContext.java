package com.dtp.core.context;

import cn.hutool.core.collection.CollUtil;
import com.dtp.common.dto.AlarmInfo;
import com.dtp.common.dto.NotifyItem;
import com.dtp.common.dto.NotifyPlatform;
import com.dtp.core.thread.DtpExecutor;
import lombok.Builder;
import lombok.Data;
import lombok.val;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

/**
 * DtpContext
 *
 * @author 方便面
 * @date 2022/5/2
 */
@Builder
@Data
public class DtpContext {

    private DtpExecutor dtpExecutor;

    private List<NotifyPlatform> platforms;

    private NotifyItem notifyItem;

    private AlarmInfo alarmInfo;

    public NotifyPlatform getPlatform(String platform) {
        if (CollUtil.isEmpty(platforms)) {
            return null;
        }
        val map = platforms.stream()
                .collect(toMap(x -> x.getPlatform().toLowerCase(), Function.identity(), (v1, v2) -> v2));
        return map.get(platform.toLowerCase());
    }
}
