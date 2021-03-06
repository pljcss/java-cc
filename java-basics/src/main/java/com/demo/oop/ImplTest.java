package com.demo.oop;

/**
 * 在java类中实现不同接口的同名方法时，该方法属于哪个接口
 *
 * @author cs
 * @version 1.0
 * @date 2020/10/4 5:39 下午
 */
public class ImplTest implements Demo1, Demo2{
    public static void main(String[] args) {
        Demo1 d1 = new ImplTest();

        Demo1 d2 = new ImplTest();

        d1.test();
        d2.test();
    }

    @Override
    public void test() {
        System.out.println("who??");
    }

    @Override
    public void d2() {
        System.out.println("Demo2: d2");
    }

    @Override
    public void d1() {
        System.out.println("Demo1: d1");
    }
}

interface Demo1 {
    void test();
    void d1();
}

interface Demo2 {
    void test();
    void d2();
}