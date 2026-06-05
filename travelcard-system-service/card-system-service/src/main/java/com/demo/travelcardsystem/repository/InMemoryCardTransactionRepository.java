package com.demo.travelcardsystem.repository;

import com.demo.travelcardsystem.entity.Station;
import com.demo.travelcardsystem.entity.TravelCard;
import com.demo.travelcardsystem.entity.TravelCardObserver;
import com.demo.travelcardsystem.exception.InvalidCardException;
import com.demo.travelcardsystem.exception.InvalidDataProvidedException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
public class InMemoryCardTransactionRepository {

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
        travelCardStore.put(travelCard.getCardNumber(), travelCard);
        return travelCard;
    }

    public TravelCard findCardByCardNumber(String cardNumber) {
        TravelCard travelCard = travelCardStore.get(cardNumber);
        if (travelCard == null) {
            throw new InvalidCardException("This card is Invalid. Please use a valid card");
        }
        return travelCard;
    }

    public Station findStationByName(String stationName) {
        return stationStore.stream()
                .filter(station -> station.getName().equals(stationName))
                .findAny()
                .orElseThrow(InvalidDataProvidedException::new);
    }

    public boolean addAllStationsToStationStore(Set<Station> stations) {
        clearStationStore();
        return stationStore.addAll(stations);
    }

    public void clearStationStore() { stationStore.clear(); }
    public void clearTravelCardStore() { travelCardStore.clear(); }

    public List<String> fetchAllCardNumber() {
        return new ArrayList<>(travelCardStore.keySet());
    }
}