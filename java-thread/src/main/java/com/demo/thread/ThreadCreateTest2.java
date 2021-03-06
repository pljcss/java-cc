package com.demo.thread;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/14 10:28 下午
 */
public class ThreadCreateTest2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println(Thread.currentThread().getName() + i);
                }
            }
        }, "son-thread");

        t1.start();

        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}
