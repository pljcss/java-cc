package com.demo.behavioralpattern.observer.traditionalway;

/**
 * @author cs
 * @date 2020/11/1 8:21 下午
 */
public class Client {
    public static void main(String[] args) {
        // 创建接入方
        CurrentConditions currentConditions = new CurrentConditions();

        WeatherData weatherData = new WeatherData(currentConditions);

        // 更新天气
        weatherData.setData(30, 150, 40);

        weatherData.setData(40, 240, 80);

    }
}
