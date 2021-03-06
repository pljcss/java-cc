package com.demo.behavioralpattern.observer.traditionalway;

/**
 * 显示当前天气状况，可以理解成是气象站自己的网站
 * @author cs
 * @date 2020/11/1 6:12 下午
 */
public class CurrentConditions {
    private float temperature;
    private float pressure;
    private float humidity;

    /**
     * 更新天气状态，由 WeatherData 来调用，使用推送模式
     */
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;

        display();
    }

    /**
     * 显示
     */
    public void display() {
        System.out.println("Today temperature " + temperature);
        System.out.println("Today pressure " + pressure);
        System.out.println("Today humidity " + humidity);
    }


}
