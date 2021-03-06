package com.demo.designpattern.creationalpattern.singleton1;

/**
 * 静态内部类 （可用）
 *   线程安全，懒加载
 * @author cs
 * @version 1.0
 * @date 2020/10/22 12:19 上午
 */
public class Singleton7 {
    private Singleton7() {}

    private static class SingletonInstance {
        private static final Singleton7 INSTANCE = new Singleton7();
    }
    public static Singleton7 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
