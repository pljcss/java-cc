package com.demo.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * Lock不会像 synchronized一样，异常的时候自动释放锁，因此最佳实战是，finally中释放锁，保证发生异常的时候锁一定会被释放
 *
 * @author cs
 * @version 1.0
 * @date 2020/10/20 2:52 下午
 *
 */
public class MustUnlock {
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
         lock.lock();
         try {
             // 获取本锁保护的资源
             System.out.println(Thread.currentThread().getName());
         } finally {
             lock.unlock();
         }
    }
}
