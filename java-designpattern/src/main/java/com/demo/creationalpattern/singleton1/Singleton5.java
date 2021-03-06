package com.demo.designpattern.creationalpattern.singleton1;

/**
 * 懒汉式（线程不安全）(不可用)
 * @author cs
 * @version 1.0
 * @date 2020/10/22 12:06 上午
 */
public class Singleton5 {
    private static Singleton5 instance;

    private Singleton5() {}

    public synchronized static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                instance = new Singleton5();
            }
        }
        return instance;
    }
}
