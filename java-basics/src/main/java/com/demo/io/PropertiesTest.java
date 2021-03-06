package com.demo.io;

import java.io.*;
import java.util.Properties;
import java.util.Set;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/12 2:44 下午
 */
public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();

        // 添加数据
        properties.setProperty("1", "111");
        properties.setProperty("2", "222");

        // 获取 值
        System.out.println(properties.getProperty("1"));

        // 遍历 （keySet、entrySet、stringPropertyNames）
        Set<String> propertyNames = properties.stringPropertyNames();
        for (String name : propertyNames) {
            System.out.println(name + " : " + properties.getProperty(name));
        }

        // 和流有关的方法
        // list 方法
        PrintWriter pw = new PrintWriter("tmp/pro.txt");
        properties.list(pw);
        pw.flush();
        pw.close();

        // store 方法
        FileOutputStream fos = new FileOutputStream("tmp/store.properties");
        properties.store(fos, "注释");
        fos.close();

        // load 方法
        Properties properties2 = new Properties();
        properties2.load(new FileInputStream("tmp/store.properties"));
        System.out.println(properties2.toString());



    }
}
