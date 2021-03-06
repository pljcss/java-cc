package com.demo.designpattern.creationalpattern.singleton1;

/**
 * 饿汉式（静态代码块）（可用）
 * @author cs
 * @version 1.0
 * @date 2020/10/21 11:57 下午
 */
public class Singleton2 {
    private static final Singleton2 INSTANCE;

    static {
        INSTANCE = new Singleton2();
    }

    private Singleton2() {}

    public static Singleton2 getInstance() {
        return INSTANCE;
    }
}
