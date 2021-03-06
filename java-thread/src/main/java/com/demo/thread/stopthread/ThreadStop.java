package com.demo.thread.stopthread;

import java.util.concurrent.SynchronousQueue;

/**
 *
 * run()方法内没有sleep或wait方法时，停止线程
 * @author cs
 * @version 1.0
 * @date 2020/10/19 10:09 下午
 */
public class ThreadStop {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int num = 0;
                while (!Thread.currentThread().isInterrupted() && num <= Integer.MAX_VALUE / 2) {
                    if (num % 10000 == 0) {
                        System.out.println(num + "是10000的倍数....");
                    }
                    ++num;
                }
                System.out.println("任务结束");
            }
        });


        t1.start();

        Thread.sleep(1000);
        t1.interrupt();

    }
}
