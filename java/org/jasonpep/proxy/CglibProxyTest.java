package org.jasonpep.proxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * description: CglibProxyTest
 * date: 2020/3/3 14:34
 * author: JASONPEP
 * version: 1.0
 */
public class CglibProxyTest {

    public static void main(String[] args) {
        Student student = new Student();
        // 通过增强类 创建代理子类
        // cglib 户要通过字节码创建 实现类的子类 来实现代理
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(student);
        enhancer.setSuperclass(student.getClass());
        // enhancer.create 创建代理的子类 然后通过代理子类的 然后通过代理子类调用被代理父类的方法实现 动态代理
        Student student2 = (Student) enhancer.create();
        student2.eatFoods();
    }

}
