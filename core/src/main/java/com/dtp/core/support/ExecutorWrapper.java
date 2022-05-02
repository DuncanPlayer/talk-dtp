package com.dtp.core.support;

import lombok.Data;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * ExecutorWrapper
 *
 * @author 方便面
 * @date 2022/5/2
 */
@Data
public class ExecutorWrapper {

    private String threadPoolName;

    private ThreadPoolExecutor executor;
}
