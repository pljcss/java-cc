package com.demo.behavioralpattern.observer.observer;

import java.util.HashMap;

/**
 * @author cs
 * @date 2020/11/1 8:47 下午
 */
public class Client {
    public static void main(String[] args) {
        // 创建一个 WeatherData
        WeatherData weatherData = new WeatherData();
        // 创建观察者
        CurrentConditions currentConditions = new CurrentConditions();
        // 注册到 WeatherData
        weatherData.registerObserver(currentConditions );

        // 添加新的观察者
        BaiduConditions baiduConditions = new BaiduConditions();
        weatherData.registerObserver(baiduConditions);

        // 测试
        weatherData.setData(37, 100, 32);

    }
}
