package com.dtp.core.notify.sms;

import com.dtp.common.dto.NotifyPlatform;
import com.dtp.core.notify.AbstractNotifier;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * AbstractSmsNotifier
 *
 * @author 方便面
 * @date 2022/5/2
 */
@Slf4j
public abstract class AbstractSmsNotifier extends AbstractNotifier {


    public void doSend(NotifyPlatform notifyPlatform, String title, String text, List<String> mobiles) {

    }

}
