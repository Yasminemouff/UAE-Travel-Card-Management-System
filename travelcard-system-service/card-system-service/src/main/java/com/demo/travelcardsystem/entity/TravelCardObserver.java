package com.demo.travelcardsystem.entity;

import com.demo.travelcardsystem.service.util.FareCalculator;
<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Data
@AllArgsConstructor
@Component
public class TravelCardObserver implements Observer<TravelCard>{

    private FareCalculator fareCalculator;

    @Override
    public void reactOnChange(TravelCard travelCard) {
        TravelCard card = travelCard;
        Journey journey =  travelCard.getCurrentJourney();

        //When journey is completed then add max charge back and debit chargeable fare
        if(journey.isJourneyCompleted()) {
            card.addCredit(fareCalculator.getTravelStrategy().getRuleCollection().getMaxFare());
            debitChargeableFare(card);
        } else {
            // If journey starts the charge max amount
            card.debitAmount(fareCalculator.getTravelStrategy().getRuleCollection().getMaxFare());
=======
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class TravelCardObserver implements Observer<TravelCard> {

    private FareCalculator fareCalculator;

    public TravelCardObserver(FareCalculator fareCalculator) {
        this.fareCalculator = fareCalculator;
    }

    public FareCalculator getFareCalculator() { return fareCalculator; }
    public void setFareCalculator(FareCalculator fareCalculator) { this.fareCalculator = fareCalculator; }

    @Override
    public void reactOnChange(TravelCard travelCard) {
        Journey journey = travelCard.getCurrentJourney();
        if (journey.isJourneyCompleted()) {
            travelCard.addCredit(fareCalculator.getTravelStrategy().getRuleCollection().getMaxFare());
            debitChargeableFare(travelCard);
        } else {
            travelCard.debitAmount(fareCalculator.getTravelStrategy().getRuleCollection().getMaxFare());
>>>>>>> sprint-1
        }
    }

    private void debitChargeableFare(TravelCard card) {
        Double maxFare = fareCalculator.getTravelStrategy().getRuleCollection().getMaxFare();
<<<<<<< HEAD

        Double fareAmount = Optional.of(fareCalculator.calculate(card.getCurrentJourney())).orElse(maxFare);
        // Fare Amount is either the calculated fareAmount or the max Fare
        card.debitAmount(fareAmount);
    }
}
=======
        Double fareAmount = Optional.ofNullable(fareCalculator.calculate(card.getCurrentJourney())).orElse(maxFare);
        card.debitAmount(fareAmount);
    }
}
>>>>>>> sprint-1
