package com.demo.alg;

import java.util.HashMap;

/**
 * @author cs
 * @version 1.0
 * @date 2019/11/8 11:21 上午
 */
public class RecursionDemo {

    private static HashMap hasSolvedList = new HashMap();

    public static void main(String[] args) {
        stepCount1(4);
    }


    public static int addF(int n) {
        if (n == 1) {return 1;}
        return addF(n-1) + 1;
    }


    public static int stepCount(int n) {
        if (n == 1) {return 1;}
        if (n == 2) {return 2;}
        System.out.println(n);
        return stepCount(n-1) + stepCount(n-2);
    }


    public static int stepCount1(int n) {
        if (n == 1) {return 1;}
        if (n == 2) {return 2;}

        // hasSolvedList可以理解成一个Map，key是n，value是f(n)
        if (hasSolvedList.containsKey(n)) {
            return (int)hasSolvedList.get(n);
        }


        int ret = stepCount1(n-1) + stepCount1(n-2);

        hasSolvedList.put(n, ret);
        return ret;
    }

    public static void test1(int n) {
        if (n==1) {return;}

    }
}
