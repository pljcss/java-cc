package com.demo.thread.escape;

import java.util.HashMap;
import java.util.Map;

/**
 * 发布逸出问题
 *     方法返回一个private 对象
 *
 * @author cs
 * @version 1.0
 * @date 2020/10/21 12:22 下午
 */
public class MultiThreadError2 {
    private Map<String, String> states;

    public MultiThreadError2() {
        this.states = new HashMap<>();
        states.put("1", "星期1");
        states.put("2", "星期2");
    }

    /**
     * 方法对外发布 private对象
     * @return
     */
    public Map<String, String> getStates() {
        return states;
    }

    public static void main(String[] args) {
        MultiThreadError2 o1 = new MultiThreadError2();

        Map<String, String> method = o1.getStates();
        String s1 = method.get("1");
        System.out.println(s1);

        // 外界可以对该 private Map对象 进行修改
        method.remove("1");

        String s2 = method.get("1");
        System.out.println(s2);
    }
}
