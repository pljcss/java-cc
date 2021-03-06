package com.demo.annotation;

/**
 * 创建注解类型
 *    注解可以有默认值
 *
 * @author cs
 * @version 1.0
 * @date 2020/10/13 5:08 下午
 */
public @interface MyAnnotation {

    // 属性（类似方法）
    String name();

    int age();

    String address() default "china";
}


/**
 * 使用注解
 *   注解可以放在类上、方法上
 */
class Person {

    @MyAnnotation(name = "张三", age = 20)
    public void show() {

    }
}