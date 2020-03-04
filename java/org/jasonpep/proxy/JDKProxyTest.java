package org.jasonpep.proxy;

import java.lang.reflect.Proxy;

/**
 * description: JDKProxyTest
 * date: 2020/3/3 14:18
 * author: JASONPEP
 * version: 1.0
 */
public class JDKProxyTest {

    public static void main(String[] args) {
        Student student = new Student();
        Human o = (Human) Proxy.newProxyInstance(student.getClass().getClassLoader(), student.getClass().getInterfaces(), new HumanProxy(student));
        o.sayHello();
        o.eatFoods();
    }

}
