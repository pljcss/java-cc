package com.demo.designpattern.creationalpattern.singleton;

/**
 * 单例第一种写法
 *
 * 饿汉式 单例模式
 *      1）首先创建一个常量
 *      2）私有化构造方法，外部不能创建对象
 *      3）通过一个公开的方法返回这个对象
 * 优点
 *      1）线程安全
 * 缺点
 *      1）声明周期长，不使用也会创建
 *
 * @author cs
 * @version 1.0
 * @date 2020/10/13 12:00 下午
 */
public class SingletonEager {
    /**
     * 创建常量
     */
    private static final SingletonEager INSTANCE = new SingletonEager();

    private SingletonEager() {} // 私有化构造方法

    public static SingletonEager getInstance() {
        return INSTANCE;
    }
}
