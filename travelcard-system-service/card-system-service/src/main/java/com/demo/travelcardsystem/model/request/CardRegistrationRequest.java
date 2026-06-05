package com.demo.travelcardsystem.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
<<<<<<< HEAD
import lombok.Data;

@Data
@JsonIgnoreProperties
public class CardRegistrationRequest {
    private String cardNumber;
    private Double balance;
}
=======

@JsonIgnoreProperties
public class CardRegistrationRequest {

    private String cardNumber;
    private Double balance;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
>>>>>>> sprint-1
