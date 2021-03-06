package com.demo.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author cs
 * @date 2020/10/26 11:39 上午
 */
public class StreamDemo {
    public static void main(String[] args) {
        // 1 Collection接口中的 stream() 和 parallelStream() 方法
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        // 遍历
        Stream<String> stream = list.stream();
        stream.forEach(s -> System.out.println(s));

        // 2 Arrays工具类的 stream() 方法
        String[] strings = {"aaa", "bbb", "ccc"};
        Stream<String> stream1 = Arrays.stream(strings);
        stream1.forEach(System.out::println);


    }
}
