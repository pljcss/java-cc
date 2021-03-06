package com.demo.designpattern.creationalpattern.singleton;

/**
 * 单例第三种写法
 *
 * 静态内部类写法
 * @author cs
 * @version 1.0
 * @date 2020/10/13 12:22 下午
 */
public class SingletonLazy2 {
    private SingletonLazy2() {}

    private static class Holder {
        static SingletonLazy2 instance = new SingletonLazy2();
    }

    public static SingletonLazy2 getInstance() {
        return Holder.instance;
    }
}
