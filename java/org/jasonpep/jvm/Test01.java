package org.jasonpep.jvm;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

/**
 * description: Test01
 * date: 2020/3/1 18:15
 * author: JASONPEP
 * version: 1.0
 */
public class Test01 {

    private static int _1GB = 1024 * 1024 * 8;

    private static List bbList = new LinkedList();

    private static List inList = new LinkedList();

    public static void main(String[] args) throws IOException, InterruptedException {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE / 2; i++) {

                int[] ints = new int[_1GB];
//                inList.add(ints);
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            while (true) {
                long begin = System.currentTimeMillis();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                System.out.println(Thread.currentThread().getName() + "线程状态为" + Thread.currentThread().getState().name() + "直在执行" + (System.currentTimeMillis() - begin));
            }
        });
        t2.start();
        t1.start();
        t1.join();
        System.out.println(bbList.size());
    }

    public static void test() throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_1GB);
        bbList.add(byteBuffer);
//        System.out.println("现在把 byteBuffer 放入bbList");
//        byteBuffer = null;
    }
}
