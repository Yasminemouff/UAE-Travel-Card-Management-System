package com.demo.travelcardsystem.entity;

public interface Observable<T> {
    void notifyAllObservers();
    void registerObserver(Observer<T> observer);
}