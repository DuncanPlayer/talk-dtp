package com.dtp.core.notify;

import com.dtp.common.dto.DtpMainProp;
import com.dtp.common.em.NotifyTypeEnum;

import java.util.List;

/**
 * Notifier
 *
 * @author 方便面
 * @date 2022/5/2
 */
public interface Notifier {

    /**
     * Get the send platform name.
     *
     * @return platform
     */
    String platform();

    /**
     * Send change notify message.
     *
     * @param oldProp old properties
     * @param diffs the changed keys
     */
    void sendChangeMsg(DtpMainProp oldProp, List<String> diffs);

    /**
     * Send alarm message.
     * @param typeEnum notify type
     */
    void sendAlarmMsg(NotifyTypeEnum typeEnum);
}
