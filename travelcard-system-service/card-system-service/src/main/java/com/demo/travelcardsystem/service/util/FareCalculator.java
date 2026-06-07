package com.demo.travelcardsystem.service.util;

import com.demo.travelcardsystem.businessrule.Rule;
import com.demo.travelcardsystem.businessrule.TravelStrategy;
import com.demo.travelcardsystem.entity.Journey;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

@Component
public class FareCalculator {

    private TravelStrategy travelStrategy;

    // Manual constructor for Spring injection
    public FareCalculator(TravelStrategy travelStrategy) {
        this.travelStrategy = travelStrategy;
    }

    public TravelStrategy getTravelStrategy() {
        return travelStrategy;
    }

    public void setTravelStrategy(TravelStrategy travelStrategy) {
        this.travelStrategy = travelStrategy;
    }

    // Compare rules and pick the one with lower chargeable fare
    private Comparator<Rule> ruleComparator = (firstRule, secondRule) -> {
        if (firstRule.getChargeableFare() < secondRule.getChargeableFare()) {
            return -1;
        } else if (firstRule.getChargeableFare() > secondRule.getChargeableFare()) {
            return 1;
        } else {
            return 0;
        }
    };

    public Double calculate(Journey journey) {
        Predicate<Rule> rulePredicate = rule -> rule.isRuleSatisfied(journey);

        // Figure out which rule will be applicable out of all provided business rules
        return travelStrategy.getRuleCollection().getRules()
                .stream()
                .filter(rulePredicate)
                .min(ruleComparator)
                .orElseThrow(() -> new NoSuchElementException("No fare rule found for this journey"))
                .getChargeableFare();
    }
}