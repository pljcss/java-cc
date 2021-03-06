package com.demo.designpattern.creationalpattern.singleton1;

/**
 * 饿汉式（静态常量）（可用）
 * 优点
 *    简单、安全（在类被加载的时候就完成了初始化）
 *
 * @author cs
 * @version 1.0
 * @date 2020/10/21 11:54 下午
 */
public class Singleton1 {
    private static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {}

    public static Singleton1 getInstance() {
        return INSTANCE;
    }

}
