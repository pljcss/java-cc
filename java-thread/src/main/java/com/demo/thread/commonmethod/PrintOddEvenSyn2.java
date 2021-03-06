package com.demo.thread.commonmethod;


/**
 * 两个线程交替打印 0~100的奇偶数
 *   wait() notify() 实现
 * @author cs
 * @version 1.0
 * @date 2020/10/20 11:29 下午
 */
public class PrintOddEvenSyn2 {
    private static int count = 0;
    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        TurningRunner runner = new TurningRunner();
        Thread t1 = new Thread(runner, "偶");
        Thread t2 = new Thread(runner, "奇");
        t1.start();
        Thread.sleep(100);
        t2.start();
    }

    static class TurningRunner implements Runnable {
        @Override
        public void run() {
            while (count <= 100) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " : " + count++);
                    lock.notify();
                    if (count <= 100) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
