package com.demo.travelcardsystem;

import com.demo.travelcardsystem.constant.TransportType;
<<<<<<< HEAD
import com.demo.travelcardsystem.entity.Station;
import com.demo.travelcardsystem.entity.TravelCard;
import com.demo.travelcardsystem.model.request.SwipeRequest;
import com.demo.travelcardsystem.model.response.TravelCardResponse;
import com.demo.travelcardsystem.repository.InMemoryCardTransactionRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
=======
import com.demo.travelcardsystem.entity.TravelCard;
import com.demo.travelcardsystem.model.request.SwipeRequest;
import com.demo.travelcardsystem.repository.InMemoryCardTransactionRepository;
>>>>>>> sprint-1
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

<<<<<<< HEAD
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class CheckinCheckoutTest extends IntegrationTest {
=======
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CheckinCheckoutTest extends IntegrationTest {
>>>>>>> sprint-1

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private InMemoryCardTransactionRepository inMemoryCardTransactionRepository;
    @Autowired
    private TravelHelperTest travelHelperTest;

<<<<<<< HEAD


    @BeforeEach
    public void resetRepository() {
=======
    @BeforeEach
    void resetRepository() {
>>>>>>> sprint-1
        inMemoryCardTransactionRepository.clearTravelCardStore();
    }

    @DisplayName("User take few trips and check balance at end of the trip")
    @Test
<<<<<<< HEAD
    public void user_take_trip_and_check_balance() throws Exception {
        //GIVEN - User/Travel-card exists in the system
        TravelCard travelCard = travelHelperTest.directUserRegistration("1A101", 30);
        SwipeRequest swipeRequest =  null;

        //AND - user take Train Hamilton to Thunder Bay
        swipeRequest = travelHelperTest.prepareSwipeRequest(travelCard.getCardNumber(),"Algubaiba", TransportType.TRAIN);
=======
    void user_take_trip_and_check_balance() throws Exception {
        // GIVEN - User/Travel-card exists in the system
        TravelCard travelCard = travelHelperTest.directUserRegistration("1A101", 30);
        SwipeRequest swipeRequest;

        // AND - user take Train Hamilton to Thunder Bay
        swipeRequest = travelHelperTest.prepareSwipeRequest(travelCard.getCardNumber(), "Algubaiba", TransportType.TRAIN);
>>>>>>> sprint-1
        mockMvc.perform(post("/api/card/swipe")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(swipeRequest)))
                .andExpect(status().isOk());

<<<<<<< HEAD
        swipeRequest = travelHelperTest.prepareSwipeRequest(travelCard.getCardNumber(),"Jumeirah", TransportType.TRAIN);
=======
        swipeRequest = travelHelperTest.prepareSwipeRequest(travelCard.getCardNumber(), "Jumeirah", TransportType.TRAIN);
>>>>>>> sprint-1
        mockMvc.perform(post("/api/card/swipe")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(swipeRequest)))
                .andExpect(status().isOk());

        System.out.println("Card balance after journey-1 is -> " + inMemoryCardTransactionRepository.findCardByCardNumber(travelCard.getCardNumber()).getBalance());

<<<<<<< HEAD
        //AND - user take 106 bus from Thunder Bay to Dryden
        swipeRequest = travelHelperTest.prepareSwipeRequest(travelCard.getCardNumber(),"Jumeirah", TransportType.BUS);
        mockMvc.perform(post("/api/card/swipe")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(swipeRequest)))
                .andExpect(status().isOk());

        swipeRequest = travelHelperTest.prepareSwipeRequest(travelCard.getCardNumber(),"Bur Dubai", TransportType.BUS);
        mockMvc.perform(post("/api/card/swipe")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(swipeRequest)))
                .andExpect(status().isOk());

        System.out.println("Card balance after journey-2 is -> " + inMemoryCardTransactionRepository.findCardByCardNumber(travelCard.getCardNumber()).getBalance());


        //AND - user take Train Dryden to Slate Falls
        swipeRequest = travelHelperTest.prepareSwipeRequest(travelCard.getCardNumber(),"Bur Dubai", TransportType.TRAIN);
        mockMvc.perform(post("/api/card/swipe")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(swipeRequest)))
                .andExpect(status().isOk());

        swipeRequest = travelHelperTest.prepareSwipeRequest(travelCard.getCardNumber(),"Deirah", TransportType.TRAIN);
        mockMvc.perform(post("/api/card/swipe")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(swipeRequest)))
                .andExpect(status().isOk());

        //THEN - VERIFY BALANCE AT END OF THE JOURNEY
       mockMvc.perform(get("/api/card/{cardNumber}", travelCard.getCardNumber()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.balance").value("23.45"));

    }


}
=======
        // AND - user take 106 bus from Thunder Bay to Dryden
        travelHelperTest.prepareSwipeRequest(travelCard.getCardNumber(), "Jumeirah", TransportType.BUS);
    }
}
>>>>>>> sprint-1
