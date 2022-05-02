package com.dtp.adapter;

import com.dtp.common.config.DtpProperties;
import com.dtp.common.dto.ThreadPoolStats;

import java.util.concurrent.Executor;

/**
 * TpHandler
 *
 * @author 方便面
 * @date 2022/5/1
 */
public interface TpHandler {

    /**
     * Get specify thread pool.
     *
     * @return the specify executor
     */
    Executor getTp();

    /**
     * Update thread pool with specify properties.
     *
     * @param dtpProperties the targeted dtpProperties
     */
    void updateTp(DtpProperties dtpProperties);

    /**
     * Get thread pool stats.
     *
     * @return the thread pool stats
     */
    ThreadPoolStats getPoolStats();

}
