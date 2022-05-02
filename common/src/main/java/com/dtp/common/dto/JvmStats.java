package com.dtp.common.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * JvmStats
 *
 * @author 方便面
 * @date 2022/5/2
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class JvmStats extends Metrics {
    /**
     * Jvm max memory.
     */
    private String maxMemory;

    /**
     * Jvm total memory.
     */
    private String totalMemory;

    /**
     * Jvm free memory.
     */
    private String freeMemory;

    /**
     * Jvm usable memory.
     */
    private String usableMemory;
}
