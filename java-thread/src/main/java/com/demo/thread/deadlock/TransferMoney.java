package com.demo.thread.deadlock;

/**
 * @author cs
 * @date 2020/10/22 11:11 上午
 */
public class TransferMoney implements Runnable{
    int flag = 1;
    static Account a = new Account(500);
    static Account b = new Account(500);

    public static void main(String[] args) throws InterruptedException {
        TransferMoney r1 = new TransferMoney();
        TransferMoney r2 = new TransferMoney();
        r1.flag=1;
        r2.flag=0;

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("a余额 " + a.balance);
        System.out.println("b余额 " + b.balance);
    }

    @Override
    public void run() {
        if (flag == 1) {
            transferMoney(a, b,600);
        }

        if (flag == 0) {
            transferMoney(b, a,100);
        }
    }

    public static void transferMoney(Account from, Account to, int amount) {
        synchronized (from) {
            // sleep一会就会发生死锁
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            synchronized (to) {
                if (from.balance - amount < 0) {
                    throw new RuntimeException("余额不足。。。");
                }
                from.balance -= amount;
                to.balance += amount;
                System.out.println("转账成功");
            }
        }
    }

    static class Account {
        int balance;
        public Account(int balance) {
            this.balance = balance;
        }
    }
}
