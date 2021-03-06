package com.demo.thread.flowcontrol.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition 基本用法
 * @author cs
 * @date 2020/10/27 2:30 下午
 */
public class ConditionDemo {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    void method1() {
        lock.lock();
        try {
            System.out.println("条件不满足，开始等待。。。");
            condition.await();
            System.out.println("条件满足，开始执行！！！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void method2() {
        lock.lock();
        try {
            System.out.println("准备工作安成，唤醒其他线程");
            condition.signal();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ConditionDemo conditionDemo = new ConditionDemo();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                conditionDemo.method1();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                conditionDemo.method2();
            }
        });

        t1.start();
        Thread.sleep(2*1000);
        t2.start();

    }
}
