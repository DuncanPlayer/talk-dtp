package com.dtp.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * ApplicationContextHolder
 *
 * @author 方便面
 * @date 2022/5/1
 */
public class ApplicationContextHolder  implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        return context.getBean(name, clazz);
    }

    public static <T> Map<String, T> getBeansOfType(Class<T> clazz) {
        return context.getBeansOfType(clazz);
    }

    public static ApplicationContext getInstance() {
        return context;
    }

    public static Environment getEnvironment() {
        return getInstance().getEnvironment();
    }

    public static ConfigurableListableBeanFactory getConfigurableListableBeanFactory() {
        return ((ConfigurableApplicationContext) context).getBeanFactory();
    }
}
