package com.demo.travelcardsystem.service.util;

import com.demo.travelcardsystem.businessrule.Rule;
import com.demo.travelcardsystem.businessrule.TravelStrategy;
import com.demo.travelcardsystem.entity.Journey;
<<<<<<< HEAD
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.function.Predicate;

@Data
@Component
@RequiredArgsConstructor
public class FareCalculator {

    @NonNull
    private TravelStrategy travelStrategy;

    // compare rules and pick the one has lower chargeable fare
    private Comparator<Rule> ruleComparator = (Rule firstRule, Rule secondRule) -> {
=======
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
>>>>>>> sprint-1
        if (firstRule.getChargeableFare() < secondRule.getChargeableFare()) {
            return -1;
        } else if (firstRule.getChargeableFare() > secondRule.getChargeableFare()) {
            return 1;
        } else {
            return 0;
        }
    };

<<<<<<< HEAD

=======
>>>>>>> sprint-1
    public Double calculate(Journey journey) {
        Predicate<Rule> rulePredicate = rule -> rule.isRuleSatisfied(journey);

        // Figure out which rule will be applicable out of all provided business rules
<<<<<<< HEAD
        Rule applicableRule = travelStrategy.getRuleCollection().getRules()
                .stream()
                .filter(rulePredicate)
                .min(ruleComparator)
                .get();

        //finally, return the chargeable fare
        return applicableRule.getChargeableFare();
    }
}
=======
        return travelStrategy.getRuleCollection().getRules()
                .stream()
                .filter(rulePredicate)
                .min(ruleComparator)
                .orElseThrow(() -> new NoSuchElementException("No fare rule found for this journey"))
                .getChargeableFare();
    }
}
>>>>>>> sprint-1
