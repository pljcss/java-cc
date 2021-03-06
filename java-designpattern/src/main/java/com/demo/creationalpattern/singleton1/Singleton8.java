package com.demo.designpattern.creationalpattern.singleton1;

/**
 * 枚举写法（推荐用）
 * @author cs
 * @version 1.0
 * @date 2020/10/22 12:24 上午
 */
public enum  Singleton8 {
    INSTANCE;

    public void method1() {
        System.out.println("hello enum!");
    }
}

class TestDemo {
    public static void main(String[] args) {
        // 单例模式枚举写法
        Singleton8.INSTANCE.method1();
    }
}