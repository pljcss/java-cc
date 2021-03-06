package com.demo.thread.threadlocal;

/**
 * ThreadLocal 用法2
 *
 * @author cs
 * @date 2020/10/22 3:56 下午
 */
public class ThreadLocalUsage2 {
    public static void main(String[] args) {
        new Service1().process();
    }
}

class Service1 {
    public void process() {
        User user1 = new User("leo");
        UserContextHolder.holder.set(user1);
        new Service2().process2();
    }
}

class Service2 {
    public void process2() {
        User user = UserContextHolder.holder.get();
        System.out.println("Service2 拿到用户名 " + user.name);
        new Service3().process3();
    }
}

class Service3 {
    public void process3() {
        User user = UserContextHolder.holder.get();
        System.out.println("Service3 拿到用户名 " + user.name);
    }
}

class UserContextHolder {
    public static ThreadLocal<User> holder = new ThreadLocal<>();
}
class User {
    String name;
    public User(String name) {
        this.name = name;
    }
}