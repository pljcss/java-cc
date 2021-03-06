package com.demo.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 匿名内部类
 * Lambda表达式
 *
 * @author cs
 * @version 1.0
 * @date 2020/10/15 2:54 下午
 */
public class FunctionalInterface {
    public static void main(String[] args) {
        consumer(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        }, "hello world");


        consumer(t -> System.out.println(t), "hello world2");

        supplier(() -> new Random().nextInt(1000), 10);

        handlerString(s -> s.toUpperCase(), "hello world");

        ArrayList<String> strings = new ArrayList<>();
        strings.add("di");
        strings.add("hello");
        strings.add("hello");
        strings.add("he");
        filterNames(s -> s.contains("hello"), strings);
    }


    /**
     * Consumer 消费型接口
     * @param consumer
     * @param str
     */
    public static void consumer(Consumer<String> consumer, String str) {
        consumer.accept(str);
    }


    /**
     * Supplier 供给型接口
     * @param supplier
     * @param count
     */
    public static void supplier(Supplier<Integer> supplier, int count) {
        int[] arr = new int[count];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = supplier.get();
        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     * Function 函数型接口
     * @param function
     * @param string
     */
    public static void handlerString(Function<String, String> function, String string) {
        String apply = function.apply(string);
        System.out.println(apply);
    }

    /**
     * Predicate 断言型接口
     * @param predicate
     * @param list
     */
    public static void filterNames(Predicate<String> predicate, List<String> list) {
        for (String s : list) {
            if (predicate.test(s)) {
                System.out.println(s);
            }
        }
    }
}
