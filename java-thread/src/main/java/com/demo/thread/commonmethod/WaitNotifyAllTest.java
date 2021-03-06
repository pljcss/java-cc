package com.demo.thread.commonmethod;

/**
 * 3个线程，线程1 和线程2 首先被阻塞，线程3 唤醒它们
 * notify() notifyAll()区别
 *
 * 使用 notify() 的情况
 * 没有 sleep() 的情况
 *
 * @author cs
 * @version 1.0
 * @date 2020/10/20 9:27 下午
 */
public class WaitNotifyAllTest implements Runnable{
    private static final Object resourceA = new Object();

    @Override
    public void run() {
        synchronized (resourceA) {
            System.out.println(Thread.currentThread().getName() + "get resourceA lock...");

            try {
                System.out.println(Thread.currentThread().getName() + "wait start...");
                resourceA.wait();
                System.out.println(Thread.currentThread().getName() + "wait end...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new WaitNotifyAllTest());
        Thread t2 = new Thread(new WaitNotifyAllTest());

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    resourceA.notifyAll();
                    /* resourceA.notify(); */
                }
                System.out.println(Thread.currentThread().getName() + "notifyAll...");
            }
        });

        t1.start();
        t2.start();

        Thread.sleep(100);

        t3.start();
    }
}
