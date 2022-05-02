package com.dtp.core.spring;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * EnableDynamicTp
 *
 * @author 方便面
 * @date 2022/5/2
 */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(DtpBeanDefinitionRegistrar.class)
public @interface EnableDynamicTp {

}
