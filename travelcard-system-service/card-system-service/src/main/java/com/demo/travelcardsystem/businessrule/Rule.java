package com.demo.travelcardsystem.businessrule;

import com.demo.travelcardsystem.constant.TransportType;
import com.demo.travelcardsystem.entity.Journey;
import com.demo.travelcardsystem.entity.ZonePair;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Rule {
    private TransportType transportType;
    private Double chargeableFare;
    private final Set<ZonePair> zonePairSet = new HashSet<>();

    public synchronized void addZonePair(ZonePair zonePair) {
        zonePairSet.add(zonePair);
    }

    public boolean isRuleSatisfied(Journey journey) {
        return zonePairSet.stream().anyMatch(zonePair -> zonePair.checkIfJourneyMatchToThisZonePair(journey))
                || (journey.getTransportType().equals(this.getTransportType()) && zonePairSet.isEmpty());
    }

<<<<<<< HEAD
=======
	public TransportType getTransportType() {
		return transportType;
	}

	public void setTransportType(TransportType transportType) {
		this.transportType = transportType;
	}

	public Double getChargeableFare() {
		return chargeableFare;
	}

	public void setChargeableFare(Double chargeableFare) {
		this.chargeableFare = chargeableFare;
	}

	public Set<ZonePair> getZonePairSet() {
		return zonePairSet;
	}

>>>>>>> sprint-1

}
