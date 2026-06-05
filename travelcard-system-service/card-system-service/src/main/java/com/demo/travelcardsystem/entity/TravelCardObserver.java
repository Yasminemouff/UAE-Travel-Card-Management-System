package com.demo.travelcardsystem.entity;

import com.demo.travelcardsystem.service.util.FareCalculator;
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
        }
    }

    private void debitChargeableFare(TravelCard card) {
        Double maxFare = fareCalculator.getTravelStrategy().getRuleCollection().getMaxFare();
        Double fareAmount = Optional.ofNullable(fareCalculator.calculate(card.getCurrentJourney())).orElse(maxFare);
        card.debitAmount(fareAmount);
    }
}