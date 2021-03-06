package com.demo.jvm;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/16 9:43 上午
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        String str = "";
        System.out.println(str.getClass().getClassLoader());

        Class<?> aClass = Class.forName("java.sql.Driver");
        System.out.println(aClass.getClassLoader());

        System.out.println(ClassLoaderTest.class.getClassLoader());
    }
}
