package com.demo.thread;

/**
 * 创建线程
 *      方式1：继承 Thread 类
 * @author cs
 * @version 1.0
 * @date 2020/10/14 10:08 下午
 */
public class ThreadCreateTest1 {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();

        t1.start();

        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }

}

/**
 * 线程类
 */
class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}