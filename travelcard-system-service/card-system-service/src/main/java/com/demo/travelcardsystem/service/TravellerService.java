package com.demo.travelcardsystem.service;

import com.demo.travelcardsystem.entity.Journey;
import com.demo.travelcardsystem.entity.Station;
import com.demo.travelcardsystem.entity.TravelCard;
import com.demo.travelcardsystem.exception.InvalidCardException;
import com.demo.travelcardsystem.exception.InvalidDataProvidedException;
import com.demo.travelcardsystem.exception.InvalidRechargeAmount;
import com.demo.travelcardsystem.model.request.CardRegistrationRequest;
import com.demo.travelcardsystem.model.request.SwipeRequest;
import com.demo.travelcardsystem.model.response.TravelCardResponse;
import com.demo.travelcardsystem.repository.InMemoryCardTransactionRepository;
import com.demo.travelcardsystem.service.util.TravelCardConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TravellerService {

    private InMemoryCardTransactionRepository inMemoryCardTransactionRepository;
    private TravelCardConverter travelCardConverter;

    public TravellerService(InMemoryCardTransactionRepository inMemoryCardTransactionRepository,
                            TravelCardConverter travelCardConverter) {
        this.inMemoryCardTransactionRepository = inMemoryCardTransactionRepository;
        this.travelCardConverter = travelCardConverter;
    }

    public void registerNewCard(CardRegistrationRequest cardRegistrationRequest) {
        if (cardRegistrationRequest == null || cardRegistrationRequest.getCardNumber() == null
                || cardRegistrationRequest.getCardNumber().isEmpty()) {
            throw new InvalidCardException("This card is Invalid. Please use a valid card");
        }

        if (cardRegistrationRequest.getBalance() < 0) {
            throw new InvalidRechargeAmount("Recharge amount must not be negative");
        }

        TravelCard travelCard = new TravelCard();
        travelCard.setCardNumber(cardRegistrationRequest.getCardNumber());
        travelCard.setBalance(cardRegistrationRequest.getBalance());

        inMemoryCardTransactionRepository.registerNewCard(travelCard);
    }

    public void rechargeTheCard(String cardNumber, double rechargeAmount) {
        if (cardNumber == null || cardNumber.isEmpty()) {
            throw new InvalidCardException("This card is Invalid. Please use a valid card");
        }

        if (rechargeAmount < 0) {
            throw new InvalidRechargeAmount("Recharge amount must not be negative");
        }

        TravelCard travelCard = inMemoryCardTransactionRepository.findCardByCardNumber(cardNumber);
        travelCard.addCredit(rechargeAmount);
    }

    public TravelCardResponse swipeCard(SwipeRequest swipeRequest) {

        if (null == swipeRequest.getTransportType()) throw new InvalidDataProvidedException();

        TravelCard travelCard = inMemoryCardTransactionRepository.findCardByCardNumber(swipeRequest.getCardNumber());
        Station station = inMemoryCardTransactionRepository.findStationByName(swipeRequest.getStationName());

        if (null != travelCard.getCurrentJourney()) {
            travelCard.getCurrentJourney().setEndStation(station);
            travelCard.getCurrentJourney().setJourneyCompleted(true);
            travelCard.notifyAllObservers();
            travelCard.setCurrentJourney(null);
        } else {
            Journey journey = Journey.builder()
                    .startStation(station)
                    .transportType(swipeRequest.getTransportType())
                    .journeyCompleted(false)
                    .build();

            travelCard.setCurrentJourney(journey);
            travelCard.notifyAllObservers();
        }

        //Updated to use getConverter()
        return travelCardConverter.getConverter().apply(travelCard);
    }

    public TravelCardResponse checkCardDetail(String cardNumber) {
        TravelCard travelCard = inMemoryCardTransactionRepository.findCardByCardNumber(cardNumber);
        //Updated to use getConverter()
        return travelCardConverter.getConverter().apply(travelCard);
    }

    public List<String> fetchAllCard() {
        return inMemoryCardTransactionRepository.fetchAllCardNumber();
    }
    
    
    public double getCardBalance(String cardNumber) {
        TravelCard travelCard = inMemoryCardTransactionRepository.findCardByCardNumber(cardNumber);
        return travelCard.getBalance();
    }
    
    public Set<Station> getAllStations() {
        return inMemoryCardTransactionRepository.getAllStations();
    }
}