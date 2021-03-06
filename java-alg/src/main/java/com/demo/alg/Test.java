package com.demo.alg;

/**
 * @author cs
 * @version 1.0
 * @date 2019/11/8 5:45 下午
 */
public class Test {
    public static void main(String[] args) {
        method(0, 5);
    }


    public static void method(int a, int b) {
        if (a>=b) {
            return;
        }

        int center = (a+b)/2;
        /**
         * method1 a=0;b=5;ce=2
         * method2 a=0;b=2;ce=1
         * method3 a=0;b=1;ce=0
         * method3 a=0;b=0  ---> return: 退出方法调用端
         */

        method(a, center);

        System.out.println("执行了");
    }
}
