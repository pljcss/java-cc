package com.demo.creationalpattern.factory;

/**
 * 工厂类
 * 如果新增一个设备，则需要修改工厂类
 *
 * 使用反射优化工厂方法
 * @author cs
 * @version 1.0
 * @date 2020/10/13 11:19 上午
 */
public class UsbFactory {

    /**
     * 使用反射优化
     * @param type 完成的包名 com.demo.xxx
     * @return
     */
    public static Usb createUsb(String type) {
        Usb usb = null;
        Class<?> class1 = null;

        try {
            class1 = Class.forName(type);
            usb = (Usb) class1.newInstance();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return usb;
    }

    /**
     * 不灵活，每次添加新设备都需要修改该方法
     * @param type
     * @return
     */
    public static Usb createUsb1(String type) {
        if ("mouse".equalsIgnoreCase(type)) {
            return new Mouse();
        } else if ("keyboard".equalsIgnoreCase(type)) {
            return new Keyboard();
        } else if ("display".equalsIgnoreCase(type)) {
            return new Display();
        }

        return null;
    }
}
