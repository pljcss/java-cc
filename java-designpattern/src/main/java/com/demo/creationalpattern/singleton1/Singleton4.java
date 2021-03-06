package com.demo.designpattern.creationalpattern.singleton1;

/**
 * 懒汉式（线程安全）(不推荐用)
 *   缺点：效率低
 *
 * @author cs
 * @version 1.0
 * @date 2020/10/22 12:03 上午
 */
public class Singleton4 {
    private static Singleton4 instance;

    private Singleton4() {}

    public synchronized static Singleton4 getInstance() {
        if (instance == null) {
            return new Singleton4();
        }
        return instance;
    }

}
