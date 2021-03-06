package com.demo.thread.commonmethod;

/**
 * wait notify基本用法
 *   执行顺序
 *   wait会释放锁
 *
 * @author cs
 * @version 1.0
 * @date 2020/10/20 9:14 下午
 */
public class WaitNotifyTest {
    private static Object object = new Object();


    static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + "线程开始执行...");
                try {
                    // 释放锁
                    // 再次获取锁后，从此处开始执行
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "线程重新获取到锁...");
            }
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                object.notify();
                System.out.println(Thread.currentThread().getName() + "线程调用了notify...");
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        t1.start();
        // 保证 t1先执行
        Thread.sleep(100);

        t2.start();
    }


}
