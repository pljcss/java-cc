package com.demo.thread.escape;

/**
 * 初始化未完毕，就this赋值
 * @author cs
 * @version 1.0
 * @date 2020/10/21 1:27 下午
 */
public class MultiThreadError3 {
    static Point point;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new PointMaker()).start();

        Thread.sleep(10);

        // 在不同时刻，point的值不一样
        /*Thread.sleep(100);*/

        if (point != null) {
            System.out.println(point);
        }
    }
}

class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) throws InterruptedException {
        this.x = x;
        MultiThreadError3.point = this;
        Thread.sleep(100);
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

/**
 * 初始化 Point 线程
 */
class PointMaker implements Runnable {
    @Override
    public void run() {
        try {
            new Point(1, 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}