package com.demo.thread.flowcontrol.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多等一
 *
 * 5个运动员准备好了，等待裁判的枪声才能一起跑
 * @author cs
 * @date 2020/10/27 1:18 下午
 */
public class CountDownLatchDemo2 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);

        ExecutorService service = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            int no = i + 1;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("No." + no + " 号准备完毕，等待发枪...");
                    try {
                        latch.await();
                        System.out.println("No. " + no + " 号开始跑步了");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            service.submit(runnable);
        }

        // 裁判员检查发令枪
        System.out.println("等待裁判员检查发令枪...");
        Thread.sleep(5 * 1000);
        System.out.println("发令枪响，开始比赛！");
        latch.countDown();

        service.shutdown();
    }
}
