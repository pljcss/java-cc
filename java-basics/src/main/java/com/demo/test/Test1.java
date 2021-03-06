package com.demo.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;

/**
 * throw 抛出异常
 * @author cs
 * @version 1.0
 * @date 2020/10/12 11:00 上午
 */
public class Test1 {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setAge(130);
    }
}

class Person {
    int age;
    public void setAge(int age) {
        if (age > 0 && age < 120) {
            this.age = age;
        } else {
            throw new AgeException("年龄不符合要求");
        }
    }
}

/**
 * 自定义异常
 *  1）Exception 或子类
 *  2）添加构造方法
 */
class AgeException extends RuntimeException {
    public AgeException() {
        super();
    }
    public AgeException(String message) {
        super(message);
    }
}