package com.demo.thread.commonmethod;

/**
 * 两个线程交替打印 0~100的奇偶数
 *    synchronized 实现
 * @author cs
 * @version 1.0
 * @date 2020/10/20 10:23 下午
 */
public class PrintOddEvenSyn {
    private static int count = 0;
    private static Object lock = new Object();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                while (count < 100) {
                    synchronized (lock) {
                        if (count % 2 == 0) {
                            System.out.println(Thread.currentThread().getName() + "  " + count);
                            count++;
                        }
                    }
                }
            }
        }, "odd").start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (count < 100) {
                    synchronized (lock) {
                        if (count % 2 != 0) {
                            System.out.println(Thread.currentThread().getName() + "  " + count);
                            count++;
                        }
                    }
                }
            }
        }, "even").start();

    }
}
