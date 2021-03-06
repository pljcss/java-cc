package com.demo.thread.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 这种情况下 SimpleDateFormat 安全，因为每个线程都会有一个 SimpleDateFormat 对象
 *      但是会有1000个 SimpleDateFormat 对象
 *
 * @author cs
 * @date 2020/10/22 3:12 下午
 */
public class ThreadLocalNormal1 {
    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        // 线程1
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    String s = dataFormat(finalI);
                    System.out.println(Thread.currentThread().getName() + " " + s);
                }
            });
        }

        threadPool.shutdown();

    }


    public static String dataFormat(int seconds) {
        // 参数的单位是毫秒
        Date date = new Date(1000 * seconds);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        return sdf.format(date);
    }
}
