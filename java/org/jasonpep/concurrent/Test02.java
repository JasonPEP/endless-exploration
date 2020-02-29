package org.jasonpep.concurrent;

/**
 * description: Test02
 * date: 2020/3/1 01:11
 * author: JASONPEP
 * version: 1.0
 */
public class Test02 {

    private static Object obj1 = new Object();

    private static Object obj2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                synchronized (obj1) {
                    System.out.println("线程1 调用wait before");
                    obj1.wait();
                    System.out.println("线程1 调用wait after");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (obj1) {
                System.out.println("线程2 调用了 notify before");
                obj1.notify();
                System.out.println("线程2 调用了 notify after");
            }

        });

        t1.start();
        t2.start();
    }
}
