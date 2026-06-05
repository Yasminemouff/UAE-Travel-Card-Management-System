package com.demo.travelcardsystem.entity;

import com.demo.travelcardsystem.constant.Zone;
<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ZonePair {
    private Zone startZone;
    private Zone endZone;

    public boolean checkIfJourneyMatchToThisZonePair(Journey journey) {
        return journey.getStartStation().getZones().contains(startZone) && journey.getEndStation().getZones().contains(endZone);
    }
}
=======

public class ZonePair {

    private Zone startZone;
    private Zone endZone;

    public ZonePair(Zone startZone, Zone endZone) {
        this.startZone = startZone;
        this.endZone = endZone;
    }

    public boolean checkIfJourneyMatchToThisZonePair(Journey journey) {
        return journey.getStartStation().getZones().contains(startZone)
                && journey.getEndStation().getZones().contains(endZone);
    }

    public Zone getStartZone() { return startZone; }
    public void setStartZone(Zone startZone) { this.startZone = startZone; }
    public Zone getEndZone() { return endZone; }
    public void setEndZone(Zone endZone) { this.endZone = endZone; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZonePair that = (ZonePair) o;
        return startZone == that.startZone && endZone == that.endZone;
    }

    @Override
    public int hashCode() {
        return 31 * startZone.hashCode() + endZone.hashCode();
    }
}
>>>>>>> sprint-1
