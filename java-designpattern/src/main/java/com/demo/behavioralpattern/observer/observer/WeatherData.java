package com.demo.behavioralpattern.observer.observer;

import com.demo.designpattern.behavioralpattern.observer.traditionalway.CurrentConditions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cs
 * @date 2020/11/1 8:41 下午
 */
public class WeatherData implements Subject{
    private float temperature;
    private float pressure;
    private float humidity;
    private final List<Observer> observersList = new ArrayList<>();

    /**
     * 注册一个观察者
     * @param observer
     */
    @Override
    public void registerObserver(Observer observer) {
        observersList.add(observer);
    }

    /**
     * 移除一个观察者
     * @param observer
     */
    @Override
    public void removeObserver(Observer observer) {
        observersList.remove(observer);
    }

    /**
     * 遍历所有的观察者，并通知
     */
    @Override
    public void notifyObservers() {
        for (Observer observer : observersList) {
            observer.update(temperature, pressure, humidity);
        }
    }


    public void dataChange() {
        notifyObservers();
    }

    /**
     * 当数据有更新时就调用 setData 方法
     */
    public void setData(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        // 调用dataChange()，将最新数据推送给接入方 CurrentConditions
        dataChange();
    }
}
