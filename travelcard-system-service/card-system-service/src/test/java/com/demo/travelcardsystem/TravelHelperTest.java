package com.demo.travelcardsystem;

import com.demo.travelcardsystem.config.TravelcardsystemApplication;
import com.demo.travelcardsystem.constant.TransportType;
import com.demo.travelcardsystem.entity.TravelCard;
import com.demo.travelcardsystem.model.request.SwipeRequest;
import com.demo.travelcardsystem.repository.InMemoryCardTransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = TravelcardsystemApplication.class)
class TravelHelperTest extends IntegrationTest {

    @Autowired
    private InMemoryCardTransactionRepository inMemoryCardTransactionRepository;

    @BeforeEach
    void resetRepository() {
        inMemoryCardTransactionRepository.clearTravelCardStore();
    }

    public SwipeRequest prepareSwipeRequest(String cardNumber, String stationName, TransportType transportType) {
        SwipeRequest swipeRequest = new SwipeRequest();
        swipeRequest.setCardNumber(cardNumber);
        swipeRequest.setStationName(stationName);
        swipeRequest.setTransportType(transportType);
        return swipeRequest;
    }

    public TravelCard directUserRegistration(String cardNumber, double amount) {
        TravelCard travelCard = new TravelCard();
        travelCard.setCardNumber(cardNumber);
        travelCard.setBalance(amount);
        return inMemoryCardTransactionRepository.registerNewCard(travelCard);
    }

    @DisplayName("prepareSwipeRequest returns correct values")
    @Test
    void prepareSwipeRequest_returns_correct_values() {
        SwipeRequest result = prepareSwipeRequest("1A101", "Algubaiba", TransportType.TRAIN);
        assertEquals("1A101", result.getCardNumber());
        assertEquals("Algubaiba", result.getStationName());
        assertEquals(TransportType.TRAIN, result.getTransportType());
    }

    @DisplayName("prepareSwipeRequest with BUS transport type")
    @Test
    void prepareSwipeRequest_with_bus_transport_type() {
        SwipeRequest result = prepareSwipeRequest("1A102", "Jumeirah", TransportType.BUS);
        assertEquals("1A102", result.getCardNumber());
        assertEquals("Jumeirah", result.getStationName());
        assertEquals(TransportType.BUS, result.getTransportType());
    }

    @DisplayName("directUserRegistration registers card with correct balance")
    @Test
    void directUserRegistration_registers_card_successfully() {
        TravelCard result = directUserRegistration("1A103", 50.0);
        assertEquals("1A103", result.getCardNumber());
        assertEquals(50.0, result.getBalance());
    }

    @DisplayName("directUserRegistration registers card with zero balance")
    @Test
    void directUserRegistration_with_zero_balance() {
        TravelCard result = directUserRegistration("1A104", 0);
        assertEquals("1A104", result.getCardNumber());
        assertEquals(0, result.getBalance());
    }
}