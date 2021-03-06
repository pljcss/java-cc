package com.demo.creationalpattern.factory;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/13 11:16 上午
 */
public class Keyboard implements Usb {
    @Override
    public void service() {
        System.out.println("键盘开始工作。。。");
    }
}
