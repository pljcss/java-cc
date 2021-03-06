package com.demo.io.byte_stream;

import java.io.Serializable;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/12 11:35 上午
 */
public class Student implements Serializable {
    private String name;
    private int age;

    private static final long serialVersionUID = -6590811968852467115L;


    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
