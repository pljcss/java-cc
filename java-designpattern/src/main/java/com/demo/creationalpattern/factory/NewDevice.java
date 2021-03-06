package com.demo.creationalpattern.factory;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/13 11:53 上午
 */
public class NewDevice implements com.demo.designpattern.creationalpattern.factory.Usb {
    @Override
    public void service() {
        System.out.println("新设备开始通过。。。通过 usb.properties");
    }
}
