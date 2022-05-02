package com.dtp.core.support;

import java.lang.annotation.*;

/**
 * DynamicTp
 *
 * @author 方便面
 * @date 2022/5/2
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DynamicTp {

    /**
     * Thread pool name, has higher priority than @Bean annotated method name.
     *
     * @return name
     */
    String value() default "";
}
