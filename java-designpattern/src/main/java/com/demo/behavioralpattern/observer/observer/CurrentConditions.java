package com.demo.behavioralpattern.observer.observer;

/**
 * @author cs
 * @date 2020/11/1 8:39 下午
 */
public class CurrentConditions implements Observer {
    private float temperature;
    private float pressure;
    private float humidity;

    @Override
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;

        display();
    }

    public void display() {
        System.out.println("Today temperature " + temperature);
        System.out.println("Today pressure " + pressure);
        System.out.println("Today humidity " + humidity);
    }


}
