package com.demo.travelcardsystem.model.response;

import com.demo.travelcardsystem.constant.TransportType;
import lombok.Data;

@Data
public class TravelCardResponse {
    private String cardNumber;
    private double balance;
    private boolean inTransit;
    private TransportType transportType;
<<<<<<< HEAD
=======
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public boolean isInTransit() {
		return inTransit;
	}
	public void setInTransit(boolean inTransit) {
		this.inTransit = inTransit;
	}
	public TransportType getTransportType() {
		return transportType;
	}
	public void setTransportType(TransportType transportType) {
		this.transportType = transportType;
	}
    
    
>>>>>>> sprint-1
}
