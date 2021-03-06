package com.demo.thread.flowcontrol.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 使用2个CountDownLatch
 * 5个运动员准备好了，等待裁判的枪声才能一起跑； 当所有人到终点后，比赛结束
 * @author cs
 * @date 2020/10/27 1:28 下午
 */
public class CountDownLatchDemo2Plus {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(5);
        
        ExecutorService service = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            int no = i + 1;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("No." + no + " 号准备完毕，等待发枪...");
                    try {
                        begin.await();
                        System.out.println("No. " + no + " 号开始跑步了");
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("No. " + no + " 跑到终点了");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        end.countDown();
                    }
                }
            };

            service.submit(runnable);
        }

        // 裁判员检查发令枪
        System.out.println("等待裁判员检查发令枪...");
        Thread.sleep(5 * 1000);
        System.out.println("发令枪响，开始比赛！");
        begin.countDown();

        // 裁判等待5个运动员跑到终点
        end.await();
        System.out.println("所有人到达终点，比赛结束！");

        service.shutdown();
    }
}
