package com.demo.reflect;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/13 9:56 上午
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 3638828028583189986L;
    private String name;
    private int age;

    public Person() {
        System.out.println("无参构造方法。。。。。");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sayHello() {
        System.out.println(name + " hello person。。。");
    }

    public void eatFood(String food) {
        System.out.println("eat 。。。" + food);
    }

    private void privateMethod() {
        System.out.println("私有方法。。。。");
    }

    public static void staticMethod() {
        System.out.println("静态方法。。。。");
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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
