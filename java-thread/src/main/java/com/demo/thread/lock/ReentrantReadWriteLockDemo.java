package com.demo.thread.lock;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author cs
 * @date 2020/10/22 10:49 下午
 */
public class ReentrantReadWriteLockDemo {
    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private static ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
    private static ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

    private void read() {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 获取到了读锁，正在读取。。。");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " 释放了读锁。。。");
            readLock.unlock();
        }
    }

    private void write() {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 获取到了写锁，正在读取。。。");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " 释放了写锁。。。");
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {

    }
}
