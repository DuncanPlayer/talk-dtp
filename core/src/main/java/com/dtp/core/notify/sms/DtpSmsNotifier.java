package com.dtp.core.notify.sms;

import cn.hutool.core.util.StrUtil;
import com.dtp.common.constant.SmsPushConst;
import com.dtp.common.dto.DtpMainProp;
import com.dtp.common.dto.NotifyPlatform;
import com.dtp.common.em.NotifyPlatformEnum;
import com.dtp.common.em.NotifyTypeEnum;
import com.dtp.core.context.DtpContext;
import com.dtp.core.context.DtpContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import java.util.List;

import static com.dtp.common.constant.SmsPushConst.*;

/**
 * DtpSmsNotifier
 *
 * @author 方便面
 * @date 2022/5/2
 */
@Slf4j
public class DtpSmsNotifier extends AbstractSmsNotifier {

    @Override
    public void sendChangeMsg(DtpMainProp oldProp, List<String> diffs) {
        DtpContext contextWrapper = DtpContextHolder.get();
        NotifyPlatform platform = contextWrapper.getPlatform(NotifyPlatformEnum.SMS.name());
        String content = buildNoticeContent(platform, SMS_CHANGE_NOTICE_TEMPLATE, oldProp, diffs);
        if (StringUtils.isBlank(content)) {
            return;
        }

        List<String> receivesList = StrUtil.split(platform.getReceivers(), ',');
        doSend(platform, SMS_NOTICE_TITLE, content, receivesList);
    }

    @Override
    public void sendAlarmMsg(NotifyTypeEnum typeEnum) {
        DtpContext contextWrapper = DtpContextHolder.get();
        NotifyPlatform platform = contextWrapper.getPlatform(NotifyPlatformEnum.SMS.name());
        String content = buildAlarmContent(platform, typeEnum, SMS_ALARM_TEMPLATE);
        if (StringUtils.isBlank(content)) {
            return;
        }

        List<String> receivesList = StrUtil.split(platform.getReceivers(), ',');
        doSend(platform, SMS_ALARM_TITLE, content, receivesList);
    }

    @Override
    protected Pair<String, String> getColors() {
        return new ImmutablePair<>(WARNING_COLOR, CONTENT_COLOR);
    }

    @Override
    public String platform() {
        return NotifyPlatformEnum.SMS.name().toLowerCase();
    }
}
