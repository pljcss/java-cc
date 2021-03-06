package com.demo.jvm;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/16 1:25 下午
 */
public class MemoryAllocTest {
    public static void main(String[] args) {
        // 单位 M
        System.out.println(Runtime.getRuntime().totalMemory()/1024/1024);
        System.out.println(Runtime.getRuntime().freeMemory()/1024/1024);
        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024);
    }
}
