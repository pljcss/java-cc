package com.demo.thread;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/21 12:16 上午
 */
public class SleepInterrupt {
    public static void main(String[] args) throws InterruptedException {
        SleepRunner sleepRunner = new SleepRunner();
        Thread thread = new Thread(sleepRunner);

        thread.start();
        Thread.sleep(5*1000);
        thread.interrupt();

    }
}

class SleepRunner implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("我被中断了！");
                e.printStackTrace();
            }
        }
    }
}