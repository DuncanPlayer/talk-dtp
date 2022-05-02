package com.dtp.common.config.web;

import lombok.Data;

/**
 * JettyThreadPool
 *
 * @author 方便面
 * @date 2022/5/1
 */
@Data
public class JettyThreadPool {

    /**
     * Maximum number of threads.
     */
    private int max = 200;

    /**
     * Minimum number of threads.
     */
    private int min = 8;
}
