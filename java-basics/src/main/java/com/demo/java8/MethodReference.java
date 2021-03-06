package com.demo.java8;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 方法引用
 *   对象::实例方法
 *   类::静态方法
 *   类::实例方法
 *   类::new
 *
 * @author cs
 * @date 2020/10/26 11:20 上午
 */
public class MethodReference {
    public static void main(String[] args) {
        // 1 对象::实例方法
        Consumer<String> consumer = s -> System.out.println(s.toUpperCase());
        consumer.accept("hello");

        Consumer<String> consumer2 = s -> System.out.println(s);
        Consumer<String> consumer3 = System.out::println;
        consumer3.accept("hello");

        // 2 类::静态方法
        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1, o2);
        Comparator<Integer> comparator2 = Integer::compare;

        // 3 类::实例方法

        // 4 类::new

    }
}
