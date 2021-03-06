package com.demo.thread.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * 原子数组的释放方法
 * @author cs
 * @date 2020/10/23 11:30 上午
 */
public class AtomicIntegerArrayDemo {

    public static void main(String[] args) {
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(100);
        IncrementTool incrementTool = new IncrementTool(atomicIntegerArray);
        DecrementTool decrementTool = new DecrementTool(atomicIntegerArray);

        Thread[] threadsIncrement = new Thread[100];
        Thread[] threadsDecrement = new Thread[100];

        for (int i = 0; i < 100; i++) {
            threadsDecrement[i] = new Thread(decrementTool);
            threadsIncrement[i] = new Thread(incrementTool);

            threadsIncrement[i].start();
            threadsDecrement[i].start();
        }

        for (int i = 0; i < 100; i++) {
            // join
        }

    }

}

class DecrementTool implements Runnable {
    private AtomicIntegerArray array;

    public DecrementTool(AtomicIntegerArray atomicIntegerArray) {
        this.array = atomicIntegerArray;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length(); i++) {
            array.getAndDecrement(i);
        }
    }
}

class IncrementTool implements Runnable {
    private AtomicIntegerArray array;

    public IncrementTool(AtomicIntegerArray atomicIntegerArray) {
        this.array = atomicIntegerArray;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length(); i++) {
            array.getAndIncrement(i);
        }
    }
}