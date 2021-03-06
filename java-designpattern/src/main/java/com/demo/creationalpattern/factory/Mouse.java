package com.demo.creationalpattern.factory;

/**
 * 子类产品
 * @author cs
 * @version 1.0
 * @date 2020/10/13 11:15 上午
 */
public class Mouse implements Usb {
    @Override
    public void service() {
        System.out.println("鼠标开始工作。。。");
    }
}
