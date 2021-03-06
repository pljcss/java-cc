package com.demo.structuralpattern.proxy;

/**
 * 静态代理
 *      特点：代理类和被代理类，在编译期间就确定下来了
 *
 * @author cs
 * @version 1.0
 * @date 2020/10/13 3:42 下午
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        // 创建被代理类对象
        ClothFactory nikeClothFactory = new NikeClothFactory();
        // 创建代理类对象
        ClothFactory proxyClothFactory = new ProxyClothFactory(nikeClothFactory);

        proxyClothFactory.produceCloth();
    }
}

interface ClothFactory {
    void produceCloth();
}

/**
 * 代理类
 */
class ProxyClothFactory implements ClothFactory {
    private ClothFactory clothFactory;

    public ProxyClothFactory(ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂开始。。。。");
        clothFactory.produceCloth();
        System.out.println("代理工厂结束。。。。");
    }
}

/**
 * 被代理类
 */
class NikeClothFactory implements ClothFactory {
    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产衣服。。。。");
    }
}