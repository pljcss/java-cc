package com.demo.thread.deadlock;


import java.util.concurrent.TimeUnit;

/**
 * 手写死锁
 *
 * @author cs
 * @date 2020/10/22 10:53 上午
 */
public class MustDeadLock implements Runnable{
    int flag = 1;
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        MustDeadLock task1 = new MustDeadLock();
        MustDeadLock task2 = new MustDeadLock();
        task1.flag = 1;
        task2.flag = 0;

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();

    }

    @Override
    public void run() {
        if (flag == 1) {
            synchronized (lock1) {
                System.out.println("t1 获取到lock1");
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("t1 获取到lock2");
                }
            }
        }

        if (flag == 0) {
            synchronized (lock2) {
                System.out.println("t2 获取到lock2");
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("t2 获取到lock1");
                }
            }
        }
    }
}
