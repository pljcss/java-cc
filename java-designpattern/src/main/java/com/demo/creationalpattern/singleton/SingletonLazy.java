package com.demo.designpattern.creationalpattern.singleton;

/**
 * 单例第二种写法
 *
 * 懒汉式 单例模式
 *      1）首先创建一个对象，赋值为null
 *      2）私有化构造方法，外部不能创建对象
 *      3）通过一个公开的方法返回这个对象
 *
 * 优点
 *      1）生命周期短，节省空间，用到的时候才初始化
 * 缺点
 *      1）有线程安全问题
 *          解决办法：1、同步方法；2、同步代码块（可以加if提高效率）
 *
 * @author cs
 * @version 1.0
 * @date 2020/10/13 12:05 下午
 */
public class SingletonLazy {
    // 创建对象
    private static SingletonLazy instance=null;

    private SingletonLazy() {} // 私有化构造方法

    /**
     * 线程安全
     * 方式1：同步方法
     * @return
     */
    public static synchronized SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }

    /**
     * 线程安全
     * 方式1：同步代码块
     * @return
     */
    public static  SingletonLazy getInstance2() {
        if (instance == null) { // 提高效率
            synchronized (SingletonLazy.class) {
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }

    /**
     * 线程不安全
     * @return
     */
    public static SingletonLazy getInstanceNotSafe() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}
