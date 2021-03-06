package com.demo.thread.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 这种情况SimpleDateFormat 线程不安全的情况，会打印出重复的时间（线程不安全）
 *    解决方式
 *      1、加锁，synchronized，但是效率低
 *      2、更好的解决方式就是 ThreadLocal
 *
 * @author cs
 * @date 2020/10/22 3:12 下午
 */
public class ThreadLocalNormal2 {
    /**
     * 线程不安全情况
     */
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        // 线程1
        for (int i = 0; i < 1001; i++) {
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
        return sdf.format(date);
    }
}
