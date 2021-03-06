package com.demo.thread.flowcontrol.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 控制线程执行顺序
 *    1、可以使用join()
 *    2、CountDownLatch
 *
 * 一等多
 *
 * @author cs
 * @version 1.0
 * @date 2020/10/21 6:22 下午
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            int no = i + 1;
            Runnable runnable = new Runnable(){
                @Override
                public void run() {
                    try {
                        Thread.sleep((long) (Math.random() * 1000));
                        System.out.println("NO. " + no + " 完成了检查");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            };

            executorService.submit(runnable);
        }

        System.out.println("等待5个人检查完。。。");

        // 等待
        countDownLatch.await();

        System.out.println("所有人都完成了工作！");

        executorService.shutdown();
    }
}
