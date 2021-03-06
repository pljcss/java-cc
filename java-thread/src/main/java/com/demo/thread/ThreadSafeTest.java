package com.demo.thread;

import java.util.Arrays;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/15 11:16 上午
 */
public class ThreadSafeTest {
    private static int index = 0;

    public static void main(String[] args) {
        final String[] arr = new String[5];

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                arr[index] = "hello";
                index++;
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                arr[index] = "world";
                index++;
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.toString(arr));

    }
}
