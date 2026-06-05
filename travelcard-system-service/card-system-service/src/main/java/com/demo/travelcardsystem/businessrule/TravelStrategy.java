package com.demo.travelcardsystem.businessrule;

import com.demo.travelcardsystem.constant.TransportType;
import com.demo.travelcardsystem.constant.Zone;
import com.demo.travelcardsystem.entity.ZonePair;
import lombok.Data;
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
        rule.addZonePair(new ZonePair(Zone.ONE, Zone.TWO));
        rule.addZonePair(new ZonePair(Zone.TWO, Zone.ONE));
        rule.addZonePair(new ZonePair(Zone.ONE, Zone.THREE));
        rule.addZonePair(new ZonePair(Zone.THREE, Zone.ONE));
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
    };

    public RuleCollection loadAllBusinessRules() {
        anyWhereInZoneOneStrategy.accept(2.50);
        anyOneZoneOutsideZoneOneStrategy.accept(2.00);
        anyTwoZoneIncludingZoneOneStrategy.accept(3.00);
        anyTwoZoneExcludingZoneOneStrategy.accept(2.25);
        anyThreeZoneStrategy.accept(3.20);
        anyJourneyByBus.accept(1.80, TransportType.BUS);

        this.ruleCollection.setMaxFare(3.20);
        return this.ruleCollection;
    }
}