package org.jasonpep.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * description: Test01
 * date: 2020/2/26 23:14
 * author: JASONPEP
 * version: 1.0
 */
public class Test01 {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                System.out.println("线程1 开始抢锁");
                lock.lock();
                System.out.println("线程1 取到了锁");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("线程2 开始抢锁");
                lock.lock();
                System.out.println("线程2 拿到了锁");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

    }

}
