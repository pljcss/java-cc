package com.demo.thread;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/19 9:08 下午
 */
public class Test {
    public static void main(String[] args) {

        ArrayList<Object> objects = new ArrayList<>();

        objects.add(new Object());



        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable....");
            }
        }) {
            @Override
            public void run() {
                System.out.println("Thread.....");
            }
        };

        t1.start();

        


    }
}
