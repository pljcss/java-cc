package com.demo.java8;

import java.util.Comparator;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/15 2:10 下午
 */
public class LambdaTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println(Thread.currentThread().getName() + "子线程执行了..."),
                "son-thread");
        t1.start();

        // Lambda 写法
        Runnable r1 = ()->{
            System.out.println("Lambda");
        };

        // 传统写法
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("-----");
            }
        };

    }
}
