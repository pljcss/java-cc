package com.demo.creationalpattern.factory;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/13 11:17 上午
 */
public class Display implements Usb {
    @Override
    public void service() {
        System.out.println("显示器开始工作。。。");
    }
}
