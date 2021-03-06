package com.demo.thread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 演示
 *   volatile不安全的情况
 *
 * @author cs
 * @version 1.0
 * @date 2020/10/19 5:07 下午
 */
public class VolatileNotSafe {
    public static void main(String[] args) throws Exception{
        BankAccount bankAccount = new BankAccount();

        ExecutorService pool = Executors.newFixedThreadPool(2);

        Future<?> submit = pool.submit(new Runnable() {
            @Override
            public void run() {
                bankAccount.add();
            }
        });

        Future<?> submit2 = pool.submit(new Runnable() {
            @Override
            public void run() {
                bankAccount.add();
            }
        });

        submit.get();
        submit2.get();


        pool.shutdown();

        System.out.println(bankAccount.getMoney());

    }

    /**
     * 显示创建线程
     *   使用Test注解，需要跑更多次才能跑出错误的情况
     * @throws Exception
     */
    @Test
    public void test1() throws Exception{
        BankAccount bankAccount = new BankAccount();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                bankAccount.add();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                bankAccount.add();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(bankAccount.getMoney());
    }
}

/**
 * volatile 修饰的属性
 */
class BankAccount {
    private volatile int money = 0;

    public int getMoney() {
        return money;
    }

    public void add() {
        for (int i = 0; i < 100000; i++) {
            money++;
        }
    }
}