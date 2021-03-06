package com.demo.thread.jmm;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * 演示重排序
 * @author cs
 * @version 1.0
 * @date 2020/10/21 4:45 下午
 */
public class OutOfOrderExecution {
    private static int x=0, y = 0;
    private static int a=0, b = 0;


    public static void main(String[] args) throws InterruptedException {


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                a = 1;
                x = b;
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                b = 1;
                y = a;
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("x= " + x + " , y=" + y);
    }
}
