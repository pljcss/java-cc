package com.demo.designpattern.creationalpattern.singleton;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/13 12:02 下午
 */
public class ClientDemo {
    public static void main(String[] args) {
        SingletonEager instance = SingletonEager.getInstance();
        SingletonEager instance1 = SingletonEager.getInstance();
        SingletonEager instance2 = SingletonEager.getInstance();

        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}
