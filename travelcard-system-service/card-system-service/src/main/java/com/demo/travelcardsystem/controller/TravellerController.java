package com.demo.travelcardsystem.controller;

import com.demo.travelcardsystem.entity.Station;
import com.demo.travelcardsystem.model.request.CardRegistrationRequest;
import com.demo.travelcardsystem.model.request.SwipeRequest;
import com.demo.travelcardsystem.model.response.TravelCardResponse;
import com.demo.travelcardsystem.service.TravellerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/card")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "Travel Card API", description = "Endpoints for managing travel cards and stations")
public class TravellerController {

    private TravellerService travellerService;

    @Operation(summary = "Ping the service", description = "Check if the service is running")
    @ApiResponse(responseCode = "200", description = "Service is up and running")
    @GetMapping(value = "/ping")
    public String pingMe() {
        return "Service is UP and Running";
    }

    @Operation(summary = "Register a new travel card", description = "Creates a new travel card with the provided details")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Card registered successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid card details provided")
    })
    @PostMapping(value = "/register")
    public void registerNewUser(@RequestBody CardRegistrationRequest cardRegistrationRequest) {
        travellerService.registerNewCard(cardRegistrationRequest);
    }

    @Operation(summary = "Recharge a travel card", description = "Adds credit to an existing travel card")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Card recharged successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid card number or recharge amount")
    })
    @PostMapping(value = "/recharge/{rechargeAmount}")
    public void rechargeTheCard(
        @RequestBody String cardNumber,
        @Parameter(description = "Amount to recharge") @PathVariable double rechargeAmount) {
        travellerService.rechargeTheCard(cardNumber, rechargeAmount);
    }

    @Operation(summary = "Swipe a travel card", description = "Records a tap in or tap out for a journey")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Card swiped successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid swipe request")
    })
    @PostMapping(value = "/swipe")
    public TravelCardResponse swipeCard(@RequestBody SwipeRequest swipeRequest) {
        return travellerService.swipeCard(swipeRequest);
    }

    @Operation(summary = "Get card details", description = "Retrieves details of a specific travel card")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Card details retrieved successfully"),
        @ApiResponse(responseCode = "404", description = "Card not found")
    })
    @GetMapping(value = "/{cardNumber}")
    public TravelCardResponse checkCardDetail(
        @Parameter(description = "The card number to look up") @PathVariable String cardNumber) {
        return travellerService.checkCardDetail(cardNumber);
    }

    @Operation(summary = "Get all cards", description = "Returns a list of all registered card numbers")
    @ApiResponse(responseCode = "200", description = "List of cards retrieved successfully")
    @GetMapping
    public List<String> fetchAllCard() {
        return travellerService.fetchAllCard();
    }

    @Operation(summary = "Get card balance", description = "Returns the current balance of a travel card")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Balance retrieved successfully"),
        @ApiResponse(responseCode = "404", description = "Card not found")
    })
    @GetMapping(value = "/{cardNumber}/balance")
    public ResponseEntity<Double> getCardBalance(
        @Parameter(description = "The card number to check balance for") @PathVariable String cardNumber) {
        double balance = travellerService.getCardBalance(cardNumber);
        return new ResponseEntity<>(balance, HttpStatus.OK);
    }

    @Operation(summary = "Get all stations", description = "Returns a list of all stations and their associated zones")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Stations retrieved successfully")
    })
    @GetMapping(value = "/stations")
    public ResponseEntity<Set<Station>> getAllStations() {
        return new ResponseEntity<>(travellerService.getAllStations(), HttpStatus.OK);
    }
}