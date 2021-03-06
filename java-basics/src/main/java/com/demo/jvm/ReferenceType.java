package com.demo.jvm;

import java.lang.ref.SoftReference;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/19 1:34 下午
 */
public class ReferenceType {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SoftReference<UserDemo> sr = new SoftReference<UserDemo>(new UserDemo("soft" + i));

        }
    }
}


class UserDemo {
    private String name;

    public UserDemo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize.... " + name);
    }
}