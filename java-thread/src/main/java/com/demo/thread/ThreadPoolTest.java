package com.demo.thread;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * 创建线程池
 * Executor：线程池的根接口，一般不会直接用，因为只有一个execute() 方法
 *
 * ExecutorService：Executor的子接口，包含管理线程池的一些方法，如submit()、shutdown()
 *    ThreadPoolExecutor：ExecutorService的实现类，实际不会直接用，因为构造方法参数太多太复杂
 *    ScheduledThreadPoolExecutor：ThreadPoolExecutor子类
 *
 * Executors：创建线程池的工具类
 *    1）创建固定线程个数线程池
 *    2）创建缓存线程池，由任务的多少决定
 *    3）创建单个线程池，只有一个线程
 *    4）创建调度线程池，周期、定时执行
 * @author cs
 * @version 1.0
 * @date 2020/10/15 5:05 下午
 */
public class ThreadPoolTest {
    public static void main(String[] args) {

    }


    /**
     * 创建固定线程个数的线程池
     */
    @Test
    public void fixedThreadPool() {
        // 创建固定线程个数的线程池
        ExecutorService pool = Executors.newFixedThreadPool(4);
        // 创建任务
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " " + "execute...");
            }
        };
        // 提交任务
        pool.submit(task);
        pool.submit(task);
        pool.submit(task);
        pool.submit(task);
        pool.submit(task);
        // 关闭线程池
        pool.shutdown();
    }

    /**
     * 创建缓存线程池，创建的线程个数是由任务决定的
     */
    @Test
    public void cachedThreadPool() {
        ExecutorService pool = Executors.newCachedThreadPool();
        Runnable task = ()-> System.out.println(Thread.currentThread().getName() + " " + "execute...");

        pool.submit(task);
        pool.submit(task);
        pool.submit(task);
        pool.submit(task);
        pool.submit(task);
        pool.submit(task);

        pool.shutdown();

    }
}
