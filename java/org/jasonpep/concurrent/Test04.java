package org.jasonpep.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * description: Test04
 * date: 2020/3/1 01:34
 * author: JASONPEP
 * version: 1.0
 */
public class Test04 {

    // 并发屏障 需要等「parties」个线程都调用 await() 后 才会放开执行
    private static CyclicBarrier barrier = new CyclicBarrier(3, () -> {
        System.out.println("预备！开始！！");
    });

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                System.out.println("t1 准备起跑");
                barrier.await();
                System.out.println("t1 到达终点");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("t2 准备起跑");
                barrier.await();
                System.out.println("t2 到达终点");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("t3 准备起跑");
                barrier.await();
                System.out.println("t3 到达终点");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
