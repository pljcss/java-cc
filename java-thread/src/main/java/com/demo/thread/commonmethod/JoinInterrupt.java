package com.demo.thread.commonmethod;

import java.util.concurrent.TimeUnit;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/21 10:05 上午
 */
public class JoinInterrupt {

    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mainThread.interrupt();
                System.out.println("t1 执行。。。");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            System.out.println("被中断了");
            e.printStackTrace();
        }


    }
}
