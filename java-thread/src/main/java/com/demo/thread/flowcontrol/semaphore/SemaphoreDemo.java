package com.demo.thread.flowcontrol.semaphore;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;

/**
 * Semaphore 使用
 * @author cs
 * @date 2020/10/27 2:19 下午
 */
public class SemaphoreDemo {
    static Semaphore semaphore = new Semaphore(3, true);

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 100; i++) {
            service.submit(new Task());
        }

        service.shutdown();

        
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " 拿到了许可证");

            // 执行任务
            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " 释放许可证");
            semaphore.release();
        }
    }
}
