package org.jasonpep.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * description: Student
 * date: 2020/3/3 14:19
 * author: JASONPEP
 * version: 1.0
 */
public class Student implements Human, MethodInterceptor {

    public void sayHello() {
        System.out.println("hello");
    }

    public void eatFoods() {
        System.out.println("eating!!!");
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return methodProxy.invokeSuper(o, objects);
    }
}
