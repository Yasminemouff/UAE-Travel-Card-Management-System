package com.demo.travelcardsystem.entity;

import java.util.ArrayList;
import java.util.List;

public class TravelCard implements Observable<TravelCard> {
    private String cardNumber;
    private double balance;
    private Journey currentJourney;
    private List<Observer<TravelCard>> observerCollection = new ArrayList<>();

    public synchronized void addCredit(double amount) { balance += amount; }
    public synchronized void debitAmount(double amount) { balance -= amount; }

    @Override
    public void notifyAllObservers() {
        observerCollection.forEach(observer -> observer.reactOnChange(this));
    }

    @Override
    public void registerObserver(Observer<TravelCard> observer) { observerCollection.add(observer); }

    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
    public Journey getCurrentJourney() { return currentJourney; }
    public void setCurrentJourney(Journey currentJourney) { this.currentJourney = currentJourney; }

    public List<Observer<TravelCard>> getObserverCollection() { return observerCollection; }
    public void setObserverCollection(List<Observer<TravelCard>> observerCollection) { this.observerCollection = observerCollection; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelCard that = (TravelCard) o;
        return cardNumber.equals(that.cardNumber);
    }

    @Override
    public int hashCode() { return cardNumber.hashCode(); }
}