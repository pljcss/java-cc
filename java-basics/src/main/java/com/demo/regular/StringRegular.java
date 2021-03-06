package com.demo.regular;

import org.junit.Test;

/**
 * @Author: cs
 * @Date: 2021/3/5 7:37 下午
 * @Desc:
 */
public class StringRegular {

    /**
     * 判断是否是手机号
     */
    @Test
    public void matches() {
        String isPhone = "1\\d{10}";
        boolean matches = "13196986660".matches(isPhone);

        System.out.println(matches);
    }

    /**
     * 隐藏电话号码中间四位
     * 使用回溯引用
     */
    @Test
    public void phoneHide() {
        // 隐藏电话号码中间四位
        String encryptReg = "(\\d{3})\\d*(\\d{4})";
        String hideReg = "$1****$2";
        String s = "13196986660".replaceAll(encryptReg, hideReg);

        System.out.println(s);

        // 给手机号添加<h1>标签
        String h1Reg = "(\\d{11})";
        String h1AddReg = "<h1>$1</h1>";
        String s1 = "13196986660".replaceAll(h1Reg, h1AddReg);
        System.out.println(s1);
    }


    public void test1() {
        // 向前匹配
        String url = "https://www.baidu.com";
        String forwardReg = ".+(?=:)";

        boolean matches = url.matches(forwardReg);

    }

}
