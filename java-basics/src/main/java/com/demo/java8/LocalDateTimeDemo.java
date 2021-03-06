package com.demo.java8;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

/**
 * @author cs
 * @date 2020/10/26 11:57 上午
 */
public class LocalDateTimeDemo {
    public static void main(String[] args) {
        // 1 创建本地时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.getYear());
        System.out.println(now.getMonth());
        System.out.println(now.getDayOfMonth());


    }
}
