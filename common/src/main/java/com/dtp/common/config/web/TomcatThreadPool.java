package com.dtp.common.config.web;

import lombok.Data;

/**
 * TomcatThreadPool
 *
 * @author 方便面
 * @date 2022/5/1
 */
@Data
public class TomcatThreadPool {

    /**
     * Maximum amount of worker threads.
     */
    private int max = 200;

    /**
     * Minimum amount of worker threads.
     */
    private int minSpare = 10;
}
