package com.demo.travelcardsystem;

import com.demo.travelcardsystem.entity.TravelCard;
import com.demo.travelcardsystem.repository.InMemoryCardTransactionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
<<<<<<< HEAD

import java.util.stream.Stream;

=======
import java.util.stream.Stream;
>>>>>>> sprint-1
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

<<<<<<< HEAD

class RechargeTravelCardTests extends IntegrationTest{
=======
class RechargeTravelCardTests extends IntegrationTest {
>>>>>>> sprint-1

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private InMemoryCardTransactionRepository inMemoryCardTransactionRepository;
    @Autowired
    private TravelHelperTest travelHelperTest;

    private static Stream<Arguments> usersGenerator() {
        return Stream.of(
<<<<<<< HEAD
                Arguments.of("1AE101",  30),
                Arguments.of("1AE102",  40)
=======
                Arguments.of("1AE101", 30),
                Arguments.of("1AE102", 40)
>>>>>>> sprint-1
        );
    }

    @BeforeEach
<<<<<<< HEAD
    public void resetRepository() {
        inMemoryCardTransactionRepository.clearTravelCardStore();

    }


    @DisplayName("Service is Up and Running")
    @Test
    public void check_if_ping_is_working() throws Exception {
        mockMvc.perform(get("/api/card/ping"))
                .andExpect(status().isOk());

=======
    void resetRepository() {
        inMemoryCardTransactionRepository.clearTravelCardStore();
    }

    @DisplayName("Service is Up and Running")
    @Test
    void check_if_ping_is_working() throws Exception {
        mockMvc.perform(get("/api/card/ping"))
                .andExpect(status().isOk());
>>>>>>> sprint-1
    }

    @DisplayName("User try to register himself successfully")
    @ParameterizedTest
    @MethodSource("usersGenerator")
<<<<<<< HEAD
    public void register_user_in_the_system(String cardNumber, double amount) throws Exception {
        //GIVEN - user enter his user detail
        TravelCard travelCard = new TravelCard();
        travelCard.setCardNumber(cardNumber);
        travelCard.setBalance(amount);


        //WHEN -  User try to register himself
=======
    void register_user_in_the_system(String cardNumber, double amount) throws Exception {
        TravelCard travelCard = new TravelCard();
        travelCard.setCardNumber(cardNumber);
        travelCard.setBalance(amount);
>>>>>>> sprint-1
        mockMvc.perform(post("/api/card/register")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(travelCard)))
                .andExpect(status().isOk());
<<<<<<< HEAD

        //THEN - Check if RegisteredUsersMap is populated or not
        assertThat(inMemoryCardTransactionRepository.findCardByCardNumber(cardNumber)).isEqualTo(travelCard);

=======
        assertThat(inMemoryCardTransactionRepository.findCardByCardNumber(cardNumber)).isEqualTo(travelCard);
>>>>>>> sprint-1
    }

    @DisplayName("User try to recharge a invalid card. System throws INVALID_CARD exception")
    @Test
<<<<<<< HEAD
    public void register_user_with_invalid_card_number() throws Exception {

        //INVALID CARD NUMBER IS SET HERE
        TravelCard travelCard = new TravelCard();
        travelCard.setCardNumber(null);
        travelCard.setBalance(30);

        //WHEN -  User try to register himself
       String errorMsg =  mockMvc.perform(post("/api/card/register")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(travelCard)))
                //THEN -  status should be not acceptable
                .andExpect(status().isNotAcceptable())
                .andReturn().getResolvedException().getMessage();


        //THEN -  exception should be thrown
        assertEquals(errorMsg, "This card is Invalid. Please use a valid card");
=======
    void register_user_with_invalid_card_number() throws Exception {
        TravelCard travelCard = new TravelCard();
        travelCard.setCardNumber(null);
        travelCard.setBalance(30);
        String errorMsg = mockMvc.perform(post("/api/card/register")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(travelCard)))
                .andExpect(status().isNotAcceptable())
                .andReturn().getResolvedException().getMessage();
        assertEquals("This card is Invalid. Please use a valid card", errorMsg);
>>>>>>> sprint-1
    }

    @DisplayName("Users are able to recharge the card successfully")
    @ParameterizedTest
    @MethodSource("usersGenerator")
<<<<<<< HEAD
    public void users_are_able_to_recharge_the_card_successfully(String cardNumber, double amount) throws Exception {
        // GIVEN - user exists in the system with a valid card number and zero amount on card. Records are directly inserted in the repository.
        travelHelperTest.directUserRegistration(cardNumber, 0);

        //WHEN - user try to recharge the card
=======
    void users_are_able_to_recharge_the_card_successfully(String cardNumber, double amount) throws Exception {
        travelHelperTest.directUserRegistration(cardNumber, 0);
>>>>>>> sprint-1
        mockMvc.perform(post("/api/card/recharge/{rechargeAmount}", amount)
                        .contentType("application/json")
                        .content(cardNumber))
                .andExpect(status().isOk());
<<<<<<< HEAD


        //THEN - card should be recharged with provided amount.
        assertEquals(inMemoryCardTransactionRepository.findCardByCardNumber(cardNumber).getBalance(), amount);
    }

}
=======
        assertEquals(inMemoryCardTransactionRepository.findCardByCardNumber(cardNumber).getBalance(), amount);
    }

    @DisplayName("User can check their card balance")
    @Test
    void user_can_check_card_balance() throws Exception {
        travelHelperTest.directUserRegistration("1A105", 25.0);
        String response = mockMvc.perform(get("/api/card/1A105/balance"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals("25.0", response);
    }
}
>>>>>>> sprint-1
