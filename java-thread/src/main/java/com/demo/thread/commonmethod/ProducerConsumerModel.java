package com.demo.thread.commonmethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 生产者消费者模式
 *    使用 wait notify实现
 *
 * @author cs
 * @version 1.0
 * @date 2020/10/20 10:01 下午
 */
public class ProducerConsumerModel {

    public static void main(String[] args) {
        EventStorage storage = new EventStorage();
        Producer producer = new Producer(storage);
        Consumer consumer = new Consumer(storage);

        new Thread(producer).start();
        new Thread(consumer).start();


    }
    static class Producer implements Runnable {
        private EventStorage storage;

        public Producer(EventStorage storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                storage.put();
            }
        }
    }

    static class Consumer implements Runnable {
        private EventStorage storage;

        public Consumer(EventStorage storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                storage.take();
            }
        }
    }

    static class EventStorage {
        private int maxSize;
        private LinkedList<Date> storage;

        public EventStorage() {
            maxSize = 10;
            storage = new LinkedList<>();
        }

        public synchronized void put() {
            // 满了就停止
            while (storage.size() == maxSize) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            storage.add(new Date());
            System.out.println("仓库里面有了 "+storage.size()+" 个产品");
            // 通知
            notify();
        }


        public synchronized void take() {
            while (storage.size() == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("拿到了。。。 " + storage.poll() + " 还剩 " + storage.size());
            // 通知
            notify();
        }
    }
}
