package com.demo.travelcardsystem.controller;

import com.demo.travelcardsystem.model.request.CardRegistrationRequest;
import com.demo.travelcardsystem.model.request.SwipeRequest;
import com.demo.travelcardsystem.model.response.TravelCardResponse;
import com.demo.travelcardsystem.service.TravellerService;
import lombok.AllArgsConstructor;
<<<<<<< HEAD
=======

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
>>>>>>> sprint-1
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/card")
@AllArgsConstructor
<<<<<<< HEAD
@CrossOrigin
=======
@CrossOrigin(origins = "http://localhost:4200")  
>>>>>>> sprint-1
public class TravellerController {

    private TravellerService travellerService;

    @GetMapping(value = "/ping")
    public String pingMe() {
        return "Service is UP and Running";
    }

    @PostMapping(value = "/register")
    public void registerNewUser(@RequestBody CardRegistrationRequest cardRegistrationRequest) {
        travellerService.registerNewCard(cardRegistrationRequest);
    }

    @PostMapping(value = "/recharge/{rechargeAmount}")
    public void rechargeTheCard(@RequestBody String cardNumber, @PathVariable double rechargeAmount) {
        travellerService.rechargeTheCard(cardNumber, rechargeAmount);
    }

    @PostMapping(value = "/swipe")
    public TravelCardResponse swipeCard(@RequestBody SwipeRequest swipeRequest) {
        return travellerService.swipeCard(swipeRequest);
    }

    @GetMapping(value = "/{cardNumber}")
    public TravelCardResponse checkCardDetail(@PathVariable String cardNumber) {
        return travellerService.checkCardDetail(cardNumber);
    }

    @GetMapping
    public List<String> fetchAllCard() {
        return travellerService.fetchAllCard();
    }
<<<<<<< HEAD


}
=======
    
    @GetMapping(value = "/{cardNumber}/balance")
    public ResponseEntity<Double> getCardBalance(@PathVariable String cardNumber) {
        double balance = travellerService.getCardBalance(cardNumber);
        return new ResponseEntity<>(balance, HttpStatus.OK);
    }
}
>>>>>>> sprint-1
