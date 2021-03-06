package com.demo.thread;

/**
 * a++ 问题
 * @author cs
 * @version 1.0
 * @date 2020/10/21 11:56 上午
 */
public class MultiThreadError {
    public static void main(String[] args) throws InterruptedException {
        Counter task = new Counter();
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(task.count);
    }


    /**
     * 计数器
     */
    static class Counter implements Runnable {
        private int count = 0;
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        }
    }
}

