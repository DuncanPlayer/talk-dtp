package com.dtp.common.em;

import lombok.Getter;

/**
 * RejectedTypeEnum
 *
 * @author 方便面
 * @date 2022/5/1
 */
@Getter
public enum RejectedTypeEnum {

    /**
     * RejectedExecutionHandler type while triggering reject policy.
     */
    ABORT_POLICY("AbortPolicy"),

    CALLER_RUNS_POLICY("CallerRunsPolicy"),

    DISCARD_OLDEST_POLICY("DiscardOldestPolicy"),

    DISCARD_POLICY("DiscardPolicy");

    private final String name;

    RejectedTypeEnum(String name) {
        this.name = name;
    }

}
