package com.dtp.core.reject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * RejectedInvocationHandler
 *
 * @author 方便面
 * @date 2022/5/2
 */
public class RejectedInvocationHandler implements InvocationHandler,RejectedAware {

    private final Object target;

    public RejectedInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            ThreadPoolExecutor executor = (ThreadPoolExecutor) args[1];
            beforeReject(executor);

            return method.invoke(target, args);
        } catch (InvocationTargetException ex) {
            throw ex.getCause();
        }
    }
}
