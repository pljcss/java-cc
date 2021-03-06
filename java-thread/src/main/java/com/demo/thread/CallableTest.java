package com.demo.thread;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Callable接口使用
 *   Callable与Runnable区别
 *      1）Callable接口中的call方法有返回值，Runnable接口中的run方法没有返回值
 *      2）Callable接口中的call方法有声明异常，Runnable接口中的run方法没有声明异常
 *
 * @author cs
 * @version 1.0
 * @date 2020/10/15 5:45 下午
 */
public class CallableTest {
    public static void main(String[] args) {

    }

    /**
     * 计算 1~100的和，使用 Callable
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void callableDemo() throws ExecutionException, InterruptedException {
        // 计算1~100的和
        // 1、创建Callable对象
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println(Thread.currentThread().getName() + " 开始计算...");
                int sum = 0;
                for (int i = 1; i <= 100; i++) {
                    sum += i;
                }
                return sum;
            }
        };

        // 2、把Callable对象转换成k可执行任务
        FutureTask<Integer> task = new FutureTask<>(callable);

        // 3、创建线程
        Thread t1 = new Thread(task);

        // 4、启动线程
        t1.start();

        // 5、获取结果，等待任务执行完毕才会返回
        Integer integer = task.get();
        System.out.println("result " + integer);
    }

    /**
     *  Callable配置线程池使用
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void callableDemo2() throws ExecutionException, InterruptedException {
        // 1、创建线程池
        ExecutorService es = Executors.newFixedThreadPool(1);
        // 2、提交任务，Future表示将要执行完任务的结果
        Future<Integer> submit = es.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println(Thread.currentThread().getName() + " 开始计算...");
                int sum = 0;
                for (int i = 0; i <= 100; i++) {
                    sum += i;
                }
                return sum;
            }
        });

        // 3、获取任务结果，等待任务执行完毕才会返回
        Integer integer = submit.get();
        System.out.println(integer);

        // 4、关闭线程池
        es.shutdown();
    }

    /**
     * 使用两个线程计算 1～100的和，1～50，51～100
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void add() throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = es.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println(Thread.currentThread().getName() + " 开始计算...");
                int sum = 0;
                for (int i = 0; i <= 50; i++) {
                    sum += i;
                }
                return sum;
            }
        });

        Future<Integer> future2 = es.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println(Thread.currentThread().getName() + " 开始计算...");
                int sum = 0;
                for (int i = 51; i <= 100; i++) {
                    sum += i;
                }
                return sum;
            }
        });

        int result = future1.get() + future2.get();
        System.out.println("result: " + result);

    }

}
