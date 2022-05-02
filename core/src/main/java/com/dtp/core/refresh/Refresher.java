package com.dtp.core.refresh;

import com.dtp.common.em.ConfigFileTypeEnum;

/**
 * Refresher
 *
 * @author 方便面
 * @date 2022/5/2
 */
public interface Refresher {

    /**
     * Refresh with specify content.
     * @param content content
     * @param fileType file type
     */
    void refresh(String content, ConfigFileTypeEnum fileType);
}
