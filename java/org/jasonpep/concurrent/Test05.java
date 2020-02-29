package org.jasonpep.concurrent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * description: Test05
 * date: 2020/3/1 01:43
 * author: JASONPEP
 * version: 1.0
 */
public class Test05 {

    // 可用来控制 资源数量 限流等， 类似令牌桶 但是回归还
    private static Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                boolean t = semaphore.tryAcquire(3, TimeUnit.SECONDS);
                if (t) {
                    System.out.println("t1 获取了许可");
                    Thread.sleep(2000);
                    semaphore.release();
                    System.out.println("t1 归还了许可");
                } else {
                    System.out.println("t1 获取许可超时");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                boolean t = semaphore.tryAcquire(3, TimeUnit.SECONDS);
                if (t) {
                    System.out.println("t2 获取了许可");
                    Thread.sleep(2000);
                    semaphore.release();
                    System.out.println("t2 归还了许可");
                } else {
                    System.out.println("t2 获取许可超时");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                boolean t = semaphore.tryAcquire(3, TimeUnit.SECONDS);
                if (t) {
                    System.out.println("t3 获取了许可");
                    semaphore.release();
                    System.out.println("t3 归还了许可");
                } else {
                    System.out.println("t3 获取许可超时");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }
}
