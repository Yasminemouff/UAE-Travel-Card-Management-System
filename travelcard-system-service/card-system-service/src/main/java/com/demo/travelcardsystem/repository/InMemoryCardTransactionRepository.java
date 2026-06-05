package com.demo.travelcardsystem.repository;

import com.demo.travelcardsystem.entity.Station;
import com.demo.travelcardsystem.entity.TravelCard;
<<<<<<< HEAD
import com.demo.travelcardsystem.exception.InvalidCardException;
import com.demo.travelcardsystem.exception.InvalidDataProvidedException;
import com.demo.travelcardsystem.exception.InvalidRechargeAmount;
=======
import com.demo.travelcardsystem.entity.TravelCardObserver;
import com.demo.travelcardsystem.exception.InvalidCardException;
import com.demo.travelcardsystem.exception.InvalidDataProvidedException;
>>>>>>> sprint-1
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
public class InMemoryCardTransactionRepository {

<<<<<<< HEAD
    // Key is cardNumber
    private ConcurrentMap<String, TravelCard> travelCardStore = new ConcurrentHashMap<>();
    private Set<Station> stationStore = new HashSet<>();

    public TravelCard registerNewCard(TravelCard travelCard) {
        // Check if card already exists. Then throw exception
        if(null != travelCardStore.get(travelCard.getCardNumber())) {
            throw new InvalidCardException("This card is already registered.");
        }
=======
    private ConcurrentMap<String, TravelCard> travelCardStore = new ConcurrentHashMap<>();
    private Set<Station> stationStore = new HashSet<>();

    // ✅ Inject observer so every new card gets it registered
    private TravelCardObserver travelCardObserver;

    public InMemoryCardTransactionRepository(TravelCardObserver travelCardObserver) {
        this.travelCardObserver = travelCardObserver;
    }

    public TravelCard registerNewCard(TravelCard travelCard) {
        if (null != travelCardStore.get(travelCard.getCardNumber())) {
            throw new InvalidCardException("This card is already registered.");
        }
        // ✅ Every card gets the observer when registered
        travelCard.registerObserver(travelCardObserver);
>>>>>>> sprint-1
        travelCardStore.put(travelCard.getCardNumber(), travelCard);
        return travelCard;
    }

    public TravelCard findCardByCardNumber(String cardNumber) {
        TravelCard travelCard = travelCardStore.get(cardNumber);
<<<<<<< HEAD
        if(travelCard == null) {
            throw new InvalidCardException("This card is Invalid. Please use a valid card");
        }

=======
        if (travelCard == null) {
            throw new InvalidCardException("This card is Invalid. Please use a valid card");
        }
>>>>>>> sprint-1
        return travelCard;
    }

    public Station findStationByName(String stationName) {
<<<<<<< HEAD
       return stationStore.stream().filter(station -> station.getName().equals(stationName)).findAny()
               .orElseThrow(InvalidDataProvidedException::new);
=======
        return stationStore.stream()
                .filter(station -> station.getName().equals(stationName))
                .findAny()
                .orElseThrow(InvalidDataProvidedException::new);
>>>>>>> sprint-1
    }

    public boolean addAllStationsToStationStore(Set<Station> stations) {
        clearStationStore();
        return stationStore.addAll(stations);
    }

<<<<<<< HEAD
    public void clearStationStore() {
        stationStore.clear();
    }

    public void clearTravelCardStore() {
        travelCardStore.clear();
    }

=======
    public void clearStationStore() { stationStore.clear(); }
    public void clearTravelCardStore() { travelCardStore.clear(); }
>>>>>>> sprint-1

    public List<String> fetchAllCardNumber() {
        return new ArrayList<>(travelCardStore.keySet());
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> sprint-1
