package com.demo.travelcardsystem.businessrule;

import com.demo.travelcardsystem.constant.FareConstants;
import com.demo.travelcardsystem.constant.TransportType;
import com.demo.travelcardsystem.constant.Zone;
import com.demo.travelcardsystem.entity.ZonePair;
import lombok.Data;
<<<<<<< HEAD
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Data
@Component
@RequiredArgsConstructor
public class TravelStrategy {

    @NonNull
    private RuleCollection ruleCollection;

    public Consumer<Double> anyWhereInZoneOneStrategy = chargeableAmount -> {
        Rule rule = new Rule();
        rule.setChargeableFare(chargeableAmount);

        //Create all possible ZonePair for Zone 1
        ZonePair zonePair = new ZonePair(Zone.ONE, Zone.ONE);
        rule.addZonePair(zonePair);

        ruleCollection.addRules(rule);

    };

    public Consumer<Double> anyOneZoneOutsideZoneOneStrategy = chargeableAmount -> {
        Rule rule = new Rule();
        rule.setChargeableFare(chargeableAmount);

        //create all possible pair of any zone outside zone one.
        rule.addZonePair(new ZonePair(Zone.TWO, Zone.TWO));
        rule.addZonePair(new ZonePair(Zone.THREE, Zone.THREE));

        ruleCollection.addRules(rule);
    };

    public Consumer<Double> anyTwoZoneIncludingZoneOneStrategy = chargeableAmount -> {
        Rule rule = new Rule();
        rule.setChargeableFare(chargeableAmount);

        //create all possible pair of any zone outside zone one.
=======
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;
import java.util.function.DoubleConsumer;

@Data
@Component
public class TravelStrategy {

    private RuleCollection ruleCollection;
    
    public TravelStrategy(RuleCollection ruleCollection) {
        this.ruleCollection = ruleCollection;
    }

    public RuleCollection getRuleCollection() {
		return ruleCollection;
	}

	public void setRuleCollection(RuleCollection ruleCollection) {
		this.ruleCollection = ruleCollection;
	}

	public DoubleConsumer getAnyWhereInZoneOneStrategy() {
		return anyWhereInZoneOneStrategy;
	}

	public void setAnyWhereInZoneOneStrategy(DoubleConsumer anyWhereInZoneOneStrategy) {
		this.anyWhereInZoneOneStrategy = anyWhereInZoneOneStrategy;
	}

	public DoubleConsumer getAnyOneZoneOutsideZoneOneStrategy() {
		return anyOneZoneOutsideZoneOneStrategy;
	}

	public void setAnyOneZoneOutsideZoneOneStrategy(DoubleConsumer anyOneZoneOutsideZoneOneStrategy) {
		this.anyOneZoneOutsideZoneOneStrategy = anyOneZoneOutsideZoneOneStrategy;
	}

	public DoubleConsumer getAnyTwoZoneIncludingZoneOneStrategy() {
		return anyTwoZoneIncludingZoneOneStrategy;
	}

	public void setAnyTwoZoneIncludingZoneOneStrategy(DoubleConsumer anyTwoZoneIncludingZoneOneStrategy) {
		this.anyTwoZoneIncludingZoneOneStrategy = anyTwoZoneIncludingZoneOneStrategy;
	}

	public DoubleConsumer getAnyTwoZoneExcludingZoneOneStrategy() {
		return anyTwoZoneExcludingZoneOneStrategy;
	}

	public void setAnyTwoZoneExcludingZoneOneStrategy(DoubleConsumer anyTwoZoneExcludingZoneOneStrategy) {
		this.anyTwoZoneExcludingZoneOneStrategy = anyTwoZoneExcludingZoneOneStrategy;
	}

	public DoubleConsumer getAnyThreeZoneStrategy() {
		return anyThreeZoneStrategy;
	}

	public void setAnyThreeZoneStrategy(DoubleConsumer anyThreeZoneStrategy) {
		this.anyThreeZoneStrategy = anyThreeZoneStrategy;
	}

	public BiConsumer<Double, TransportType> getAnyJourneyByBus() {
		return anyJourneyByBus;
	}

	public void setAnyJourneyByBus(BiConsumer<Double, TransportType> anyJourneyByBus) {
		this.anyJourneyByBus = anyJourneyByBus;
	}




	private DoubleConsumer anyWhereInZoneOneStrategy = chargeableAmount -> {
        Rule rule = new Rule();
        rule.setChargeableFare(chargeableAmount);
        ZonePair zonePair = new ZonePair(Zone.ONE, Zone.ONE);
        rule.addZonePair(zonePair);
        ruleCollection.addRules(rule);
    };

    private DoubleConsumer anyOneZoneOutsideZoneOneStrategy = chargeableAmount -> {
        Rule rule = new Rule();
        rule.setChargeableFare(chargeableAmount);
        rule.addZonePair(new ZonePair(Zone.TWO, Zone.TWO));
        rule.addZonePair(new ZonePair(Zone.THREE, Zone.THREE));
        ruleCollection.addRules(rule);
    };

    private DoubleConsumer anyTwoZoneIncludingZoneOneStrategy = chargeableAmount -> {
        Rule rule = new Rule();
        rule.setChargeableFare(chargeableAmount);
>>>>>>> sprint-1
        rule.addZonePair(new ZonePair(Zone.ONE, Zone.TWO));
        rule.addZonePair(new ZonePair(Zone.TWO, Zone.ONE));
        rule.addZonePair(new ZonePair(Zone.ONE, Zone.THREE));
        rule.addZonePair(new ZonePair(Zone.THREE, Zone.ONE));
<<<<<<< HEAD

        ruleCollection.addRules(rule);
    };

    public  Consumer<Double> anyTwoZoneExcludingZoneOneStrategy = chargeableAmount -> {
        Rule rule = new Rule();
        rule.setChargeableFare(chargeableAmount);

        //create all possible pair of any two zone excluding zone one.
        rule.addZonePair(new ZonePair(Zone.TWO, Zone.THREE));
        rule.addZonePair(new ZonePair(Zone.THREE, Zone.TWO));

        ruleCollection.addRules(rule);
    };

    public Consumer<Double> anyThreeZoneStrategy = chargeableAmount -> {
        Rule rule = new Rule();
        rule.setChargeableFare(chargeableAmount);



        ruleCollection.addRules(rule);
    };

    public BiConsumer<Double, TransportType> anyJourneyByBus = (chargeableAmount, transType) -> {
        Rule rule = new Rule();
        rule.setChargeableFare(chargeableAmount);
        rule.setTransportType(transType);

        ruleCollection.addRules(rule);


=======
        ruleCollection.addRules(rule);
    };

    private DoubleConsumer anyTwoZoneExcludingZoneOneStrategy = chargeableAmount -> {
        Rule rule = new Rule();
        rule.setChargeableFare(chargeableAmount);
        rule.addZonePair(new ZonePair(Zone.TWO, Zone.THREE));
        rule.addZonePair(new ZonePair(Zone.THREE, Zone.TWO));
        ruleCollection.addRules(rule);
    };

    private DoubleConsumer anyThreeZoneStrategy = chargeableAmount -> {
        Rule rule = new Rule();
        rule.setChargeableFare(chargeableAmount);
        ruleCollection.addRules(rule);
    };

    private BiConsumer<Double, TransportType> anyJourneyByBus = (chargeableAmount, transType) -> {
        Rule rule = new Rule();
        rule.setChargeableFare(chargeableAmount);
        rule.setTransportType(transType);
        ruleCollection.addRules(rule);
>>>>>>> sprint-1
    };

  

    public RuleCollection loadAllBusinessRules() {
        anyWhereInZoneOneStrategy.accept(FareConstants.FARE_ANY_WHERE_IN_ZONE_ONE);
        anyOneZoneOutsideZoneOneStrategy.accept(FareConstants.FARE_ANY_ONE_ZONE_OUTSIDE_ZONE_ONE);
        anyTwoZoneIncludingZoneOneStrategy.accept(FareConstants.FARE_ANY_TWO_ZONE_INCLUDING_ZONE_ONE);
        anyTwoZoneExcludingZoneOneStrategy.accept(FareConstants.FARE_ANY_TWO_ZONE_EXCLUDING_ZONE_ONE);
        anyThreeZoneStrategy.accept(FareConstants.FARE_ANY_THREE_ZONE);
        anyJourneyByBus.accept(FareConstants.FARE_ANY_JOURNEY_BY_BUS, TransportType.BUS);

        this.ruleCollection.setMaxFare(FareConstants.MAX_FARE);
        return this.ruleCollection;
    }
}
>>>>>>> sprint-1
