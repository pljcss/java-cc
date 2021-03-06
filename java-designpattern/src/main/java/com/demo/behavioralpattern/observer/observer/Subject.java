package com.demo.behavioralpattern.observer.observer;


/**
 * @author cs
 * @date 2020/11/1 8:34 下午
 */
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
