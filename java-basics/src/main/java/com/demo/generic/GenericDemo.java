package com.demo.generic;

/**
 * 泛型
 *   语法：类名<T>
 *        T是类型占位符，表示一种引用类型，如果编写多个用逗号隔开
 *   泛型只能是引用类型
 *
 * @author cs
 * @date 2020/10/24 6:04 下午
 */
public class GenericDemo<T> {
    /**
     * 1、使用泛型 T ：创建变量
     */
    T t;

    /**
     * 2、使用泛型 T ：泛型作为方法的参数
     * @param t
     */
    public void show(T t) {

    }

    /**
     * 2、使用泛型 T ：泛型作为方法的返回值
     * @return
     */
    public T getT() {
        return t;
    }


}
