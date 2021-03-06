package com.demo.thread.commonmethod;

/**
 * 证明 wait() 只释放当前那把锁
 * @author cs
 * @version 1.0
 * @date 2020/10/20 9:41 下午
 */
public class WaitNotifyReleaseLock {
    private static final Object objA = new Object();
    private static final Object objB = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (objA) {
                    System.out.println(Thread.currentThread().getName() + "获取A");
                    synchronized (objB) {
                        System.out.println(Thread.currentThread().getName() + "获取B");
                        try {
                            // 释放锁A
                            objA.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (objA) {
                    System.out.println(Thread.currentThread().getName() + "获取A");
                    synchronized (objB) {
                        System.out.println(Thread.currentThread().getName() + "获取B");
                    }
                }
            }
        });

        t1.start();

        Thread.sleep(100);

        t2.start();


    }
}
