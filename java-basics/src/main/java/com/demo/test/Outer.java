package com.demo.test;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/14 5:00 下午
 */
public class Outer {
    private String name = "trump";
    private int age = 18;

    // 静态成员
    private static int count = 100;

    /**
     * 静态内部类，和外部类相同
     */
    static class Inner {
        private String address = "上海";
        private String phone = "123";
        // 静态成员
        private static int num = 100;

        public void show() {
            // 调用外部类的属性，需要new后再访问（不能直接访问）
            Outer outer = new Outer();
            // 调用外部类的属性，静态属性
            System.out.println(outer.name);
            System.out.println(outer.age);
            System.out.println(Outer.count);
        }
    }
}
