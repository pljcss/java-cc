package com.demo.behavioralpattern.observer.traditionalway;

/**
 * 当有数据有更新时，就主动调用 CurrentConditions 的update方法
 * @author cs
 * @date 2020/11/1 8:15 下午
 */
public class WeatherData {
    private float temperature;
    private float pressure;
    private float humidity;
    private CurrentConditions currentConditions;

    public WeatherData(CurrentConditions currentConditions) {
        this.currentConditions = currentConditions;
    }

    public void dataChange() {
        currentConditions.update(temperature, pressure, humidity);
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
