package com.demo.creationalpattern.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

/**
 * 客户端程序
 * @author cs
 * @version 1.0
 * @date 2020/10/13 11:21 上午
 */
public class ClientDemo {
    public static void main(String[] args) {
        System.out.println("====请输入要购买的产品======");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        // 需要使用 classloader
        InputStream resourceAsStream = ClientDemo.class.getClassLoader().getResourceAsStream("usb.properties");
        Properties properties = new Properties();

        System.out.println(resourceAsStream);
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Usb usb = UsbFactory.createUsb(properties.getProperty(String.valueOf(choice)));
        if (usb != null) {
            System.out.println("购买成功");
            usb.service();
        } else {
            System.out.println("购买失败");
        }


    }
}
