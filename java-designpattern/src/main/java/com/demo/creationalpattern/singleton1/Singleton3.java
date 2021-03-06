package com.demo.designpattern.creationalpattern.singleton1;

/**
 * 懒汉式（线程不安全）(不可用)
 * @author cs
 * @version 1.0
 * @date 2020/10/21 11:59 下午
 */
public class Singleton3 {
    private static Singleton3 instance;

    private Singleton3() {}

    public static Singleton3 getInstance() {
        if (instance == null) {
            return new Singleton3();
        }
        return instance;
    }
}
