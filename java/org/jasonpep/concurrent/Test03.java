package org.jasonpep.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * description: Test03
 * date: 2020/3/1 01:28
 * author: JASONPEP
 * version: 1.0
 */
public class Test03 {

    // 流量阀门 当调用 await() 时 会阻塞直到 阈值=0
    private static CountDownLatch latch = new CountDownLatch(3);

    public static void main(String[] args) {
        // t1
        new Thread(() -> {
            try {
                System.out.println("t1 开始工作");
                Thread.sleep(1000);
                latch.countDown();
                System.out.println("t1 结束工作");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        // t2
        new Thread(() -> {
            try {
                System.out.println("t2 开始工作");
                Thread.sleep(1000);
                latch.countDown();
                System.out.println("t2 结束工作");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        // t3
        new Thread(() -> {
            try {
                System.out.println("t3 开始工作");
                Thread.sleep(1000);
                latch.countDown();
                System.out.println("t3 结束工作");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束");
    }
}
