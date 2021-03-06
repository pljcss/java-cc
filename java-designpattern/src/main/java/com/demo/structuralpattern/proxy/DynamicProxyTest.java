package com.demo.structuralpattern.proxy;

/**
 * 动态代理
 * @author cs
 * @version 1.0
 * @date 2020/10/13 3:51 下午
 */
public class DynamicProxyTest {

}

interface Human {
    String getBelief();
    void eatFood(String food);
}

/**
 * 被代理类
 */
class Superman implements Human{

    @Override
    public String getBelief() {
        return "I believe i can fly";
    }

    @Override
    public void eatFood(String food) {
        System.out.println("喜欢吃 " + food);
    }
}

class ProxyFactory {
    /**
     *
     * @param obj 被代理类的对象
     * @return
     */
    public static Object getProxyInstance(Object obj) {

        return null;
    }
}