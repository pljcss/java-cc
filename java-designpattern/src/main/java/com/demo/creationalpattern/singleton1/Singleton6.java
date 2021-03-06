package com.demo.designpattern.creationalpattern.singleton1;

/**
 * 双重检查（推荐面试使用）
 *    注意：instance 需要需要使用volatile修饰，防止重排序
 * @author cs
 * @version 1.0
 * @date 2020/10/22 12:13 上午
 */
public class Singleton6 {
    private volatile static Singleton6 instance;

    private Singleton6() {}

    public synchronized static Singleton6 getInstance() {
        if (instance == null) {
            synchronized (Singleton6.class) {
                if (instance == null) {
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}
