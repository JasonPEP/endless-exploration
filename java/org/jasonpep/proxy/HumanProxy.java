package org.jasonpep.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * description: HumanProxy
 * date: 2020/3/3 14:20
 * author: JASONPEP
 * version: 1.0
 */
public class HumanProxy implements InvocationHandler {

    private Object target;

    public HumanProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target, args);
    }
}
