package com.demo.travelcardsystem.entity;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

public interface Observable {
     List<Observer> observerCollection = new ArrayList<>();
     void notifyAllObservers();
     void registerObserver(Observer observer);
}
=======
public interface Observable<T> {
    void notifyAllObservers();
    void registerObserver(Observer<T> observer);
}
>>>>>>> sprint-1
